/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "care")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Care.findAll", query = "SELECT c FROM Care c")
    , @NamedQuery(name = "Care.findByCareid", query = "SELECT c FROM Care c WHERE c.careid = :careid")
    , @NamedQuery(name = "Care.findByCarename", query = "SELECT c FROM Care c WHERE c.carename = :carename")})
public class Care implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "careid", nullable = false)
    private int careid;
    
    @Column(name = "carename", length = 50)
    private String carename;
    
    @Lob
    @Column(name = "carephoto")
    private byte[] carephoto;
    
    
    @OneToMany(targetEntity=Article.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "care")
    private List<Article> articles;

    public Care() {
    }

    public Care(Integer careid) {
        this.careid = careid;
    }

    public Care(Integer careid, String carename, byte[] carephoto) {
        this.careid = careid;
        this.carename = carename;
        this.carephoto = carephoto;
    }

    public int getCareid() {
        return careid;
    }

    public void setCareid(int careid) {
        this.careid = careid;
    }


    public String getCarename() {
        return carename;
    }

    public void setCarename(String carename) {
        this.carename = carename;
    }

    public byte[] getCarephoto() {
        return carephoto;
    }

    public void setCarephoto(byte[] carephoto) {
        this.carephoto = carephoto;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

 

}
