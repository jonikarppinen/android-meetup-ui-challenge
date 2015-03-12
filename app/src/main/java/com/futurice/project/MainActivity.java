package com.futurice.project;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

        // Rows
        GridLayout.Spec row1 = GridLayout.spec(0);
        GridLayout.Spec row2 = GridLayout.spec(1);

        // COlumns
        GridLayout.Spec col1 = GridLayout.spec(0);
        GridLayout.Spec col2 = GridLayout.spec(1);

        View first = createCoverView("Kodaline", "In a Perfect World", R.drawable.album_kodaline);
        View second = createCoverView("Fitz & The Tantrum", "More than Just a Dream", R.drawable.album_fitz);
        View third = createCoverView("Jamie Lidell", "Jamie Lidell", R.drawable.album_jamie);
        View fourth = createCoverView("Yuna", "Nocturnal", R.drawable.album_yuna);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int boxWidth = metrics.widthPixels / 2;
        int boxHeight = (metrics.heightPixels - 200) / 2;

        gridLayout.addView(first, gridParams(row1, col1, boxWidth, boxHeight));
        gridLayout.addView(second, gridParams(row1, col2, boxWidth, boxHeight));
        gridLayout.addView(third, gridParams(row2, col1, boxWidth, boxHeight));
        gridLayout.addView(fourth, gridParams(row2, col2, boxWidth, boxHeight));

    }

    private GridLayout.LayoutParams gridParams(GridLayout.Spec row1, GridLayout.Spec col1, int width, int height) {
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(row1, col1);
        params.width = width;
        params.height = height;
        return params;
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
