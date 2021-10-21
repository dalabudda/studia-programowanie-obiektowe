#include "Liczba.h"
#include <iostream>
using namespace std;

Liczba::Liczba(double re)
{
    cout<<"Konstruktor Liczba = "<<re<<"\n";
    this->re = re;
}

Liczba::~Liczba(void)
{
    cout<<"Destruktor Liczba = "<<re<<"\n";
}

double Liczba::modul()
{
    return re;
}

std::ostream & operator<<(std::ostream &out, Liczba &l)
{
    out<<"Liczba rzeczywista: " << l.re<<"\n";
    return out;
}
