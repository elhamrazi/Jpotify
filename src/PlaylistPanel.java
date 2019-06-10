import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlaylistPanel extends JPanel {
    ArrayList<SongButton> songs;
    int i;
//    ImportMusicButton importMusicButton;

    public PlaylistPanel()
    {
        super();
//        this.importMusicButton = importMusicButton;
        songs = new ArrayList<>();
        System.out.println("Playlist Panel Start adding...");
        i = 0;
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(layout);
        System.out.println("Playlist Panel Added!");
    }
    public void addSong(SongButton songButton)
    {
        boolean duplicate = false;
            for (SongButton btn : songs) {
                if (btn.getLink().equals(songButton.getLink())) {
                    duplicate = true;
                    break;
                }
            }
        if (!duplicate) {
            songs.add(songButton);
            this.add(songButton);
        }
    }
    public void addSong(ImportMusicButton importMusicButton)
    {
        this.add(importMusicButton);
    }
}