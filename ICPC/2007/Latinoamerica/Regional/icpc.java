import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class icpc
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static class Resultado
	{
		int numeroProblemas = 0;
		int intentosExtras = 0;
		int penalizacionInicial = 0;
		
		public int darPenalizacion(int n)
		{
			return penalizacionInicial + intentosExtras * n;
		}
		
		public boolean compararResultado(Resultado otro, int penalizacion)
		{
			if(numeroProblemas != otro.numeroProblemas)
				return true;
			return Integer.valueOf(darPenalizacion(20)).compareTo(otro.darPenalizacion(20)) == Integer.valueOf(darPenalizacion(penalizacion)).compareTo(otro.darPenalizacion(penalizacion));
		}
		
		void agregarResultado(String s)
		{
			String[] pedazos = s.split("/");
			if(pedazos[1].equals("-"))
				return;
			numeroProblemas++;
			penalizacionInicial += Integer.valueOf(pedazos[1]);
			intentosExtras += Integer.valueOf(pedazos[0]) - 1;
		}
	}
	
	static Resultado[] resultados = new Resultado[100];
	static int n;
	
	public static boolean esCorrecto(int penalizacion)
	{
		for(int i = 0; i < n; i++)
			for(int j = i + 1; j < n; j++)
				if(!resultados[i].compararResultado(resultados[j], penalizacion))
					return false;
		return true;
	}
	public static int busquedaBinariaBajo(int menor, int mayor)
	{
		if(menor == mayor)
			return menor;
		else if(menor + 1 == mayor)
			return esCorrecto(menor) ? menor : mayor;
		if(menor > mayor)
			return 20;
		int medio = (menor + mayor) / 2;
		if(esCorrecto(medio))
			return busquedaBinariaBajo(menor, medio);
		else
			return busquedaBinariaBajo(medio + 1, mayor);
	}
	
	public static int busquedaBinariaAlto(int menor, int mayor)
	{
		if(menor == mayor)
			return menor;
		else if(menor + 1 == mayor)
			return esCorrecto(mayor) ? mayor : menor;
		if(menor > mayor)
			return 20;
		int medio = (menor + mayor) / 2;
		if(esCorrecto(medio))
			return busquedaBinariaAlto(medio, mayor);
		else
			return busquedaBinariaAlto(menor, medio - 1);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			int nProb = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				resultados[i] = new Resultado();
				for(int j = 0; j < nProb; j++)
					resultados[i].agregarResultado(sc.next());
			}
			int alto = busquedaBinariaAlto(20, 1000000);
			String resAlto = alto + "";
			if(alto == 1000000)
				resAlto = "*";
			System.out.println(busquedaBinariaBajo(1, 20) + " " + resAlto);
		}
	}
}