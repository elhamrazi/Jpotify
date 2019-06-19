import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * It builds:
 * LoadingFrame
 * mainFrame.
 * It adds panels such as:
 * LeftMenu > Which Keeps Buttons for Playlists and more
 * BottomMenu > Which keeps cover of song and details.
 * CenterMenu > Which keeps playlistTabs.
 * etc...
 * @author G-squad menhaye Maryam
 * @version 1.2
 *
 */

public class MainFrame extends JFrame{
    Image img;
    public MainFrame(AppObjects appObjects)  {
        super("Jpotify");
        appObjects.setMainFrame(this);
        JFrame loadingFrame = new JFrame("Loading...");
        JLabel Logo = new JLabel();
        Image jpotifyLogo = null;
        try {
            jpotifyLogo = ImageIO.read(getClass().getResource("icons\\logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logo.setIcon(new ImageIcon(jpotifyLogo));
        loadingFrame.add(Logo);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setSize(520,210);
        loadingFrame.setBackground(Color.WHITE);
        loadingFrame.setResizable(false);
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setUndecorated(true);
        loadingFrame.setVisible(true);
        System.out.println ("Main Frame Start Adding...");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(100,100);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        setLayout(new BorderLayout());
        TopMenu topMenu = new TopMenu(appObjects);
        add(topMenu , BorderLayout.NORTH);
        BottomMenu bottomMenu = new BottomMenu(appObjects);
        add(bottomMenu , BorderLayout.SOUTH);
//        add(bottomMenu,BorderLayout.SOUTH);
        LeftMenu leftMenu = new LeftMenu(appObjects);
        add(leftMenu , BorderLayout.WEST);
        CenterMenu centerMenu = new CenterMenu(appObjects);
        add(centerMenu , BorderLayout.CENTER);
        this.getContentPane().setBackground(new Color(176 , 0 , 9));
        this.setVisible(true);
        loadingFrame.setVisible(false);
        System.out.println("Main Frame Added!");
    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(img,0,0,this);
    }

}
