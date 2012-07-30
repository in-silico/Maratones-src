import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Kamen 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out, 2000000), false));
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
	
	static class Roca implements Comparable <Roca>
	{	
		int fila;
		int piedrasEncima = 0;
		
		public Roca(int f)
		{
			fila = f;
		}

		@Override
		public int compareTo(Roca o) 
		{
			return fila - o.fila;
		}
	}
	
	static Roca temp = new Roca(0);
	
	private static boolean vacio(int fila, int columna) 
	{
		return mapa[fila][columna] == '.';
	}
	
	private static int buscarRoca(int fila, int columna)
	{
		ArrayList <Roca> este = rocas[columna];
		temp.fila = fila;
		int indice = Collections.binarySearch(este, temp);
		indice++;
		indice = -indice;
		return indice;
	}
	
	static class Trigger
	{
		int columna;
		int cabeza;
		
		public Trigger(int col, int cab)
		{
			columna = col;
			cabeza = cab;
		}
		
		public void actuar()
		{
			cabezas[columna] = Math.min(cabezas[columna], cabeza + 1);
			if(siguiente != null)
				siguiente.actuar();
		}
		
		Trigger siguiente;
	}
	static int columnaActual;
	
	static int [][][] ultimos = new int[30][30000][2];
	static int [] cabezas = new int[30];
	static Trigger [][] triggers = new Trigger[30000][30];
	
	static void agregarPiedra(int columna, int roca, int profundidad)
	{
		Roca actual = rocas[columna].get(roca);
		if(actual.piedrasEncima == 0)
		{
			mapa[actual.fila - actual.piedrasEncima - 1][columna] = 'O';
			if(triggers[actual.fila - actual.piedrasEncima - 1][columna] != null)
				triggers[actual.fila - actual.piedrasEncima - 1][columna].actuar();
			actual.piedrasEncima++;
		}
		else
		{
			int filaActual = actual.fila - actual.piedrasEncima - 1;
			if(columna != 0 && vacio(filaActual, columna - 1) && vacio(filaActual + 1, columna - 1))
			{
				agregarPiedra(columna - 1, buscarRoca(filaActual, columna - 1), profundidad + 1);
				ultimos[columnaActual][profundidad][0] = columna;
				ultimos[columnaActual][profundidad][1] = roca;
				Trigger nuevo = new Trigger(columnaActual, profundidad);
				nuevo.siguiente = triggers[filaActual][columna - 1];
				triggers[filaActual][columna - 1] = nuevo;
				nuevo = new Trigger(columnaActual, profundidad);
				nuevo.siguiente = triggers[filaActual + 1][columna - 1];
				triggers[filaActual + 1][columna - 1] = nuevo;
				if(cabezas[columnaActual] < profundidad + 1)
					cabezas[columnaActual] = profundidad + 1;
			}
			else if(columna != c - 1 && vacio(filaActual, columna + 1) && vacio(filaActual + 1, columna + 1))
			{
				agregarPiedra(columna + 1, buscarRoca(filaActual, columna + 1), profundidad + 1);
				ultimos[columnaActual][profundidad][0] = columna;
				ultimos[columnaActual][profundidad][1] = roca;
				Trigger nuevo = new Trigger(columnaActual, profundidad);
				nuevo.siguiente = triggers[filaActual][columna + 1];
				triggers[filaActual][columna + 1] = nuevo;
				nuevo = new Trigger(columnaActual, profundidad);
				nuevo.siguiente = triggers[filaActual + 1][columna + 1];
				triggers[filaActual + 1][columna + 1] = nuevo;
				if(cabezas[columnaActual] < profundidad + 1)
					cabezas[columnaActual] = profundidad + 1;
			}
			else
			{
				mapa[actual.fila - actual.piedrasEncima - 1][columna] = 'O';
				if(triggers[actual.fila - actual.piedrasEncima - 1][columna] != null)
					triggers[actual.fila - actual.piedrasEncima - 1][columna].actuar();
				actual.piedrasEncima++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	static ArrayList <Roca> [] rocas = new ArrayList[30];
	static char[][] mapa;
	static int r;
	static int c;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		r = sc.nextInt();
		c = sc.nextInt();
		mapa = new char[r][];
		for(int i = 0; i < r; i++)
		{
			mapa[i] = sc.nextLine().toCharArray();
		}
		for(int i = 0; i < c; i++)
		{
			ultimos[i][0][0] = i;
			ultimos[i][0][1] = 0;
			cabezas[i] = 1;
			rocas[i] = new ArrayList <Roca> ();
			for(int j = 0; j < r; j++)
				if(mapa[j][i] == 'X')
					rocas[i].add(new Roca(j));
			rocas[i].add(new Roca(r));
		}
		int nPiedras = sc.nextInt();
		for(int i = 0; i < nPiedras; i++)
		{
			int columna = sc.nextInt() - 1;
			columnaActual = columna;
			agregarPiedra(ultimos[columna][cabezas[columna] - 1][0], ultimos[columna][cabezas[columna] - 1][1], cabezas[columna]);
		}
		for(int i = 0; i < r; i++)
			System.out.println(new String(mapa[i]));
		System.out.flush();
	}

}
