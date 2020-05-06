package bll;

import bo.enchere.Enchere;
import dal.DAO.EncheresDAO;

public class EncheresManager extends BaseManager<Enchere, EncheresDAO>
{
	
	private static EncheresManager instance;
	
	public static EncheresManager getInstance() {
		if(instance == null)
			instance = new EncheresManager();
		
		return instance;
	}
	
	private EncheresManager()
	{
		this.setManagerDAO(new EncheresDAO());
	}

	@Override
	public boolean isObjectCorrect(Enchere object) {
		boolean itsOk = true;
		itsOk &= object.getDate_enchere().toLocalDate().toString() != "";
        itsOk &= object.getMontant_enchere() >= 0;

        return itsOk;
	}

}
