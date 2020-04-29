package dal.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.enchere.Enchere;

public class EncheresDAO extends BaseDAO<Enchere> {

	public EncheresDAO()
	{
		this.setTableName(this.getClass().getSimpleName().replace("DAO", "").toUpperCase());
	    this.setTableIdColumn("no_enchere");
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
	public List<Enchere> ParseToList(ResultSet resultSet) {
		List<Enchere> ret = new ArrayList<>();
		try
		{
			while(resultSet.next())
			{
				Integer no_enchere = resultSet.getInt(this.tableIdColumn);
				Integer no_utilisateur = resultSet.getInt("no_utilisateur");
				Integer no_article = resultSet.getInt("no_article");
				Date date_enchere = resultSet.getDate("date_enchere");
				Float montant_enchere = resultSet.getFloat("montant_enchere");
				
				ret.add(new Enchere(no_enchere, no_utilisateur, no_article, date_enchere, montant_enchere));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

}
