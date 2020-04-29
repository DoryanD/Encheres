package utils;

import dal.Param;

import java.util.List;

public interface SQLObject
{

    List<Param> GetAllQuery();
    List<Param> GetQueryNoId();
    Param GetSQLId();
    int GetId();

}
