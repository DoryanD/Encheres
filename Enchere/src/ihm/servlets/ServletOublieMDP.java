package ihm.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import bll.UtilisateursManager;
import bo.utilisateur.Utilisateur;
import java.util.*;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class ServletOublieMDP
 */
@WebServlet("/ServletOublieMDP")
public class ServletOublieMDP extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageOublieMail");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getAttribute("email") != null)
    	{
			UtilisateursManager instance = UtilisateursManager.getInstance();
			List<Utilisateur> listeUtilisateur = new ArrayList<>();
			listeUtilisateur = instance.selectAll();
			for (Utilisateur utilisateur : listeUtilisateur)
			{
				if(utilisateur.getEmail().equals(request.getAttribute("email")))
				{
					/*String to = (String) request.getAttribute("email");
				    String from = "floch.titouan@outlook.com";
				    String host = "localhost";
				    Properties properties = System.getProperties();
				    properties.setProperty("mail.smtp.host", host);
				    Session session = Session.getDefaultInstance(properties);
				    MimeMessage message = new MimeMessage(session);
			        try {
						message.setFrom(new InternetAddress(from));
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						message.setSubject("Oublie de mot de passe");
						message.setText("Voici votre mot de passe : " + utilisateur.getMot_de_passe());
						Transport.send(message);
					} catch (Exception e)
			        {
						e.printStackTrace();
					}*/
			        System.out.println("Email envoyé");
				}
			}
    	}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageOublieMail");
			rd.forward(request, response);
		}
	}

}
