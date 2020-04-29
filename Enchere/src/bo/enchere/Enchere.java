package bo.enchere;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dal.Param;
import utils.SQLObject;

public class Enchere implements SQLObject
{

	private Integer no_enchere;
	private Integer no_utilisateur;
	private Integer no_article;
	private Date date_enchere;
	private Float montant_enchere;
	
	//allColumns
	public Enchere(Integer no_enchere, Integer no_utilisateur, Integer no_article, Date date_enchere,
			Float montant_enchere) {
		super();
		this.no_enchere = no_enchere;
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}
	
	//without no_enchere
	public Enchere(Integer no_utilisateur, Integer no_article, Date date_enchere,
			Float montant_enchere) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	@Override
	public List<Param> GetAllQuery() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_enchere", no_enchere));
		ret.add(new Param("no_utilisateur", no_utilisateur));
		ret.add(new Param("no_article", no_article));
		ret.add(new Param("date_enchere", date_enchere));
		ret.add(new Param("montant_enchere", montant_enchere));
		return ret;
	}

	@Override
	public List<Param> GetQueryNoId() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_utilisateur", no_utilisateur));
		ret.add(new Param("no_article", no_article));
		ret.add(new Param("date_enchere", date_enchere));
		ret.add(new Param("montant_enchere", montant_enchere));
		return ret;
	}

	@Override
	public Param GetSQLId() {
		return new Param("no_enchere", no_enchere);
	}

	@Override
	public int GetId() {
		return this.no_enchere;
	}

	@Override
	public String toString() {
		return "Enchere [no_enchere=" + no_enchere + ", no_utilisateur=" + no_utilisateur + ", no_article=" + no_article
				+ ", date_enchere=" + date_enchere + ", montant_enchere=" + montant_enchere + "]";
	}

	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public Integer getNo_article() {
		return no_article;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}

	public Date getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}

	public Float getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public void setNo_enchere(Integer no_enchere) {
		this.no_enchere = no_enchere;
	}

}
