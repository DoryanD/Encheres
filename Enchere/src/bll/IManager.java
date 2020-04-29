package bll;

import java.util.List;

import utils.SQLObject;
import utils.Exceptions.BLLException;

public interface IManager<T extends SQLObject>
{
	
	List<T> selectAll();
	Integer add(T object) throws BLLException;
	void update(T object) throws BLLException;
	void delete(Integer index);
	boolean isObjectCorrect(T object);
	T get(Integer index);
	void closeConnection();

}
