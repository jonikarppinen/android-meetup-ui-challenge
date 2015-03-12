package com.futurice.project;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.futurice.project.AndroidUtils.getVibrantColor;

public class AlbumActivity extends BaseActivity {

    public static final String KEY_ALBUM_ID = "id";
    public static final String VIEW_NAME_IMAGE = "album:cover";
//    public static final String VIEW_NAME_ALBUM = "album:name";
//    public static final String VIEW_NAME_ARTIST = "album:artist";

    @InjectView(R.id.cover_image) ImageView coverImage;
    @InjectView(R.id.artist) TextView artistName;
    @InjectView(R.id.album) TextView albumName;
    @InjectView(android.R.id.content) View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ButterKnife.inject(this);

        coverImage.setTransitionName(VIEW_NAME_IMAGE);
//        albumName.setTransitionName(VIEW_NAME_ALBUM);
//        artistName.setTransitionName(VIEW_NAME_ARTIST);

        Album album = Album.getTestAlbumById((getIntent().getIntExtra(KEY_ALBUM_ID, -1)));

        artistName.setText(album.artist);
        albumName.setText(album.name);
        coverImage.setImageDrawable(getResources().getDrawable(album.coverResId));
        contentView.setBackgroundColor(getVibrantColor(getResources(), album.coverResId, getTitleColor()));
    }



}
