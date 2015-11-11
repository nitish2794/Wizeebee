package com.anikora;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class DoWebopediaMine extends HttpServlet{	
	private static final long serialVersionUID = 1L;

	String query=null;
	String preurl = "http://www.ask.com/web?q=";

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		try{
			System.out.println("Inside doget");
			query=request.getParameter("query");
			String answer=(String)request.getAttribute("answer");
			String url = "http://www.webopedia.com/sgsearch/results?q=";
			//System.out.println("Enter the query:");
			String queryurl=query.replaceAll(" ","+");
			url=url+queryurl;
			String check="";
			Document doc = Jsoup.connect(url).get(); // getting the HTML of the URL
			Elements links=doc.select("div.result_container p" );// filter the links
			for (Element link : links) { // for all filtered links

				check = link.text().toString();
				//			if(check.contains("...")){
				//				//System.out.println("replacing");
				//				check=check.replaceAll("...","");
				//			}
				if (null != check && check.length() > 0 )
				{
					System.out.println("\n"+check);

					//System.out.println("Source : webopedia.com");
					break;

				}  

			}
			answer = answer +"\n"+check;
			//request.setAttribute("answer", check);
			//request.getRequestDispatcher("/home.jsp").forward(request, response);
			response.setContentType("text/plain");
			System.out.println("sending to ajax");
			response.getWriter().write( answer);
		}
		catch(Exception e)
		{
			System.out.println("An exception occurred");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String error = sw.toString(); // stack trace as a string
			request.setAttribute("body",error);
			request.setAttribute("query",query);
			request.getRequestDispatcher("/SendMail").forward(request, response);
		}

	}

}
