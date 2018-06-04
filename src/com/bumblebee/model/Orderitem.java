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
@Table(name = "orderitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderitem.findAll", query = "SELECT o FROM Orderitem o")
    , @NamedQuery(name = "Orderitem.findByOrditid", query = "SELECT o FROM Orderitem o WHERE o.orditid = :orditid")
    , @NamedQuery(name = "Orderitem.findByNumber", query = "SELECT o FROM Orderitem o WHERE o.number = :number")
    , @NamedQuery(name = "Orderitem.findByTotalline", query = "SELECT o FROM Orderitem o WHERE o.totalline = :totalline")})
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orditid", nullable = false)
    private int orditid;
    
    @Column(name = "number")
    private Integer number;
    
    @Column(name = "totalline")
    private Double totalline;
    
    @ManyToOne(targetEntity=Article.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "articles_artid", referencedColumnName = "artid")
    private Article article;
    
    
    @ManyToOne(targetEntity=Order.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_orderid", referencedColumnName = "orderid")
    private Order order;

    public Orderitem() {
    }

    public int getOrditid() {
        return orditid;
    }

    public void setOrditid(int orditid) {
        this.orditid = orditid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalline() {
        return totalline;
    }

    public void setTotalline(Double totalline) {
        this.totalline = totalline;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

 
}
