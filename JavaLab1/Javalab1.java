package dawid.labudda.lab3;
import java.util.Scanner;
import dawid.labudda.lab3.transformacje.*;

public class Javalab1 {
    public static void main(String[] args)
    {
        Punkt punkt = new Punkt(3.1, 4.0);
        System.out.println("Pobieranie x:");
        System.out.println(punkt.getX());
        System.out.println("Pobieranie y:");
        System.out.println(punkt.getY());
        System.out.println("Drukowanie całego obiektu:");
        System.out.println(punkt);
        Punkt punkt1 = new Punkt(9.2, 3.14);
        System.out.println("Porównywanie referencji: punkt == punkt");
        System.out.println(punkt == punkt);
        System.out.println("Porównywanie referencji: punkt == punkt1");
        System.out.println(punkt == punkt1);
        System.out.println("Metoda equals: punkt.equals(punkt)");
        System.out.println(punkt.equals(punkt));
        System.out.println("Metoda equals: punkt.equals(punkt1)");
        System.out.println(punkt.equals(punkt1));
        System.out.println("Metoda hashCode: punkt.hashCode()");
        System.out.println(punkt.hashCode());
        System.out.println("Metoda hashCode: punkt1.hashCode()");
        System.out.println(punkt1.hashCode());
        System.out.println();
        
        try {
            Punkt p1 = Punkt.E_X;
            System.out.println(p1);
            Transformacja tr = new Translacja(5, 6);
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr2 = new Skalowanie(5, 4);
            System.out.println(tr2);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        }
        catch(BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tr2 = new Skalowanie(5, 0);
            System.out.println(tr2);
            System.out.println(p1);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        }
        catch(BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(); 
        
        
        try
        {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tr3 = new Obrot(90);
            System.out.println(tr3);
            System.out.println(p1);
            Punkt p2 = tr3.transformuj(p1);
            System.out.println(p2);
            Transformacja trr3 = tr3.getTransformacjaOdwrotna();
            System.out.println(trr3);
            Punkt p3 = trr3.transformuj(p2);
            System.out.println(p3);
        }
        catch(BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(); 
        
        
        try
        {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tab[] = new Transformacja[3];
            tab[0] = new Translacja(3, 2);
            tab[1] = new Skalowanie(2, 4);
            tab[2] = new Obrot(90);
            Transformacja tr4 = new ZlozenieTransformacji(tab);
            System.out.println(tr4);
            System.out.println(p1);
            Punkt p2 = tr4.transformuj(p1);
            System.out.println(p2);
            Transformacja trr4 = tr4.getTransformacjaOdwrotna();
            System.out.println(trr4);
            Punkt p3 = trr4.transformuj(p2);
            System.out.println(p3);
        }
        catch(BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(); 
    }
}
