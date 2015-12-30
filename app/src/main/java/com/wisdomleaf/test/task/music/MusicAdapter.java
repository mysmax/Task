package com.wisdomleaf.test.task.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wisdomleaf.test.task.R;

import java.util.List;

/**
 * Created by chethan on 30-12-2015.
 */
public class MusicAdapter extends BaseAdapter {
    private Context context;
    private List<SongModel> songList;

    public MusicAdapter(Context context, List<SongModel> songList) {
        this.context = context;
        this.songList = songList;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View music;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            music = new View(context);
            music = inflater.inflate(R.layout.item_music, null);
            ImageView musicThumbnail = (ImageView) music.findViewById(R.id.music_thumbnail);
            Picasso.with(context)
                    .load(songList.get(i).getThumb_url())
                    .placeholder(R.drawable.ic_place_holder)
                    .error(android.R.drawable.stat_notify_error)
                    .fit().centerCrop()
                    .into(musicThumbnail);
            TextView songTitle = (TextView) music.findViewById(R.id.txt_music_title);
            songTitle.setText(songList.get(i).getTitle());
            TextView songArtist = (TextView) music.findViewById(R.id.txt_music_artist);
            songArtist.setText(songList.get(i).getArtist());
            TextView songDuration = (TextView) music.findViewById(R.id.txt_music_duration);
            songDuration.setText(songList.get(i).getDuration());

        } else {
            music = (View) view;
        }
        return music;
    }
}
