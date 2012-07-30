import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

public class I 
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
	
	
	public static int[] generarPermutacion()
	{
		Random r = new Random();
		int[] nueva = new int[26];
		LinkedList <Integer> posibles = new LinkedList <Integer> ();
		for(int i = 0; i < 26; i++)
			posibles.add(i);
		for(int i = 0; i < 26; i++)
			nueva[i] = posibles.remove(r.nextInt(posibles.size()));
		return nueva;
	}
	
	public static char[] aplicarPermutacion(char[] a, int[] permutacion)
	{
		char[] nuevo = new char[26];
		for(int i = 0; i < 26; i++)
			nuevo[permutacion[i]] = a[i];
		return nuevo;
	}
	public static void probar(char[] esta)
	{
		int[] ciclos = new int[27];
		for(int i = 0; i < esta.length; i++)
		{
			if(esta[i] == 0)
				continue;
			int j = i;
			int tam = 0;
			while(tam == 0 || j != i)
			{
				char este = esta[j];
				esta[j] = 0;
				j = este - 'A';
				tam++;
			}
			ciclos[tam]++;
		}
		boolean bien = true;
		for(int i = 0; i < 27; i++)
			if(i % 2 == 0)
				bien = bien && ((ciclos[i] % 2) == 0);
		if(bien)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	static String todas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int i = 0; i < t; i++)
			probar(sc.next().toCharArray());
	}
}