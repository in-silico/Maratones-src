import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class F 
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
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        for(int caso = 0; caso < t; caso++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            LinkedList <Integer> todos = new LinkedList <Integer> ();
            int[] cuenta = new int[10];
            for(int i = 0; i < n; i++)
            {
                int nuevo = sc.nextInt();
                todos.add(nuevo);
                cuenta[nuevo]++;
            }
            todos.set(m, todos.get(m) + 10);
            int num = 1;
            while(true)
            {
                int actual = todos.pollFirst();
                boolean paila = false;
                int nu = actual >= 10 ? actual - 10 : actual;
                for(int i = nu + 1; i < 10; i++)
                    if(cuenta[i] > 0)
                        paila = true;
                if(paila)
                    todos.addLast(actual);
                else
                {
                    if(actual >= 10)
                    {
                        System.out.println(num);
                        break;
                    }
                    else
                    {
                        num++;
                        cuenta[actual]--;
                    }
                }
            }
        }
    }
}
