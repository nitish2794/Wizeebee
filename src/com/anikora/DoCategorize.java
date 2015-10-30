package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nitts.ContentFilterfinal.ContentFilter;

import java.io.IOException;
import java.io.PrintWriter;


public class DoCategorize extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query=null;
	String preurl = "http://www.ask.com/web?q=";
	String url=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		System.out.println("Inside doget of categorize");
		query=request.getParameter("query");
		
		if(ContentFilter.checker(query)==true)
		{
			request.setAttribute("answer","LOL. This is Wizeebee. Please mind your language.");
			request.setAttribute("asked", ContentFilter.checkerAndReplacer(query));
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			System.out.println("if ran");
		}		
		else
		{
			System.out.println("else ran");	
		String url = "http://wiki.answers.com/Q/";
		String queryurl=query.replaceAll(" ","_");
		url=url+queryurl;
		Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
		//System.out.println(doc);
		Elements links=doc.select("a.category_name" );// filter the links
		String category="";
		for (Element link : links) { // for all filtered links

			String check = link.text().toString();
			
			if (null != check && check.length() > 0 )
			{
				
				System.out.println(check);// prints the category
				category=check;
					break;
			    //
			}  
			
			
			
		}
		
		request.setAttribute("query", query);

//		
////		if(query.contains("what is")||query.contains("who is")) // wikipedia
////		{
////			request.getRequestDispatcher("/DoWikiMine").forward(request, response);
////		}
//		 if(query.contains("learn")||query.contains("tutorial")) // tutorial point
//		{
//			request.getRequestDispatcher("/DoTPMine").forward(request, response);
//		}
//		else if(category=="Computers") //webopedia
//		{
//			request.getRequestDispatcher("/DoWebopedia").forward(request, response);
//		}
	//else // ask and yahoo
		//{
			request.getRequestDispatcher("/DoAskmine").forward(request, response);
			
		//}
		}

	}

}
