#ifndef VEKTORND_H_INCLUDED
#define VEKTORND_H_INCLUDED

#include <iostream>

using namespace std;

class VektorNd {
    double *_liczby;
    int _wymiar;
    void wypisz(ostream & out = cout);
public:
    VektorNd();
    VektorNd(const double liczby[],int wymiar);
    ~VektorNd();
    VektorNd(const VektorNd& oryginal);
    VektorNd& operator=(const VektorNd& right){
        if(_wymiar!=right._wymiar){
            delete[] _liczby;
            _liczby = new double[right._wymiar];
            _wymiar=right._wymiar;
        }
        for(int i=0;i<_wymiar;i++)
            _liczby[i] = right._liczby[i];
        return *this;
    }
    void getCoefs(double liczby[]);
    void setCoef(double wartosc,int index);
    void setCoefs(const double liczby[],int wymiar);
    friend ostream& operator<<(ostream & left,VektorNd& right);
    friend istream& operator>>(istream & left, VektorNd& right);
};

#endif // VEKTORND_H_INCLUDED
