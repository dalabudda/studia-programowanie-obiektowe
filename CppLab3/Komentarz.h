#ifndef KOMENTARZ_H_INCLUDED
#define KOMENTARZ_H_INCLUDED

#include "Organizm.h"

class Organizm;

class Komentarz
{
private:
    Organizm *atakujacy;
    Organizm *broniacy;
    char *zdarzenie;
public:
    Komentarz(Organizm *a, Organizm *b);
    ~Komentarz();
    void setZdarzenie(char *z);
    char* getChar();
};


#endif // KOMENTARZ_H_INCLUDED
