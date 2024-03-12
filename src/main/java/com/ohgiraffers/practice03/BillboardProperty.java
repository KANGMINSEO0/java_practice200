package com.ohgiraffers.practice03;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class BillboardProperty implements Serializable {
    private IntegerProperty rank;
    private StringProperty artist;
    private StringProperty song;
    private StringProperty imagesrc;
    private IntegerProperty lastweek;
    public BillboardProperty() {
        this.rank = new SimpleIntegerProperty();
        this.artist = new SimpleStringProperty();
        this.song = new SimpleStringProperty();
        this.imagesrc = new SimpleStringProperty();
        this.lastweek = new SimpleIntegerProperty();
    }

    public int getRank() {
        return rank.get();
    }

    public IntegerProperty rankProperty() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank.set(rank);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getSong() {
        return song.get();
    }

    public StringProperty songProperty() {
        return song;
    }

    public void setSong(String song) {
        this.song.set(song);
    }

    public String getImagesrc() {
        return imagesrc.get();
    }

    public StringProperty imagesrcProperty() {
        return imagesrc;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc.set(imagesrc);
    }

    public int getLastweek() {
        return lastweek.get();
    }

    public IntegerProperty lastweekProperty() {
        return lastweek;
    }

    public void setLastweek(int lastweek) {
        this.lastweek.set(lastweek);
    }

    @Override
    public String toString() {
        return "BillboardProperty{" +
                "rank=" + rank +
                ", artist=" + artist +
                ", song=" + song +
                ", imagesrc=" + imagesrc +
                ", lastweek=" + lastweek +
                '}';
    }
}
