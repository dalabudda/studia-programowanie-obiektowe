package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Robot;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

public class Terminator extends Robot {

    public Terminator(int numerSeryjny) {
        super("T-101", numerSeryjny);
    }
    
    public Terminator(String model, int numerSeryjny) {
        super(model, numerSeryjny);
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        switch(rodzajTerenu)
        {
            case DROGA:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Rozwijanie maksymalnej prędkości.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.9; //Od 0.9 do 1.0
            case SCIEZKA:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Prędkość umiarkowana.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.8; //Od 0.80 do 0.90
            case WYSOKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Nieprzyjazne warunki.");
                return czynnikiLosowe.nextDouble()*0.2 + 0.5; //Od 0.5 do 0.7
            case NISKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu+". Wykryto znaczną liczbę przeszkód.");
                return czynnikiLosowe.nextDouble()*0.2 + 0.3; //Od 0.3 do 0.5
            case BAGNO:
            default:
                komunikuj("Wykryto teren: "+rodzajTerenu+".");
                komunikuj("Awaria silników!");
                return czynnikiLosowe.nextDouble()*0.2 + 0.1; //Od 0.1 do 0.3
        }
    }
    
    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        komunikuj("Wykryto zadanie - "+dziedzinaZadania+".");
        switch(dziedzinaZadania)
        {
            case MATEMATYKA:
            case FIZYKA:
            case INFORMATYKA:
                return true;
            case SZTUKA:
            case NAUKI_LESNE:
            default:
                return czynnikiLosowe.nextDouble() <= 0.05;
        }
    }
}
