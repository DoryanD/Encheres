package dal.DAO;

import dal.Param;
import utils.SQLObject;

import java.sql.ResultSet;
import java.util.List;

public interface IDAO<T extends SQLObject >
{

    void setTableName(String name);
    void setTableIdColumn(String name);

    ResultSet SelectById(SQLObject sqlObject);
    ResultSet SelectById(int id);
    ResultSet SelectAll();
    ResultSet Update(SQLObject sqlObject);
    ResultSet Update(SQLObject sqlObject, List<Param> params);
    ResultSet Update(int id, List<Param> params);
    ResultSet Insert(SQLObject sqlObject);
    int Delete(SQLObject sqlObject);
    int Delete(int id);

    List<T> ParseToList(ResultSet resultSet);

}
