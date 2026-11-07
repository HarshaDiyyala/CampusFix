package com.campusfix.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Issue {
    private final int id;
    private final String name, email, category, location, description, createdAt;
    private String status;
    private String adminNote;

    public Issue(int id, String name, String email, String category, String location, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
        this.location = location;
        this.description = description;
        this.status = "Reported";
        this.adminNote = "Your report has been received.";
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a"));
    }
    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }
    public String getCategory(){ return category; }
    public String getLocation(){ return location; }
    public String getDescription(){ return description; }
    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
    public String getAdminNote(){ return adminNote; }
    public void setAdminNote(String note){ this.adminNote = note; }
    public String getCreatedAt(){ return createdAt; }
}
