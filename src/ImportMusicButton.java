import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

public class ImportMusicButton extends JButton implements ActionListener {

    public ImportMusicButton(){
        setBorder(null);
        try {
            Image exitButtonIcon = ImageIO.read(getClass().getResource("icons\\addMusicButton.png"));
            this.setIcon(new ImageIcon(exitButtonIcon));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        this.addActionListener(this);
        this.setBorder(null);
        this.setBackground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Mp3 File", "mp3");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            FileInputStream file = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
            Player player = new Player(file);
            player.play();

        }
        catch (Exception t)
        {
            System.out.println(t);
        }
    }
}
