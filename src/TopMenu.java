import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopMenu extends JPanel {
    MainFrame mainFrame;
    public TopMenu(MainFrame mainFrame){

        super();

        this.mainFrame = mainFrame;
        setBackground(Color.BLACK);
//        CloseMenu closeMenu = new CloseMenu(mainFrame);

        setLayout(new BorderLayout());
        ExitButton exitButton = new ExitButton();
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(exitButton);
        MinimizeButton minimizeButton = new MinimizeButton(mainFrame);
        add(minimizeButton);
//        Border  whiteLine = BorderFactory.createLineBorder(new Color(0 , 30 , 135));
//        setBorder(whiteLine);
        this.setVisible(true);

    }

}