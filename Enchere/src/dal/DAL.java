package dal;

import utils.enums.SQLComparaisonType;
import utils.enums.SQLParamType;
import utils.enums.SQLQueryType;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAL
{

    Connection con;

    public DAL()
    {
        try
        {
        	Context ctx = new InitialContext();
        	DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/pool_suivis_repas");
        	this.con = ds.getConnection();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Executer une query de type SELECT
     * @param query
     * @return ResultSet
     */
    public ResultSet DoSQuery(String query)
    {
        ResultSet resultSet = null;
        PreparedStatement state;
        try
        {
            state = con.prepareStatement(query);
            resultSet = state.executeQuery();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return resultSet;

    }

    /**
     * Executer une query de type INSERT ou UPDATE
     * @param query
     * @return ResultSet
     */
    public ResultSet DoIUQuery(String query, List<Param> params)
    {
        ResultSet ret = null;
        PreparedStatement state;
        try
        {
            state = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            state = bindParams(state, params);
            state.executeUpdate();
            ret = state.getGeneratedKeys();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return ret;

    }

    /**
     * Executer une query de type DELETE
     * @param query
     * @return ResultSet
     */
    public int DoDQuery(String query)
    {
        int ret = 0;
        PreparedStatement state;
        try
        {
            state = con.prepareStatement(query);
            ret = state.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return ret;

    }

    /**
     * Retourne une query en fonction des paramètres passés
     * @param queryType
     * @param table
     * @param params
     * @return String
     */
    public String MakeQueryFromParams(SQLQueryType queryType, String table, List<Param> params)
    {
        String query = queryType.getKeyWord() + (queryType != SQLQueryType.SELECT ? table : "");
        query += queryType == SQLQueryType.UPDATE ? " SET " : "";
        for (Param p : params)
        {
            switch (queryType)
            {

                case SELECT:
                    query += p.getName() + (p.equals(params.get(params.size() - 1)) ? " " : ", ");
                    break;
                case UPDATE:
                    query += p.getName() + " = ?" + (p.equals(params.get(params.size() - 1)) ? " " : ", ");
                    break;
            }
        }

        switch (queryType)
        {

            case SELECT:
                query += "FROM " + table;
                break;
            case INSERT:
                query += FormatToInsertQuery(params);
                break;
        }

        return query;
    }

    /**
     * Retourne une query en fonction du paramètre passé
     * @param queryType
     * @param table
     * @param params
     * @return String
     */
    public String MakeQueryFromParams(SQLQueryType queryType, String table, Param p)
    {
        String query = queryType.getKeyWord() + (queryType != SQLQueryType.SELECT ? table : "");
        query += queryType == SQLQueryType.UPDATE ? " SET " : "";
        switch (queryType)
        {
            case INSERT:
                query += "(" + p.getName() + ") VALUES (?)";
                break;
            case UPDATE:
                query += p.getName() + " = ?";
                break;
        }

        return query;
    }

    private String FormatToInsertQuery(List<Param> params)
    {
        String columns = "(";
        String values = "VALUES (";

        for (Param p : params)
        {
            columns += p.getName() + (p.equals(params.get(params.size() - 1)) ? " " : ", ");
            values += "?" + (p.equals(params.get(params.size() - 1)) ? " " : ", ");
        }

        return columns + ") " + values + ") ";
    }

    /**
     * Créer une WHERE CLAUSE
     * @param param
     * @param comparaisonType
     * @return
     */
    public String MakeWhere(Param param, SQLComparaisonType comparaisonType)
    {
        String c = param.getType() == SQLParamType.STRING ? "'" : "";
        return " WHERE " + param.getName() + comparaisonType.getOprator() + c + param.getValue() + c;
    }

    /**
     * Créer une WHERE CLAUSE
     * @param param
     * @param comparaisonType
     * @return
     */
    public String MakeWhere(List<Param> params, List<SQLComparaisonType> comparaisonType)
    {
        String whereClause = "WHERE ";
        for (int i = 0; i < params.size(); i++)
        {
            Param p = params.get(i);
            String c = p.getType() == SQLParamType.STRING ? "'" : "";
            whereClause += " WHERE" + p.getName() + comparaisonType.get(i).getOprator() + c + p.getValue() + c + (i != params.size() - 1 ? ", " : "");
        }

        return whereClause;
    }

    public void CloseConnection()
    {
        try
        {
            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private PreparedStatement bindParams(PreparedStatement state, List<Param> params)
    {
        for (int i = 0; i < params.size(); i++)
        {
            Param p = params.get(i);
            try
            {
                switch (p.getType())
                {
                    case STRING:
                        state.setString(i + 1, (String) p.getValue());
                        break;
                    case INTEGER:
                        state.setInt(i + 1, (Integer) p.getValue());
                        break;
                    case DOUBLE:
                        state.setDouble(i + 1, (Double) p.getValue());
                        break;
                    case FLOAT:
                        state.setFloat(i + 1, (Float) p.getValue());
                        break;
                    case BOOLEAN:
                        state.setBoolean(i + 1, (Boolean) p.getValue());
                        break;
                    case NULL:
                    	break;
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return state;
    }

    public String ResultSetToString(ResultSet resultSet)
    {
        String ret = "";
        try
        {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int nbColumns = rsmd.getColumnCount();
            while (resultSet.next())
            {
                for (int i = 1; i <= nbColumns; i++)
                {
                    if (i > 1) ret += ", \n";
                    String columnValue = resultSet.getString(i);
                    ret += "\t" + rsmd.getColumnName(i) + " : " + columnValue;
                }
                ret += "\n\n";
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return ret;
    }


}
