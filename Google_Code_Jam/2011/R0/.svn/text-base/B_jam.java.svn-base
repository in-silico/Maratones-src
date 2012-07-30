import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B_jam 
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
	
	static class Letra
	{
		ArrayList <Character> opuestos = new ArrayList <Character> ();
		TreeMap <Character, Character> combinados = new TreeMap <Character, Character> ();
	}
	
	static Letra[] letras = new Letra[256];
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("b.in"));
		System.setOut(new PrintStream("b.out"));
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 1; caso <= t; caso++)
		{
			for(int i = 'A'; i <= 'Z'; i++)
				letras[i] = new Letra();
			int c = sc.nextInt();
			for(int i = 0; i < c; i++)
			{
				String s = sc.next();
				char a = s.charAt(0);
				char b = s.charAt(1);
				char r = s.charAt(2);
				letras[a].combinados.put(b, r);
				letras[b].combinados.put(a, r);
			}
			int d = sc.nextInt();
			for(int i = 0; i < d; i++)
			{
				String s = sc.next();
				char a = s.charAt(0);
				char b = s.charAt(1);
				letras[a].opuestos.add(b);
				letras[b].opuestos.add(a);
			}
			LinkedList <Character> lista = new LinkedList <Character> ();
			sc.nextInt();
			for(char a : sc.next().toCharArray())
			{
				while(true)
				{
					if(lista.isEmpty())
					{
						lista.add(a);
						break;
					}
					else if(letras[a].combinados.containsKey(lista.peekLast()))
					{
						a = letras[a].combinados.get(lista.pollLast());
						continue;
					}
					else
					{
						boolean limpio = false;
						for(char o : letras[a].opuestos)
						{
							if(lista.contains(o))
							{
								lista.clear();
								limpio = true;
								break;
							}
						}
						if(!limpio)
							lista.add(a);
						break;
					}
				}
			}
			System.out.println("Case #" + caso + ": " + lista.toString());
		}
	}

}
