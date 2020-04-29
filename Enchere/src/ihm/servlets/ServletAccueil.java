package ihm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	HttpSession session = request.getSession();
    	if(session.getAttribute("pseudo")!=null) 
    	{
    		this.getServletContext().getRequestDispatcher("/LesEncheresConnecte").forward(request, response);
    	}
    	else 
    	{	
    		this.getServletContext().getRequestDispatcher("/LesEncheresDeconnecte").forward(request, response);
    	}
	}

}