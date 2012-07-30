#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cstring>

using namespace std;

long long int lpow(int b,int exp){
  long long int ans=1;
  for(int i=1;i<=exp;i++){
    ans*=b;
  }
  return ans;
}

long long int calc_inv(long long int b,long long int n,long long int p){
  long long int tmp=b;
  long long int ans=1;
  while(n){
    if(n&1){
      ans=(ans*tmp)%p;
    }
    tmp=(tmp*tmp)%p;
    n>>=1;
  }
  return ans;
}


int solve_for_p(long long int number,int p){
  int ans=number%p;
  for(int i=0;i<p;i++)
    if(((i*i*i)%p)==ans)
      return i;
}

long long int solve_derivada(long long int r,int alpha,long long int number,int p){
  /* 3r^2*t = (number-r^3)/p^alpha (mod p) */
  long long int right;
  right=number-r*r*r;
  right/=lpow(p,alpha-1);
  right%=p;
  if(right<0) right+=p;
  for(int t=0;t<p;t++){
    long long int left=(3*r*r*t)%p;
    if(left==right)
      return t;
  }
}

long long int solve_a(int p, int n,long long int number){
  long long int r=solve_for_p(number,p);
  for(int alpha=2;alpha<=n;alpha++){
    r=r+lpow(p,alpha-1)*solve_derivada(r,alpha,number,p);
  }
  return r;
}
int calc_a(long long int a[2],int n, long long int number){
  a[0]=solve_a(2,n,number);
  a[1]=solve_a(5,n,number);
}


int solve(int n,long long int number){
  long long int a[2],M[2],b[2],base;
  base=lpow(10,n);
  calc_a(a,n,number);

  M[0]=pow(5,n);
  M[1]=pow(2,n);

  b[0]=calc_inv(pow(5,n),pow(2,n)-pow(2,n-1)-1,pow(2,n));
  b[1]=calc_inv(pow(2,n),pow(5,n)-pow(5,n-1)-1,pow(5,n));

  long long int ans,ans2;
  ans=(a[0]*M[0])%base;
  ans=(ans*b[0])%base;
  ans2=(a[1]*M[1])%base;
  ans2=(ans2*b[1])%base;
  printf("%lld\n",(ans+ans2)%base);
}


int main(){
  int c;
  char number[15];

  scanf("%d",&c);
  while(c--){
    scanf("%s",number);
    solve(strlen(number),atoll(number));
  }
  return 0;
}

