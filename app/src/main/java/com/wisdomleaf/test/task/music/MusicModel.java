package com.wisdomleaf.test.task.music;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by chethan on 30-12-2015.
 */
@Root(name = "music")
public class MusicModel {
    @ElementList(inline = true ,required = false)
    public List<SongModel> song;

    public List<SongModel> getSong() {
        return song;
    }

    public void setSong(List<SongModel> song) {
        this.song = song;
    }
}
