/* 
 * File:   jolly.cpp
 * Author: sebastian
 *
 * Created on 2 de marzo de 2009, 09:52 PM
 */

#include <stdlib.h>
#include <iostream>

using namespace std;

int abs(int x) {
    return (x >= 0) ? x : -1*x;
}

//check if val exist in a of size n
bool existe(int *a, int n, int val) {
    for (int i=0; i<n; i++)
        if (a[i] == val) return true;
    return false;
}

// Recibes a secuence of n numbers in a and returns if is jolly
bool isJolly(int *a, int n) {
    if (n<2)
        return true;
    int dif[n-1]; //hold the absolute value of the diference
    for (int i=0; i<n-1; i++) {
        int tmp = abs(a[i] - a[i+1]); 
        if (tmp >= n || existe(dif,i,tmp) || tmp==0)
            return false;
        dif[i] = tmp;
    }
    return true;
}

/*
 * 
 */
int main5(int argc, char** argv) {
    int n;
    while (cin >> n) {
        int a[n];
        for (int i=0; i<n; i++)
            cin >> a[i];
        if (isJolly(a,n))
            cout << "Jolly\n";
        else
            cout << "Not jolly\n";
    }
    return (EXIT_SUCCESS);
}

