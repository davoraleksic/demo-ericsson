package com.example.demo.dto;


public class BookRequestDto {

    private String title;
    private int publishYear;
    private String authorFirstName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

//    public String getAuthorLastName() {
//        return authorLastName;
//    }
//
//    public void setAuthorLastName(String authorLastName) {
//        this.authorLastName = authorLastName;
//    }



}
