#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <complex>

using namespace std;

#define EPSILON 1E-10
#define PREC 1E-6
#define Point complex<double>

class Matrix {
    double *data;
    int rows, cols;
public:
    Matrix(int rows, int cols) {
        this->rows=rows; this->cols=cols;
        data = new double[rows*cols];
    }

    ~Matrix() {
        delete [] data;
    }

    double getRows() { return rows; }
    double getCols() { return cols; }

    double &operator()(int i, int j) {
        if (i<rows && j<cols)
            return data[i*cols + j];
        else
            throw "Out of bounds index exception";
    }

    void operator=(Matrix &a) {
        if (a.getCols()==cols && a.getRows()==rows) {
            for (int i=0; i<rows; i++)
                for (int j=0; j<cols; j++)
                    (*this)(i,j)=a(i,j);
        } else {
            throw "Wrong matrix dimesion for copying";
        }
    }

    void swapRow(int row1, int row2) {
        for (int j=0; j<cols; j++) {
            double tmp = (*this)(row1,j);
            (*this)(row1,j) = (*this)(row2,j);
            (*this)(row2,j) = tmp;
        }
    }

    void multRow(int row, double coeff) {
        for (int j=0; j<cols; j++) {
            (*this)(row,j) *= coeff;
        }
    }

    void addRows(int destRow, int srcRow, double factor=1.0) {
        for (int j=0; j<cols; j++) {
            (*this)(destRow,j) += (*this)(srcRow,j)*factor;
        }
    }

    void printMat() {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                printf("%lf\t", (*this)(i,j));
            }
            printf("\n");
        }
    }

};

bool invMatrix(Matrix &ans, Matrix &m) {
    int rows=m.getRows(), cols=m.getCols();
    
    //Take a extended copy of the matrix
    Matrix tmp(rows, 2*cols);
    for (int i=0; i<rows; i++) {
        for (int j=0; j<2*cols; j++) {
            if (j<cols)
                tmp(i,j) = m(i,j);
            else {
                tmp(i,j) = ( (j-cols)==i ) ? 1 : 0;
            }
        }
    }
    //tmp.printMat();
    
    //Invert the extended matrix
    for (int i=0; i<rows; i++) {
        int maxrow=i; double maxval=tmp(i,i);
        for (int k=i+1; k<rows; k++) {
            if (fabs(maxval) < fabs(tmp(k,i))) {
                maxval=tmp(k,i);
                maxrow=k;
            }
        }
        if (fabs(maxval)<EPSILON)
            return false;
        tmp.swapRow(maxrow,i);
        //tmp.printMat();
        tmp.multRow(i,1.0/maxval);
        //tmp.printMat();
        for (int k=0; k<rows; k++) {
            if (k != i) {
                //tmp.multRow(k, -1.0/tmp(k,i));
                tmp.addRows(k,i,-tmp(k,i));
            }
        }
        //tmp.printMat();
    }

    //copy the solution to answer
    for (int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++) {
            ans(i,j) = tmp(i,j+cols);
        }
    }
    return true;
}

void subMatrix(Matrix &ans, Matrix &a, Matrix &b) {
    for (int i=0; i<ans.getRows(); i++)
        for (int j=0; j<ans.getCols(); j++)
            ans(i,j) = a(i,j) - b(i,j);
}

void multMatrix(Matrix &ans, Matrix &a, Matrix &b) {
    if (a.getCols() != b.getRows())
        throw "Error: Wrong dimensions for matrix multiplication";
    int rows = a.getRows(), cols=b.getCols(), kmax=a.getCols();
    Matrix tmp(rows, cols);
    for (int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++) {
            double sum=0;
            for (int k=0; k<kmax; k++) {
                sum += a(i,k)*b(k,j);
            }
            tmp(i,j)=sum;
        }
    }
    ans=tmp;
}

Point P[3], L[3];
double D[3], A[3];

double dotProd(Point a, Point b) {
    return (a.real()*b.real() + a.imag()*b.imag());
}

void jacobian(Matrix &J, Matrix &R) {
    for (int i=0; i<3; i++) {
        double dist = abs(P[(i+1)%3] - P[i]);
        double tmp1 = R(i,0)/tan(A[i]) + R((i+1)%3,0)/tan(A[(i+1)%3]) - dist;
        J(i,i) = 4*R((i+1)%3,0) - (2/tan(A[i]))*tmp1;
        J(i,(i+1)%3) = 4*R(i,0) - (2/tan(A[(i+1)%3]))*tmp1;
        J(i,(i+2)%3) = 0;
    }
}

void function(Matrix &F, Matrix &R) {
    for (int i=0; i<3; i++) {
        double c1 = 4*R(i,0)*R((i+1)%3,0);
        double c2 = R(i,0)/tan(A[i]);
        double c3 = (R((i+1)%3, 0) / tan(A[(i+1)%3]));
        double c4 = abs(P[i]-P[(i+1)%3]);
        F(i,0) = c1-((c2+c3-c4)*(c2+c3-c4));
    }
}

void newton(Matrix &R) {
    Matrix E(3,1), F(3,1), J(3,3);
    double error;
    do {
        //R.printMat();
        jacobian(J,R);
        //J.printMat();
        function(F,R);
        //F.printMat();
        if (!invMatrix(J,J)) {
            printf("Matriz no invertible\n");
        }
        //J.printMat();
        multMatrix(E,J,F);
        //E.printMat();
        subMatrix(R,R,E);
        error = fabs(F(0,0))+fabs(F(1,0))+fabs(F(2,0));
    } while (fabs(error) > PREC);
}

int main() {
    int tmp[6];
    while(true) {
        bool lastCase=true;
        for (int i=0; i<6; i+=2) {
            scanf("%i %i",&tmp[i],&tmp[i+1]);
            P[i/2]=Point(tmp[i],tmp[i+1]);
            lastCase = lastCase && (tmp[i]==0 && tmp[i+1]==0);
        }
        if (lastCase) break;
        for (int i=0; i<3; i++) 
            L[i] = (P[(i+1)%3] - P[i]);
        for (int i=0; i<3; i++) {
            double num = dotProd(L[(i+2)%3], L[i]);
            double den = abs(L[i])*abs(L[(i+2)%3]);
            A[i] = 0.5*acos(-num/den);
            D[i] = abs(L[i]);
        }
        Matrix R(3,1);
        R(0,0)=0.1;R(1,0)=0.1;R(2,0)=0.1;
        newton(R);
        printf("%.5lf %.5lf %.5lf\n", R(0,0), R(1,0), R(2,0));
    }
}
