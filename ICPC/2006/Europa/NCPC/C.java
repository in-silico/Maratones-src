import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C
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

    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        for(int caso = 0; caso < t; caso++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            b -= c;
            if(a > b)
                System.out.println("do not advertise");
            else if(a < b)
                System.out.println("advertise");
            else
                System.out.println("does not matter");
        }
    }
}