package com.example.tanush.registrationmodule;

public class MarvelDCUser {
    String participant1;
    String participant2;
    String mail;
    String collegeName;
    String id;
    String slot;
    int cost;
    int score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public MarvelDCUser(String participant1, String participant2, String mail, String contact, String collegeName,String id,String slot,int cost,int score) {
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.mail = mail;
        this.contact = contact;
        this.collegeName=collegeName;
        this.id=id;
        this.slot=slot;
        this.cost=cost;
        this.score=score;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getParticipant1() {
        return participant1;
    }

    public void setParticipant1(String participant1) {
        this.participant1 = participant1;
    }

    public String getParticipant2() {
        return participant2;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    String contact;
}
