/* 
 * File:   gattaca.cpp
 * Author: sebastian
 *
 * Created on 21 de febrero de 2009, 10:47 PM
 */

#include <stdlib.h>
#include <iostream>
#include <string.h>

using namespace std;


void gattaca(char *cadena) {
    int rep = 0;
    int L = strlen(cadena);
    int maxLen = 0; //Maxima longitud encontrada hasta el momento
    int start; //Donde arranca la cadena
    for (int i=0; i<L; i++) {
        for (int j=i+1; j<L; j++) {
            int k=0;
            while ((j+k)<L && cadena[i+k]==cadena[j+k]) k++;
            if (k > maxLen) {
                maxLen = k;
                start = i;
                rep = 2;
            } else if (k == maxLen) {
                // check for equality
                bool igual = true;
                for (k=0; k<maxLen; k++) {
                    if (cadena[i+k] != cadena[start+k]) {
                        igual = false;
                        if (cadena[i+k] < cadena[start+k]) {
                            // is minor lexicaly, so replace
                            start = i;
                            rep = 2;
                        }
                        break;
                    }
                }
                if (igual && start==i) {
                    rep++;
                } 
            }
        }
    }
    if (rep > 0) {
        for (int i=0; i<maxLen; i++)
            cout << cadena[start+i];
        cout << " " << rep;
    } else
        cout << "No repetitions found!";
}

/*
 * 
 */
int main2(int argc, char** argv) {
    char cad[1100];
    int t;
    cin >> t;
    for (int i=0; i<t; i++) {
        cin >> cad;
        gattaca(cad);
        cout << "\n";
    }    
    return (EXIT_SUCCESS);
}

