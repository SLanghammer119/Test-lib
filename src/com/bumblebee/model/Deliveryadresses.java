/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "deliveryadresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveryadresses.findAll", query = "SELECT d FROM Deliveryadresses d")
    , @NamedQuery(name = "Deliveryadresses.findByDelid", query = "SELECT d FROM Deliveryadresses d WHERE d.delid = :delid")
    , @NamedQuery(name = "Deliveryadresses.findByFirstname", query = "SELECT d FROM Deliveryadresses d WHERE d.firstname = :firstname")
    , @NamedQuery(name = "Deliveryadresses.findByLastname", query = "SELECT d FROM Deliveryadresses d WHERE d.lastname = :lastname")
    , @NamedQuery(name = "Deliveryadresses.findByStreet", query = "SELECT d FROM Deliveryadresses d WHERE d.street = :street")
    , @NamedQuery(name = "Deliveryadresses.findByHouseno", query = "SELECT d FROM Deliveryadresses d WHERE d.houseno = :houseno")
    , @NamedQuery(name = "Deliveryadresses.findByPostcode", query = "SELECT d FROM Deliveryadresses d WHERE d.postcode = :postcode")
    , @NamedQuery(name = "Deliveryadresses.findByTown", query = "SELECT d FROM Deliveryadresses d WHERE d.town = :town")
    , @NamedQuery(name = "Deliveryadresses.findByCountry", query = "SELECT d FROM Deliveryadresses d WHERE d.country = :country")})
public class Deliveryadresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delid", nullable = false)
    private Integer delid;
    
    @Column(name = "firstname", length = 150)
    private String firstname;
    
    @Column(name = "lastname", nullable = false, length = 150)
    private String lastname;
    
    @Column(name = "street", nullable = false, length = 100)
    private String street;
    
    @Column(name = "houseno", nullable = false, length = 10)
    private String houseno;
    
    @Column(name = "postcode", nullable = false, length = 10)
    private String postcode;
    
    @Column(name = "town", nullable = false, length = 100)
    private String town;
    
    @Column(name = "country", length = 100)
    private String country;
    

    public Deliveryadresses() {
    }

    public Deliveryadresses(Integer delid) {
        this.delid = delid;
    }

    public Deliveryadresses(Integer delid, String lastname, String street, String houseno, String postcode, String town) {
        this.delid = delid;
        this.lastname = lastname;
        this.street = street;
        this.houseno = houseno;
        this.postcode = postcode;
        this.town = town;
    }

    public Integer getDelid() {
        return delid;
    }

    public void setDelid(Integer delid) {
        this.delid = delid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public Integer getCustomersCustid() {
//        return customersCustid;
//    }
//
//    public void setCustomersCustid(Integer customersCustid) {
//        this.customersCustid = customersCustid;
//    }
    
}
