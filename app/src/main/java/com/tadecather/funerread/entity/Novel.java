package com.tadecather.funerread.entity;

/**
 * Created by TAD on 8/1/2017.
 */

public class Novel {
    private int id;
    private String name;
    private String author;
    private String publishData;
    private String briefIntroduction;
    private String imageSrc;
    private double progress;

    public Novel(int id, String name, String author, String publishData, String briefIntroduction, String imageSrc, double progress) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishData = publishData;
        this.briefIntroduction = briefIntroduction;
        this.imageSrc = imageSrc;
        this.progress = progress;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }



    public double getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishData() {
        return publishData;
    }

    public void setPublishData(String publishData) {
        this.publishData = publishData;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }
}
