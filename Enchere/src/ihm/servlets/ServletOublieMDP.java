package ihm.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import bll.UtilisateursManager;
import bo.utilisateur.Utilisateur;
import utils.Exceptions.BLLException;

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
@WebServlet("/OublieMDP")
public class ServletOublieMDP extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/PageChangementDeMotDePasse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("email") != null && request.getParameter("mdp") != null)
    	{
			UtilisateursManager leManager = UtilisateursManager.getInstance();
			List<Utilisateur> laListe = leManager.selectAll();
			String email = (String) request.getParameter("email");
			for (Utilisateur utilisateur : laListe) 
			{
				
				if(utilisateur.getEmail().equals(email))
				{
					String mdp = (String) request.getParameter("mdp");
					utilisateur.setMot_de_passe(mdp);
					try 
					{
						leManager.update(utilisateur);
						/*rediriger vers connexion */
					} 
					catch (BLLException e) 
					{
						e.printStackTrace();
					}
				}
			}
    	}
		else
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/PageChangementDeMotDePasse.jsp").forward(request, response);
		}
	}

}
