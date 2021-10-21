#include "VektorNd.h"
#include <iostream>

using namespace std;

void VektorNd::wypisz(ostream & out){
    out << "|-------------------------BEGIN------------------------------|"<<endl;
    out << "Jestem wektorem pod adresem: " << this <<endl;
    out << "Moj wymiar to: " << _wymiar << endl;
    out << "A elementy:"<<endl;
    for (int i=0;i<_wymiar;i++)
    out <<"["<<i<<"] = \t" << _liczby[i]<<endl;
    out << "|--------------------------END-------------------------------|"<<endl;
}

VektorNd::VektorNd(){
    _liczby = 0;
    _wymiar = 0;
}

VektorNd::VektorNd(const double liczby[],int wymiar){
    _liczby = new double[wymiar];
    _wymiar = wymiar;
    for (int i=0;i<_wymiar;i++)
        _liczby[i] = liczby[i];
}

VektorNd::~VektorNd(){
    cout << "zwalniam pamiec pod adresem: " << _liczby <<endl;
    delete[] _liczby;
}

VektorNd::VektorNd(const VektorNd& oryginal){
    _liczby = new double[oryginal._wymiar];
    _wymiar = oryginal._wymiar;
    for (int i=0;i<_wymiar;i++)
        _liczby[i] = oryginal._liczby[i];
}

void VektorNd::getCoefs(double liczby[]){
    for (int i=0;i<_wymiar;i++)
    liczby[i] = _liczby[i];
}

void VektorNd::setCoef(double wartosc,int index){
    _liczby[index] = wartosc;
}

void VektorNd::setCoefs(const double liczby[],int wymiar){
    delete[] _liczby;
    _liczby = new double[wymiar];
    _wymiar = wymiar;
    for(int i=0;i<_wymiar;i++)
        _liczby[i] = liczby[i];
}

ostream& operator<<(ostream & left,VektorNd& right){
    right.wypisz(left);
    return left;
}

istream& operator>>(istream & left, VektorNd& right){
    delete[] right._liczby;
    left >> right._wymiar;
    right._liczby = new double[right._wymiar];
    for (int i = 0; i < right._wymiar; i++)
        left >> right._liczby[i];
    return left;
}

