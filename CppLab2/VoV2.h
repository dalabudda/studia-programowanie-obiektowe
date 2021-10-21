#ifndef VOV2_H_INCLUDED
#define VOV2_H_INCLUDED

#include "VektorNd.h"
#include <iostream>

using namespace std;

class VectorOfVectors2 {
    VektorNd *vektory;
    int size;
    void wypisz(ostream & out = cout);
public:
    VectorOfVectors2();
    VectorOfVectors2(const VektorNd p_vektory[], int p_size);
    VectorOfVectors2(const VectorOfVectors2& oryginal);
    ~VectorOfVectors2();
    VectorOfVectors2& operator=(const VectorOfVectors2& right);
    friend ostream& operator<<(ostream & left, VectorOfVectors2& right);
    friend istream& operator>>(istream & left, VectorOfVectors2& right);
};

#endif // VOV2_H_INCLUDED
