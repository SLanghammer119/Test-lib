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
@Table(name = "colors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")
    , @NamedQuery(name = "Color.findByColid", query = "SELECT c FROM Color c WHERE c.colid = :colid")
    , @NamedQuery(name = "Color.findByColor", query = "SELECT c FROM Color c WHERE c.color = :color")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colid", nullable = false)
    private int colid;
    
    @Column(name = "color", length = 50)
    private String color;
    
    @Lob
    @Column(name = "colorphoto")
    private byte[] colorphoto;
    
    
    @OneToMany(targetEntity=Articlecolor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "color")
    private List<Articlecolor> articlecolors;

    public Color() {
    }

    public Color(int colid, String color, byte[] colorphoto, List<Articlecolor> articlecolors) {
        this.colid = colid;
        this.color = color;
        this.colorphoto = colorphoto;
        this.articlecolors = articlecolors;
    }
    
    
    public int getColid() {
        return colid;
    }

    public void setColid(int colid) {
        this.colid = colid;
    }

  

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getColorphoto() {
        return colorphoto;
    }

    public void setColorphoto(byte[] colorphoto) {
        this.colorphoto = colorphoto;
    }

    public List<Articlecolor> getArticlecolors() {
        return articlecolors;
    }

    public void setArticlecolors(List<Articlecolor> articlecolors) {
        this.articlecolors = articlecolors;
    }

 
    
}
