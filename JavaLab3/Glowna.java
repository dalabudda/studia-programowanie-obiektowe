package dawid.labudda.jpolabotw;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class Glowna {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Panel Example");
        
        Gra gra = new Gra(frame);
        
        JButton przycisk_nastepnaTura = new JButton("Następna tura");     
        przycisk_nastepnaTura.setBounds(15,430,120,30);    
        przycisk_nastepnaTura.setBackground(Color.orange);
        przycisk_nastepnaTura.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                gra.nastepnaTura();
            }  
        });  
        frame.add(przycisk_nastepnaTura);
        
        JButton przycisk_odNowa = new JButton("Od nowa");
        przycisk_odNowa.setBounds(140,430,100,30);
        przycisk_odNowa.setBackground(Color.red);
        przycisk_odNowa.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                gra.odNowa();
            }  
        }); 
        frame.add(przycisk_odNowa);
        
        JButton przycisk_zapisz = new JButton("Zapisz");
        przycisk_zapisz.setBounds(245,430,80,30);
        przycisk_zapisz.setBackground(Color.green);
        przycisk_zapisz.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                gra.zapisz();
            }  
        }); 
        frame.add(przycisk_zapisz);
        
        JButton przycisk_wczytaj = new JButton("Wczytaj");
        przycisk_wczytaj.setBounds(330,430,80,30);
        przycisk_wczytaj.setBackground(Color.yellow);
        przycisk_wczytaj.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                gra.wczytaj();
            }  
        }); 
        frame.add(przycisk_wczytaj);
        
        frame.setSize(800,520);    
        frame.setLayout(null);    
        frame.setVisible(true);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}