package pl.edu.pg.eti.ksg.po.lab2;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.BiegPoLesie;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.FabrykaElementowTrasy;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.BladBudowaniaElementuTrasyException;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Uczestnik;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.BagiennyBiegacz;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.Student;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.LesnyBiegacz;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.RobotMobilny;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.Terminator;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.TerminatorL;


public class Javalab2 {

    public static void main(String[] args) {
        
        Set<Uczestnik> uczestnicy = new HashSet<>();
        uczestnicy.add(new BagiennyBiegacz("Krzysztof", "Kowalski", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new RobotMobilny(1));
        uczestnicy.add(new LesnyBiegacz("Anna", "Nowak", Czlowiek.Plec.KOBIETA));
        uczestnicy.add(new Student("Kamil", "Szpak", Czlowiek.Plec.MEZCZYZNA, "INFORMATYKA"));
        uczestnicy.add(new Terminator(1));
        uczestnicy.add(new TerminatorL(1));
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w aplikacji Bieg po Lesie. Wybierz bieg: ");
        System.out.println("1. Górki");
        System.out.println("2. Na przełaj z Matematyką");
        System.out.println("3. Bagienny miks naukowy");
        System.out.println("4. Stwórz własny bieg");
        int wybor = scanner.nextInt();
        
        BiegPoLesie bieg;
        
        switch(wybor)
        {
            default:
                System.out.println("Niezany wybór. Wybieranie opcji nr 1.");
            case 1:
                bieg = gorki(System.out, System.out);
                break;
            case 2:
                bieg = naPrzelajZMatematyka(System.out, System.out);
                break;
            case 3:
                bieg = bagiennyMiks(System.out, System.out);
                break;
            case 4:
                bieg = wlasnyBieg(System.out, System.out);
                break;
        }
        
        for(Uczestnik u : uczestnicy)
        {
            bieg.dodajUczestnika(u);
        }
        
        bieg.zasubskrybujDojscieDoMety((Uczestnik u) -> {
            System.out.println("MAIN: Ktoś doszedł do mety.");
        });
        
        bieg.przeprowadzImpreze();
    }
    
    private static BiegPoLesie gorki(PrintStream mikrofon, PrintStream przestrzenWLesie)
    {
        BiegPoLesie gorki_ = new BiegPoLesie("Górki",mikrofon,przestrzenWLesie);
        
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.FIZYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return gorki_;
    }

    private static BiegPoLesie naPrzelajZMatematyka(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie naPrzelaj = new BiegPoLesie("Na przełaj z matematyką",mikrofon,przestrzenWLesie);
        
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return naPrzelaj;
    }

    private static BiegPoLesie bagiennyMiks(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie miks = new BiegPoLesie("Bagienny miks naukowy",mikrofon,przestrzenWLesie);
        
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.FIZYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.INFORMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.SZTUKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return miks;
    }
    
    private static BiegPoLesie wlasnyBieg(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie wlasny = new BiegPoLesie("Własny bieg po lesie",mikrofon,przestrzenWLesie);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę elementów twojej trasy.");
        int liczba = scanner.nextInt();
        
        for (int i = 0; i < liczba; i++) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Podaj nazwę "+(i+1)+" elementu trasy.");
            String element = scanner2.nextLine();
            try {
                wlasny.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(element));
                System.out.println("Dodano element "+element+" do twojej trasy.");
            }
            catch (BladBudowaniaElementuTrasyException e) {
                System.out.println("Nieprawidłowa nazwa elementu.");
                i--;
            }
        }
        
        return wlasny;
    }
    
}
