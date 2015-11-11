package com.anikora;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service (HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String body =req.getParameter("body");
		String query =req.getParameter("query");
		String to="nitish2794@gmail.com";//req.getAttribute("to").toString();
		//String frommail=req.getParameter("fromemail");//req.getAttribute("from").toString();
		String from="nitish2794@gmail.com";
		//req.getAttribute("subject").toString();
		String admin="Nitish Srivastava";//req.getAttribute("admin").toString();
		String user=req.getParameter("fromname");;//req.getAttribute("user").toString();
		String sub="From wizeebee.appspot.com: An error occurred at wizeebee";
		String msgBody ="Hi Nitish,there occurred an error at wizeebee.\n"+"Query : "+query+"\nError :"+body;

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from, admin));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to, user));
			msg.setSubject(sub);
			msg.setText(msgBody);
			Transport.send(msg);
			//req.getRequestDispatcher("/index.html").forward(req, resp);
			resp.setContentType("text/plain");
			System.out.println("sending to ajax from sendmail");
			resp.getWriter().write("Sorry! But there is some error in processing this query. I have sent the crash report to my developers.");

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		}



	}

}

