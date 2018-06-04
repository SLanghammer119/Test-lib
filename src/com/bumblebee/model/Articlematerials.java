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
@Table(name = "articlematerials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articlematerials.findAll", query = "SELECT a FROM Articlematerials a")
    , @NamedQuery(name = "Articlematerials.findByArtmatid", query = "SELECT a FROM Articlematerials a WHERE a.artmatid = :artmatid")})
public class Articlematerials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artmatid", nullable = false)
    private int artmatid;
    
    @ManyToOne(targetEntity=Article.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    private Article article;
    
    @ManyToOne(targetEntity=Material.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "materials_matid", referencedColumnName = "matid")
    private Material material;

    public Articlematerials() {
        material = new Material();
    }

    public int getArtmatid() {
        return artmatid;
    }

    public void setArtmatid(int artmatid) {
        this.artmatid = artmatid;
    }

    public void setArtmatid(Integer artmatid) {
        this.artmatid = artmatid;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }


    
}
