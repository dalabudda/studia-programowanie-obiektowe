#ifndef WYJATEK_H_INCLUDED
#define WYJATEK_H_INCLUDED

#include <string>

using namespace std;

class Wyjatek
{
private:
    string wiadomosc;
public:
    Wyjatek(string w);
    void wypisz();
};


#endif // WYJATEK_H_INCLUDED
