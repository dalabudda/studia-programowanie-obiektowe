package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

public interface ElementTrasy {
    Iterable<Uczestnik> getUczestnicy();
    void dodajUczestnika(Uczestnik u);
    void usunUczestnika(Uczestnik u);
    public int getLiczbaUczestnikowNaTrasie();
}
