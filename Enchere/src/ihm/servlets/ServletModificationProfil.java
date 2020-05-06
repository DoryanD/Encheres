package ihm.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			response.sendRedirect("/Enchere/Accueil");
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
			this.getServletContext().getRequestDispatcher("/WEB-INF/PageModificationProfil.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		boolean modifier = false;
		HttpSession session = request.getSession();
    	if(session.getAttribute("pseudo") !=null ) 
    	{
			response.sendRedirect("/Enchere/Accueil");
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
			if(id != request.getParameter("id") || pseudo != request.getParameter("pseudo") || prenom != request.getParameter("prenom") || tel != request.getParameter("tel") || cp != request.getParameter("cp") || mdpActuel != request.getParameter("mdp") || nom != request.getParameter("nom") || Email != request.getParameter("Email") || Rue != request.getParameter("Rue") || ville != request.getParameter("ville"))
			{
				modifier = true;
			}
			if(modifier == true)
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
				int credit = (int) session.getAttribute("credit");
				session.setAttribute("id", id);
				session.setAttribute("pseudo", pseudo);
				session.setAttribute("prenom", prenom);
				session.setAttribute("tel", tel);
				session.setAttribute("cp", cp);
				session.setAttribute("mdp", mdp);
				session.setAttribute("nom", nom);
				session.setAttribute("Email", Email);
				session.setAttribute("Rue", Rue);
				session.setAttribute("ville", ville);
				session.setAttribute("credit", credit);
				int id2 = Integer.parseInt(request.getParameter("id"));
				session.setAttribute("administrateur", session.getAttribute("administrateur"));
				Boolean administrateur = (Boolean) session.getAttribute("administrateur");
				Utilisateur UtiModifier = new Utilisateur(id2,pseudo,nom,prenom,Email,tel,Rue,cp,ville,mdp,credit,administrateur);
				UtilisateursManager instance = UtilisateursManager.getInstance();
				List<Utilisateur> laListe = new ArrayList<>();
				laListe = instance.selectAll();
				Boolean existe = false ;
				ResultSet result = instance.getManagerDAO().DoSQuery("SELECT IF(COUNT(pseudo) > 1, 1, 0) as result FROM UTILISATEURS WHERE pseudo = '" + pseudo + "' AND no_utilisateur != '"+ id2 +"'");
				try {
					existe = result.getInt("result") == 1;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!existe)
				{
					ResultSet result2 = instance.getManagerDAO().DoSQuery("SELECT IF(COUNT(email) > 1, 1, 0) as result FROM UTILISATEURS WHERE email = '" + Email + "'AND no_utilisateur != '"+ id2 +"'");
					try {
						existe = result2.getInt("result") > 1;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if(!existe)
				{
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
				}
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/PageProfilUtilisateur.jsp").forward(request, response);
			}
		}
	}

}
