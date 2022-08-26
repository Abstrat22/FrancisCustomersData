package com.example.franciscustomersdata;

//Person's Data
public class Customer {

    private String name, town, contact, address, otherNames, partner, mother, father, imageData;

    // Constructors
    public Customer(String name, String town, String contact, String address, String otherNames, String partner, String mother, String father, String imageData) {
        this.name = name;
        this.town = town;
        this.address = address;
        this.otherNames = otherNames;
        this.mother = mother;
        this.father = father;
        this.contact = contact;
        this.partner = partner;
        this.imageData = imageData;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String imageData) {
        this.name = name;
        this.imageData = imageData;

    }

    public Customer() {

    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", partner='" + partner + '\'' +
                ", mother='" + mother + '\'' +
                ", father='" + father + '\'' +
                ", imageData='" + imageData + '\'' +
                '}';
    }
}
