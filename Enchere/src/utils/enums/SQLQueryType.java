package utils.enums;

public enum SQLQueryType
{

    SELECT("SELECT "),
    INSERT("INSERT INTO "),
    UPDATE("UPDATE "),
    DELETE("DROP TABLE ");

    private String keyWord;

    SQLQueryType(String keyWord)
    {
        this.keyWord = keyWord;
    }

    public String getKeyWord()
    {
        return keyWord;
    }

    public void setKeyWord(String keyWord)
    {
        this.keyWord = keyWord;
    }
}
