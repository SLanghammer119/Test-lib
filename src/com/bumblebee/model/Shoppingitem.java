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
@Table(name = "shoppingitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingitem.findAll", query = "SELECT s FROM Shoppingitem s")
    , @NamedQuery(name = "Shoppingitem.findByShopitemid", query = "SELECT s FROM Shoppingitem s WHERE s.shopitemid = :shopitemid")
    , @NamedQuery(name = "Shoppingitem.findByNumber", query = "SELECT s FROM Shoppingitem s WHERE s.number = :number")
    , @NamedQuery(name = "Shoppingitem.findByTotalLine", query = "SELECT s FROM Shoppingitem s WHERE s.totalLine = :totalLine")})
public class Shoppingitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopitemid", nullable = false)
    private int shopitemid;
    
    @Column(name = "number")
    private Integer number;
    
    @Column(name = "totalLine")
    private Double totalLine;
    
    @ManyToOne(targetEntity=Article.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="articles_artid", referencedColumnName = "artid")
    private Article article;
    
    
    public Shoppingitem() {
        
    }

    
    public Shoppingitem(Article a) {
        article = new Article(a.getArtid(), a.getArticleno(), a.getName(), a.getPrice(), a.getPhoto(), a.getColor(), a.getSize());
        this.number=0;
        this.totalLine=0.00;
    }
    

    public int getShopitemid() {
        return shopitemid;
    }

    public void setShopitemid(int shopitemid) {
        this.shopitemid = shopitemid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(Double totalLine) {
        this.totalLine = totalLine;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    public Double getCalculateTotalLine() {
        this.totalLine = this.number * article.getPrice();
        return this.totalLine;
    }

    


    
}
