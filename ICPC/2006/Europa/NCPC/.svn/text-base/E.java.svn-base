import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class E 
{
    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

    static class Entero
    {
        Integer cual;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        for(int caso = 0; caso < t; caso++)
        {
            int n = sc.nextInt();
            Entero[] todos = new Entero[n];
            for(int i = 0; i < n; i++)
                todos[i] = new Entero();
            LinkedList <Entero> cola = new LinkedList <Entero> ();
            for(int i = 0; i < n; i++)
                cola.add(todos[i]);
            for(int i = 1; i <= n; i++)
            {
               for(int j = 0; j < i; j++)
                   cola.add(cola.poll());
               cola.peek().cual = i;
               cola.poll();
            }
            for(int i = 0; i < n; i++)
                if(i == 0)
                    System.out.print(todos[i].cual);
                else
                    System.out.print(" " + todos[i].cual);
            System.out.println();
        }
    }
}