#ifndef VOV1_H_INCLUDED
#define VOV1_H_INCLUDED

#include "VektorNd.h"
#include <iostream>

const int N = 10;

class VectorOfVectors1 {
    VektorNd vektory[N];
    int size;
    void wypisz(ostream & out = cout);
public:
    VectorOfVectors1();
    VectorOfVectors1(const VektorNd p_vektory[], int p_size);
    VectorOfVectors1(const VectorOfVectors1& oryginal);
    ~VectorOfVectors1();
    VectorOfVectors1& operator=(const VectorOfVectors1& right);
    friend ostream& operator<<(ostream & left, VectorOfVectors1& right);
    friend istream& operator>>(istream & left, VectorOfVectors1& right);
};

#endif // VOV1_H_INCLUDED
