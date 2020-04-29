package dal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.categorie.Categorie;

public class CategoriesDAO extends BaseDAO<Categorie> {

	public CategoriesDAO()
	{
		this.setTableName(this.getClass().getSimpleName().replace("DAO", "").toUpperCase());
	    this.setTableIdColumn("no_categorie");
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
	public List<Categorie> ParseToList(ResultSet resultSet) {
		List<Categorie> ret = new ArrayList<>();
		try
		{
			while(resultSet.next())
			{
				Integer no_categorie = resultSet.getInt(this.tableIdColumn);
			    String libelle = resultSet.getString("libelle");
				
				ret.add(new Categorie(no_categorie, libelle));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

}
