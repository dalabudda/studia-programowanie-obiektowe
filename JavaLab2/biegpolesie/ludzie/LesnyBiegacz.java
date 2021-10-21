package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

public class LesnyBiegacz extends Czlowiek{

    public LesnyBiegacz(String imie, String nazwisko, Czlowiek.Plec plec) {
        super(imie, nazwisko, plec);
    }
    
    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć! Jestem "+getImie()+" "+getNazwisko()+". Moim ulubionym drzewem jest sosna.");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        switch(rodzajTerenu)
        {
            case DROGA:
                wypowiedzSie("Idę sobie drogą.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.1 + 0.9; //Od 0.9 do 1.0
            case SCIEZKA:
                wypowiedzSie("Co za ładna ścieżka w lesie");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.15 + 0.85; //Od 0.85 do 1.0
            case WYSOKI_LAS:
                wypowiedzSie("Wysoki las prawie jak droga.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.8; //Od 0.8 do 1.0
            case NISKI_LAS:
                wypowiedzSie("Niski las nie taki zły.");
                return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.6; //Od 0.6 do 0.8
            default:
                return super.predkoscPoruszaniaSie(rodzajTerenu);
        }
    }
}
