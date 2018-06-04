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
@Table(name = "units")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
    , @NamedQuery(name = "Unit.findByUnitid", query = "SELECT u FROM Unit u WHERE u.unitid = :unitid")
    , @NamedQuery(name = "Unit.findByUnit", query = "SELECT u FROM Unit u WHERE u.unit = :unit")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unitid", nullable = false)
    private int unitid;
    
    @Column(name = "unit", length = 100)
    private String unit;
    
    
    @OneToMany(targetEntity=Articlesize.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "unit")
    private List<Articlesize> articlesizes;

    public Unit() {
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Articlesize> getArticlesizes() {
        return articlesizes;
    }

    public void setArticlesizes(List<Articlesize> articlesizes) {
        this.articlesizes = articlesizes;
    }

   
    
}
