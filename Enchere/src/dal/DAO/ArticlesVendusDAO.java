package dal.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.articlesVendu.ArticlesVendu;

public class ArticlesVendusDAO extends BaseDAO<ArticlesVendu>
{

	public ArticlesVendusDAO()
	{
		this.setTableName("ARTICLES_VENDUS");
	    this.setTableIdColumn("no_article");
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
	public List<ArticlesVendu> ParseToList(ResultSet resultSet) {
		List<ArticlesVendu> ret = new ArrayList<>();
		try
		{
			while(resultSet.next())
			{
				Integer no_article = resultSet.getInt(this.tableIdColumn);
			    String nom_article = resultSet.getString("nom_article");
			    String description = resultSet.getString("description");
				Date date_debut_encheres = resultSet.getDate("date_debut_encheres");
				Date date_fin_encheres = resultSet.getDate("date_fin_encheres");
			    Float prix_initial = resultSet.getFloat("prix_initial");
			    Float prix_vente = resultSet.getFloat("prix_vente");
			    Integer no_utilisateur = resultSet.getInt("no_utilisateur");
			    Integer no_categorie = resultSet.getInt("no_categorie");
				
				ret.add(new ArticlesVendu(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

}
