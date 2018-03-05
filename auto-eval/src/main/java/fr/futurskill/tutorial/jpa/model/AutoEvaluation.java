package fr.futurskill.tutorial.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class AutoEvaluation implements Serializable {

    private static final long serialVersionUID = 3761346633764688612L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 16*1024)
    private String evaluation;

    @Column(length = 20)
    private String numeroTelephone;

    @Column(length = 32)
    private String prenom;

    @Column(length = 32)
    private String nom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AutoEvaluation{" +
                "id=" + id +
                ", evaluation='" + evaluation + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                '}';
    }
}
