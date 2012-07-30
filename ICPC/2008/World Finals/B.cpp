#include <complex>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

#include <complex>
#include <cmath>

#define PREC 0.1
#define ERR 0.1

const int maxlength = 100;

class bigint
{
public:
	int oper,length,a[maxlength];
	bigint(int=0);
	~bigint();
	int max(int a,int b);
	void check();
	void operator=(bigint m);
	void operator=(int m);
	void operator=(char *s);
	bool operator<(bigint m);
	bool operator<=(bigint m);
	bool operator>(bigint m);
	bool operator>=(bigint m);
	bool operator==(bigint m);
	bool operator!=(bigint m);
	bigint operator-();
	bigint operator+(bigint m);
	void operator+=(bigint m);
	bigint operator-(bigint m);
	void operator-=(bigint m);
	bigint operator*(bigint m);
	bigint operator*(int m);
	void operator*=(bigint m);
	void operator*=(int m);
	bigint operator/(bigint m);
	bigint operator/(int m);
	void operator/=(bigint m);
	void operator/=(int m);
	bigint operator%(bigint m);
	bigint operator%(int m);
	void operator%=(bigint m);
	void operator%=(int m);
};
bigint abs(bigint m);
bool read(bigint &m);
void write(bigint m);
void swrite(char *s,bigint m);
void writeln(bigint m);
bigint sqr(bigint m);
bigint sqrt(bigint m);
bigint gcd(bigint a,bigint b);
bigint lcm(bigint a,bigint b);

int bigint::max(int a,int b)
{
	return (a>b)?a:b;
}
bigint::bigint(int v)
{
	(*this)=v;
	this->check();
}
bigint::~bigint()
{
}
void bigint::check()
{
	for (;length>0 && a[length]==0;length--);
	if (length==0)
		oper=1;
}
void bigint::operator=(bigint m)
{
	oper=m.oper;
	length=m.length;
	memcpy(a,m.a,maxlength*sizeof(int));
	this->check();
}
void bigint::operator=(int m)
{
	oper=(m>0)?1:-1;
	m=abs(m);
	memset(a,0,maxlength*sizeof(int));
	for (length=0;m>0;m=m/10000)
		a[++length]=m%10000;
	this->check();
}
void bigint::operator=(char *s)
{
	int i,L;
	(*this)=0;
	if (s[0]=='-' || s[0]=='+')
	{
		if (s[0]=='-')
			oper=-1;
		L=strlen(s);
		for (i=0;i<L;i++)
			s[i]=s[i+1];
	}
	L=strlen(s);
	length=(L+3)/4;
	for (i=0;i<L;i++)
		a[(L-i+3)/4]=a[(L-i+3)/4]*10+(s[i]-48);
	this->check();
}
bool bigint::operator<(bigint m)
{
	if (oper!=m.oper)
		return oper<m.oper;
	if (length!=m.length)
		return oper*length<m.length*oper;
	for (int i=length;i>=1;i--)
		if (a[i]!=m.a[i])
			return a[i]*oper<m.a[i]*oper;
	return false;
}
bool bigint::operator<=(bigint m)
{
	return !(m<(*this));
}
bool bigint::operator>(bigint m)
{
	return m<(*this);
}
bool bigint::operator>=(bigint m)
{
	return !((*this)<m);
}
bool bigint::operator==(bigint m)
{
	return (!((*this)<m)) && (!(m<(*this)));
}
bool bigint::operator!=(bigint m)
{
	return ((*this)<m) || (m<(*this));
}
bigint bigint::operator-()
{
	bigint c=(*this);
	c.oper=-c.oper;
	c.check();
	return c;
}
bigint abs(bigint m)
{
	bigint c=m;
	c.oper=abs(c.oper);
	c.check();
	return c;
}
bigint bigint::operator+(bigint m)
{
	if (m.length==0)
		return (*this);
	if (length==0)
		return m;
	if (oper==m.oper)
	{
		bigint c;
		c.oper=oper;
		c.length=max(length,m.length)+1;
		for (int i=1,temp=0;i<=c.length;i++)
			c.a[i]=(temp=(temp/10000+a[i]+m.a[i]))%10000;
		c.check();
		return c;
	}
	return (*this)-(-m);
}
bigint bigint::operator-(bigint m)
{
	if (m.length==0)
		return (*this);
	if (length==0)
		return (-m);
	if (oper==m.oper)
	{
		bigint c;
		if (abs(*this)>=abs(m))
		{
			c.oper=oper;
			c.length=length;
			for (int i=1,temp=0;i<=length;i++)
				c.a[i]=((temp=(-int(temp<0)+a[i]-m.a[i]))+10000)%10000;
			c.check();
			return c;
		}
		return -(m-(*this));
	}
	return (*this)+(-m);
}

void swrite(char *s,bigint m)
{
	int L=0;
	if (m.oper==-1)
		s[L++]='-';
	sprintf(s+L,"%d",m.a[m.length]);
	for (;s[L]!=0;L++);
	for (int i=m.length-1;i>=1;i--)
	{
		sprintf(s+L,"%04d",m.a[i]);
		L+=4;
	}
	s[L]=0;
}
void write(bigint m)
{
	if (m.oper==-1)
		printf("-");
	printf("%d",m.a[m.length]);
	for (int i=m.length-1;i>=1;i--)
		printf("%04d",m.a[i]);
}
void writeln(bigint m)
{
	write(m);
	printf("\n");
}
bigint bigint::operator*(bigint m)
{
	bigint c;
	c.oper=oper*m.oper;
	c.length=length+m.length;
	for (int i=1;i<=m.length;i++)
	{
		int number=m.a[i],j,temp=0;
		for (j=1;j<=length;j++)
			c.a[i+j-1]+=number*a[j];
		if (i%10==0 || i==m.length)
			for (j=1;j<=c.length;j++)
				c.a[j]=(temp=(temp/10000)+c.a[j])%10000;
	}
	c.check();
	return c;
}
bigint bigint::operator*(int m)
{
	if (m<0)
		return -((*this)*(-m));
	return (*this)*bigint(m);
}
bigint bigint::operator/(bigint m)
{
	if (m.length==0)
	{
		printf("Division by zero.\n");
		exit(0);
	}
	if (abs(*this)<abs(m))
		return 0;
	bigint c,left;
	c.oper=oper/m.oper;
	m.oper=1;
	c.length=length-m.length+1;
	left.length=m.length-1;
	memcpy(left.a+1,a+length-left.length+1,left.length*sizeof(int));
	for (int i=c.length;i>=1;i--)
	{
		left=left*10000+a[i];
		int head=0,tail=10000,mid;
		while (head+1<tail)
		{
			mid=(head+tail)/2;
			if (m*mid<=left)
				head=mid;
			else
				tail=mid;
		}
		c.a[i]=head;
		left-=m*head;
	}
	c.check();
	return c;
}
bigint bigint::operator/(int m)
{
	if (m<0)
		return -((*this)/(-m));
	return (*this)/bigint(m);
}
bigint bigint::operator %(bigint m)
{
	return (*this)-((*this)/m)*m;
}
bigint bigint::operator%(int m)
{
	if (m<0)
		return -((*this)%(-m));
	return (*this)%bigint(m);
}
bigint sqr(bigint m)
{
	return m*m;
}
bigint sqrt(bigint m)
{
	if (m.oper<0 || m.length==0)
		return 0;
	bigint c,last,now,templast;
	c.length=(m.length+1)/2;
	c.a[c.length]=int(sqrt((double)m.a[c.length*2]*10000+m.a[c.length*2-1])+1e-6);
	templast.length=c.length*2;
	templast.a[c.length*2-1]=(c.a[c.length]*c.a[c.length])%10000;
	templast.a[c.length*2]=(c.a[c.length]*c.a[c.length])/10000;
	templast.check();
	for (int i=c.length-1;i>=1;i--)
	{
		last=templast;
		int head=0,tail=10000,mid,j,temp;
		while (head+1<tail)
		{
			mid=(head+tail)/2;
			now=last;
			now.a[2*i-1]+=mid*mid;
			for (j=i+1;j<=c.length;j++)
				now.a[i+j-1]+=mid*c.a[j]*2;
			now.length++;
			for (j=2*i-1,temp=0;j<=now.length;j++)
				now.a[j]=(temp=(temp/10000+now.a[j]))%10000;
			now.check();
			if (now<=m)
			{
				templast=now;
				head=mid;
			}
			else
				tail=mid;
		}
		c.a[i]=head;
	}
	c.check();
	return c;
}
bigint gcd(bigint a,bigint b)
{
	return (b==0)?a:gcd(b,a%b);
}
bigint lcm(bigint a,bigint b)
{
	return a*b/gcd(a,b);
}
void bigint::operator+=(bigint m)
{
	(*this)=(*this)+m;
}
void bigint::operator-=(bigint m)
{
	(*this)=(*this)-m;
}
void bigint::operator*=(bigint m)
{
	(*this)=(*this)*m;
}
void bigint::operator/=(bigint m)
{
	(*this)=(*this)/m;
}
void bigint::operator%=(bigint m)
{
	(*this)=(*this)%m;
}
void bigint::operator*=(int m)
{
	(*this)=(*this)*m;
}
void bigint::operator/=(int m)
{
	(*this)=(*this)/m;
}
void bigint::operator%=(int m)
{
	(*this)=(*this)%m;
}



using namespace std;

class Polynom {
public:
    int grado, max;
    bigint *coef;

    Polynom();
    Polynom(int grado, int max);
    ~Polynom();

    Polynom* operator+= (Polynom *b);
    Polynom* operator-= (Polynom *b);
    Polynom* operator*= (Polynom *b);
    Polynom* operator/= (Polynom *b);
    Polynom* operator%= (Polynom *b);

    bigint eval(bigint x);
    void derivate();
    void clear();
    void print();
    void simplify();
    void div(Polynom *b, Polynom *cos, Polynom *residuo);
    void copyFrom(Polynom *p);
    void remMultRoot();
    void laguerre(complex<double>* roots);

    bool isZero();
};

void mcd(Polynom *a, Polynom *b, Polynom *res);


Polynom::Polynom() {
    int max = 101;
    int grado = 0;
    if (max != 0)   this->coef = new bigint[max];
    this->max=max;
    clear();
    this->grado=grado;
}
Polynom::Polynom(int grado, int max) {
    if (max != 0)   this->coef = new bigint[max];
    this->max=max;
    clear();
    this->grado=grado;
}

Polynom::~Polynom() {
    delete [] coef;
}

Polynom* Polynom::operator +=(Polynom* b) {
    int i = (b->grado > grado) ? b->grado : grado;
    this->grado=i;
    for (; i>=0; i--) {
        coef[i] += b->coef[i];
    }
    simplify();
    return this;
}

Polynom* Polynom::operator -=(Polynom* b) {
    int i = (b->grado > grado) ? b->grado : grado;
    this->grado=i;
    for (; i>=0; i--) {
        coef[i] -= b->coef[i];
    }
    simplify();
    return this;
}

Polynom* Polynom::operator *=(Polynom* b) {
    bigint nc[max];
    for (int i=0; i<max; i++) nc[i]=0;
    for (int i=0; i<=grado; i++) {
        for (int j=0; j<=b->grado; j++) {
            nc[i+j] += coef[i]*b->coef[j];
        }
    }
    for (int i=0; i<max; i++) coef[i]=nc[i];
    grado+=b->grado;
    simplify();
    return this;
}

Polynom* Polynom::operator /=(Polynom* b) {
    this->div(b, this, NULL);
    return this;
}

Polynom* Polynom::operator %=(Polynom* b) {
    Polynom* cos = new Polynom(0,max);
    Polynom* res = new Polynom(0,max);
    div(b,cos,res);
    this->copyFrom(res);
    delete cos; delete res;
    return this;
}

bigint Polynom::eval(bigint x) {
    bigint fx = 0;
    for (int i=grado; i>=0; i--) {
        fx *= x;
        fx += coef[i];
    }
    return fx;
}

void Polynom::derivate() {
    for (int i=1; i<=grado; i++) {
        coef[i-1] = coef[i]*i;
    }
    grado--;
}

void Polynom::clear() {
    for (int i=0; i<max; i++) {
        coef[i]=0;
    }
    this->grado=0;
}

void Polynom::print() {
/*    for (int i=0; i<=grado; i++) {
        if(coef[i] != 0)
            printf("%in^%i ",(int)coef[i],i);
    }
    printf("\n");*/
}

void Polynom::simplify() {
    while (grado>0 && coef[grado] == 0) grado--;
}

void Polynom::copyFrom(Polynom* p) {
    this->grado = p->grado;
    for (int i=grado; i>=0; i--) {
        this->coef[i] = p->coef[i];
    }
}

void Polynom::remMultRoot() {
    Polynom *a = this;
    while(true)
    {
        Polynom b(0,max);
        Polynom gcd(0,max);
        b.copyFrom(this);
        b.derivate();
        mcd(a,&b,&gcd);
        if (gcd.grado>0) *a /= &gcd;
        else break;
    }
}

//It doesn't change b or this. Just changes cos and return residuo if not null
void Polynom::div(Polynom* b, Polynom* cos, Polynom* residuo) {
    if (cos != this) cos->copyFrom(this);
    bigint *res = cos->coef;
    int n=grado, m=b->grado, ng=n-m;
    cos->coef = new bigint[max];
    clear();
    while (n>=m) {
        bigint val = res[n]/b->coef[m];
        cos->coef[n-m] = val;
        for (int i=m, j=n; i>=0; i--) {
            res[j--] -= val*b->coef[i];
        }
        n--;
    }
    cos->grado = ng;
    cos->simplify();
    if (residuo == NULL) delete [] res;
    else {
        delete [] residuo->coef;
        residuo->coef = res;
        residuo->max = cos->max;
        residuo->grado = b->grado;
        residuo->simplify();
    }
}

bool Polynom::isZero() {
    return ( this->grado==0 && *(this->coef)==0 );
}

void mcd(Polynom* na, Polynom* nb, Polynom *res) {
    Polynom a(0,20); Polynom b(0,20);
    a.copyFrom(na); b.copyFrom(nb);
    Polynom *t = new Polynom(0,a.max);
    Polynom *residuo = new Polynom(0,a.max);
    while (! b.isZero() ) {
        a.div(&b,t,residuo);
        a.copyFrom(&b);
        b.copyFrom(residuo);
        t->clear();
    }
    delete t; delete residuo;
    res->copyFrom(&a);
}


Polynom nMasUno[101];
int D;


bool iterar(Polynom *anterior) {
    bigint primero = 0;
    bigint resp = anterior->eval(primero);
    if((resp % D) != 0) {
        return false;
    }
    if(anterior->grado == 0) {
        return true;
    }
    Polynom *siguiente = new Polynom(0, 101);
    siguiente->clear();
    for(int i = 1; i <= anterior->grado; i++) {
        if(anterior->coef[i] != 0) {
            Polynom nuevo(0, 101);
            Polynom temp(0, 101);
            temp.coef[0] = anterior->coef[i];
            nuevo.copyFrom(&nMasUno[i]);
            nuevo *= &temp;
            (*siguiente) += &nuevo;
        }
    }
    siguiente->coef[0] += anterior->coef[0];
    (*siguiente) -= anterior;
    siguiente->simplify();
    bool respuesta = iterar(siguiente);
    delete siguiente;
    return respuesta;
}


Polynom *leer() {
    char entrada[10000];
    int actual = 0;
    fgets(entrada, 10000, stdin);
    if(entrada[0] == '.')
        return NULL;
    actual = 1;
    Polynom *nuevo = new Polynom(101, 105);
    while(true) {
        if(entrada[actual] == ')')
            break;
        int a;
        if(entrada[actual] == 'n') {
            a = 1;
        }
        else if((entrada[actual] == '-' || entrada[actual] == '+') && entrada[actual + 1] == 'n') {
            a = entrada[actual] == '-' ? -1 : 1;
            actual++;
        }
        else {
            sscanf(entrada + actual, "%d", &a);
            for(int i = actual; i < 10000; i++) {
                if((entrada[i] > '9' || entrada[i] < '0') && entrada[i] != '+' && entrada[i] != '-')
                {
                    actual = i;
                    break;
                }
            }
        }
        if(entrada[actual] == 'n')
            actual++;
        else {
            nuevo->coef[0] += a;
            break;
        }
        int exp;
        if(entrada[actual] == '^')
        {
            actual++;
            sscanf(entrada + actual, "%d", &exp);
            for(int i = actual; i < 10000; i++) {
                if(entrada[i] > '9' || entrada[i] < '0')
                {
                    actual = i;
                    break;
                }
            }
        }
        else {
            exp = 1;
        }
        nuevo->coef[exp] += a;
    }
    nuevo->simplify();
    actual += 2;
    sscanf(entrada + actual, "%d", &D);
    return nuevo;
}

int main() {
    nMasUno[1].clear();
    nMasUno[1].grado = 1;
    nMasUno[1].coef[0] = 1;
    nMasUno[1].coef[1] = 1;
    for(int i = 2; i < 101; i++) {
        nMasUno[i].copyFrom(&nMasUno[i - 1]);
        nMasUno[i] *= &nMasUno[1];
    }
    int caso = 1;
    while(true) {
        Polynom *actual = leer();
        bool es = true;
        if(actual == NULL)
            break;
        for(int i = 0; i < 200; i++)
        {
            if((actual->eval(i) % D) != 0)
                es = false;
        }
        if(es) {
            printf("Case %d: Always an integer\n", caso++);
        }
        else {
            printf("Case %d: Not always an integer\n", caso++);
        }
        delete actual;
    }
}