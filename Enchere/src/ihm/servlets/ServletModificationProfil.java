package ihm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UtilisateursManager;
import bo.utilisateur.Utilisateur;
import utils.Exceptions.BLLException;

/**
 * Servlet implementation class ServletModificationProfil
 */
@WebServlet("/ModificationProfil")
public class ServletModificationProfil extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
    	if(session.getAttribute("pseudo") !=null ) 
    	{
			response.sendRedirect("/Encheres/ihm.servlets/Accueil");
    	}
		else
		{
			request.setAttribute("id", session.getAttribute("id"));
			request.setAttribute("pseudo", session.getAttribute("pseudo"));
			request.setAttribute("prenom", session.getAttribute("prenom"));
			request.setAttribute("tel", session.getAttribute("tel"));
			request.setAttribute("cp", session.getAttribute("cp"));
			request.setAttribute("nom", session.getAttribute("nom"));
			request.setAttribute("Email", session.getAttribute("Email"));
			request.setAttribute("Rue", session.getAttribute("Rue"));
			request.setAttribute("ville", session.getAttribute("ville"));
			this.getServletContext().getRequestDispatcher("/PageModificationProfil").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int modifier = 0;
		HttpSession session = request.getSession();
    	if(session.getAttribute("pseudo") !=null ) 
    	{
			response.sendRedirect("/Encheres/ihm.servlets/Accueil");
    	}
		else
		{
			String id = (String) session.getAttribute("id");
			String pseudo = (String) session.getAttribute("pseudo");
			String prenom = (String) session.getAttribute("prenom");
			String tel = (String) session.getAttribute("tel");
			String cp = (String) session.getAttribute("cp");
			String mdpActuel = (String) session.getAttribute("mdp");
			String nom = (String) session.getAttribute("nom");
			String Email = (String) session.getAttribute("Email");
			String Rue = (String) session.getAttribute("Rue");
			String ville = (String) session.getAttribute("ville");
			if(id != request.getParameter("id"))
			{
				modifier = 1;
			}
			if(pseudo != request.getParameter("pseudo"))
			{
				modifier = 1;
			}
			if(prenom != request.getParameter("prenom"))
			{
				modifier = 1;
			}
			if(tel != request.getParameter("tel"))
			{
				modifier = 1;
			}
			if(cp != request.getParameter("cp"))
			{
				modifier = 1;
			}
			if(mdpActuel != request.getParameter("mdp"))
			{
				modifier = 1;
			}
			if(nom != request.getParameter("nom"))
			{
				modifier = 1;
			}
			if(Email != request.getParameter("Email"))
			{
				modifier = 1;
			}
			if(Rue != request.getParameter("Rue"))
			{
				modifier = 1;
			}
			if(ville != request.getParameter("ville"))
			{
				modifier = 1;
			}
			if(modifier == 1)
			{
				id = (String) request.getParameter("id");
				pseudo = (String) request.getParameter("pseudo");
				prenom = (String) request.getParameter("prenom");
				tel = (String) request.getParameter("tel");
				cp = (String) request.getParameter("cp");
				String mdp = (String) request.getParameter("mdp");
			    nom = (String) request.getParameter("nom");
				Email = (String) request.getParameter("Email");
				Rue = (String) request.getParameter("Rue");
				ville = (String) request.getParameter("ville");
				session.setAttribute("id", request.getParameter("id"));
				session.setAttribute("pseudo", request.getParameter("pseudo"));
				session.setAttribute("prenom", request.getParameter("prenom"));
				session.setAttribute("tel", request.getParameter("tel"));
				session.setAttribute("cp", request.getParameter("cp"));
				session.setAttribute("mdp", request.getParameter("mdp"));
				session.setAttribute("nom", request.getParameter("nom"));
				session.setAttribute("Email", request.getParameter("Email"));
				session.setAttribute("Rue", request.getParameter("Rue"));
				session.setAttribute("ville", request.getParameter("ville"));
				session.setAttribute("credit", session.getAttribute("credit"));
				int credit = (int) session.getAttribute("credit");
				int id2 = Integer.parseInt(request.getParameter("id"));
				session.setAttribute("administrateur", session.getAttribute("administrateur"));
				Boolean administrateur = (Boolean) session.getAttribute("administrateur");
				Utilisateur UtiModifier = new Utilisateur(id2,pseudo,nom,prenom,Email,tel,Rue,cp,ville,mdp,credit,administrateur);
				UtilisateursManager instance = UtilisateursManager.getInstance();
				try 
				{
					instance.update(UtiModifier);
					Cookie cookieMDP = new Cookie("mdp",mdp);
					Cookie cookiePseudo = new Cookie("pseudo",pseudo);
					cookieMDP.setMaxAge(1000000000);
					cookiePseudo.setMaxAge(1000000000);
					response.addCookie(cookieMDP);
					response.addCookie(cookiePseudo);
				} 
				catch (BLLException e) 
				{
					e.printStackTrace();
				}
				this.getServletContext().getRequestDispatcher("/PageProfilUtilisateur").forward(request, response);
			}
		}
	}

}
