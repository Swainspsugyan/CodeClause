package com.app.CodeClause;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

class MusicPlayer {
    private List<Song> playlist;
    private int currentSongIndex;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentSongIndex = -1;
    }

    public void addSong(String title, String artist) {
        playlist.add(new Song(title, artist));
    }

    public void displayPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            Song song = playlist.get(i);
            System.out.println((i + 1) + ". " + song.getTitle() + " - " + song.getArtist());
        }
    }

    public void play(int index) {
        if (index >= 1 && index <= playlist.size()) {
            currentSongIndex = index - 1;
            Song song = playlist.get(currentSongIndex);
            System.out.println("Now playing: " + song.getTitle() + " - " + song.getArtist());
        } else {
            System.out.println("Invalid song index");
        }
    }

    public void stop() {
        if (currentSongIndex != -1) {
            System.out.println("Stopped playing: " + playlist.get(currentSongIndex).getTitle());
            currentSongIndex = -1;
        } else {
            System.out.println("No song is currently playing");
        }
    }
}

public class MusicStreamingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();

        while (true) {
            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Play Song");
            System.out.println("4. Stop");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.next();
                    System.out.print("Enter artist: ");
                    String artist = scanner.next();
                    musicPlayer.addSong(title, artist);
                    break;
                case 2:
                    musicPlayer.displayPlaylist();
                    break;
                case 3:
                    System.out.print("Enter the index of the song to play: ");
                    int index = scanner.nextInt();
                    musicPlayer.play(index);
                    break;
                case 4:
                    musicPlayer.stop();
                    break;
                case 5:
                    System.out.println("Exiting the music streaming app. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
