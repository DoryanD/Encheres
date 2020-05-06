package bll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dal.DAO.BaseDAO;
import utils.SQLObject;
import utils.Exceptions.BLLException;

public abstract class BaseManager<T extends SQLObject, D extends BaseDAO<T>> implements IManager<T>
{

	private D managerDAO;

	@Override
	public List<T> selectAll()
	{
		return getManagerDAO().ParseToList(getManagerDAO().SelectAll());
	}

	@Override
	public Integer add(T object) throws BLLException {
		ResultSet temp;
		Integer ret = null;
		if(isObjectCorrect(object))
			temp = getManagerDAO().Insert(object);
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
			getManagerDAO().Update(object);
        else
            throw new BLLException("Erreur d'insertion : toutes les variables doivent être renseignées");		
	}

	@Override
	public void delete(Integer index) { getManagerDAO().Delete(index); }

	@Override
	public abstract boolean isObjectCorrect(T object);
	
	@Override
	public T get(Integer index) {
		ResultSet rs = getManagerDAO().SelectById(index);
        return getManagerDAO().ParseToList(rs).get(0);
	}

	@Override
	public void closeConnection() { getManagerDAO().CloseConnection(); }

	public D getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(D managerDAO) {
		this.managerDAO = managerDAO;
	}

}
