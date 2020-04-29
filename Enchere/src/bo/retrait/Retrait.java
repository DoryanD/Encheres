package bo.retrait;

import java.util.ArrayList;
import java.util.List;

import dal.Param;
import utils.SQLObject;

public class Retrait implements SQLObject
{
	
	private Integer no_retrait;
	private Integer no_article;
	private String rue;
	private String code_postal;
	private String ville;	
	
	//allColumns
	public Retrait(Integer no_retrait, Integer no_article, String rue, String code_postal, String ville) {
		super();
		this.no_retrait = no_retrait;
		this.no_article = no_article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	
	//without no_retrait
	public Retrait(Integer no_article, String rue, String code_postal, String ville) {
		super();
		this.no_article = no_article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	@Override
	public List<Param> GetAllQuery() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_retrait", no_retrait));
		ret.add(new Param("no_article", no_article));
		ret.add(new Param("rue", rue));
		ret.add(new Param("code_postal", code_postal));
		ret.add(new Param("ville", ville));
		return ret;
	}

	@Override
	public List<Param> GetQueryNoId() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_article", no_article));
		ret.add(new Param("rue", rue));
		ret.add(new Param("code_postal", code_postal));
		ret.add(new Param("ville", ville));
		return ret;
	}

	@Override
	public Param GetSQLId() {
		return new Param("no_retrait", no_retrait);
	}

	@Override
	public int GetId() {
		return this.no_retrait;
	}

	@Override
	public String toString() {
		return "Retrait [no_retrait=" + no_retrait + ", no_article=" + no_article + ", rue=" + rue + ", code_postal="
				+ code_postal + ", ville=" + ville + "]";
	}

	public Integer getNo_article() {
		return no_article;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setNo_retrait(Integer no_retrait) {
		this.no_retrait = no_retrait;
	}	

}
