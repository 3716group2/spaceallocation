package com.Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StuFrame extends JFrame
{
    //member variables
    private JPanel panel;
    private JButton view_Button;
    private JButton request_Button;
    private static final int width=600;
    private static final int height=240;
    
    //constructor
    public StuFrame()
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
        request_Button=new JButton("Submit request");  
        
        panel.add(view_Button);
        panel.add(request_Button);
        
        add(panel);                       
    }       
    
    private void createListeners() 
    {   ActionListener view_Listener,request_Listener;
        view_Listener = new ViewAction(); // new a listener
        request_Listener = new RequestAction(); 
        
        view_Button.addActionListener(view_Listener); // add the listener to button
        request_Button.addActionListener(request_Listener);
    }

    class RequestAction implements ActionListener 
    {   
        public void actionPerformed(ActionEvent event) // rewrite(customize) the default method
        {
            new RequestForm();
        }
    }
}
