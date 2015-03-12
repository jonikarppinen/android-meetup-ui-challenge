package com.futurice.project;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        gridLayout.addView(createCoverView("Kodaline", "In a Perfect World", R.drawable.album_kodaline));
        gridLayout.addView(createCoverView("Fitz & The Tantrum", "More than Just a Dream", R.drawable.album_fitz));
        gridLayout.addView(createCoverView("Jamie Lidell", "Jamie Lidell", R.drawable.album_jamie));
        gridLayout.addView(createCoverView("Yuna", "Nocturnal", R.drawable.album_yuna));
    }

    private View createCoverView(String artist, String album, int coverResId) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_cover, gridLayout, false);
        TextView artistTextView = (TextView) view.findViewById(R.id.artistTextView);
        TextView albumTextView = (TextView) view.findViewById(R.id.albumTextView);
        ImageView coverImageView = (ImageView) view.findViewById(R.id.coverImageView);
        artistTextView.setText(artist);
        albumTextView.setText(album);
        coverImageView.setImageResource(coverResId);
        return view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
