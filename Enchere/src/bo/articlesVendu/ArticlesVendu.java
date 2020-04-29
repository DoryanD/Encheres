package bo.articlesVendu;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dal.Param;
import utils.SQLObject;

public class ArticlesVendu implements SQLObject
{
	
	private Integer no_article;
    private String nom_article;
    private String description;
	private Date date_debut_encheres;
	private Date date_fin_encheres;
    private Float prix_initial;
    private Float prix_vente;
    private Integer no_utilisateur;
    private Integer no_categorie;

    //allColumns
    public ArticlesVendu(Integer no_article, String nom_article, String description, Date date_debut_encheres,
							Date date_fin_encheres, Float prix_initial, Float prix_vente, Integer no_utilisateur,
							Integer no_categorie)
    {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
    //without no_article
    public ArticlesVendu(String nom_article, String description, Date date_debut_encheres,
							Date date_fin_encheres, Float prix_initial, Float prix_vente, Integer no_utilisateur,
							Integer no_categorie)
    {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
    //without prix_intial & prix_vente
    public ArticlesVendu(Integer no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, Integer no_utilisateur,
			Integer no_categorie)
	{
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
    //without prix_intial
    public ArticlesVendu(Integer no_article, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, Float prix_initial, Integer no_utilisateur,
			Integer no_categorie)
	{
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
    //without prix_vente
    public ArticlesVendu(Integer no_article, String nom_article, String description, Date date_debut_encheres,
    		Float prix_vente, Date date_fin_encheres, Integer no_utilisateur,
			Integer no_categorie)
	{
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
  //without prix_vente & no_article
    public ArticlesVendu(String nom_article, String description, Date date_debut_encheres,
    		Float prix_vente, Date date_fin_encheres, Integer no_utilisateur,
			Integer no_categorie)
	{
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
    //without prix_intial & prix_vente & no_article
    public ArticlesVendu(String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, Integer no_utilisateur,
			Integer no_categorie)
	{
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
    
    //without prix_intial & no_article
    public ArticlesVendu(String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, Float prix_initial, Integer no_utilisateur,
			Integer no_categorie)
	{
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}

	@Override
	public List<Param> GetAllQuery() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_article", no_article));
		ret.add(new Param("nom_article", nom_article));
		ret.add(new Param("description", description));
		ret.add(new Param("date_debut_encheres", date_debut_encheres));
		ret.add(new Param("date_fin_encheres", date_fin_encheres));
		ret.add(new Param("prix_initial", prix_initial));
		ret.add(new Param("prix_vente", prix_vente));
		ret.add(new Param("no_utilisateur", no_utilisateur));
		ret.add(new Param("no_categorie", no_categorie));
		return ret;
	}

	@Override
	public List<Param> GetQueryNoId() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("nom_article", nom_article));
		ret.add(new Param("description", description));
		ret.add(new Param("date_debut_encheres", date_debut_encheres));
		ret.add(new Param("date_fin_encheres", date_fin_encheres));
		ret.add(new Param("prix_initial", prix_initial));
		ret.add(new Param("prix_vente", prix_vente));
		ret.add(new Param("no_utilisateur", no_utilisateur));
		ret.add(new Param("no_categorie", no_categorie));
		return ret;
	}

	@Override
	public Param GetSQLId() {
		return new Param("no_article", no_article);
	}

	@Override
	public int GetId() {
		return no_article;
	}
	
	@Override
	public String toString() {
		return "ArticlesVendu [no_article=" + no_article + ", nom_article=" + nom_article + ", description="
				+ description + ", date_debut_encheres=" + date_debut_encheres + ", date_fin_encheres="
				+ date_fin_encheres + ", prix_initial=" + prix_initial + ", prix_vente=" + prix_vente
				+ ", no_utilisateur=" + no_utilisateur + ", no_categorie=" + no_categorie + "]";
	}	

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(Date date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public Date getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(Date date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public Float getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(Float prix_initial) {
		this.prix_initial = prix_initial;
	}

	public Float getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(Float prix_vente) {
		this.prix_vente = prix_vente;
	}

	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public Integer getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}

	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}
	
	

}
