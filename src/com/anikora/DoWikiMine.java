package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;


public class DoWikiMine extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query=null;
	String preurl = "http://www.ask.com/web?q=";
	String url=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		System.out.println("Inside doget");
		query=request.getParameter("query");
		/// removing stopwords
		query.replaceAll("what is","").replaceAll("who is","").replaceAll(" ","");
		
		String regex="(\\[|\\().+?(\\)|\\])"; // regular expression for removing () and [] with their content
		String url = "https://en.wikipedia.org/w/index.php?search=";
		//System.out.println("Enter the query:");
		String check_url = null,check = null,data2;
		String queryurl=query.replaceAll(" ","+");
		url=url+queryurl;
		Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
		//System.out.println(doc);
		Element link=doc.select("div.mw-search-result-heading a" ).first();// get the first relevant link

		// if the content found not found on first page
		if(link!=null){
			//System.out.println("2 page:"+url);
			check = link.text().toString();
			//String check_url = link.html().toString();
			check_url = link.absUrl("href").toString();
			Document doc2 = Jsoup.connect(check_url).get();
			//System.out.println(doc2);
			Element data=doc2.select("div.mw-content-ltr p" ).first();
			data2=data.text().toString();
		}
		// if the content found found on first page
		else
		{
			url = "https://en.wikipedia.org/wiki/";
			//System.out.println("Enter the query:");
			query=capitalize(query);
			//System.out.println(query);
			queryurl=query.replaceAll(" ","_");
			url=url+queryurl;
			doc = Jsoup.connect(url).get();
			Element data=doc.select("div.mw-content-ltr p" ).first();
			data2=data.text().toString().replaceAll(regex,"");
			// if there are more same things with the search term
			if(data2.contains("may refer to:")||data2.contains("may stand for:")){
				Elements data_uls=doc.select("div.mw-content-ltr ul" );
				for(Element data_ul : data_uls)
					data2=data2+"\n-> "+data_ul.text().toString();
			}
		}
		//System.out.println("\n"+check+":"+check_url);
		System.out.println("\n"+data2);
		//System.out.println("Source : wikipedia.com");
		request.setAttribute("answer", data2);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
	public static String capitalize(String inline) {
		String words[]=inline.split(" ");
		String outline="";
		for(String word:words){
			outline= outline+Character.toUpperCase(word.charAt(0)) + word.substring(1)+" ";
		}
		return outline;
	}

}
