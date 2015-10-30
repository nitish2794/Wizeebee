package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
//import java.io.PrintWriter;


public class DoStackoverflowMine extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query=null;
	String url = "http://stackoverflow.com/search?q=";
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		query=request.getParameter("query");
		
		//String query="how to run garbage collector";
		String queryurl=query.replaceAll(" ","+");
		url=url+queryurl;
		Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
		//System.out.println(doc);
		Elements links=doc.select("div.result-link a" );// filter the links
		for (Element link : links) { // for all filtered links

			String check = link.attr("abs:href");
			
					//System.out.println("\n"+check);
					Document doc2 = Jsoup.connect(check).get(); // getting the HTML of the URL
					//System.out.println(doc);
					Element links2=doc2.select("td.answercell div.post-text").first();
					if(links2!=null)
					System.out.println(links2.text());
					url="";
					request.setAttribute("answer", links2.text());
					request.setAttribute("asked", query);
					request.getRequestDispatcher("/home.jsp").forward(request, response);
//					System.out.println("Source : ask.com");
			break;
		}

	}
}
