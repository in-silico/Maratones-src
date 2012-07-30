#include <queue>
#include <cstdio>
#include <string>

using namespace std;


struct Oferta
{
    int numero;
    int precio;

    Oferta(int n, int p) : numero(n), precio(p) { }

    bool operator<(const Oferta & otra) const
    {
        return precio < otra.precio;
    }

    bool operator>(const Oferta & otra) const
    {
        return precio > otra.precio;
    }
};

priority_queue< Oferta, vector<Oferta>, greater<Oferta> > asks;
priority_queue< Oferta > bids;
char temp[10];

int main()
{
    int tc;
    scanf("%i\n", &tc);
    for(int i = 0; i < tc; i++)
    {
        int n;
        scanf("%i\n", &n);
        while(!asks.empty())
            asks.pop();
        while(!bids.empty())
            bids.pop();
        int stockPrice = -1;
        for(int j = 0; j < n; j++)
        {
            int numero;
            int precio;
            scanf("%s %i shares at %i", temp, &numero, &precio);
            string tipo(temp);
            bool compra = tipo == "buy";
            if(compra)
                bids.push(Oferta(numero, precio));
            else   
                asks.push(Oferta(numero, precio));
            while(!bids.empty() && !asks.empty() && bids.top().precio >= asks.top().precio)
            {
                Oferta bid = bids.top();
                Oferta ask = asks.top();
                bids.pop();
                asks.pop();
                if(bid.numero > ask.numero)
                {
                    bid.numero -= ask.numero;
                    bids.push(bid);
                }
                else if(bid.numero < ask.numero)
                {
                    ask.numero -= bid.numero;
                    asks.push(ask);
                }
                stockPrice = ask.precio;
            }
            if(bids.empty() && asks.empty())
            {
                if(stockPrice == -1)
                    printf("- - -\n");
                else
                    printf("- - %i\n", stockPrice);
            }
            else if(bids.empty())
            {
                if(stockPrice == -1)
                    printf("%i - -\n", asks.top().precio);
                else
                    printf("%i - %i\n", asks.top().precio, stockPrice);
            }
            else if(asks.empty())
            {
                if(stockPrice == -1)
                    printf("- %i -\n", bids.top().precio);
                else
                    printf("- %i %i\n", bids.top().precio, stockPrice);
            }
            else
            {
                if(stockPrice == -1)
                    printf("%i %i -\n", asks.top().precio, bids.top().precio);
                else
                    printf("%i %i %i\n", asks.top().precio, bids.top().precio, stockPrice);
            }
        }
    }
}
