package bll;

import bo.articlesVendu.ArticlesVendu;
import dal.DAO.ArticlesVendusDAO;

public class ArticlesVendusManager extends BaseManager<ArticlesVendu, ArticlesVendusDAO>
{

	private static ArticlesVendusManager instance;
	
	public static ArticlesVendusManager getInstance() {
		if(instance == null)
			instance = new ArticlesVendusManager();
		
		return instance;
	}
	
	private ArticlesVendusManager()
	{
		this.managerDAO = new ArticlesVendusDAO();
	}

	@Override
	public boolean isObjectCorrect(ArticlesVendu object) {
		boolean itsOk = true;
		itsOk &= object.getNom_article() != "";
		itsOk &= object.getDate_debut_encheres().toLocalDate().toString() != "";
		itsOk &= object.getDate_fin_encheres().toLocalDate().toString() != "";

        return itsOk;
	}

}
