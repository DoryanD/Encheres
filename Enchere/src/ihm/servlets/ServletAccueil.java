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
import bo.articlesVendu.ArticlesVendu;
import bo.categorie.Categorie;
import bo.enchere.Enchere;

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
        List<Categorie> listeCategorie = new ArrayList<>();
        listeCategorie = troisiemeManager.selectAll();
        request.setAttribute("listeCategorie", listeCategorie);
		List<Enchere> lesEncheresPasFiltre = new ArrayList<>();
		List<Enchere> lesEncheresFiltre = new ArrayList<>();
		lesEncheresPasFiltre = leManager.selectAll();
		Date dateAuj = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if(request.getParameter("enchOuv") != null)
		{
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				if(larticle.getDate_debut_encheres().before(dateAuj) && larticle.getDate_fin_encheres().after(dateAuj))
				{
					lesEncheresFiltre.add(enchere);
				}
			}
		}
		if(request.getParameter("mesEnchEnCours") != null)
		{
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				if(larticle.getDate_debut_encheres().before(dateAuj) && larticle.getDate_fin_encheres().after(dateAuj) && enchere.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					lesEncheresFiltre.add(enchere);			
				}
			}
		}
		if(request.getParameter("mesEnchRemp") != null)
		{
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				if(larticle.getDate_fin_encheres().before(dateAuj) && enchere.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					lesEncheresFiltre.add(enchere);			
				}
			}
		}
		if(request.getParameter("venEnCours") != null)
		{
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				if(larticle.getDate_debut_encheres().before(dateAuj) && larticle.getDate_fin_encheres().after(dateAuj) && larticle.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					lesEncheresFiltre.add(enchere);			
				}
			}
		}
		if(request.getParameter("venNonDeb") != null)
		{
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				if(larticle.getDate_debut_encheres().before(dateAuj) && larticle.getDate_fin_encheres().after(dateAuj) && larticle.getNo_utilisateur().equals(session.getAttribute("id")))
				{
					lesEncheresFiltre.add(enchere);			
				}
			}
		}
		if(request.getParameter("venTerm") != null)
		{
				for (Enchere enchere : lesEncheresPasFiltre) 
				{
					ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
					if( larticle.getDate_fin_encheres().before(dateAuj) && larticle.getNo_utilisateur().equals(session.getAttribute("id")))
					{
						lesEncheresFiltre.add(enchere);			
					}
				}
		}
		if(request.getParameter("categorie") != null)
		{
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				int nocategorie = Integer.parseInt(request.getParameter("categorie"));
				if(larticle.getNo_categorie() == nocategorie)
				{
					lesEncheresFiltre.add(enchere);			
				}
			}
		}
		if(request.getParameter("filtre") != null)
		{
			String filtre = request.getParameter("filtre");
			for (Enchere enchere : lesEncheresPasFiltre) 
			{
				ArticlesVendu larticle = deuxiemeManager.get(enchere.getNo_article());
				if(larticle.getNom_article().contains(filtre))
				{
					lesEncheresFiltre.add(enchere);			
				}
			}
		}
		if(lesEncheresFiltre.isEmpty())
		{
			lesEncheresFiltre = lesEncheresPasFiltre;
		}
		request.setAttribute("listeEncheres", lesEncheresFiltre);
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
