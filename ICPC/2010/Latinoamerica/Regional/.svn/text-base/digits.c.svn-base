#include <stdio.h>
#include <string.h>

#define count(n, c)					\
  last = 0;							\
  if ((n)){							\
	last += (n) % 10;				\
									\
	for(j=((n) % 10) ; j> 0; j--)	\
	  (c)[j] += 1;					\
									\
	(n) /= 10;						\
	if ((n)){						\
	  (c)[0] = 1;					\
	}								\
	for(j = 1; j < 10; j++)			\
	  (c)[j] += (n);				\
  }									\
  for(i=1; (n) > 0; i++){			\
	if (i){							\
	  (c)[0] += (n-1)*d[i-1];		\
	}								\
									\
	(c)[(n)%10] += last+1;			\
	last += d[i]*((n) % 10);		\
	if((n)%10 && (n/10))			\
	  (c)[0] += d[i];				\
									\
	for(j=((n) % 10)-1 ; j> 0; j--)	\
	  (c)[j] += d[i];				\
									\
	(n) /= 10;						\
									\
	for(j = 1; j < 10; j++)			\
	  (c)[j] += (n)*d[i];			\
  }									\



int main(){
  unsigned long int a, b;
  int i, j, last, ca[10], cb[10], d[10];

  d[0] = 1;
  for(i=1; i < 10; i++)
    d[i] = d[i-1]*10;

  while(scanf("%ld %ld", &a, &b) && a && b){
    memset(ca, 0, 10*sizeof(int));
    memset(cb, 0, 10*sizeof(int));

    a--;
    count(a, ca);
    count(b, cb);

    for(i=0; i< 10; i++)
      printf("%d%c", cb[i] - ca[i], i == 9 ? '\n' : ' ');
  }

  return 0;
}
