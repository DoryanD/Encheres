package bo.utilisateur;

import java.util.ArrayList;
import java.util.List;

import dal.Param;
import utils.SQLObject;

public class Utilisateur implements SQLObject
{
	
	private Integer no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private Integer credit;
	private Boolean administrateur;

	//allColumns
	public Utilisateur(Integer no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, Boolean administrateur) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	//without telephone
	public Utilisateur(Integer no_utilisateur, String pseudo, String nom, String prenom, String email,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, Boolean administrateur) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	//without no_utilisateur
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, Boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	//without telephone & no_utilisateur
	public Utilisateur(String pseudo, String nom, String prenom, String email,
			String rue, String code_postal, String ville, String mot_de_passe, Integer credit, Boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	public Utilisateur() 
	{
	}

	@Override
	public List<Param> GetAllQuery() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("no_utilisateur", no_utilisateur));
		ret.add(new Param("pseudo", pseudo));
		ret.add(new Param("nom", nom));
		ret.add(new Param("prenom", prenom));
		ret.add(new Param("email", email));
		ret.add(new Param("telephone", telephone));
		ret.add(new Param("rue", rue));
		ret.add(new Param("code_postal", code_postal));
		ret.add(new Param("ville", ville));
		ret.add(new Param("mot_de_passe", mot_de_passe));
		ret.add(new Param("credit", credit));
		ret.add(new Param("administrateur", administrateur));
		return ret;
	}

	@Override
	public List<Param> GetQueryNoId() {
		List<Param> ret = new ArrayList<>();
		ret.add(new Param("pseudo", pseudo));
		ret.add(new Param("nom", nom));
		ret.add(new Param("prenom", prenom));
		ret.add(new Param("email", email));
		ret.add(new Param("telephone", telephone));
		ret.add(new Param("rue", rue));
		ret.add(new Param("code_postal", code_postal));
		ret.add(new Param("ville", ville));
		ret.add(new Param("mot_de_passe", mot_de_passe));
		ret.add(new Param("credit", credit));
		ret.add(new Param("administrateur", administrateur));
		return ret;
	}

	@Override
	public Param GetSQLId() {
		return new Param("no_utilisateur", no_utilisateur);
	}

	@Override
	public int GetId() {
		return this.no_utilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_postal="
				+ code_postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

}
