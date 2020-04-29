package bo.categorie;

import java.util.ArrayList;
import java.util.List;

import dal.Param;
import utils.SQLObject;

public class Categorie implements SQLObject
{

	private Integer no_categorie;
	private String libelle;
	
	//allColumns
	public Categorie(Integer no_categorie, String libelle) {
		super();
		this.no_categorie = no_categorie;
		this.libelle = libelle;
	}
	
	//without no_categorie
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public List<Param> GetAllQuery() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_categorie", no_categorie));
		ret.add(new Param("libelle", libelle));
		return ret;
	}

	@Override
	public List<Param> GetQueryNoId() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("libelle", libelle));
		return ret;
	}

	@Override
	public Param GetSQLId() {
		return new Param("no_categorie", no_categorie);
	}

	@Override
	public int GetId() {
		return this.no_categorie;
	}

	@Override
	public String toString() {
		return "Categorie [no_categorie=" + no_categorie + ", libelle=" + libelle + "]";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}
	
}
