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
@Table(name = "descriptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Description.findAll", query = "SELECT d FROM Description d")
    , @NamedQuery(name = "Description.findByDesid", query = "SELECT d FROM Description d WHERE d.desid = :desid")
    , @NamedQuery(name = "Description.findByFeature", query = "SELECT d FROM Description d WHERE d.feature = :feature")})
public class Description implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desid", nullable = false)
    private int desid;
    
    @Column(length = 1000, name = "feature")
    private String feature;
    
    
    @OneToMany(targetEntity=Articledescriptions.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "description")
    private List<Articledescriptions> articledescriptions;

    public Description() {
    }

    public int getDesid() {
        return desid;
    }

    public void setDesid(int desid) {
        this.desid = desid;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public List<Articledescriptions> getArticledescriptions() {
        return articledescriptions;
    }

    public void setArticledescriptions(List<Articledescriptions> articledescriptions) {
        this.articledescriptions = articledescriptions;
    }

   
    
}
