package com.termfinal.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestProgramUI extends WindowAdapter implements ActionListener {
    private JFrame f;
    private JPanel panel1, panel2, panel3;
    private JTextField text_field1, text_field2;
    private JButton button1, button2, button3;
    private JComboBox comboBox;
    private FileDialog fd;
    private File file1 = null;
    private DefaultComboBoxModel model;

    public void display(){
        f = new JFrame("InFile");
        f.setSize(680, 150);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.lightGray);
        f.addWindowListener(this);
        //f.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        text_field1 = new JTextField("Choose your java class",50);
        text_field1.setEnabled(false);
        text_field1.setFont(new Font("Dialog",Font.BOLD,12));
        panel1.add(text_field1);
        button1 = new JButton("choose");
        panel1.add(button1);
        button1.addActionListener(this);
        f.add(panel1,"North");
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        text_field2 = new JTextField("Choose your test case example",50);
        text_field2.setEnabled(false);
        text_field2.setFont(new Font("Dialog",Font.BOLD,12));
        panel2.add(text_field2);
        button2 = new JButton("choose");
        panel2.add(button2);
        button2.addActionListener(this);
        f.add(panel2,"Center");
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        model = new DefaultComboBoxModel();
        comboBox = new JComboBox(model);
        comboBox.setEditable(true);
        panel3.add(comboBox);
        button3 = new JButton("start");
        panel3.add(button3);
        button3.addActionListener(this);
        f.add(panel3,"South");
        f.setVisible(true);
    }//end display

    public void actionPerformed(ActionEvent e){
        long start = System.currentTimeMillis();
        if(e.getSource() == button1){
            fd = new FileDialog(f, "Open", FileDialog.LOAD);
            fd.setVisible(true);
            if((fd.getDirectory() != null) && (fd.getFile() != null)){
                text_field1.setText(fd.getDirectory() + fd.getFile());
                //File classFile = new File(fd.getDirectory(),fd.getFile());
                String packagename = fd.getDirectory().substring(fd.getDirectory().indexOf("com")).replace("\\",".");
                System.out.println(packagename);
                String classname = fd.getFile().replace(".java", "");
                try{
                    Class clazz = Class.forName(packagename + classname);
                    System.out.println(clazz);
                    Class[] classes = clazz.getDeclaredClasses();
                    model.addElement(clazz.toString());
                    for(int j = 0; j < classes.length; j++){
                        System.out.println(classes[j]);
                        model.addElement(classes[j].toString());
                    }
                    /*(Method[] methods = clazz.getDeclaredMethods();
                    for(int i = 0; i < methods.length; i++){
                        model.addElement(methods[i].toString());
                    }*/
                }catch (ClassNotFoundException cnfe){
                    System.out.println(cnfe);
                }
                /*try{
                    file1 = new File(fd.getDirectory(), fd.getFile());
                    BufferedInputStream fr = new BufferedInputStream(new FileInputStream(file1), 8);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fr), 10*1024*1024);
                    String aline;
                    while((aline = br.readLine()) != null){
                        text_area.append(aline + "\r\n");
                    }
                    fr.close();
                    br.close();
                }catch (IOException ioe){
                    System.err.println(ioe);
                }*/
            }
        }//if e.getSource() == button1
        if(e.getSource() == button2){
            fd = new FileDialog(f, "Open", FileDialog.LOAD);
            fd.setVisible(true);
            if((fd.getDirectory() != null) && (fd.getFile() != null)){
                text_field2.setText(fd.getDirectory() + fd.getFile());
            }
        }
        if (e.getSource() == button3) {

        }
    }

    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

    public static void main(String []args){
        (new TestProgramUI()).display();
    }
}