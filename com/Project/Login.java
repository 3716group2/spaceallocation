package com.Project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame 
{
    public static void main(String[] args) 
    {
        JFrame frame = new Login();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // member variables
    private JButton login_button; 
    private JLabel userName_Label; // define all the components 
    private JLabel password_Label;
    private JTextField userName_Field;
    private JTextField password_Field;
    private JTextField status_Field;
    private JCheckBox prnEntry_CheckBox;

    private JFrame frm2;

    private final int width = 600;
    private final int height = 240;

    private static final String STUID = "stuID.txt";
    private static final String PRNID = "prnID.txt";

    private HashMap<String, String> stuID_Map;
    private HashMap<String, String> prnID_Map;

    // constructor
    public Login() 
    {   createComponents();
        createListeners();
        setSize(width, height);
        status_Field.setText("status");
        status_Field.setEditable(false);

        stuID_Map=new HashMap<String, String>();
        prnID_Map=new HashMap<String, String>();
        
        cacheData(STUID);
        cacheData(PRNID);
    }

    // helpers
    private void createComponents() 
    {   JPanel panel = new JPanel(); // panel
        panel.setLayout(new GridLayout(4, 2));

        userName_Label = new JLabel("user name: "); // username_Label
        userName_Field = new JTextField(10); // username_Field
        password_Label = new JLabel("password: ");
        password_Field = new JTextField(10);
        login_button = new JButton("log in"); // button
        status_Field = new JTextField(15);
        prnEntry_CheckBox = new JCheckBox("principal entry", false);

        panel.add(userName_Label); // add username_label
        panel.add(userName_Field); // add Field
        panel.add(password_Label); // add Label
        panel.add(password_Field); // add Field
        panel.add(status_Field);
        panel.add(login_button); // add button
        panel.add(prnEntry_CheckBox);

        add(panel); // add panel

    }

    private void createListeners() 
    {   ActionListener listener;
        listener = new LoginAction(); // new a listener

        login_button.addActionListener(listener); // add the listener to button
    }

    class LoginAction implements ActionListener 
    {   
        public void actionPerformed(ActionEvent event) // rewrite(customize) the default method
        {
            if(prnEntry_CheckBox.isSelected() == false) // stu in
            {
                if( stuID_Map.containsKey( userName_Field.getText() ) && stuID_Map.get( userName_Field.getText() ).equals( password_Field.getText() ) )
                {
                    status_Field.setText("login succeed");
                    frm2=new StuFrame();
                }
                else 
                {   status_Field.setText("cannot login");   }
            } 
            else                                          // Prn in
            {
                if ( prnID_Map.containsKey( userName_Field.getText() ) && prnID_Map.get( userName_Field.getText() ).equals( password_Field.getText() ) )
                {
                    status_Field.setText("login succeed");
                    frm2=new PrnFrame();
                }
                else
                {   status_Field.setText("cannot login");   }
            }
        }
    }

    private void cacheData(String fileName)
    {
        try ( BufferedReader br = new BufferedReader( new FileReader(fileName) ) )
        {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null)
            {   String[] parts = sCurrentLine.split(";");
                if (fileName.equalsIgnoreCase(STUID))
                {   stuID_Map.put(parts[0], parts[1]);   }
                else
                {   prnID_Map.put(parts[0], parts[1]);   }
            }
        }
        catch (IOException ex)
        {   ex.printStackTrace();   }

    }
}
