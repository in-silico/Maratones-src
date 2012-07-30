import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	
	static int numeroN;
	static HashSet <Solucion> a = new HashSet <Solucion> ();
	static LinkedList <Solucion> b = new LinkedList <Solucion> ();
	
	static class Solucion
	{
		long tablero;
		int numero;
		int pasos;
		char movimiento;
		Solucion anterior;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + numero;
			result = prime * result + ((int) tablero);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Solucion other = (Solucion) obj;
			if (numero != other.numero)
				return false;
			if (tablero != other.tablero)
				return false;
			return true;
		}
		

		public long swap(long anterior, int a, int b)
		{
			int dosA = a << 1;
			int dosB = b << 1;
			long temp1 = valorPos(anterior, a);
			long temp2 = valorPos(anterior, b);
			long mascara = 3L << dosA;
			mascara = ~mascara;
			anterior &= mascara;
			mascara = 3L << dosB;
			mascara = ~mascara;
			anterior &= mascara;
			anterior |= temp1 << dosB;
			anterior |= temp2 << dosA;
			return anterior;
		}
		
		public int valorPos(long v, int numero)
		{
			return (int) ((v >> (numero << 1)) & 3L);
		}

		public void generarHijos()
		{
			if(numero - 2 >= 0 && valorPos(tablero, numero - 2) == 2)
			{
				Solucion nueva = new Solucion();
				nueva.tablero = swap(tablero, numero, numero - 2);
				nueva.numero = numero - 2;
				nueva.pasos = pasos + 1;
				nueva.anterior = this;
				nueva.movimiento = 'H';
				if(!a.contains(nueva))
				{
					a.add(nueva);
					b.add(nueva);
				}
			}
			if(numero + 2 < numeroN && valorPos(tablero, numero + 2) == 1)
			{
				Solucion nueva = new Solucion();
				nueva.tablero = swap(tablero, numero, numero + 2);
				nueva.numero = numero + 2;
				nueva.pasos = pasos + 1;
				nueva.anterior = this;
				nueva.movimiento = 'h';
				if(!a.contains(nueva))
				{
					a.add(nueva);
					b.add(nueva);
				}
			}
			if(numero + 1 < numeroN && valorPos(tablero, numero + 1) == 1)
			{
				Solucion nueva = new Solucion();
				nueva.tablero = swap(tablero, numero, numero + 1);
				nueva.numero = numero + 1;
				nueva.pasos = pasos + 1;
				nueva.anterior = this;
				nueva.movimiento = 's';
				if(!a.contains(nueva))
				{
					a.add(nueva);
					b.add(nueva);
				}
			}
			if(numero - 1 >= 0 && valorPos(tablero, numero - 1) == 2)
			{
				Solucion nueva = new Solucion();
				nueva.tablero = swap(tablero, numero, numero - 1);
				nueva.numero = numero - 1;
				nueva.pasos = pasos + 1;
				nueva.anterior = this;
				nueva.movimiento = 'S';
				if(!a.contains(nueva))
				{
					a.add(nueva);
					b.add(nueva);
				}
			}
		}
		public void poner(int i, int val)
		{
			long valor = val;
			valor <<= (i << 1);
			tablero |= valor;
		}
	}
	
	public static void imprimir(long p)
	{
		for(int i = 0; i < numeroN; i++)
		{
			System.out.print((p & 3) == 2 ? "G" : (p & 3) == 1 ? "B" : " ");
			p >>= 2;
		}
		System.out.println();
	}
	
	public static void solucionar(int numero, int girls, int boys)
	{
		numeroN = girls + boys + 1;
		Solucion inicial = new Solucion();
		for(int i = 0; i < girls; i++)
			inicial.poner(i,  2);
		for(int i = girls + 1; i < girls + boys + 1; i++)
			inicial.poner(i, 1);
		inicial.numero = girls;
		Solucion objetivo = new Solucion();
		for(int i = 0; i < boys; i++)
			objetivo.poner(i, 1);
		for(int i = boys + 1; i < girls + boys + 1; i++)
			objetivo.poner(i, 2);
		objetivo.numero = boys;
		inicial.pasos = 0;
		b.clear();
		a.clear();
		b.add(inicial);
		a.add(inicial);
		while(!b.isEmpty())
		{
			Solucion actual = b.poll();
			if(actual.equals(objetivo))
			{
				char[] salida = new char[actual.pasos];
				int n = actual.pasos;
				for(int i = n - 1; i >= 0; i--)
				{
					salida[i] = actual.movimiento;
					actual = actual.anterior;
				}
				System.out.println(numero + " " + n);
				int faltantes = n;
				int act = 0;
				while(faltantes > 50)
				{
					System.out.println(new String(salida, act, 50));
					act += 50;
					faltantes -= 50;
				}
				System.out.println(new String(salida, act, faltantes));
				System.out.println();
				break;
			}
			actual.generarHijos();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
			solucionar(sc.nextInt(), sc.nextInt(), sc.nextInt());
	}
}
