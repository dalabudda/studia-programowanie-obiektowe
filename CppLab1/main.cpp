#include "Wartosc_Liczbowa.h"
#include "Liczba.h"
#include "Complex.h"
#include <iostream>

using namespace std;

int main()
{
    cout << "#1\n\n";

    Liczba liczba1(7);
    Liczba *liczba2 = new Liczba(5);
    Liczba *liczba3 = liczba2;
    liczba3->wypisz(cout);
    *liczba2 = liczba1 + *liczba2;
    cout << *liczba3;

    cout << "\n#2\n\n";

    Complex zespolona1(3,4);
    zespolona1.wypisz(cout);
    Complex *zespolona2 = new Complex(5,7);
    Complex zespolona3 = zespolona1 + *zespolona2;
    cout << zespolona3;

    cout << "\n#3\n\n";

    Wartosc_Liczbowa* liczby[5];
    liczby[0] = &liczba1;
    liczby[1] = liczba2;
    liczby[2] = &zespolona1;
    liczby[3] = zespolona2;
    liczby[4] = new Complex();

    cout << "\n#4\n\n";

    for (int i = 0; i < 5; i++)
    {
        cout << i << ".\t";
        liczby[i]->wypisz(cout);
        cout << "\tModul: " << liczby[i]->modul() << endl;
    }

    cout << "\n#5\n\n";

    delete liczba2;
    delete zespolona2;
    delete liczby[4];

    cout << "\n#6\n\n";

    liczba1.overriding();
    zespolona1.overriding();

    cout << "\n#7\n\n";

    zespolona1.overloading();
    zespolona1.overloading(7);

    cout << endl;

    return 0;
}
