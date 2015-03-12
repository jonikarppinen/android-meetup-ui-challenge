package com.futurice.project;

import java.util.Arrays;
import java.util.List;

/**
 */
public class Album {

    public static final List<Album> TEST_DATA = Arrays.asList(
            new Album(0, "Kodaline", "In a Perfect World", R.drawable.album_kodaline),
            new Album(1, "Fitz & The Tantrum", "More than Just a Dream", R.drawable.album_fitz),
            new Album(2, "Jamie Lidell", "Jamie Lidell", R.drawable.album_jamie),
            new Album(3, "Yuna", "Nocturnal", R.drawable.album_yuna)
    );

    public static Album getTestAlbumById(int id) {
        for (Album album : TEST_DATA) {
            if (id == album.id) return album;
        }
        return null;
    }

    public int id;
    public String artist;
    public String name;
    public int coverResId;

    public Album(int id, String artist, String name, int coverResId) {
        this.id = id;
        this.artist = artist;
        this.name = name;
        this.coverResId = coverResId;
    }
}
