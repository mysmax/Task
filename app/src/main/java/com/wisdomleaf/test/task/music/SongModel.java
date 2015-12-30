package com.wisdomleaf.test.task.music;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by chethan on 30-12-2015.
 */
@Root(name = "song")
public class SongModel {

    @Element(name = "id")
    private String id;

    @Element(name = "title")
    private String title;

    @Element(name = "artist")
    private String artist;

    @Element(name = "duration")
    private String duration;

    @Element(name = "thumb_url")
    private String thumb_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }
}
