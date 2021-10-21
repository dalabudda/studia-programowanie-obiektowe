#include "VoV1.h"
#include "VektorNd.h"
#include <iostream>

using namespace std;

void VectorOfVectors1::wypisz(ostream & out){
    out << "|-------------------------VectorOfVectors1-BEGIN------------------------------|"<<endl;
    out << "Jestem wektorem wektorow pod adresem: " << this <<endl;
    out << "Moj rozmiar to: " << size << endl;
    out << "A wektory:"<<endl;
    for (int i = 0; i < size; i++)
    out <<i<<".\n" << vektory[i] <<endl;
    out << "|--------------------------VectorOfVectors1-END-------------------------------|"<<endl;
}

VectorOfVectors1::VectorOfVectors1(){
    size = 0;
}

VectorOfVectors1::VectorOfVectors1(const VektorNd p_vektory[], int p_size){
    size = p_size;
    if (size > N)
        size = N;
    for (int i = 0; i < size; i++)
        vektory[i] = p_vektory[i];
}

VectorOfVectors1::VectorOfVectors1(const VectorOfVectors1& oryginal){
    size = oryginal.size;
    if (size > N)
        size = N;
    for (int i = 0; i < size; i++)
        vektory[i] = oryginal.vektory[i];
}

VectorOfVectors1::~VectorOfVectors1(){
    cout << "Destruktor VectorOfVectors1" <<endl;
}

VectorOfVectors1& VectorOfVectors1::operator=(const VectorOfVectors1& right){
    cout << "Copy-swap START" << endl;
    VectorOfVectors1 tmp(right);
    swap(size, tmp.size);
    swap(vektory, tmp.vektory);
    cout << "Copy-swap SUCCESS" << endl;
    return *this;
}

ostream& operator<<(ostream & left, VectorOfVectors1& right){
    right.wypisz(left);
    return left;
}

istream& operator>>(istream & left, VectorOfVectors1& right){
    left >> right.size;
    for (int i = 0; i < right.size; i++)
        left >> right.vektory[i];
    return left;
}
