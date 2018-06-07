/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.ArrayList;
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
    @Column(name = "colorcode")
    private String colorcode;
    
    
    @OneToMany(targetEntity=Articlecolor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "color")
    private List<Articlecolor> articlecolors;

    public Color() {
//        articlecolors = new ArrayList<>();
    }

    //noch lassen wegen im Warenkorb Änderung der Farbe auf eine andere
    public Color(int colid, String color, String colorcode, List<Articlecolor> articlecolors) {
        this.colid = colid;
        this.color = color;
        this.colorcode = colorcode;
        this.articlecolors = new ArrayList<>(articlecolors);
    }

    public Color(int colid, String color, String colorcode) {
        this.colid = colid;
        this.color = color;
        this.colorcode = colorcode;
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

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public List<Articlecolor> getArticlecolors() {
        return articlecolors;
    }

    public void setArticlecolors(List<Articlecolor> articlecolors) {
        this.articlecolors = articlecolors;
    }

 
    
}
