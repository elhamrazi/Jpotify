import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class represents different tabs for different playLists.
 * playLists such as favorites , all songs &... .
 * @author ahmadrezadl
 *
 */

public class PlaylistTabs extends JTabbedPane {
    AddPlayListButton addPlayListButton;
    Scanner sc;
    AppObjects appObjects;
    public PlaylistTabs(AppObjects appObjects)
    {
        super();
        this.appObjects = appObjects;
        File file = new File("playLists.txt");
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setForeground(new Color(0x17091c));
        this.setBackground(new Color(0x17091c));
        appObjects.setPlaylistTabs(this);
        ImageIcon tab1Icon = new ImageIcon("icons\\musicLogo.png");
        System.out.println("PlayList Tabs Adding...");
        String name = sc.nextLine();
        PlaylistPanel allSongs = new PlaylistPanel(appObjects,name);
        JScrollPane allSongsPane = new JScrollPane(allSongs);
        appObjects.setAllSongsPanel(allSongs);
        this.addTab(name,allSongsPane);
        allSongs.addSong(new ImportMusicButton(appObjects,appObjects.getAllSongsPanel()));
        name = sc.nextLine();
        PlaylistPanel favorites = new PlaylistPanel(appObjects,name);
        appObjects.setFavorites(favorites);
        JScrollPane favoritesPane = new JScrollPane(favorites);
        this.add(name , favoritesPane);
        favorites.addSong(new ImportMusicButton(appObjects,favorites));
        name = sc.nextLine();
        PlaylistPanel radio = new PlaylistPanel(appObjects,name);
        this.add(name , radio);
        RadioChannel iloveradio = new RadioChannel(0,appObjects);
        radio.add(iloveradio);

        while(sc.hasNext())
        {
            name = sc.nextLine();
            PlaylistPanel pp = new PlaylistPanel(appObjects,name);
            this.add(name , pp);
            pp.addSong(new ImportMusicButton(appObjects,pp));
        }
        addPlayListButton = new AddPlayListButton(appObjects);

        appObjects.getLeftMenu().add(addPlayListButton);

        System.out.println("PlayList Tabs Added");

    }
    public void removeTab(int i, PlaylistPanel playlistPanel) {
        String tabTitle = this.getTitleAt(i);
        if(!(tabTitle.equals("All Songs") || tabTitle.equals("Favorites"))) {
            this.remove(i);
            appObjects.getPlaylists().remove(playlistPanel);
        }
        else

            JOptionPane.showMessageDialog(null,
                    "Sorry You Can't Remove " + tabTitle + " Playlist!",
                    "Error 02",
                    JOptionPane.WARNING_MESSAGE);

    }
    public void renameTab(int i,String name)
    {
        this.setTitleAt(i,name);
    }

}
