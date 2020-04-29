package dal.DAO;

import dal.DAL;
import dal.Param;
import utils.SQLObject;
import utils.enums.SQLComparaisonType;
import utils.enums.SQLQueryType;

import java.sql.ResultSet;
import java.util.List;

public abstract class BaseDAO<T extends SQLObject> extends DAL implements IDAO<T>
{

    protected String tableName;
    protected String tableIdColumn;
    
    @Override
    public ResultSet SelectById(SQLObject sqlObject)
    {
        return SelectById(sqlObject.GetId());
    }

    @Override
    public ResultSet SelectById(int id)
    {
        String query = "SELECT * FROM " + tableName + MakeWhere(new Param(tableIdColumn, id), SQLComparaisonType.EQUALS);

        return DoSQuery(query);
    }

    @Override
    public ResultSet SelectAll()
    {
        String query = "SELECT * FROM " + tableName;

        return DoSQuery(query);
    }

    @Override
    public ResultSet Update(SQLObject sqlObject)
    {
        return DoIUQuery(
                MakeQueryFromParams(
                        SQLQueryType.UPDATE,
                        tableName,
                        sqlObject.GetQueryNoId()
                ) + MakeWhere(sqlObject.GetSQLId(), SQLComparaisonType.EQUALS)
                , sqlObject.GetQueryNoId()
        );
    }

    @Override
    public ResultSet Update(SQLObject sqlObject, List<Param> params)
    {
        return DoIUQuery(
                MakeQueryFromParams(
                        SQLQueryType.UPDATE,
                        tableName,
                        params
                ) + MakeWhere(sqlObject.GetSQLId(), SQLComparaisonType.EQUALS)
                , params
        );
    }

    @Override
    public ResultSet Update(int id, List<Param> params)
    {
        return DoIUQuery(
                MakeQueryFromParams(
                        SQLQueryType.UPDATE,
                        tableName,
                        params
                ) + MakeWhere(new Param(tableIdColumn, id), SQLComparaisonType.EQUALS)
                , params
        );
    }

    @Override
    public ResultSet Insert(SQLObject sqlObject)
    {
        return DoIUQuery(
                MakeQueryFromParams(
                        SQLQueryType.INSERT,
                        tableName,
                        sqlObject.GetQueryNoId()
                )
                , sqlObject.GetQueryNoId()
        );
    }

    @Override
    public int Delete(SQLObject sqlObject)
    {
        return Delete(sqlObject.GetId());
    }

    @Override
    public int Delete(int id)
    {
        String query = "DELETE FROM " + tableName + MakeWhere(new Param(tableIdColumn, id), SQLComparaisonType.EQUALS);
        return DoDQuery(query);
    }
    
}
