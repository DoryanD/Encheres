package dal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.retrait.Retrait;

public class RetraitsDAO extends BaseDAO<Retrait>
{

	public RetraitsDAO()
	{
		this.setTableName(this.getClass().getSimpleName().replace("DAO", "").toUpperCase());
	    this.setTableIdColumn("no_retrait");
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
	public List<Retrait> ParseToList(ResultSet resultSet) {
		List<Retrait> ret = new ArrayList<>();
		try
		{	
			while(resultSet.next())
			{
				Integer no_retrait = resultSet.getInt(this.tableIdColumn);
				Integer no_article = resultSet.getInt("no_article");
				String rue = resultSet.getString("rue");
				String code_postal = resultSet.getString("code_postal");
				String ville = resultSet.getString("ville");
				
				ret.add(new Retrait(no_retrait, no_article, rue, code_postal, ville));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}

}
