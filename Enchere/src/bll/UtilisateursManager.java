package bll;

import bo.utilisateur.Utilisateur;
import dal.DAO.UtilisateursDAO;

public class UtilisateursManager extends BaseManager<Utilisateur, UtilisateursDAO>
{
	
	private static UtilisateursManager instance;
	
	public static UtilisateursManager getInstance() {
		if(instance == null)
			instance = new UtilisateursManager();
		
		return instance;
	}
	
	private UtilisateursManager()
	{
		this.managerDAO = new UtilisateursDAO();
	}

	@Override
	public boolean isObjectCorrect(Utilisateur object) {
		boolean itsOk = true;
		itsOk &= object.getPseudo() != "";
		itsOk &= object.getNom() != "";
		itsOk &= object.getPrenom() != "";
		itsOk &= object.getEmail() != "";
		itsOk &= object.getRue() != "";
		itsOk &= object.getCode_postal() != "";
		itsOk &= object.getVille() != "";
		itsOk &= object.getMot_de_passe() != "";
		
        return itsOk;
	}

}
