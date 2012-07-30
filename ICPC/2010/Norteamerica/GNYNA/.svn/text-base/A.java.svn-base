import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class A
{
    static ArrayList <Integer> xx = new ArrayList <Integer> ();
    static ArrayList <Integer> yy = new ArrayList <Integer> ();
    static ArrayList <Integer> respuesta = new ArrayList<Integer> ();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++)
        {
            String[] pedazos = br.readLine().split(" ");
            int nn = Integer.parseInt(pedazos[0]);
            int b = Integer.parseInt(pedazos[1]);
            int x = Integer.parseInt(pedazos[2]);
            int y = Integer.parseInt(pedazos[3]);
            xx.clear();
            yy.clear();
            while(x != 0)
            {
                xx.add(x % b);
                x /= b;
            }
            while(y != 0)
            {
                yy.add(y % b);
                y /= b;
            }
            while(xx.size() > yy.size())
            {
                yy.add(0);
            }
            while(yy.size() > xx.size())
            {
                xx.add(0);
            }
            respuesta.clear();
            int tamano = xx.size();
            for(int j = 0; j < tamano; j++)
            {
                respuesta.add((xx.get(j) + yy.get(j)) % b);
            }
            int res = 0;
            int base = 1;
            for(int j = 0; j < xx.size(); j++)
            {
                res += respuesta.get(j) * base;
                base *= b;
            }
            System.out.println(nn + " " + res);
        }
    }
}
