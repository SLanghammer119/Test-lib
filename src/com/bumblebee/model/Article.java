/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import static java.io.FileDescriptor.in;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.imageio.ImageIO;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "articles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByArtid", query = "SELECT a FROM Article a WHERE a.artid = :artid")
    , @NamedQuery(name = "Article.findByArticleno", query = "SELECT a FROM Article a WHERE a.articleno = :articleno")
    , @NamedQuery(name = "Article.findByName", query = "SELECT a FROM Article a WHERE a.name = :name")
    , @NamedQuery(name = "Article.findByPrice", query = "SELECT a FROM Article a WHERE a.price = :price")
    , @NamedQuery(name = "Articles.findBySubcategory", query = "SELECT a FROM Article a JOIN a.Subcategory s WHERE s.subcatname = :subcatname")
    , @NamedQuery(name = "Articles.findByPrimecategory", query = "SELECT a FROM Article a JOIN a.Subcategory s JOIN s.Primecategory p WHERE p.primename = :primename")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artid", nullable = false)
    private int artid;

    @Column(name = "articleno", unique = true)
    private String articleno;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @OneToMany(targetEntity = Articledescriptions.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articledescriptions> articledescriptions;

    @OneToMany(targetEntity = Articlesize.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlesize> articlesizes;

    @OneToMany(targetEntity = Articlecolor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlecolor> articlecolors;

    @OneToMany(targetEntity = Articlematerials.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Articlematerials> articlematerials;

    @OneToMany(targetEntity = Orderitem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "article")
    private List<Orderitem> orderitems;

    @OneToMany(targetEntity = Shoppingitem.class, mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shoppingitem> shoppingitems;

    @ManyToOne(targetEntity = Care.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "care_careid", referencedColumnName = "careid")
    private Care care;

    @ManyToOne(targetEntity = Subcategory.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategories_subcatid", referencedColumnName = "subcatid")
    private Subcategory subcategory;

    //neu hinzugefügt
    @OneToOne(targetEntity = Color.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "colors_colid", referencedColumnName = "colid")
    private Color color;

    //neu hinzugefügt
    @OneToOne(targetEntity = Unit.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "units_unitid", referencedColumnName = "unitid")
    private Unit size;

    public Article() {
        articledescriptions = new ArrayList<>();
        articlematerials = new ArrayList<>();
        articlesizes = new ArrayList<>();
        articlecolors = new ArrayList<>();

    }

    Article(Article a) {
        this.artid = a.getArtid();
        this.articleno = a.getArticleno();
        this.name = a.getName();
        this.price = a.getPrice();
        this.photo = a.getPhoto();
        this.articledescriptions = new ArrayList<>(a.getArticledescriptions());
        this.articlematerials = new ArrayList<>(a.getArticlematerials());
        this.care = new Care();
        setCare(a.getCare());
        this.subcategory = new Subcategory();
        setSubcategory(a.getSubcategory());
        this.color = new Color();
        setColor(a.getColor());
        this.size = new Unit();
        setSize(a.getSize());
    }

    public int getArtid() {
        return artid;
    }

    public void setArtid(int artid) {
        this.artid = artid;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Articledescriptions> getArticledescriptions() {
        return articledescriptions;
    }

    public void setArticledescriptions(List<Articledescriptions> articledescriptions) {
        this.articledescriptions = articledescriptions;
    }

    public List<Articlesize> getArticlesizes() {
        return articlesizes;
    }

    public void setArticlesizes(List<Articlesize> articlesizes) {
        this.articlesizes = articlesizes;
    }

    public List<Articlecolor> getArticlecolors() {
        return articlecolors;
    }

    public void setArticlecolors(List<Articlecolor> articlecolors) {
        this.articlecolors = articlecolors;
    }

    public List<Articlematerials> getArticlematerials() {
        return articlematerials;
    }

    public void setArticlematerials(List<Articlematerials> articlematerials) {
        this.articlematerials = articlematerials;
    }

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public List<Shoppingitem> getShoppingitems() {
        return shoppingitems;
    }

    public void setShoppingitems(List<Shoppingitem> shoppingitems) {
        this.shoppingitems = shoppingitems;
    }

    public Care getCare() {
        return care;
    }

    public void setCare(Care care) {
        this.care = care;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Unit getSize() {
        return size;
    }

    public void setSize(Unit size) {
        this.size = size;
    }

}
