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
import bll.CategorieManager;
import bll.EncheresManager;
import bll.UtilisateursManager;
import bo.articlesVendu.ArticlesVendu;
import bo.categorie.Categorie;
import bo.enchere.Enchere;
import bo.utilisateur.Utilisateur;

/**
 * Servlet implementation class Accueil
 */
@WebServlet( name="ServletAccueil", urlPatterns = {"/Accueil"} )
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		EncheresManager leManager = EncheresManager.getInstance();
		ArticlesVendusManager deuxiemeManager = ArticlesVendusManager.getInstance();
		CategorieManager troisiemeManager = CategorieManager.getInstance();
		List<ArticlesVendu> listeArticlesNonFiltre = new ArrayList<>();
		List<ArticlesVendu> listeArticlesFiltre = new ArrayList<>();
		listeArticlesNonFiltre = deuxiemeManager.selectAll();
        	List<Categorie> listeCategorie = new ArrayList<>();
        	
        UtilisateursManager userManager = UtilisateursManager.getInstance();
        List<Utilisateur> listeUtilisateur = new ArrayList<>();
        listeUtilisateur = userManager.selectAll();
        
        for (ArticlesVendu article : listeArticlesNonFiltre) {
			article.getDate_fin_encheres();
			
			article.getNo_utilisateur();
			article.getPrix_vente();
			String nomVendeur = userManager.get(article.getNo_utilisateur()).getPseudo();
//			request.setParameter("nomUtilisateur",nomVendeur);
System.out.println(article.getNom_article());
		}
        	listeCategorie = troisiemeManager.selectAll();
        	request.setAttribute("listeArticlesNonFiltre", listeArticlesNonFiltre);
        	request.setAttribute("listeCategorie", listeCategorie);
		Date dateAuj = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
			
		if(request.getParameter("enchOuv") != null)
		{
			for (ArticlesVendu Article : listeArticlesNonFiltre) 
			{
				if(Article.getDate_debut_encheres().before(dateAuj) && Article.getDate_fin_encheres().after(dateAuj))
				{
					listeArticlesFiltre.add(Article);
				}
			}
		}
		if(request.getParameter("mesEnchEnCours") != null)
		{
			for (ArticlesVendu Article : listeArticlesNonFiltre) 
			{
				if(Article.getDate_debut_encheres().before(dateAuj) && Article.getDate_fin_encheres().after(dateAuj) && Article.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					listeArticlesFiltre.add(Article);			
				}
			}
		}
		if(request.getParameter("mesEnchRemp") != null)
		{
			for (ArticlesVendu Article : listeArticlesNonFiltre)  
			{	
				if(Article.getDate_fin_encheres().before(dateAuj) && Article.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					listeArticlesFiltre.add(Article);			
				}
			}
		}
		if(request.getParameter("venEnCours") != null)
		{
			for (ArticlesVendu Article : listeArticlesNonFiltre)  
			{
				if(Article.getDate_debut_encheres().before(dateAuj) && Article.getDate_fin_encheres().after(dateAuj) && Article.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					listeArticlesFiltre.add(Article);			
				}
			}
		}
		if(request.getParameter("venNonDeb") != null)
		{
			for (ArticlesVendu Article : listeArticlesNonFiltre) 
			{
				if(Article.getDate_debut_encheres().before(dateAuj) && Article.getDate_fin_encheres().after(dateAuj) && Article.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					listeArticlesFiltre.add(Article);			
				}
			}
		}
		if(request.getParameter("venTerm") != null)
		{
				for (ArticlesVendu Article : listeArticlesNonFiltre) 
				{
					if( Article.getDate_fin_encheres().before(dateAuj) && Article.getNo_utilisateur().equals(session.getAttribute("id")))
					{
						listeArticlesFiltre.add(Article);			
					}
				}
		}
		if(request.getParameter("categorie") != null)
		{
			for (ArticlesVendu Article : listeArticlesNonFiltre)  
			{
				int nocategorie = Integer.parseInt(request.getParameter("categorie"));
				if(Article.getNo_categorie() == nocategorie)
				{
					listeArticlesFiltre.add(Article);			
				}
			}
		}
		if(request.getParameter("filtre") != null)
		{
			String filtre = request.getParameter("filtre");
			for (ArticlesVendu Article : listeArticlesNonFiltre) 
			{
				if(Article.getNom_article().contains(filtre))
				{
					listeArticlesFiltre.add(Article);			
				}
			}
		}
		if(listeArticlesFiltre.isEmpty())
		{
			listeArticlesFiltre = listeArticlesNonFiltre;
		}
		request.setAttribute("listeArticles",listeArticlesFiltre);
    	if(session.getAttribute("pseudo")!=null) 
    	{
    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/LesEncheresConnecte.jsp");
			rd.forward(request, response);
    	}
    	else 
    	{	
    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/LesEncheresDeconnecte.jsp");
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
