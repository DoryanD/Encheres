package utils.enums;

public enum SQLComparaisonType
{

    EQUALS("="),
    INFERIOR("<="),
    INFERIOR_STRICT("<"),
    SUPERIOR(">="),
    SUPERIOR_STRICT(">"),
    ;

    String oprator;

    SQLComparaisonType(String oprator)
    {
        this.oprator = oprator;
    }

    public String getOprator()
    {
        return oprator;
    }

    public void setOprator(String oprator)
    {
        this.oprator = oprator;
    }

}
