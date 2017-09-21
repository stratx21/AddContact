/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addcontact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author 0001058857
 */
public class Addn extends JFrame{
    
    
    private static int count(){
        int c=0;
        try{
            Scanner in=new Scanner(new File("Contacts.txt"));
            while(in.hasNextLine()){
                in.nextLine();
                c++;
            }
            in.close();
        } catch(IOException ioex){
            System.err.println("Error in function[count]:: "+ioex);
        }
        
        return c;
    }
    
    public Addn(){
        this.setVisible(true);
        this.setSize(250,200);
        
        JPanel panel=new JPanel();
        JLabel label1=new JLabel("Enter information [leave blank if desired]::");
        JTextField textfield = new JTextField("NAME");
        JTextField textfield2 = new JTextField("ADDRESS");
        JLabel number=new JLabel("NUMBER::");
        JTextField num1=new JTextField(3);
        JTextField num2=new JTextField(3);
        JTextField num3=new JTextField(4);
        
        JButton button=new JButton("OK");
        
        this.add(panel);
        this.add(label1);
        this.add(textfield);
        this.add(textfield2);
        this.add(number);
        this.add(num1);
        this.add(num2);
        this.add(num3);
        this.add(button);
        
        
        
        
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                final String name= textfield.getText();
                final String address=textfield2.getText();
                final String n1=num1.getText();
                final String n2=num2.getText();
                final String n3=num3.getText();
        
                createFile(name,address,n1,n2,n3);
                System.exit(-2);
            }
                });
        
        this.repaint();
    }
            
            
    public static void createFile(String name,String address,String n1,String n2,String n3){
        try{
            BufferedWriter filen=new BufferedWriter(new FileWriter(name+".txt"));
            Scanner in=new Scanner(new File("Contacts.txt"));
            
            int PPL=count();
            
            
            
            filen.write(name);
            filen.newLine();
            filen.write(address);
            filen.newLine();
            filen.write(n1+"-"+n2+"-"+n3);
            filen.newLine();
            filen.newLine();
            filen.close();
            
            
            
            
            
            
            
        }catch(IOException ioex){
            System.err.println("Error using FileWriter:: "+ioex);
        }
    }
    
}
