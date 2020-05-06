package ihm.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageCreationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		String pseudo = (String) request.getParameter("pseudo");
		String prenom = (String) request.getParameter("prenom");
		String tel = (String) request.getParameter("tel");
		String cp = (String) request.getParameter("cp");
		String mdp = (String) request.getParameter("mdp");
		String nom = (String) request.getParameter("nom");
		String Email = (String) request.getParameter("Email");
		String Rue = (String) request.getParameter("Rue");
		String ville = (String) request.getParameter("ville");
		String mdpconfirm = (String) request.getParameter("mdpconfirm");
		Boolean admin = false;
		int credit = 1000;
		UtilisateursManager instance = UtilisateursManager.getInstance();
		List<Utilisateur> laListe = new ArrayList<>();
		laListe = instance.selectAll();
		Boolean existe = false ;
		ResultSet result = instance.managerDAO.DoSQuery("SELECT IF(COUNT(pseudo) > 1, 1, 0) as result FROM UTILISATEURS WHERE pseudo = '" + pseudo + "'");
		existe = result.getInt("result") == 1;
		if(!existe)
		{
			ResultSet result = instance.managerDAO.DoSQuery("SELECT IF(COUNT(email) > 1, 1, 0) as result FROM UTILISATEURS WHERE email = '" + Email + "'");
			existe = result.getInt("result") == 1;
		}
		if(!existe)
		{
			if(mdp.equals(mdpconfirm))
			{
				Utilisateur UtiCreer = new Utilisateur(pseudo,nom,prenom,Email,tel,Rue,cp,ville,mdp,credit,admin);
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
