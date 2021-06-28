package model;
// Generated 26 mars 2021 � 22:40:09 by Hibernate Tools 5.1.10.Final

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sujet generated by hbm2java
 */
@Entity
@Table(name = "sujet", catalog = "evaly")
//@Table(name = "sujet", catalog = "u575564338_evaly")
public class Sujet implements java.io.Serializable {

	private Integer idSujet;
	private Formateur formateur;
	private Matiere matiere;
	private String nom;
	private Boolean isAutomaticGenerated;
	private String descriptionSujet;
	private Double noteMoyenne=0D;
	private Set<Examen> examens = new HashSet<Examen>(0);
	private Set<ReponseApprenantExamen> reponseApprenantExamens = new HashSet<ReponseApprenantExamen>(0);
	private Set<SujetQuestion> sujetQuestions = new HashSet<SujetQuestion>(0);
	private Set<ReponseApprenant> reponseApprenants = new HashSet<ReponseApprenant>(0);
	
	
	public Sujet() {
	}

	public Sujet(Formateur formateur, String nom, Boolean isAutomaticGenerated, String descriptionSujet,
			Double noteMoyenne, Set<ExamenSujet> examenSujets, Set<ReponseApprenantExamen> reponseApprenantExamens,
			Set<SujetQuestion> sujetQuestions, Set<ReponseApprenant> reponseApprenants) {
		this.formateur = formateur;
		this.nom = nom;
		this.isAutomaticGenerated = isAutomaticGenerated;
		this.descriptionSujet = descriptionSujet;
		this.noteMoyenne = noteMoyenne;
		this.reponseApprenantExamens = reponseApprenantExamens;
		this.sujetQuestions = sujetQuestions;
		this.reponseApprenants = reponseApprenants;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_sujet", unique = true, nullable = false)
	public Integer getIdSujet() {
		return this.idSujet;
	}

	public void setIdSujet(Integer idSujet) {
		this.idSujet = idSujet;
	}
	
	private Integer nbnotes=0;
	@Column(name = "nbnotes")
	public Integer getNbnotes() {
		return nbnotes;
	}

	public void setNbnotes(Integer nbnotes) {
		this.nbnotes = nbnotes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_formateur")
	public Formateur getFormateur() {
		return this.formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_matiere")
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Column(name = "nom", length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "is_automatic_generated")
	public Boolean getIsAutomaticGenerated() {
		return this.isAutomaticGenerated;
	}

	public void setIsAutomaticGenerated(Boolean isAutomaticGenerated) {
		this.isAutomaticGenerated = isAutomaticGenerated;
	}

	@Column(name = "description_suejt", length = 1000)
	public String getdescriptionSujet() {
		return this.descriptionSujet;
	}

	public void setdescriptionSujet(String descriptionSujet) {
		this.descriptionSujet = descriptionSujet;
	}

	@Column(name = "note_moyenne", precision = 22, scale = 0)
	public Double getNoteMoyenne() {
		double d = round(this.noteMoyenne,2);
		return d;
	}

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public void setNoteMoyenne(Double noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sujet")
	public Set<Examen> getExamens() {
		return this.examens;
	}

	public void setExamens(Set<Examen> examens) {
		this.examens = examens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sujet")
	public Set<ReponseApprenantExamen> getReponseApprenantExamens() {
		return this.reponseApprenantExamens;
	}

	public void setReponseApprenantExamens(Set<ReponseApprenantExamen> reponseApprenantExamens) {
		this.reponseApprenantExamens = reponseApprenantExamens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sujet")
	public Set<SujetQuestion> getSujetQuestions() {
		return this.sujetQuestions;
	}

	public void setSujetQuestions(Set<SujetQuestion> sujetQuestions) {
		this.sujetQuestions = sujetQuestions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sujet")
	public Set<ReponseApprenant> getReponseApprenants() {
		return this.reponseApprenants;
	}

	public void setReponseApprenants(Set<ReponseApprenant> reponseApprenants) {
		this.reponseApprenants = reponseApprenants;
	}


	
}