#include "Complex.h"
#include <iostream>
#include <math.h>
using namespace std;

Complex::Complex(double re, double im)
{
    cout<<"Konstruktor liczba zespolona = "<<re<<" + "<<im<<"i\n";
    this->re = re;
    this->im = im;
}

Complex::~Complex(void)
{
    cout<<"Destruktor liczba zespolona = "<<re<<" + "<<im<<"i\n";
}

double Complex::modul()
{
    return sqrt(pow(re,2)+pow(im,2));
}

void Complex::overriding(){
    cout <<  "Overriding - nadpisana\n";
}

void Complex::overloading(){
    cout <<  "Overloading - bez parametrow\n";
}

void Complex::overloading(int liczba){
    cout <<  "Overloading - z liczba: " << liczba << " w parametrze\n";
}

std::ostream & operator<<(std::ostream &out, Complex &l)
{
    out<<"Liczba zespolona: " << l.re <<" + "<< l.im <<"i\n";
    return out;
}
