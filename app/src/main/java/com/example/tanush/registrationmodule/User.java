package com.example.tanush.registrationmodule;

public class User {
    String participant1;
    String participant2;
    String volunteer;
    String mail;
    String contact;
    String collegeName;
    String slot;
    String id;
    String events;
    int cost;

    public String getSlot() {
        return slot;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public User(String participant1, String participant2, String volunteer, String mail, String contact, String collegeName,String id, String events,int cost) {


        this.participant1 = participant1;
        this.participant2 = participant2;
        this.volunteer = volunteer;
        this.mail = mail;
        this.contact = contact;
        this.collegeName=collegeName;
        this.id=id;
        this.events=events;
        this.cost=cost;
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

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
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
}
