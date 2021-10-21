#include <iostream>
#include "VektorNd.h"
#include "VoV1.h"
#include "VoV2.h"

using namespace std;


int main(){

    cout << "#1\n\n";
    {
        const double liczby[] = {1,2,3,4,5};
        VektorNd vektab1[5];
        for (int i = 0; i < 5; i++)
            vektab1[i].setCoefs(liczby, 5);
        VectorOfVectors1 vov1(vektab1, 5);
        cout << vov1;
        VectorOfVectors1 vov11(0, 0);
        cout << vov11;
        cin >> vov11;
        cout << vov11;
        vov1 = vov11;
    }

    cout << "\n#3\n\n";

    const double liczby2[] = {6,7,8,9,0};
    VektorNd vektab2[5];
    for (int i = 0; i < 5; i++)
        vektab2[i].setCoefs(liczby2, 5);
    VectorOfVectors2 vov2(vektab2, 5);
    cout << vov2;

    cout << "\n#4\n\n";

    VectorOfVectors2 vov22;
    cin >> vov22;
    cout << vov22;

    cout << "\n#5\n\n";

    vov2 = vov22;

    return 0;
}
