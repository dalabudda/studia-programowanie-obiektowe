#include "VoV2.h"
#include "VektorNd.h"
#include <iostream>
#include <algorithm>    // std::swap

using namespace std;

void VectorOfVectors2::wypisz(ostream & out){
    out << "|-------------------------VectorOfVectors2-BEGIN------------------------------|"<<endl;
    out << "Jestem wektorem wektorow pod adresem: " << this <<endl;
    out << "Moj rozmiar to: " << size << endl;
    out << "A wektory:"<<endl;
    for (int i = 0; i < size; i++)
    out <<i<<".\n" << vektory[i] <<endl;
    out << "|--------------------------VectorOfVectors2-END-------------------------------|"<<endl;
}

VectorOfVectors2::VectorOfVectors2(){
    vektory = 0;
    size = 0;
}

VectorOfVectors2::VectorOfVectors2(const VektorNd p_vektory[], int p_size){
    vektory = new VektorNd[p_size];
    size = p_size;
    for (int i = 0; i < size; i++)
        vektory[i] = p_vektory[i];
}

VectorOfVectors2::VectorOfVectors2(const VectorOfVectors2& oryginal){
    vektory = new VektorNd[oryginal.size];
    size = oryginal.size;
    for (int i = 0; i < size; i++)
        vektory[i] = oryginal.vektory[i];
}

VectorOfVectors2::~VectorOfVectors2(){
    cout << "Destruktor VectorOfVectors2" <<endl;
    delete[] vektory;
}

VectorOfVectors2& VectorOfVectors2::operator=(const VectorOfVectors2& right){
    cout << "Copy-swap START" << endl;
    VectorOfVectors2 tmp(right);
    swap(size, tmp.size);
    swap(vektory, tmp.vektory);
    cout << "Copy-swap SUCCESS" << endl;
    return *this;
}

ostream& operator<<(ostream & left, VectorOfVectors2& right){
    right.wypisz(left);
    return left;
}

istream& operator>>(istream & left, VectorOfVectors2& right){
    delete[] right.vektory;
    left >> right.size;
    right.vektory = new VektorNd[right.size];
    for (int i = 0; i < right.size; i++)
        left >> right.vektory[i];
    return left;
}
