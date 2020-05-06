package bll;

import bo.retrait.Retrait;
import dal.DAO.RetraitsDAO;

public class RetraitsManager extends BaseManager<Retrait, RetraitsDAO>
{
	
	private static RetraitsManager instance;
	
	public static RetraitsManager getInstance() {
		if(instance == null)
			instance = new RetraitsManager();
		
		return instance;
	}
	
	private RetraitsManager()
	{
		this.setManagerDAO(new RetraitsDAO());
	}

	@Override
	public boolean isObjectCorrect(Retrait object) {
		boolean itsOk = true;
		itsOk &= object.getRue() != "";
		itsOk &= object.getCode_postal() != "";
		itsOk &= object.getVille() != "";

        return itsOk;
	}

}
