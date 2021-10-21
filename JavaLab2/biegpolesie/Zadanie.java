package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

import java.util.HashMap;
import java.util.Map;

class Zadanie implements ElementTrasy {

    private final DziedzinaZadania dziedzinaZadania;
    private Map<Uczestnik,Boolean> uczestnicyWZadaniu = new HashMap<>();

    public Zadanie(DziedzinaZadania dziedzinaZadania) {
        this.dziedzinaZadania = dziedzinaZadania;
    }

    @Override
    public Iterable<Uczestnik> getUczestnicy() {
        return uczestnicyWZadaniu.keySet();
    }

    public DziedzinaZadania getDziedzinaZadania() {
        return dziedzinaZadania;
    }

    public Map<Uczestnik, Boolean> getUczestnicyWZadaniu() {
        return uczestnicyWZadaniu;
    }

    @Override
    public void dodajUczestnika(Uczestnik u) {
        uczestnicyWZadaniu.put(u, false);
    }

    @Override
    public void usunUczestnika(Uczestnik u) {
        uczestnicyWZadaniu.remove(u);
    }

    @Override
    public int getLiczbaUczestnikowNaTrasie() {
        return uczestnicyWZadaniu.size();
    }
    
}
