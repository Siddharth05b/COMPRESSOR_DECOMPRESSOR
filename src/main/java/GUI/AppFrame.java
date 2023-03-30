/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 91748
 */
public class AppFrame extends JFrame implements ActionListener {
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        compressButton = new JButton("Compress File");
        compressButton.setBounds(250, 100, 100, 30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Decompress File");
        decompressButton.setBounds(250, 100, 100, 30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(300, 300);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                
                System.out.print(file);
                
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                
                System.out.print(file);
                
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
