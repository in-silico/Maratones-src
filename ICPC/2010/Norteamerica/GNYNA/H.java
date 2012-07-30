import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class H
{
    static int id = 0;

    static class Entrada implements Comparable <Entrada>
    {
        int idA = id++;
        int numero;
        int precio;
        boolean buy;
        
        public Entrada(int nn, int pp, boolean b)
        {
            numero = nn;
            precio = pp;
            buy = b;
        }

        public int compareTo(Entrada o) 
        {
            if(precio == o.precio)
            {
                if(precio == o.precio)
                    return Integer.valueOf(idA).compareTo(o.idA);
                return buy ? Integer.valueOf(precio).compareTo(o.precio) : -Integer.valueOf(precio).compareTo(o.precio);
            }
            return buy ? -Integer.valueOf(precio).compareTo(o.precio) : Integer.valueOf(precio).compareTo(o.precio);
        }

        @Override
        public String toString()
        {
             return numero + " " + precio;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for(int aa = 0; aa < nt; aa++)
        {
            PriorityQueue <Entrada> ask = new PriorityQueue <Entrada> ();
            PriorityQueue <Entrada> bid = new PriorityQueue <Entrada> ();
            int n = Integer.parseInt(br.readLine());
            int stock = -1;
            for(int i = 0; i < n; i++)
            {
                String[] pedazos = br.readLine().split(" ");
                boolean compra = pedazos[0].equals("buy");
                int numero = Integer.parseInt(pedazos[1]);
                int precio = Integer.parseInt(pedazos[4]);
                Entrada e = new Entrada(numero, precio, compra);
                if(compra)
                {
                    bid.add(e);
                }
                else
                {
                    ask.add(e);
                }
                while(!ask.isEmpty() && !bid.isEmpty() && bid.peek().precio >= ask.peek().precio)
                {
                    Entrada a = ask.poll();
                    stock = a.precio;
                    Entrada b = bid.poll();
                    if(a.numero > b.numero)
                    {
                        a.numero -= b.numero;
                        ask.add(a);
                    }
                    else if(a.numero < b.numero)
                    {
                        b.numero -= a.numero;
                        bid.add(b);
                    }
                }
                System.out.println((ask.isEmpty() ? "-" : ask.peek().precio) + " " + (bid.isEmpty() ? "-" : bid.peek().precio) + " " + (stock == -1 ? "-" : stock));
            }
        }
    }
}
