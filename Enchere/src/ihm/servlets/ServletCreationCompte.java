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
 * Servlet implementation class ServletCreationCompte
 */
@WebServlet("/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageCreationProfil");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pseudo = (String) request.getParameter("pseudo");
		String prenom = (String) request.getParameter("prenom");
		String tel = (String) request.getParameter("tel");
		String cp = (String) request.getParameter("cp");
		String mdp = (String) request.getParameter("mdp");
		String nom = (String) request.getParameter("nom");
		String Email = (String) request.getParameter("Email");
		String Rue = (String) request.getParameter("Rue");
		String ville = (String) request.getParameter("ville");
		Boolean admin = false;
		int credit = 0;
		if(mdp.equals(request.getParameter("mdpconfirm")))
		{
			Utilisateur UtiCreer = new Utilisateur(id,pseudo,nom,prenom,Email,tel,Rue,cp,ville,mdp,credit,admin);
			UtilisateursManager instance = UtilisateursManager.getInstance();
			try
			{
				instance.add(UtiCreer);
			} 
			catch (BLLException e) 
			{
				e.printStackTrace();
			}
		}
		
		
	}

}
