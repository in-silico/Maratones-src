#include <iostream>
#include <string>
#include <vector>


using namespace std;
       struct Par
       {
               string numero;
               int palos;


               Par(string n, int p)
               {
                       numero = n;
                       palos = p;
               }
       };


       string resultadosMin[101];
       string resultadosMax[101];


       vector <Par> minimos;
       vector <Par> maximos;




       string minimo(int valor)
       {
               if(resultadosMin[valor].length() > 0)
                       return resultadosMin[valor];
               if(valor <= 1)
                       return "";
               if(valor == 2)
                       return "1";
               if(valor == 3)
                       return "7";
               if(valor == 4)
                       return "4";
               if(valor == 5)
                       return "2";
               if(valor == 6)
                       return "6";
               if(valor == 7)
                       return "8";
               string mejor = "";
               for(int i = 0; i < minimos.size(); i++)
               {
                       Par p = minimos[i];
                       string posible = minimo(valor - p.palos);
                       if(posible != "")
                       {
                               posible = posible + p.numero;
                               if(mejor == "" || posible.size() < mejor.size() || ((posible.size() == mejor.size()) && posible.compare(mejor) < 0))
                               {
                                       mejor = posible;
                               }
                       }
               }
               resultadosMin[valor] = mejor;
               return resultadosMin[valor];
       }


       string maximo(int valor)
       {
               if(resultadosMax[valor] != "")
                       return resultadosMax[valor];
               if(valor <= 1)
                       return "";
               if(valor == 2)
                       return "1";
               if(valor == 3)
                       return "7";
               if(valor == 4)
                       return "11";
               if(valor == 5)
                       return "71";
               if(valor == 6)
                       return "111";
               if(valor == 7)
                       return "711";
               string mejor = "";
               for(int i = 0; i < maximos.size(); i++)
               {
                       Par p = maximos[i];
                       string posible = maximo(valor - p.palos);
                       if(posible != "")
                       {
                               posible = posible + p.numero;
                               if(mejor == "" || posible.size() > mejor.size() || ((posible.size() == mejor.size()) && posible.compare(mejor) > 0))
                               {
                                       mejor = posible;
                               }
                       }
               }

               resultadosMax[valor] = mejor;
               return resultadosMax[valor];
       }




       int main()
       {
               minimos.push_back(Par("8", 7));
               minimos.push_back(Par("0", 6));
               minimos.push_back(Par("2", 5));
               minimos.push_back(Par("4", 4));
               minimos.push_back(Par("7", 3));
               minimos.push_back(Par("1", 2));
               maximos.push_back(Par("1", 2));
               maximos.push_back(Par("7", 3));
               maximos.push_back(Par("4", 4));
               maximos.push_back(Par("5", 5));
               maximos.push_back(Par("9", 6));
               maximos.push_back(Par("8", 7));
               int n;
               cin >> n;
               for(int i = 0; i < n; i++)
               {
                       int este;
                       cin >> este;
                       cout << minimo(este) << " " << maximo(este) << endl;
               }
       }
