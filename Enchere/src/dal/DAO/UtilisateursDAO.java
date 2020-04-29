package dal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.utilisateur.Utilisateur;

public class UtilisateursDAO extends BaseDAO<Utilisateur> {

	public UtilisateursDAO()
	{
		this.setTableName(this.getClass().getSimpleName().replace("DAO", "").toUpperCase());
	    this.setTableIdColumn("no_utilisateur");
	}
	
	@Override
	public void setTableName(String name) {
		this.tableName = name;
	}

	@Override
	public void setTableIdColumn(String name) {
		this.tableIdColumn = name;
	}

	@Override
	public List<Utilisateur> ParseToList(ResultSet resultSet) {
		List<Utilisateur> ret = new ArrayList<>();
		try
		{	
			while(resultSet.next())
			{
				Integer no_utilisateur = resultSet.getInt(this.tableIdColumn);
				String pseudo = resultSet.getString("pseudo");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				String rue = resultSet.getString("rue");
				String code_postal = resultSet.getString("code_postal");
				String ville = resultSet.getString("ville");
				String mot_de_passe = resultSet.getString("mot_de_passe");
				Integer credit = resultSet.getInt("credit");
				Boolean administrateur = resultSet.getInt("administrateur") == 1;
				
				ret.add(new Utilisateur(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

}
