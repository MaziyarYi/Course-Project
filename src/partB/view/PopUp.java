package partB.view;

import javax.swing.*;
import java.awt.*;

public class PopUp extends JFrame {

    public PopUp(String message){
        setBounds(300, 90, 300, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        Container c;
        JLabel name;

        c = getContentPane();
        c.setLayout(null);

        name = new JLabel(message);
        name.setFont(new Font("Arial", Font.BOLD, 10));
        name.setSize(200, 20);
        name.setLocation(100, 20);
        c.add(name);

        setVisible(true);
        setResizable(true);
    }
}
