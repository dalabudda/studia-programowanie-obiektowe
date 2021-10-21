package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Robot;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

public class TerminatorL extends Terminator {

    public TerminatorL(int numerSeryjny) {
        super("T-101L", numerSeryjny);
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        if (RodzajTerenu.NISKI_LAS.equals(rodzajTerenu)) {
            komunikuj("Wykryto teren: NISKI_LAS. Wykryto znaczną liczbę przeszkód.");
            return czynnikiLosowe.nextDouble()*0.2 + 0.5; //Od 0.5 do 0.7
        }
        else
            return super.predkoscPoruszaniaSie(rodzajTerenu);
    }
    
    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if (DziedzinaZadania.NAUKI_LESNE.equals(dziedzinaZadania)) {
            komunikuj("Wykryto zadanie - NAUKI_LESNE.");
            return czynnikiLosowe.nextDouble() <= 0.6;
        }
        else
            return super.rozwiazZadanie(dziedzinaZadania);
    }
}
