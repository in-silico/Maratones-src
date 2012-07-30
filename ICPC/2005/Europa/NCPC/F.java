import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class F
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			try
			{
				System.setOut(new PrintStream(new BufferedOutputStream(System.out)));
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(Exception e)
				{
					throw(new RuntimeException());
				}
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
	
	static class Anio
	{
		int a;
		int valor;
		
		public Anio(int nextInt, int nextInt2) 
		{
			a = nextInt;
			valor = nextInt2;
		}
		
	}
	
	static int[] dpAtras = new int[100000];
	static int[] dpAdelante = new int[100000];
	static Anio[] anios = new Anio[100000];
	static int tam;
	
	static int dpAtras(int n)
	{
		if(n == 0)
			return -1;
		if(dpAtras[n] != -1)
			return dpAtras[n];
		int tmp = n - 1;
		while(tmp != -1 && anios[tmp].valor < anios[n].valor)
			tmp = dpAtras(tmp);
		return dpAtras[n] = tmp;
	}
	
	static int dpAdelante(int n)
	{
		if(n == tam)
			return tam;
		if(dpAdelante[n] != -1)
			return dpAdelante[n];
		int tmp = n + 1;
		while(tmp != tam && anios[tmp].valor < anios[n].valor)
			tmp = dpAdelante(tmp);
		return dpAdelante[n] = tmp;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("worst.in"));
		System.setOut(new PrintStream("worstsg.out"));
		Scanner sc = new Scanner();
		int[] dpExiste = new int[100000];
		TreeMap <Integer, Integer> valores = new TreeMap <Integer, Integer> ();
		boolean inicio = false;
		while(true)
		{
			int n = sc.nextInt();
			tam = n;
			if(n == 0)
			{
				System.out.flush();
				return;
			}
			if(!inicio)
				inicio = true;
			else
				System.out.println();
			valores.clear();
			for(int i = 0; i < n; i++)
			{
				anios[i] = new Anio(sc.nextInt(), sc.nextInt());
				valores.put(anios[i].a, i);
			}
			dpExiste[0] = 0;
			for(int i = 1; i < n; i++)
			{
				if(anios[i - 1].a + 1 == anios[i].a)
					dpExiste[i] = dpExiste[i - 1];
				else
					dpExiste[i] = i;
			}
			for(int i = 0; i < n; i++)
				dpAtras[i] = -1;
			for(int i = 0; i < n; i++)
				dpAtras(i);
			for(int i = 0; i < n; i++)
				dpAdelante[i] = -1;
			for(int i = n - 1; i >= 0; i--)
				dpAdelante(i);
			int q = sc.nextInt();
			for(int i = 0; i < q; i++)
			{
				int y = sc.nextInt();
				int x = sc.nextInt();
				if(valores.get(x) != null && valores.get(y) != null)
				{
					int valor = dpAtras(valores.get(x));
					if(anios[valores.get(x)].valor <= anios[valores.get(y)].valor && valor <= valores.get(y))
					{
						if(dpExiste[valores.get(x)] <= valores.get(y))
							System.out.println("true");
						else
							System.out.println("maybe");
					}
					else
						System.out.println("false");
				}
				else
				{
					if(valores.get(y) == null)
					{
						Integer val = valores.ceilingEntry(y) == null ? null : valores.ceilingEntry(y).getValue();
						if(val == null)
							System.out.println("maybe");
						else
						{
							if(valores.floorEntry(x) == null)
								System.out.println("maybe");
							else
							{
								int val2 = valores.floorEntry(x).getValue();
								int res = dpAtras(val2);
								if(res < val || valores.get(x) == null)
									System.out.println("maybe");
								else
									System.out.println("false");
							}
						}	
					}
					else
					{
						int val = valores.get(y);
						int res = dpAdelante(val);
						int val2 = valores.floorEntry(x).getValue();
						if(res >= val2)
							System.out.println("maybe");
						else
							System.out.println("false");
					}
				}
			}
		}
	}
}
