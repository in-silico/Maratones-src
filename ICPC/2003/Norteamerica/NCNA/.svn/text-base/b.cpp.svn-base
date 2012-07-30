#include <iostream>
#include <sstream>
#include <list>
#include <map>

using namespace std;

bool is_palindrome(string s){
  int len=s.size();
  for(int i=0;i<len/2;i++)
    if(s[i]!=s[len-i-1])
      return false;
  return true;
}

int f(string line,int ncase){
  int cost,length;
  list <pair<int,string> > L;
  pair<int,string> l;
  map<string,bool > M;

  L.insert(L.end(),make_pair(0,line));
  M[line] = true;
  
  while(true){
    l = L.front();
    L.pop_front();
    int n = l.first;
    string s = l.second;
    if(is_palindrome(s)){
      cost = n;
      length = s.size();
      break;
    }else{
      string s2;
      s2 = s.substr(0,s.size()-1);
      if(M[s2] == false){
	L.insert(L.end(),make_pair(n+1,s2));
	M[s2] = true;
      }
      s2 = s.substr(1,s.size());
      if(M[s2] == false){
	L.insert(L.end(),make_pair(n+1,s2));
	M[s2] = true;
      }

      for(int i=0;i<10;i++){
	stringstream ss;
	ss << i;
	string f;
	ss >> f;
	if(s.find(f) != string::npos){
	  s2 = s+f;
	  if(M[s2] == false){
	    L.insert(L.end(),make_pair(n+1,s2));
	    M[s2] = true;
	  }
	  s2 = f+s;
	  if(M[s2] == false){
	    L.insert(L.end(),make_pair(n+1,s2));
	    M[s2] = true;
	  }
	}
      }
    }
  }

  while(!L.empty()){
    l = L.front();
    L.pop_front();
    if(cost < l.first) break;
    if((length < l.second.size()) && is_palindrome(l.second)){
      length = l.second.size();
    }
  }

  cout << "Case " << ncase << ", sequence = " << line << ", cost = " << cost << ", length = " << length << endl;
  return 0;
}

int main(){
  int ncase=1;
  string line;
  while(cin >> line){
    f(line,ncase++);
  }
  return 0;
}
