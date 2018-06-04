/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bumblebee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefanie Langhammer
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustid", query = "SELECT c FROM Customer c WHERE c.custid = :custid")
    , @NamedQuery(name = "Customer.findByCustomerno", query = "SELECT c FROM Customer c WHERE c.customerno = :customerno")
    , @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname")
    , @NamedQuery(name = "Customer.findByStreet", query = "SELECT c FROM Customer c WHERE c.street = :street")
    , @NamedQuery(name = "Customer.findByHouseno", query = "SELECT c FROM Customer c WHERE c.houseno = :houseno")
    , @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode")
    , @NamedQuery(name = "Customer.findByTown", query = "SELECT c FROM Customer c WHERE c.town = :town")
    , @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password")
    , @NamedQuery(name = "Customer.findByCategory", query = "SELECT c FROM Customer c WHERE c.category = :category")})

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custid", nullable = false)
    private int custid;
    
    //nullable gleich false noch setzen
    @Column(name = "customerno", unique = true, length = 100)
    private String customerno;
    
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
    
    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    
    @Column(name = "category", nullable = true, length = 50)
    private String category;
    
    @OneToMany(targetEntity=Deliveryadresses.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_custid", referencedColumnName = "custid")
    private List<Deliveryadresses> deliveryadresses;
    
    
    @OneToOne(targetEntity=Bankaccount.class, mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bankaccount bankaccount;
    
    
    @OneToOne(targetEntity=Creditcard.class, mappedBy="customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Creditcard creditcard;
    
    
    @OneToOne(targetEntity=Shoppingcart.class, mappedBy="customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Shoppingcart shoppingcart;

    
    public Customer() {
        setCategory("user");
        deliveryadresses = new ArrayList<>();
        creditcard = new Creditcard();
        bankaccount = new Bankaccount();  
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }
    
    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    @XmlTransient
//    public Collection<Shoppingcarts> getShoppingcartsCollection() {
//        return shoppingcartsCollection;
//    }
//
//    public void setShoppingcartsCollection(Collection<Shoppingcarts> shoppingcartsCollection) {
//        this.shoppingcartsCollection = shoppingcartsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Deliveryadresses> getDeliveryadressesCollection() {
//        return deliveryadressesCollection;
//    }
//
//    public void setDeliveryadressesCollection(Collection<Deliveryadresses> deliveryadressesCollection) {
//        this.deliveryadressesCollection = deliveryadressesCollection;
//    }
//
//    @XmlTransient
//    public Collection<Bankaccounts> getBankaccountsCollection() {
//        return bankaccountsCollection;
//    }
//
//    public void setBankaccountsCollection(Collection<Bankaccounts> bankaccountsCollection) {
//        this.bankaccountsCollection = bankaccountsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Creditcards> getCreditcardsCollection() {
//        return creditcardsCollection;
//    }
//
//    public void setCreditcardsCollection(Collection<Creditcards> creditcardsCollection) {
//        this.creditcardsCollection = creditcardsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Orders> getOrdersCollection() {
//        return ordersCollection;
//    }
//
//    public void setOrdersCollection(Collection<Orders> ordersCollection) {
//        this.ordersCollection = ordersCollection;
//    }
//    
    
    
}
