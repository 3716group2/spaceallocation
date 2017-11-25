package com.Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrnFrame extends JFrame
{
  //member variables
    private JPanel panel;
    private JButton view_Button;
    private JButton manage_Button;
    private static final int width=600;
    private static final int height=240;
    
    //constructor
    public PrnFrame()
    {   createComponents();          
        createListeners();
        setSize(width,height);     
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //helper method
    private void createComponents()
    {   panel=new JPanel();                     //build a panel and its content
        
        view_Button=new JButton("View Schedule");                 //button
        manage_Button=new JButton("Manage Schedule");  //label
        
        panel.add(view_Button);
        panel.add(manage_Button);
        
        add(panel);                             //add panel to frame (No need to assign object since
    }       
    
    
    private void createListeners() 
    {   ActionListener view_Listener,manage_Listener;
        view_Listener = new ViewAction(); // new a listener
        manage_Listener = new ManageAction(); 
        
        view_Button.addActionListener(view_Listener); // add the listener to button
        manage_Button.addActionListener(manage_Listener);
    }

    class ManageAction implements ActionListener 
    {   
        public void actionPerformed(ActionEvent event) // rewrite(customize) the default method
        {
            new ManageSchedule();
        }
    }
    
    
    
}





