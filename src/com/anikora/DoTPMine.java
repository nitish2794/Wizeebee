package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;


public class DoTPMine extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query=null;
	String url = "http://www.tutorialspoint.com/index.htm";

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		
		System.out.println("Inside doget of tpmine");
		query=request.getParameter("query");
		/// removing stopwords
		query = query.replace("learn","").replace("tutorial","");
		System.out.println(query);
		
		String list="";
		Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
		Elements links=doc.select("div.col-md-3" );// filter the links
		for (Element link : links) { // for all filtered links

			 list = list + link.text().toString().replaceAll("Learn",",").replaceAll(" , ",",").toLowerCase();

		}  
		//System.out.println("http://www.tutorialspoint.com/"+query.toLowerCase().replaceAll(" ","_")+"/index.htm");
		//System.out.println("list:"+list);
		String text="";
		String queryterms[]=query.split(" ");
		for (String queryterm:queryterms)
		{
			System.out.println(queryterm);
			queryterm=" "+queryterm+" ";
			if(list.contains(queryterm))
			{
				System.out.println("queryterm inside if:"+queryterm);
				queryterm=queryterm.trim();
				String tuturl="http://www.tutorialspoint.com/"+queryterm.toLowerCase().replaceAll(" ","_")+"/index.htm";
				Document doc2 = Jsoup.connect(tuturl).get(); // getting the HTML of the URL
				System.out.println("Wizee Recommends TutorialsPoint : "+tuturl);
				text="Wizee Recommends TutorialsPoint : "+tuturl+"\n\n";
				Elements links2=doc2.select("p");// filter the links
				
				for (Element link2 : links2) {
					text=text +link2.text().toString();
				}
				text=text.replaceAll("© Copyright 2015. All Rights Reserved.","").replace("?","");
				System.out.println("\n"+text);
				
				
			}
		}
			request.setAttribute("answer", text);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
			
		
		
	}

}
