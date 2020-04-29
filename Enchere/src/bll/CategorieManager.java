package bll;

import bo.categorie.Categorie;
import dal.DAO.CategoriesDAO;

public class CategorieManager extends BaseManager<Categorie, CategoriesDAO>
{
	
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null)
			instance = new CategorieManager();
		
		return instance;
	}
	
	private CategorieManager()
	{
		this.managerDAO = new CategoriesDAO();
	}

	@Override
	public boolean isObjectCorrect(Categorie object) {
		boolean itsOk = true;
        itsOk &= object.getLibelle() != "";

        return itsOk;
	}

}
