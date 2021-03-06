package ihm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ArticlesVendusManager;
import bll.CategorieManager;
import bll.EncheresManager;
import bll.UtilisateursManager;
import bo.articlesVendu.ArticlesVendu;
import bo.categorie.Categorie;
import bo.enchere.Enchere;
import bo.utilisateur.Utilisateur;
import utils.Exceptions.BLLException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet(urlPatterns= {"/index", "/Connexion"})
public class ServletConnexion extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		HttpSession session = request.getSession();
		if(request.getParameter("pseudo") != null)
		{
			request.setAttribute("pseudo", request.getParameter("pseudo") );
			String pseudo = (String) request.getParameter("pseudo");
			if(request.getParameter("mdp") != null)
			{
				String mdp = (String) request.getParameter("mdp");
				UtilisateursManager instance = UtilisateursManager.getInstance();
				List<Utilisateur> listeUtilisateur = new ArrayList<>();
				listeUtilisateur = instance.selectAll();
				for (Utilisateur utilisateur : listeUtilisateur)
				{
					if(utilisateur.getPseudo().equals(pseudo) && utilisateur.getMot_de_passe().equals(mdp))
					{
						if(request.getParameter("remember") != null && request.getParameter("remember") == "on")
						{
							Cookie cookieMDP = new Cookie("mdp",utilisateur.getMot_de_passe());
							Cookie cookiePseudo = new Cookie("pseudo",utilisateur.getPseudo());
							cookieMDP.setMaxAge(1000000000);
							cookiePseudo.setMaxAge(1000000000);
							response.addCookie(cookieMDP);
							response.addCookie(cookiePseudo);
						}
						
						session.setAttribute("id", utilisateur.GetId());
						session.setAttribute("pseudo", utilisateur.getPseudo());
						session.setAttribute("prenom", utilisateur.getPrenom());
						session.setAttribute("tel", utilisateur.getTelephone());
						session.setAttribute("cp", utilisateur.getCode_postal());
						session.setAttribute("mdp", utilisateur.getMot_de_passe());
						session.setAttribute("nom", utilisateur.getNom());
						session.setAttribute("Email", utilisateur.getEmail());
						session.setAttribute("Rue", utilisateur.getRue());
						session.setAttribute("ville", utilisateur.getVille());
						session.setAttribute("credit", utilisateur.getCredit());
						session.setAttribute("administrateur", utilisateur.getAdministrateur());
					}
				}
				if(session.getAttribute("pseudo")!= null) {
					RequestDispatcher rd = request.getRequestDispatcher("/Accueil");
		        	rd.forward(request, response);
				}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageConnexion.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageConnexion.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
