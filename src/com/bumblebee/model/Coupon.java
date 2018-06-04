/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "coupons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c")
    , @NamedQuery(name = "Coupon.findByCoupid", query = "SELECT c FROM Coupon c WHERE c.coupid = :coupid")
    , @NamedQuery(name = "Coupon.findByCouponno", query = "SELECT c FROM Coupon c WHERE c.couponno = :couponno")
    , @NamedQuery(name = "Coupon.findByOrigvalue", query = "SELECT c FROM Coupon c WHERE c.origvalue = :origvalue")
    , @NamedQuery(name = "Coupon.findByCurvalue", query = "SELECT c FROM Coupon c WHERE c.curvalue = :curvalue")
    , @NamedQuery(name = "Coupon.findByCoupondate", query = "SELECT c FROM Coupon c WHERE c.coupondate = :coupondate")})
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupid", nullable = false)
    private int coupid;
    
    @Column(name = "couponno", length = 100, unique = true, nullable = false)
    private String couponno;
    
    @Column(name = "origvalue")
    private Double origvalue;
    
    @Column(name = "curvalue")
    private Double curvalue;
    
    @Column(name = "coupondate")
    @Temporal(TemporalType.DATE)
    private Date coupondate;
    
    
    @OneToMany(targetEntity=Order.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "coupon")
    private List<Order> orders;

    public Coupon() {
    }

    public int getCoupid() {
        return coupid;
    }

    public void setCoupid(int coupid) {
        this.coupid = coupid;
    }
    
    public String getCouponno() {
        return couponno;
    }

    public void setCouponno(String couponno) {
        this.couponno = couponno;
    }

    public Double getOrigvalue() {
        return origvalue;
    }

    public void setOrigvalue(Double origvalue) {
        this.origvalue = origvalue;
    }

    public Double getCurvalue() {
        return curvalue;
    }

    public void setCurvalue(Double curvalue) {
        this.curvalue = curvalue;
    }

    public Date getCoupondate() {
        return coupondate;
    }

    public void setCoupondate(Date coupondate) {
        this.coupondate = coupondate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

  
    
}
