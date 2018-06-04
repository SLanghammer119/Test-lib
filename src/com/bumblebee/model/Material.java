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
@Table(name = "materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByMatid", query = "SELECT m FROM Material m WHERE m.matid = :matid")
    , @NamedQuery(name = "Material.findByMaterial", query = "SELECT m FROM Material m WHERE m.material = :material")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matid", nullable = false)
    private int matid;
    
    @Column(name = "material", length = 300)
    private String material;
    
    
    @OneToMany(targetEntity=Articlematerials.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "material")
    private List<Articlematerials> articlematerials;

    public Material() {
    }

    public int getMatid() {
        return matid;
    }

    public void setMatid(int matid) {
        this.matid = matid;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<Articlematerials> getArticlematerials() {
        return articlematerials;
    }

    public void setArticlematerials(List<Articlematerials> articlematerials) {
        this.articlematerials = articlematerials;
    }

  
    
}
