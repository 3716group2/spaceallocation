package com.Project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RequestForm extends JFrame
{
    // components
    private JLabel event_Label; 
    private JLabel stuNum_Label; 
    private JLabel space_Label; 
    private JLabel time_Label; 
    private JLabel timeFormat_Label; 
    private JLabel startTime_Label; 
    private JLabel endTime_Label; 
    private JLabel description_Label; 
    
    private JTextField event_Field;
    private JTextField stuNum_Field;
    private JTextField startTime_Field;
    private JTextField endTime_Field;
    
    private JComboBox<Object> space_ComboBox; 
    
    private JTextArea description_TextArea;
    private JScrollPane scrollPane;
    
    //private JButton cancel_Button;
    private JButton submit_Button;
    
    private final int WIDTH = 600;
    private final int HEIGHT = 1000;
    private final int ROWS=20;       
    private final int COLUMNS=40;

    // constructor
    public RequestForm() 
    {   createComponents();
        createListeners();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // helpers
    private void createComponents() 
    {   //panels
        JPanel panel,p1,p2,p3;
        
        panel=new JPanel();
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
    
        panel.setLayout( new GridLayout(3,1,10,10) );
        p1.setLayout( new GridLayout(7,2) );
        p3.setLayout( new GridLayout(1,2) );

        //p1
        event_Label=new JLabel("1.Event name: ");
        event_Field=new JTextField(15);
        stuNum_Label=new JLabel("2.Student #: "); 
        stuNum_Field=new JTextField(15);
        space_Label=new JLabel("3.Space: "); 
        space_ComboBox=new JComboBox<Object>();
            space_ComboBox.addItem("place A");
            space_ComboBox.addItem("place B");
            space_ComboBox.addItem("place C");
            space_ComboBox.addItem("place D");
            space_ComboBox.addItem("place E");
        time_Label=new JLabel("4.Time: "); 
        timeFormat_Label=new JLabel("(mmddhh): "); 
        startTime_Label=new JLabel("    Start time: "); 
        startTime_Field=new JTextField(15);
        endTime_Label=new JLabel("    End time: "); 
        endTime_Field=new JTextField(15);
        description_Label=new JLabel("5.Description: ");         
        
        //p2
        description_TextArea=new JTextArea(ROWS,COLUMNS);
        scrollPane=new JScrollPane(description_TextArea);
        
        //p3
        //cancel_Button=new JButton("Cancel");
        submit_Button=new JButton("Submit");

        //panel+
        panel.add(p1); 
        panel.add(p2); 
        panel.add(p3);
        
        //p1+
        p1.add(event_Label);
        p1.add(event_Field);
        p1.add(stuNum_Label);
        p1.add(stuNum_Field);
        p1.add(space_Label);
        p1.add(space_ComboBox);
        p1.add(time_Label);
        p1.add(timeFormat_Label);
        p1.add(startTime_Label);
        p1.add(startTime_Field);
        p1.add(endTime_Label);
        p1.add(endTime_Field);
        p1.add(description_Label);
        
        //p2+
        p2.add(scrollPane);
        
        //p3+
        //p3.add(cancel_Button);
        p3.add(submit_Button);
        
        //add panel
        add(panel); 
        
    }

    private void createListeners() 
    {   ActionListener listener;
        listener = new SubmitAction();

        submit_Button.addActionListener(listener); 
    }

    class SubmitAction implements ActionListener 
    {   public void actionPerformed(ActionEvent event)
        {   
            int stuNum,space,start,end;
            String name,description;
            
            try
            {   
                if( validTime()==true )
                {
                
                name = event_Field.getText();
                stuNum = Integer.parseInt( stuNum_Field.getText() );
                space = space_ComboBox.getSelectedIndex();
                start = Integer.parseInt( startTime_Field.getText() );
                end = Integer.parseInt( endTime_Field.getText() );
                description = description_TextArea.getText();
            
                Event submit;
                submit = new Event(name,stuNum,space,start,end,description);
            
                new Allocate(submit);
            
                dispose();
                
                JOptionPane.showMessageDialog(null, "Successfully submited.");
                //new NoticeFrame("Successfully submitted.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Something wrong with term 2-4.");
                }
            }
            catch(NumberFormatException e)
            {   
                JOptionPane.showMessageDialog(null, "Something wrong with term 2-4.");
                //new NoticeFrame("Something wrong with term 2-4.");
            }
            

        }
    }

    public boolean validTime() 
    {
        
        return true;
    }


    
    
    
    
    
    
    
    
    
    
}
