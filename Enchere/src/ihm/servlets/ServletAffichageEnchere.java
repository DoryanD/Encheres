package ihm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.ArticlesVendusManager;
import bll.EncheresManager;
import bll.RetraitsManager;
import bll.UtilisateursManager;
import bo.articlesVendu.ArticlesVendu;
import bo.enchere.Enchere;
import bo.retrait.Retrait;
import bo.utilisateur.Utilisateur;
import utils.Exceptions.BLLException;

/**
 * Servlet implementation class ServletAffichageEnchere
 */
@WebServlet("/AffichageEnchere")
public class ServletAffichageEnchere extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		if (request.getParameter("idArticle") != null)
		{
			int noArticle = Integer.parseInt(request.getParameter("idArticle"));
			EncheresManager PremierManager = EncheresManager.getInstance();
			List<Enchere> lesEncheres = new ArrayList<>();
			lesEncheres = PremierManager.selectAll();
			Enchere lenchere = null;
			for (Enchere uneEnchere : lesEncheres)
			{
				if(uneEnchere.getNo_article() == noArticle && (lenchere == null || (lenchere != null && lenchere.getMontant_enchere() < uneEnchere.getMontant_enchere())))
				{
					lenchere = uneEnchere;
				}
			}
			ArticlesVendusManager DeuxiemeManager = ArticlesVendusManager.getInstance();
			RetraitsManager TroisiemeManager = RetraitsManager.getInstance();
			UtilisateursManager QuatriemeManager = UtilisateursManager.getInstance();
			ArticlesVendu larticle = DeuxiemeManager.get(noArticle);
			List<Retrait> listeRetraits = new ArrayList<>();
			listeRetraits = TroisiemeManager.selectAll();
			Retrait LeRetrait = null;
			for (Retrait retrait : listeRetraits) 
			{
				if(retrait.getNo_article() == noArticle)
				{
					LeRetrait = retrait;
				}
			}
			int noVendeur = lenchere.getNo_utilisateur();
			System.out.println(noVendeur);
			Utilisateur lutilisateur = QuatriemeManager.get(noVendeur);
			request.setAttribute("idEnchere", lenchere.GetId());
			request.setAttribute("idArticle", larticle.GetId());
			request.setAttribute("idUtilisateur", lutilisateur.GetId());
			request.setAttribute("Description", larticle.getDescription());
			request.setAttribute("NomArticle", larticle.getNom_article());
			request.setAttribute("Categorie", larticle.getNo_categorie());
			request.setAttribute("MeilleurOffre", lenchere.getMontant_enchere());
			request.setAttribute("MiseAPrix", larticle.getPrix_initial());
			request.setAttribute("DateFin", larticle.getDate_fin_encheres());
			request.setAttribute("Rue", LeRetrait.getRue());
			request.setAttribute("CP", LeRetrait.getCode_postal());
			request.setAttribute("Ville", LeRetrait.getVille());
			request.setAttribute("Vendeur", lutilisateur.getPseudo());
			/* AFFICHER PAGE AFFICHAGE ENCHERE */
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageAffichageEnchere.jsp");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("/Enchere/Accueil");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("pseudo") != null)
		{
			if(request.getParameter("montant") != null)
			{
				float montant = Float.parseFloat(request.getParameter("montant"));
				if(montant > Float.parseFloat(request.getParameter("MeilleurOffre")))
				{
					int idEnchere = Integer.parseInt(request.getParameter("idEnchere"));
					int idUtilisateur = Integer.parseInt(request.getParameter("idEnchere"));
					int idArticle =Integer.parseInt(request.getParameter("idEnchere"));
					Date DateEnchere = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					Enchere ModifEnchere = new Enchere(idEnchere,idUtilisateur,idArticle,DateEnchere,montant);
					EncheresManager ManagerUpdate = EncheresManager.getInstance();
					try
					{
						ManagerUpdate.update(ModifEnchere);
					} 
					catch (BLLException e) 
					{
						e.printStackTrace();
					}
				}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageAffichageEnchere.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			response.sendRedirect("/Enchere/Accueil");
		}
	}

}
