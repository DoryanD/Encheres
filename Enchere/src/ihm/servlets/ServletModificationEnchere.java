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
import bll.EncheresManager;
import bll.RetraitsManager;
import bll.UtilisateursManager;
import bo.articlesVendu.ArticlesVendu;
import bo.enchere.Enchere;
import bo.retrait.Retrait;
import bo.utilisateur.Utilisateur;
import utils.Exceptions.BLLException;

/**
 * Servlet implementation class ServletModificationEnchere
 */
@WebServlet("/ServletModificationEnchere")
public class ServletModificationEnchere extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("pseudo") !=null) 
    	{
			int noEnchere = (int) session.getAttribute("idEnchere");
			EncheresManager PremierManager = EncheresManager.getInstance();
			ArticlesVendusManager DeuxiemeManager = ArticlesVendusManager.getInstance();
			RetraitsManager TroisiemeManager = RetraitsManager.getInstance();
			UtilisateursManager QuatriemeManager = UtilisateursManager.getInstance();
			Enchere lenchere = PremierManager.get(noEnchere);
			int noArticle = lenchere.getNo_article();
			session.setAttribute("noArticle",noArticle);
			
			ArticlesVendu larticle = DeuxiemeManager.get(noArticle);
			List<Retrait> listeRetraits = new ArrayList<>();
			listeRetraits = TroisiemeManager.selectAll();
			Retrait LeRetrait = null;
			for (Retrait retrait : listeRetraits) 
			{
				if(retrait.getNo_article() == noArticle)
				{
					LeRetrait = retrait;
					session.setAttribute("noRetrait",LeRetrait.GetId());
				}
			}
			int noVendeur = lenchere.getNo_utilisateur();
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
			String nomArticle = (String) request.getParameter("nomArticle");
			String description = (String) request.getParameter("description");
			Date debEnch, finEnch;
			debEnch = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			finEnch = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			try 
			{
				 debEnch = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("debEnch"));
				 finEnch = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("finEnch"));
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
			int categorie = Integer.parseInt(request.getParameter("categorie"));	
			/* METTRE LE TRUC POUR LIMAGE */	
			float prix = Float.parseFloat(request.getParameter("prix"));	
			int no_utilisateur = (int) session.getAttribute("id");
			int noArticle = (int) session.getAttribute("noArticle");
			int noRetrait = (int) session.getAttribute("noRetrait");
			ArticlesVendu unArticle = new ArticlesVendu(noArticle,nomArticle,description,debEnch,finEnch,prix,prix,no_utilisateur,categorie);
			ArticlesVendusManager leManager = ArticlesVendusManager.getInstance();
			try 
			{
				leManager.update(unArticle);
				String rueRetrait = (String) request.getParameter("rueRetrait");
				String cp = (String) request.getParameter("cp");
				String ville = (String) request.getParameter("ville");
				Retrait unRetrait = new Retrait(noRetrait,noArticle,rueRetrait,cp,ville);
				RetraitsManager deuxiemeManager = RetraitsManager.getInstance();
				try 
				{
					deuxiemeManager.update(unRetrait);
					response.sendRedirect("/Enchere/AffichageEnchere");
				} 
				catch (BLLException e) 
				{
					e.printStackTrace();
				}
			} 
			catch (BLLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("/Enchere/AffichageEnchere");
		}
	}

}
