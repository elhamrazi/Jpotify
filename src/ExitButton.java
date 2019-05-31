import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    public ExitButton() {
        setBorder(null);
        try {
            Image exitButtonIcon = ImageIO.read(getClass().getResource("icons\\exitButton.png"));
            this.setIcon(new ImageIcon(exitButtonIcon));
        }
        catch (Exception e)
        {
            System.out.println("ERROR");
        }
        this.addActionListener(this);
        this.setBackground(Color.BLACK);
        this.setToolTipText("Exit Program");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            System.exit(1);

    }
}
