/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
    , @NamedQuery(name = "Order.findByOrderid", query = "SELECT o FROM Order o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Order.findByOrderno", query = "SELECT o FROM Order o WHERE o.orderno = :orderno")
    , @NamedQuery(name = "Order.findByTotal", query = "SELECT o FROM Order o WHERE o.total = :total")
    , @NamedQuery(name = "Order.findByShipping", query = "SELECT o FROM Order o WHERE o.shipping = :shipping")
    , @NamedQuery(name = "Order.findByOrderdate", query = "SELECT o FROM Order o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Order.findByCoupondiscount", query = "SELECT o FROM Order o WHERE o.coupondiscount = :coupondiscount")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", nullable = false)
    private int orderid;
    
   //nullable noch auf false setzen
    @Column(name = "orderno", unique = true)
    private String orderno;
   
    @Column(name = "total")
    private Double total;
    
    @Column(name = "shipping")
    private Double shipping;
    
    @Column(name = "orderdate")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    
    @Column(name = "coupondiscount")
    private Double coupondiscount;
    
    @Lob
    @Column(name = "confirmation")
    private byte[] confirmation;
    
    @Lob
    @Column(name = "invoice")
    private byte[] invoice;
    
    
    @OneToMany(targetEntity=Orderitem.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private List<Orderitem> orderitems;
    
    
    
    @ManyToOne(targetEntity=Coupon.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "coupons_coupid", referencedColumnName = "coupid")
    private Coupon coupon;
    
    
    @ManyToOne(targetEntity=Customer.class,fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    private Customer customer;

    
    //Construktor
    public Order() {
        customer = new Customer();
        orderitems = new ArrayList<>();
        coupon = new Coupon();    
    }

    public Order(Integer orderid) {
        this.orderid = orderid;
    }

    public Order(Integer orderid, String orderno) {
        this.orderid = orderid;
        this.orderno = orderno;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
    
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getShipping() {
        return shipping;
    }

    public void setShipping(Double shipping) {
        this.shipping = shipping;
    }

    public Double getCoupondiscount() {
        return coupondiscount;
    }

    public void setCoupondiscount(Double coupondiscount) {
        this.coupondiscount = coupondiscount;
    }

    public byte[] getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(byte[] confirmation) {
        this.confirmation = confirmation;
    }

    public byte[] getInvoice() {
        return invoice;
    }

    public void setInvoice(byte[] invoice) {
        this.invoice = invoice;
    }

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
