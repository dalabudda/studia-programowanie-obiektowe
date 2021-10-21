package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

import java.io.PrintStream;


public interface Uczestnik {
    
    void mowDo(PrintStream ps);
    
    double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu);
    
    boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania);
}
