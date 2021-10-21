package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

public class FabrykaElementowTrasy {
    public static ElementTrasy utworzElementTrasy(RodzajTerenu rodzajTerenu)
    {
        return new Teren(rodzajTerenu);
    }
    
    public static ElementTrasy utworzElementTrasy(DziedzinaZadania dziedzinaZadania)
    {
        return new Zadanie(dziedzinaZadania);
    }
    
    public static ElementTrasy utworzElementTrasy(String element) throws BladBudowaniaElementuTrasyException
    {
        try {
            return new Teren(RodzajTerenu.valueOf(element));
        }
        catch(Exception e) {
            try {
                return new Zadanie(DziedzinaZadania.valueOf(element));
            }
            catch(Exception e2) {
                throw new BladBudowaniaElementuTrasyException();
            }
        }
    }
}
