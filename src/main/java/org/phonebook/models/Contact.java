package org.phonebook.models;

public class Contact {
    private  String name;
    private  String surname;
    private  String phone;
    private  String mail;
    private  String adress;
    private  String deskription;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Contact setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Contact setDeskription(String deskription) {
        this.deskription = deskription;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getAdress() {
        return adress;
    }

    public String getDeskription() {
        return deskription;
    }
}
