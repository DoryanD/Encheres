package ihm.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UtilisateursManager;
import bo.utilisateur.Utilisateur;
import utils.Exceptions.BLLException;

/**
 * Servlet implementation class ServletAffichageInfosUtilisateur
 */
@WebServlet("/PageAffichageInfosUtilisateur")
public class ServletAffichageInfosUtilisateur extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		request.setAttribute("affichageButton", request.getParameter("idVendeur") == null);
    	if(session.getAttribute("pseudo") == null || request.getParameter("idVendeur") != null) 
    	{
    		UtilisateursManager userManager = UtilisateursManager.getInstance();
    		Utilisateur user = userManager.get(Integer.parseInt(request.getParameter("idVendeur")));
			request.setAttribute("id", user.GetId());
			request.setAttribute("pseudo", user.getPseudo());
			request.setAttribute("prenom", user.getPrenom());
			request.setAttribute("tel", user.getTelephone());
			request.setAttribute("cp", user.getCode_postal());
			request.setAttribute("nom", user.getNom());
			request.setAttribute("Email", user.getEmail());
			request.setAttribute("Rue", user.getRue());
			request.setAttribute("ville", user.getVille());
			this.getServletContext().getRequestDispatcher("/WEB-INF/PageAffichageInfosUtilisateur.jsp").forward(request, response);
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
				this.getServletContext().getRequestDispatcher("/WEB-INF/PageAffichageInfosUtilisateur.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
    	if(session.getAttribute("pseudo") == null ) 
    	{
			response.sendRedirect("/Enchere/Accueil");
    	}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageModificationProfil.jsp");
			rd.forward(request, response);
		}
	}

}
