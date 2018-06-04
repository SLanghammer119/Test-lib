/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "articledescriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articledescriptions.findAll", query = "SELECT a FROM Articledescriptions a")
    , @NamedQuery(name = "Articledescriptions.findByArtdesid", query = "SELECT a FROM Articledescriptions a WHERE a.artdesid = :artdesid")})
public class Articledescriptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artdesid", nullable = false)
    private int artdesid;
    
    @ManyToOne(targetEntity=Article.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    private Article article;
    
    @ManyToOne(targetEntity=Description.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "descriptions_desid", referencedColumnName = "desid")
    private Description description;

    public Articledescriptions() {
        description = new Description();
    }

    public Articledescriptions(Integer artdesid) {
        this.artdesid = artdesid;
    }

    public int getArtdesid() {
        return artdesid;
    }

    public void setArtdesid(int artdesid) {
        this.artdesid = artdesid;
    }

    
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
