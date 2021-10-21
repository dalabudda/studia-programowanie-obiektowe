package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;

public class Student extends Czlowiek{

    private final String kierunekStudiow;
    public Student(String imie, String nazwisko, Plec plec, String kierunekStudiow) {
        super(imie, nazwisko, plec);
        this.kierunekStudiow = kierunekStudiow;
    }
    
    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć! Jestem "+getImie()+" "+getNazwisko()+". Studiuję "+kierunekStudiow+".");
    }
    
    @Override
    public boolean rozwiazZadanie(DziedzinaZadania dziedzinaZadania) {
        if(kierunekStudiow.equalsIgnoreCase(dziedzinaZadania.name()))
        {
            wypowiedzSie("To zadanie z mojej dziedziny - "+kierunekStudiow+"!");
            return humorIUwarunkowaniaOsobiste.nextDouble() <= 0.9;
        }
        else
            return super.rozwiazZadanie(dziedzinaZadania);
    }
}
