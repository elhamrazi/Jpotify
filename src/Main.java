import javax.swing.*;
/**
 * make frame & change the LookAndFeel
 * @author G-squad menhaye Maryam
 * @version 1.2
 */
public class Main{
    public static void main(String[]args)
    {
        System.out.println("Program Started!");
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,
                    "Cannot Load UI",
                    "Error 01",
                    JOptionPane.WARNING_MESSAGE);
        }
        AppObjects appObjects = new AppObjects();
        MainFrame mainFrame = new MainFrame(appObjects);
        for (PlaylistPanel p : appObjects.getPlayLists())
        {
            for(AlbumButton a : p.albums)
            {
                a.setVisible(false);
            }
            for(SongButton s : p.songs)
            {
                s.setVisible(true);
            }
        }
    }
}
