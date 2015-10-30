package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class DoYahooMine extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query="";
	String url=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		String url = "https://in.answers.yahoo.com/search/search_result?p=";
		String check2="";
		//System.out.println("Enter the query:");
		String query=request.getParameter("asked");
		String answer=request.getParameter("answer");
		String queryurl=query.replaceAll(" ","+");
		url=url+queryurl;
		Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
		//System.out.println(doc);
		Elements links=doc.select("h3.question-title" );// filter the links
		for (Element link : links) { // for all filtered links

			String check = link.html().toString();
			if (null != check && check.length() > 0 )
			{
					
					check = check.substring(check.indexOf("\"/") + 1);
					check = check.substring(0, check.indexOf(">"));
					String url2="https://in.answers.yahoo.com"+check;
					url2=url2.replaceAll("\"","");
					//System.out.println("\n"+url2);
					//System.out.println("Source : yahoo.com");
					Document doc2 = Jsoup.connect(url2).get();
					//System.out.println(doc2);
					Elements links2=doc2.select("span.ya-q-full-text");//span.ya-q-full-text
					//System.out.println(links2);
					
					for (Element link2 : links2) {
						 check2 = check2 + link2.text().toString();	
						 break;
					}
					System.out.println(check2);
					break;
			    //}
			}  
			
			
		}
		answer = answer +"\n"+check2;
		request.setAttribute("answer", answer);
		request.setAttribute("asked", query);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

}
