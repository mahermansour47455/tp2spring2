package com.maher.section345.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String nomEquipe;

    private String paysEquipe;

    private Date dateFound;

    public Equipe() {
        super();
    }
    public Equipe(String nomEquipe, String paysEquipe) {
        super();
        this.nomEquipe = nomEquipe;
        this.paysEquipe = paysEquipe;
    }
    public Long getIdEquipe() {
        return idEquipe;
    }
    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }
    public String getNomEquipe() {
        return nomEquipe;
    }
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }
    public String getPaysEquipe() {
        return paysEquipe;
    }
    public void setPaysEquipe(String paysEquipe) {
        this.paysEquipe = paysEquipe;
    }
    public void setDateFound(Date dateFound) {
        this.dateFound = dateFound;
    }
    public Date getDateFound() {
        return dateFound;
    }
    @Override
    public String toString() {
        return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", paysEquipe=" + paysEquipe + "]";
    }




}
