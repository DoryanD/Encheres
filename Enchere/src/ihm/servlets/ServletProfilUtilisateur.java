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

/**
 * Servlet implementation class ProfilUtilisateur
 */
@WebServlet("/ProfilUtilisateur")
public class ServletProfilUtilisateur extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur = new Utilisateur();
	private static UtilisateursManager utilisateurManager = UtilisateursManager.getInstance();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("pseudo") ==null) 
    	{
			response.sendRedirect("/Encheres/ihm.servlets/Accueil");
    	}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageProfilUtilisateur");
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
