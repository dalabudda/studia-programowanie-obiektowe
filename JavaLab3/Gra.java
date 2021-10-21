package dawid.labudda.jpolabotw;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;


public class Gra {
    private Swiat swiat;
    private JPanel tiles[][];
    private JLabel licznik_tur, zdarzenia[];
    private JList lista_wzorcow;
    public Gra(JFrame frame)
    {
        tiles = new JPanel[20][20];
        for (int y = 0; y < 20; y++)
        {
            for (int x = 0; x < 20; x++)
            {
                tiles[y][x] = new JPanel();
                tiles[y][x].setBounds(15+x*20,15+y*20,20,20);
                tiles[y][x].setBackground(Color.gray);
                
                tiles[y][x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int x = e.getXOnScreen() - frame.getX() -23;
                        int y = e.getYOnScreen() - frame.getY() -46;
                        przyciskMyszyWcisniety(x/20, y/20);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        int x = e.getXOnScreen() - frame.getX() -23;
                        int y = e.getYOnScreen() - frame.getY() -46;
                        przyciskMyszyZwolniony(x/20, y/20);
                    }
                });
                frame.add(tiles[y][x]);
            }
        }
        
        licznik_tur = new JLabel("Tura: 0");
        licznik_tur.setBounds(430,15, 330,20);
        licznik_tur.setFont(new Font("Helvetica", Font.PLAIN, 20));
        licznik_tur.setForeground(Color.decode("#ee9900"));
        frame.add(licznik_tur);
        
        zdarzenia = new JLabel[20];
        for (int i = 0; i < 20; i++)
        {
            zdarzenia[i] = new JLabel();
            zdarzenia[i].setBounds(430,40+i*19, 330,19);
            frame.add(zdarzenia[i]);
        }
        
        odNowa();
        
        String nazwy[] = new String[8];
        swiat.tablicaNazw(nazwy);
        lista_wzorcow = new JList(nazwy); 
        lista_wzorcow.setBounds(730,15,50,150);
        lista_wzorcow.setBackground(null);
        frame.add(lista_wzorcow);
    }
    
    public void nastepnaTura()
    {
        swiat.wykonajTure();
        swiat.rysujSwiat(tiles, licznik_tur, zdarzenia);
    }
    
    public void odNowa()
    {
        swiat = new Swiat(20);
        swiat.rysujSwiat(tiles, licznik_tur, zdarzenia);
    }
    
    public void zapisz()
    {
        swiat.zapiszSwiat();
    }
    
    public void wczytaj()
    {
        swiat.wczytajSwiat();
        swiat.rysujSwiat(tiles, licznik_tur, zdarzenia);
    }
    
    public void przyciskMyszyWcisniety(int x, int y)
    {
        int index = lista_wzorcow.getSelectedIndex();
        swiat.stworzOrganizm(x, y, index);
        swiat.rysujSwiat(tiles, licznik_tur, zdarzenia);
    }
    
    public void przyciskMyszyZwolniony(int x, int y)
    {
        //System.out.println("Zwolniony "+x+" "+y);
    }
}
