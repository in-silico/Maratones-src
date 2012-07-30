
#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <complex>
#include <map>

#define REP(i,N) for(int i=0; i<(N); i++)
#define REPB(i,N) for((i)=(N)-1; (i)>=0; (i)--)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )
#define PREC 1E-6
#define EQ(X,Y) (fabs((X)-(Y)) < PREC)
#define MAX 105
#define Vector complex<double>

using namespace std;

struct Clave {
    double radio;
    Vector centro;

    Clave() {
        radio=0;
    }

    bool operator == (Clave rhs) {
        return (EQ(radio, rhs.radio) && EQ(centro.real(),
                rhs.centro.real()) && EQ(centro.imag(), rhs.centro.imag()));
    }

    bool operator < (Clave rhs) {
        if (!EQ(this->radio,rhs.radio))
            return (this->radio < rhs.radio);
        if (!EQ(this->centro.real(), rhs.centro.real()))
            return this->centro.real() < rhs.centro.real();
        return this->centro.imag() < rhs.centro.imag();
    }
};

struct classcomp {
  bool operator() (const Clave& lhs, const Clave& rhs) const
  {
      if (!EQ(lhs.radio,rhs.radio))
            return (lhs.radio < rhs.radio);
        if (!EQ(lhs.centro.real(), rhs.centro.real()))
            return lhs.centro.real() < rhs.centro.real();
        if (!EQ(lhs.centro.imag(), rhs.centro.imag()))
        	return lhs.centro.imag() < rhs.centro.imag();
		return false;
  }
};

Vector puntos[MAX];
int N;
int descomb[MAX];
map<Clave,int,classcomp> mapa;
map<Clave,int,classcomp>::iterator it;

// Combinatorial code
char *alg_mark;
int *alg_lista;

//r most be less or equal than n, index=0
void comb(int* vector, int n, int r, int index, void (*func) (int*,int)) {
    if (r==0) {
        func(alg_lista,index);
        return;
    }
    int *nvect = vector;
    for (int i=0; i<=(n-r); i++) {
        alg_lista[index]=vector[i];
        comb(++nvect, n-i-1, r-1, index+1, func);
    }
}

void combinations(int* vector, int n, int r, void (*func) (int*,int)) {
    if ((r<0) || (r>n)) return;
    alg_lista = new int[r];
    comb(vector,n,r,0,func);
    delete [] alg_lista;
}

//end conbinatorial code

void invMat2x2(Vector *A) {
    double det;
    det = A[0].real() * A[1].imag();
    det -= A[1].real() * A[0].imag();
    Vector inv0(A[1].imag(), -A[0].imag());
    Vector inv1(-A[1].real(), A[0].real());
    A[0] = inv0 * (1/det);
    A[1] = inv1 * (1/det);
}

double dotP(Vector a, Vector b) {
    double c = (a.real()*b.real() + a.imag()*b.imag());
    return c;
}

//recibe vector de enteros con los índices de los r puntos (r=3) para hallar
//el centro de la circunferencia que pasa por todos ellos
Vector centro(int *vect, int r) {
    Vector A[2];
    A[0] = (puntos[vect[1]] - puntos[vect[0]])*2.0;
    A[1] = (puntos[vect[2]] - puntos[vect[0]])*2.0;
    invMat2x2(A);
    Vector v1 = puntos[vect[0]];
    Vector v2 = puntos[vect[1]];
    Vector v3 = puntos[vect[2]];
    Vector R(dotP(v2,v2)-dotP(v1,v1),dotP(v3,v3)-dotP(v1,v1));
    Vector ans( dotP(A[0],R), dotP(A[1],R));
    return ans;
}

bool colinear(int *vec, int r) {
    Vector a = puntos[vec[1]] - puntos[vec[0]];
    Vector b = puntos[vec[2]] - puntos[vec[0]];
    return (a.real()*b.imag() == a.imag()*b.real()); //crossProd==0???
}

void cocircular(int *vec, int r) {
    if (colinear(vec,r)) return;
    Clave clave;
    clave.centro = centro(vec, r);
    clave.radio = abs(clave.centro - puntos[*vec]);
    mapa[clave]++;
}

void init(int *vec) {
    REP(i,100) {
        vec[i]=i;
    }    
    for (int i=3; i<=100; i++) {
        descomb[i-3] = i*(i-1)*(i-2)/6; //iC3
    }
}

int find(int val, int from, int to) {
    if (to < from)
        return -1;
    int m=(from+to)/2, ans;
    if (val == descomb[m])
        return m;
    else if (val < descomb[m])
        ans = find(val, from, m-1);
    else
        ans = find(val, m+1, to);
    return ans;
}

int main() {
    int x,y;
    int vec[101];
    init(vec);
    while (true) {
        mapa.clear();
        scanf("%i", &N);
        if (N==0) break;
        REP(i,N) {
            scanf("%i %i",&x,&y);
            Vector act(x,y);
            puntos[i] = act;
        }
        //fill100(vec);
        combinations(vec,N,3,cocircular);
        int big=0;
        for (it=mapa.begin(); it!=mapa.end(); it++) {
            big = max(big, it->second);
        }
        if (big == 0)
            printf("%i\n", min(2,N));
        else
            printf("%i\n", find(big,0,97)+3);
    }
}

