package com.futurice.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import static com.futurice.project.Album.TEST_DATA;

public class MainActivity extends BaseActivity {

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        // Rows
        GridLayout.Spec row1 = GridLayout.spec(0);
        GridLayout.Spec row2 = GridLayout.spec(1);

        // Columns
        GridLayout.Spec col1 = GridLayout.spec(0);
        GridLayout.Spec col2 = GridLayout.spec(1);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int boxWidth = metrics.widthPixels / 2;
        int boxHeight = (metrics.heightPixels - 200) / 2;

        gridLayout.addView(createCoverView(TEST_DATA.get(0)), gridParams(row1, col1, boxWidth, boxHeight));
        gridLayout.addView(createCoverView(TEST_DATA.get(1)), gridParams(row1, col2, boxWidth, boxHeight));
        gridLayout.addView(createCoverView(TEST_DATA.get(2)), gridParams(row2, col1, boxWidth, boxHeight));
        gridLayout.addView(createCoverView(TEST_DATA.get(3)), gridParams(row2, col2, boxWidth, boxHeight));
    }

    private GridLayout.LayoutParams gridParams(GridLayout.Spec row1, GridLayout.Spec col1, int width, int height) {
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(row1, col1);
        params.width = width;
        params.height = height;
        return params;
    }

    private View createCoverView(Album album) {
        View view = LayoutInflater.from(this).inflate(R.layout.view_cover, gridLayout, false);
        TextView artistTextView = (TextView) view.findViewById(R.id.artistTextView);
        TextView albumTextView = (TextView) view.findViewById(R.id.albumTextView);
        ImageView coverImageView = (ImageView) view.findViewById(R.id.coverImageView);
        View infoSection = view.findViewById(R.id.infoSection);
        // Set coverImageView
        coverImageView.setImageResource(album.coverResId);
        // Set info section
        int vibrantColor = AndroidUtils.getVibrantColor(getResources(), album.coverResId, getTitleColor());
        infoSection.setBackgroundColor(vibrantColor);
        // Set texts
        artistTextView.setText(album.artist);
        albumTextView.setText(album.name);

        setOnClickWithAnimation(view, album);

        return view;
    }

    private void setOnClickWithAnimation(View view, final Album album) {
        view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                    intent.putExtra(AlbumActivity.KEY_ALBUM_ID, album.id);
                    startActivity(intent);
                }
            }
        );
    }

}
