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
@Table(name = "primecategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Primecategory.findAll", query = "SELECT p FROM Primecategory p")
    , @NamedQuery(name = "Primecategory.findByPrimeid", query = "SELECT p FROM Primecategory p WHERE p.primeid = :primeid")
    , @NamedQuery(name = "Primecategoriy.findByPrimename", query = "SELECT p FROM Primecategory p WHERE p.primename = :primename")})
public class Primecategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "primeid", nullable = false)
    private int primeid;
    
    @Column(name = "primename", length = 100)
    private String primename;
    
    
    @OneToMany(targetEntity=Subcategory.class, mappedBy = "primecategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subcategory> subcategories;

    public Primecategory() {
    }

    public Primecategory(int primeid, String primename) {
        this.primeid = primeid;
        this.primename = primename;
    }

    public int getPrimeid() {
        return primeid;
    }

    public void setPrimeid(int primeid) {
        this.primeid = primeid;
    }

    public String getPrimename() {
        return primename;
    }

    public void setPrimename(String primename) {
        this.primename = primename;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
    
    
    
}
