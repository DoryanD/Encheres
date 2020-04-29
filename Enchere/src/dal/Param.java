package dal;

import java.sql.Date;

import utils.enums.SQLParamType;

public class Param
{

    private SQLParamType type;
    private String       name;
    private Object       value;

    public Param(String value)
    {
        this.type = SQLParamType.STRING;
        this.value = value;
    }

    public Param(Integer value)
    {
        this.type = SQLParamType.INTEGER;
        this.value = value;
    }

    public Param(Float value)
    {
        this.type = SQLParamType.FLOAT;
        this.value = value;
    }

    public Param(Boolean value)
    {
        this.type = SQLParamType.BOOLEAN;
        this.value = value;
    }
    
    public Param(Date value)
    {
        this.type = SQLParamType.DATE;
        this.value = value;
    }

    public Param()
    {
        this.type = SQLParamType.NULL;
        this.value = null;
    }

    public Param(String name, String value)
    {
        this.name = name;
        this.type = SQLParamType.STRING;
        this.value = value;
    }

    public Param(String name, Integer value)
    {
        this.name = name;
        this.type = SQLParamType.INTEGER;
        this.value = value;
    }

    public Param(String name, Float value)
    {
        this.name = name;
        this.type = SQLParamType.FLOAT;
        this.value = value;
    }

    public Param(String name, Boolean value)
    {
        this.name = name;
        this.type = SQLParamType.BOOLEAN;
        this.value = value;
    }
    
    public Param(String name, Date value)
    {
    	this.name = name;
        this.type = SQLParamType.DATE;
        this.value = value;
    }

    public boolean isAnId()
    {
        return this.name.startsWith("id");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public SQLParamType getType()
    {
        return type;
    }

    public void setType(SQLParamType type)
    {
        this.type = type;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Param other = (Param) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
    
}
