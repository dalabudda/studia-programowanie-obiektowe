#include <iostream>
#include <time.h>
#include <stdlib.h>
#include <fstream>
#include <string>
#include "Swiat.h"
#include "Wyjatek.h"

using namespace std;

int main()
{
    cout << "+++++++++++++++++++++++++++" << endl;
    cout << "Autor: Dawid Labudda 175716" << endl;
    cout << "+++++++++++++++++++++++++++" << endl << endl;

    srand(time(NULL));

    Swiat swiat;

    bool running = true;
    while (running)
    {
        cout << "=======================================================" << endl;
        cout << "Tura: " << swiat.getTura() << endl;
        cout << "-------------------------------------------------------" << endl;
        swiat.rysujSwiat();
        cout << "z - zapisz swiat" << endl;
        cout << "w - wczytaj swiat" << endl;
        cout << "inny znak - nastepna tura" << endl;
        string wybor;
        cin >> wybor;
        if (wybor == "z")
        {
            try
            {
                swiat.zapiszSwiat();
                cout << "Zapisano pomyslnie." << endl;
            }
            catch(Wyjatek &w)
            {
                cout << "Nie mozna zapisac:" << endl;
                w.wypisz();
            }
        }
        else if (wybor == "w")
        {
            try
            {
                swiat.wczytajSwiat();
                cout << "Wczytano pomyslnie." << endl;
            }
            catch(Wyjatek &w)
            {
                cout << "Nie mozna wczytac:" << endl;
                w.wypisz();
            }
        }
        else
        {
            swiat.wykonajTure();
        }
    }

    return 0;
}
