import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class D 
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
	
	static class Punto
	{
		int i, j;

		public Punto(int x, int y)
		{
			i = x;
			j = y;
		}
		
		private void visitar() 
		{
			if(matriz[i][j] == 'A')
				return;
			char car = matriz[i][j];
			matriz[i][j] = 'A';
			if(posible(i - 1, j) && vecinoAbajo(i - 1, j))
				if(car == 'C' || car == 'D' || car == 'F')
					siguientes.add(new Punto(i - 1, j));
			if(posible(i + 1, j) && vecinoArriba(i + 1, j))
				if(car == 'B' || car == 'E' || car == 'F')
					siguientes.add(new Punto(i + 1, j));
			if(posible(i, j - 1) && vecinoDerecha(i, j - 1))
				if(car == 'B' || car == 'C' || car == 'F')
					siguientes.add(new Punto(i, j - 1));
			if(posible(i, j + 1) && vecinoIzquierda(i, j + 1))
				if(car == 'D' || car == 'E' || car == 'F')
					siguientes.add(new Punto(i, j + 1));
		}
	}
	
	static char[][] matriz = new char[1001][1001];
	static boolean[][] visitado = new boolean[1001][1001];
	static LinkedList <Punto> siguientes = new LinkedList <Punto> ();
	static int n, m;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int z = sc.nextInt();
		for(int caso = 0; caso < z; caso++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				String siguiente = sc.next();
				int j = 0;
				for(char c : siguiente.toCharArray())
				{
					visitado[i][j] = false;
					matriz[i][j++] = c;
				}
			}
			int numero = 0;
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					if(matriz[i][j] != 'A')
					{
						numero++;
						siguientes.add(new Punto(i, j));
						while(!siguientes.isEmpty())
							siguientes.poll().visitar();
					}
				}
			}
			System.out.println(numero);
		}
	}
	
	private static boolean posible(int i, int j) 
	{
		return i > -1 && i < n && j > -1 && j < m;
	}


	private static boolean vecinoAbajo(int i, int j) 
	{
		char car = matriz[i][j];
		return car == 'E' || car == 'F' || car == 'B';
	}

	private static boolean vecinoArriba(int i, int j) 
	{
		char car = matriz[i][j];
		return car == 'C' || car == 'F' || car == 'D';
	}
	
	private static boolean vecinoDerecha(int i, int j) 
	{
		char car = matriz[i][j];
		return car == 'E' || car == 'F' || car == 'D';
	}
	
	private static boolean vecinoIzquierda(int i, int j) 
	{
		char car = matriz[i][j];
		return car == 'C' || car == 'F' || car == 'B';
	}
}
