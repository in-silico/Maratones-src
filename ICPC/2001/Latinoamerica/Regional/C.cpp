#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <sstream>
#include <algorithm>
#include <vector>
#include <iterator>

using namespace std;

void itoa(int n, string &number, int base){
  while(n){
    stringstream s;
    int i= n%base;
    if(i < 10){
      s << i;
    }else{
      switch(i){
      case 10: s << 'a'; break;
      case 11: s << 'b'; break;
      case 12: s << 'c'; break;
      case 13: s << 'd'; break;
      case 14: s << 'e'; break;
      case 15: s << 'f'; break;
      }
    }
    number += s.str();
    n /= base;
  }
}

bool pali(string number){
  string rev(number);
  reverse(rev.begin(),rev.end());
  return !number.compare(rev);
}

int main(){
  int n;
  string line, number;
  vector<int> ans(20);
  vector<int> ::iterator it;

  while(true){
    getline(cin,line);
    n = atoi(line.c_str());
    if(!n) break;
    ans.clear();

    for(int base=2;base<=16;base++){
      number.clear();
      itoa(n,number,base);
      if(pali(number)) ans.insert(ans.end(), base);
    }
    if(ans.size()){
      cout << "Number "<< n << " is palindrom in basis";
      for(it=ans.begin();it!=ans.end();it++) cout<<" "<<*it;
      cout << endl;
    }else
      cout << "Number " << n << " is not palindrom" << endl;
  }
  return 0;
}
