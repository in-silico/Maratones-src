import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G
{
    public static class Scanner
    {
        BufferedReader br;
        StringTokenizer st;

        public Scanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next()
        {
            try
            {
                while(st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
            }
            catch(Exception e)
            {
                throw(new RuntimeException());
            }
            return st.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    }

    public static class Primo
    {
        String s;
        int pasos;

        public Primo(String si, int pasosi)
        {
            s = si;
            pasos = pasosi;
        }

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        boolean[] noPrimos = new boolean[10001];
        boolean[] visitados = new boolean[10001];
        for(int i = 2; i <= 10000; i++)
        {
            if(!noPrimos[i])
                for(int j = i + i; j <= 10000; j += i)
                    noPrimos[j] = true;
        }
        for(int caso = 0; caso < t; caso++)
        {
            String a = sc.next();
            String b = sc.next();
            LinkedList <Primo> cola = new LinkedList <Primo> ();
            for(int i = 0; i < 10001; i++)
                visitados[i] = false;
            visitados[Integer.parseInt(a)] = true;
            cola.add(new Primo(a, 0));
            boolean pudo = false;
            while(!cola.isEmpty())
            {
                Primo actual = cola.poll();
                if(actual.s.equals(b))
                {
                    System.out.println(actual.pasos);
                    pudo = true;
                    break;
                }
                char[] n = actual.s.toCharArray();
                for(int i = 0; i < 4; i++)
                {
                    char anterior = n[i];
                    for(int j = 0; j <= 9; j++)
                    {
                        if(i == 0 && j == 0)
                            continue;
                        n[i] = (char) (j + '0');
                        String posible = new String(n);
                        int numero = Integer.parseInt(posible);
                        if(!noPrimos[numero] && !visitados[numero])
                        {
                            visitados[numero] = true;
                            cola.add(new Primo(posible, actual.pasos + 1));
                        }
                    }
                    n[i] = anterior;
                }
            }
            if(!pudo)
                System.out.println("Impossible");
        }
    }
}