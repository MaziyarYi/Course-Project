package partB.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Objects;

public class TravelerInfo extends JFrame implements ActionListener {

    private Container c;
    private JLabel name;
    private JTextField tname;
    private JLabel city;
    private JComboBox<String> jCity;
    private JLabel email;
    private JTextField temail;
    private JLabel mno;
    private JTextField tmno;
    private JLabel occupation;
    private JComboBox<String> jOccupation;
    private JButton sub;
    private JButton search;
    private JButton close;

    private String occupationList[] = { "Engineer" , "Teacher"};
    private String cityList[] = { "London" , "Washington"};

    public TravelerInfo()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        name = new JLabel("Traveler's Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(200, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(250, 100);
        c.add(tname);

        city = new JLabel("City From");
        city.setFont(new Font("Arial", Font.PLAIN, 20));
        city.setSize(100, 20);
        city.setLocation(460, 100);
        c.add(city);

        jCity = new JComboBox(cityList);
        jCity.setFont(new Font("Arial", Font.PLAIN, 15));
        jCity.setSize(150, 20);
        jCity.setLocation(580, 100);
        c.add(jCity);

        email = new JLabel("Email ID");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 150);
        c.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(250, 150);
        c.add(temail);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(460, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(580, 150);
        c.add(tmno);

        occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Arial", Font.PLAIN, 20));
        occupation.setSize(100, 20);
        occupation.setLocation(100, 250);
        c.add(occupation);

        jOccupation = new JComboBox(occupationList);
        jOccupation.setFont(new Font("Arial", Font.PLAIN, 15));
        jOccupation.setSize(150, 20);
        jOccupation.setLocation(220, 250);
        c.add(jOccupation);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(300, 320);
        sub.addActionListener(this);
        c.add(sub);

        search = new JButton("Search");
        search.setFont(new Font("Arial", Font.PLAIN, 15));
        search.setSize(100, 20);
        search.setLocation(420, 320);
        search.addActionListener(this);
        c.add(search);

        close = new JButton("close");
        close.setFont(new Font("Arial", Font.PLAIN, 15));
        close.setSize(100, 20);
        close.setLocation(540, 320);
        close.addActionListener(this);
        c.add(close);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            String info = String.join("\n" , tname.getText(), temail.getText(), Objects.requireNonNull(jOccupation.getSelectedItem()).toString(),
                    Objects.requireNonNull(jCity.getSelectedItem()).toString(), tmno.getText(), "\n");
            appendStrToFile(info);
            new PopUp("info successfully saved!!");
        }

        else if (e.getSource() == search) {
            boolean found = false;
            BufferedReader reader;

            try {
                reader = new BufferedReader(new FileReader("src/partB/travelerInfo.txt"));
                String line = reader.readLine();

                while (line != null) {
                    if (!tmno.getText().equals("") && !line.equals("\n") && line.trim().equals(tmno.getText()))
                        found = true;
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            if (found){
                new PopUp("found traveler " + tmno.getText() + " in the file");
            }else {
                new PopUp("Traveler is not found!!");
            }
        }

        else if (e.getSource() == close) {
            this.dispose();
        }
    }

    public void appendStrToFile(String str) {
        try {
            File file = new File("src/partB/travelerInfo.txt");
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
            out.write(str);
            out.close();
        } catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }
}