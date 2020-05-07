package ihm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import bll.RetraitsManager;
import bo.articlesVendu.ArticlesVendu;
import bo.categorie.Categorie;
import bo.enchere.Enchere;
import bo.retrait.Retrait;
import fr.eni.encheres.bll.EnchereManager;
import utils.Exceptions.BLLException;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		CategorieManager troisiemeManager = CategorieManager.getInstance();
		List<Categorie> listeCategorie = new ArrayList<>();
		listeCategorie = troisiemeManager.selectAll();
		request.setAttribute("listeCategorie", listeCategorie);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/PageNouvelleVente.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nomArticle = (String) request.getParameter("nomArticle");
		String description = (String) request.getParameter("description");
		Date debEnch, finEnch;
		debEnch = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		finEnch = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		//		try 
		//		{
		//			 debEnch = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("debEnch"));
		//			 finEnch = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("finEnch"));
		//		} 
		//		catch (ParseException e) 
		//		{
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		debEnch = Date.valueOf(request.getParameter("debEnch"));
		finEnch = Date.valueOf(request.getParameter("finEnch"));

		int categorie = Integer.parseInt(request.getParameter("categorie"));	
		/* METTRE LE TRUC POUR LIMAGE */	
		float prix = Float.parseFloat(request.getParameter("prix"));	
		HttpSession session = request.getSession();
		int no_utilisateur = Integer.parseInt("" + session.getAttribute("id"));
		ArticlesVendu unArticle = new ArticlesVendu(nomArticle,description,debEnch,finEnch,prix,prix,no_utilisateur,categorie);

		String rueRetrait = (String) request.getParameter("rueRetrait");
		String cp = (String) request.getParameter("cp");
		String ville = (String) request.getParameter("ville");
		ArticlesVendusManager leManager = ArticlesVendusManager.getInstance();
		try 
		{
			int noArticle;
			noArticle = leManager.add(unArticle);
			Retrait unRetrait = new Retrait(no_utilisateur,noArticle,rueRetrait,cp,ville);
			RetraitsManager deuxiemeManager = RetraitsManager.getInstance();

			deuxiemeManager.add(unRetrait);
			response.sendRedirect("/Enchere/AffichageEnchere");
			Enchere lenchere = new Enchere(no_utilisateur,noArticle,debEnch,prix);
			EncheresManager lenchereManager = EncheresManager.getInstance();
			System.out.println(lenchere.toString());
			lenchereManager.add(lenchere); 

		} 
		catch (BLLException e) 
		{
			e.printStackTrace();
		}
	}

}
