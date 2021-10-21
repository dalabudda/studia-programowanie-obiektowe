package dawid.labudda.lab3.transformacje;

public class ZlozenieTransformacji implements Transformacja{
    private final Transformacja[] tab;
    public ZlozenieTransformacji(Transformacja[] tab) {
        this.tab = tab;
    }
    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        Transformacja[] tab2 = new Transformacja[tab.length];
        for (int i = 0; i < tab.length; i++)
            tab2[i] = tab[tab.length - 1 - i].getTransformacjaOdwrotna();
        return new ZlozenieTransformacji(tab2);
    }
    @Override
    public Punkt transformuj(Punkt p) { 
        Punkt punkt = tab[0].transformuj(p);
        for (int i = 1; i < tab.length; i++)
            punkt = tab[i].transformuj(punkt);
        return punkt;
    }
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < tab.length; i++)
            out += tab[i].toString() + "\n";
        return out;
    }
}
