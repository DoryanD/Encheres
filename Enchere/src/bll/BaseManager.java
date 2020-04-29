package bll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dal.DAO.BaseDAO;
import utils.SQLObject;
import utils.Exceptions.BLLException;

public abstract class BaseManager<T extends SQLObject, D extends BaseDAO<T>> implements IManager<T>
{

	protected D managerDAO;

	@Override
	public List<T> selectAll()
	{
		return managerDAO.ParseToList(managerDAO.SelectAll());
	}

	@Override
	public Integer add(T object) throws BLLException {
		ResultSet temp;
		Integer ret = null;
		if(isObjectCorrect(object))
			temp = managerDAO.Insert(object);
        else
            throw new BLLException("Erreur d'insertion : toutes les variables doivent être renseignées");
		
		try {
			if(temp.next())
				ret = temp.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void update(T object) throws BLLException {
		if(isObjectCorrect(object))
			managerDAO.Update(object);
        else
            throw new BLLException("Erreur d'insertion : toutes les variables doivent être renseignées");		
	}

	@Override
	public void delete(Integer index) { managerDAO.Delete(index); }

	@Override
	public abstract boolean isObjectCorrect(T object);
	
	@Override
	public T get(Integer index) {
		ResultSet rs = managerDAO.SelectById(index);
        return managerDAO.ParseToList(rs).get(0);
	}

	@Override
	public void closeConnection() { managerDAO.CloseConnection(); }

}
