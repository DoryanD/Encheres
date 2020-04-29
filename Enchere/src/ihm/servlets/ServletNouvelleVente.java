package ihm.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.articlesVendu.ArticlesVendu;

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
		
		this.getServletContext().getRequestDispatcher("/PageNouvelleVente").forward(request, response);
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
		try 
		{
			 debEnch = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("debEnch"));
			 finEnch = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("finEnch"));
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int categorie = Integer.parseInt(request.getParameter("categorie"));	
		/* METTRE LE TRUC POUR LIMAGE */	
		float prix = Float.parseFloat(request.getParameter("prix"));	
		HttpSession session = request.getSession();
		int no_utilisateur = (int) session.getAttribute("id");
		ArticlesVendu unArticle = new ArticlesVendu(nomArticle,description,debEnch,finEnch,prix,prix,no_utilisateur,categorie);
		
		String rueRetrait = (String) request.getParameter("rueRetrait");
		String cp = (String) request.getParameter("cp");
		String ville = (String) request.getParameter("ville");
	}

}
