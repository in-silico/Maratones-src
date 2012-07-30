import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class P2
{
	static class Scanner
    {
            BufferedReader br;
            StringTokenizer st;
            
            public Scanner()
            {
            		System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
                    br = new BufferedReader(new InputStreamReader(System.in));
            }
            
            public String next()
            {

                    while(st == null || !st.hasMoreTokens())
                    {
                            try { st = new StringTokenizer(br.readLine()); }
                            catch(Exception e) { throw new RuntimeException(); }
                    }
                    return st.nextToken();
            }
            
            public int nextInt()
            {
                    return Integer.parseInt(next());
            }
            
            public double nextDouble()
            {
                    return Double.parseDouble(next());
            }
            
            public String nextLine()
            {
                    st = null;
                    try { return br.readLine(); }
                    catch(Exception e) { throw new RuntimeException(); }
            }
            
            public boolean endLine()
            {
                    try 
                    {
                            String next = br.readLine();
                            while(next != null && next.trim().isEmpty())
                                    next = br.readLine();
                            if(next == null)
                                    return true;
                            st = new StringTokenizer(next);
                            return st.hasMoreTokens();
                    }
                    catch(Exception e) { throw new RuntimeException(); }
            }
    }

	static int[][] permutaciones = new int[][]{
										  {0, 1, 2, 3}, {0, 1, 3, 2}, {0, 2, 1, 3}, {0, 2, 3, 1}, {0, 3, 1, 2}, {0, 3, 2, 1},
										  {1, 0, 2, 3}, {1, 0, 3, 2}, {1, 2, 0, 3}, {1, 2, 3, 0}, {1, 3, 0, 2}, {1, 3, 2, 0},
										  {2, 0, 1, 3}, {2, 0, 3, 1}, {2, 1, 0, 3}, {2, 1, 3, 0}, {2, 3, 0, 1}, {2, 3, 1, 0},
										  {3, 0, 1, 2}, {3, 0, 2, 1}, {3, 1, 0, 2}, {3, 1, 2, 0}, {3, 2, 0, 1}, {3, 2, 1, 0}
										  };
	static int[] permutacionActual;
	static ArrayList <String> arriba = new ArrayList <String> ();
	
	static class RespuestaParcial
	{
		Character[] asignadas = new Character[20];
		Character[] seAsignaron = new Character[20];
		boolean factible = true;

		RespuestaParcial(ArrayList <String> abajo)
		{
			int cuenta = 0;
			for(String s : arriba)
			{
				String s1 = abajo.get(cuenta++);
				for(int i = 0; i < 4; i++)
					if(!asignar(s.charAt(i), s1.charAt(permutacionActual[i])))
						factible = false;
			}
		}
		
		boolean asignar(char a, char b)
		{
			int pos1 = a - 'A';
			int pos2 = b - 'a';
			if(asignadas[pos1] == null)
			{
				if(seAsignaron[pos2] == null)
				{
					seAsignaron[pos2] = a;
					asignadas[pos1] = b;
					return true;
				}
				else
				{
					asignadas[pos1] = b;
					return seAsignaron[pos2].charValue() == a;
				}
			}
			else
				return asignadas[pos1].charValue() == b;
		}
	}
	
	static Character[] letras = new Character[20];
	static Character noSeSabe = Character.valueOf('1');
	static String[] grupos = new String[]{"abcde", "fghij", "klmno", "pqrst"};
	
	public static void main(String[] a)
	{
		Scanner sc = new Scanner();
		int caso = 1;
		ArrayList <String> abajo = new ArrayList <String> ();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			System.out.println("Test #" + caso++ + ":");
			arriba.clear();
			for(int i = 0; i < n; i++)
				arriba.add(sc.next());
			abajo.clear();
			for(int i = 0; i < n; i++)
				abajo.add(sc.next());
			for(int i = 0; i < 20; i++)
				letras[i] = null;
			for(int[] p : permutaciones)
			{
				permutacionActual = p;
				RespuestaParcial r = new RespuestaParcial(abajo);
				if(!r.factible)
					continue;
				for(int i = 0; i < 20; i++)
				{
					if(letras[i] == noSeSabe)
						continue;
					if(letras[i] == null)
						letras[i] = r.asignadas[i];
					else if(letras[i] != r.asignadas[i])
							letras[i] = noSeSabe;
				}
			}
			int cuenta = -1;
			for(int i = 0; i < 4; i++)
			{
				int c = 0;
				char letra = '0';
				for(int j = 0; j < 5; j++)
				{
					int pos = i * 5 + j;
					if(letras[pos] != null && letras[pos] != noSeSabe)
					{
						c++;
						letra = letras[pos];
					}
				}
				if(c == 4)
				{
					String cual = null;
					for(String s : grupos)
					{
						if(s.contains(letra + ""))
							cual = s;
					}
					for(int j = 0; j < 5; j++)
					{
						int pos = i * 5 + j;
						if(letras[pos] != null && letras[pos] != noSeSabe)
							cual = cual.replace(letras[pos] + "", "");
					}
					for(int j = 0; j < 5; j++)
					{
						int pos = i * 5 + j;
						if(letras[pos] == null || letras[pos] == noSeSabe)
							letras[pos] = cual.charAt(0);
					}
				}
			}
			for(int i = 0; i < 20; i++)
			{
				if(cuenta++ == 4)
				{
					cuenta = 0;
					System.out.println();
				}
				if(cuenta >= 1)
					System.out.print(" ");
				if(letras[i] != null && letras[i] != noSeSabe)
					System.out.print(((char) ('A' + i)) + "-" + letras[i]);
				else
					System.out.print(((char) ('A' + i)) + "-?");
			}
			System.out.println();
		}
	}
}