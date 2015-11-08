package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;


public class DoAskmine extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query="";
	String preurl = "http://www.ask.com/web?q=";
	String url=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		System.out.println("Inside doget");
		query=request.getParameter("query");
		String queryurl=query.replaceAll(" ","+");
		url=preurl+queryurl;
		System.out.println("queryurl:"+url);
		//PrintWriter out = response.getWriter();
		String check="";
		Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
		//System.out.println("doc:"+doc);
		Elements links=doc.select("span.qna-description" );// filter the links
		//System.out.println("links:"+links);
		for (Element link : links) { // for all filtered links
			System.out.println("Inside for loop");
			check = link.text().toString();
			System.out.println(check);
			if(check.contains("...")){
				check=check.replace("...","");
			}
			System.out.println(check);
			if (null != check && check.length() > 0 )
			{
				int endIndex = check.lastIndexOf(".");
				if (endIndex != -1)  
				{
					check = check.substring(0, endIndex+1);
					//out.println("\n"+check);
					//out.println("Source : ask.com");
					break;
				}
			}  
		}
		System.out.println(check);
		System.out.println(query +" heiiiiiiii  "+check);
		
		//response.setContentType("text/plain");
		//response.getWriter().write("Ask");
		System.out.println("Ask: called");
		
		request.setAttribute("answer", check);
		request.setAttribute("asked", query);		
		request.getRequestDispatcher("/DoYahooMine").forward(request, response);
		
	}
}
