import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out, 8000000)));
			br = new BufferedReader(new InputStreamReader(System.in), 2000000);
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

		public BigInteger nextBigInteger()
		{
			return new BigInteger(next());
		}
	}
	
	static class Ciclo
	{
		int tamCiclo;
		long[] sumasParciales;
		int[] quien;
		
		public Ciclo(Numero inicial)
		{
			tamCiclo = 0;
			Numero actual = inicial;
			while(actual.numeroFinal != inicial.nOriginal)
			{
				ciclo[tamCiclo++] = actual;
				actual = tableroActual[todosNumeros[todosNumeros[actual.numeroFinal].numeroFinal].filaOriginal][todosNumeros[todosNumeros[actual.numeroFinal].numeroFinal].columnaOriginal];
			}
			ciclo[tamCiclo++] = actual;
			quien = new int[tamCiclo << 1];
			sumasParciales = new long[tamCiclo << 1];
			for(int i = 0; i < tamCiclo; i++)
			{
				ciclo[i].ciclo = this;
				ciclo[i].posCiclo = i;
				sumasParciales[i] = i == 0 ? ciclo[i].numeroImpresiones : ciclo[i].numeroImpresiones + sumasParciales[i - 1];
				quien[i] = ciclo[i].nOriginal;
			}
			int limite = tamCiclo << 1;
			for(int i = tamCiclo; i < limite; i++)
			{
				sumasParciales[i] = ciclo[i - tamCiclo].numeroImpresiones + sumasParciales[i - 1];
				quien[i] = ciclo[i - tamCiclo].nOriginal;
			}
		}
		
		public long sumatoria(int inicial, int numero)
		{
			if(numero == 0)
				return 0;
			return inicial == 0 ? sumasParciales[numero - 1] : sumasParciales[inicial + numero - 1] - sumasParciales[inicial - 1];
		}
	}
	
	static class Numero
	{
		int nOriginal;
		int numeroImpresiones = 0;
		int numeroFinal = 0;
		int columnaOriginal;
		int filaOriginal;
		Ciclo ciclo;
		int posCiclo;
	}
	
	static class Query implements Comparable <Query>
	{
		int n;
		int m;
		int respuesta;
		
		public Query(int nn, int mm)
		{
			n = nn;
			m = mm;
		}

		@Override
		public int compareTo(Query o) 
		{
			if(m == o.m)
				return n - o.n;
			return m - o.m;
		}
	}

	static int[][] numeroOriginales = new int[300][300];
	static Numero[][] tableroActual = new Numero[300][300];
	static Numero[] todosNumeros = new Numero[301 * 301];
	static Numero[] ciclo = new Numero[301 * 301];
	static int r, c;
	static char[][] tableroCambios = new char[300][300];
	
	public static void llenar()
	{
		int actual = 1;
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
			{
				todosNumeros[actual] = new Numero();
				todosNumeros[actual].nOriginal = actual;
				todosNumeros[actual].filaOriginal = i;
				todosNumeros[actual].columnaOriginal = j;
				numeroOriginales[i][j] = actual;
				tableroActual[i][j] = todosNumeros[actual++];
			}
		for(int i = 0; i < r - 1; i++)
			for(int j = 0; j < c - 1; j++)
			{
				Numero temp = tableroActual[i][j];
				temp.numeroImpresiones++;
				if(tableroCambios[i][j] == 'L')
				{
					tableroActual[i][j] = tableroActual[i][j + 1];
					tableroActual[i][j + 1] = tableroActual[i + 1][j + 1];
					tableroActual[i + 1][j + 1] = tableroActual[i + 1][j];
					tableroActual[i + 1][j] = temp;
				}
				else if(tableroCambios[i][j] == 'R')
				{
					tableroActual[i][j] = tableroActual[i + 1][j];
					tableroActual[i + 1][j] = tableroActual[i + 1][j + 1];
					tableroActual[i + 1][j + 1] = tableroActual[i][j + 1];
					tableroActual[i][j + 1] = temp;
				}
			}
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				tableroActual[i][j].numeroFinal = numeroOriginales[i][j];
	}
	
	static final BigInteger mod = BigInteger.valueOf(100000);
	static PriorityQueue <Query> pq = new PriorityQueue <Query> (100000);
	
	public static void resolver(BigInteger n)
	{
		pq.clear();
		long[] resParciales = new long[r * c + 1];
		Query[] queries = new Query[r * c + 1];
		for(int i = 1; i <= r * c; i++)
		{
			Numero actual = todosNumeros[i];
			if(actual.ciclo == null)
				new Ciclo(actual);
			long t = (r - 1) * (c - 1);
			t *= actual.ciclo.tamCiclo;
			BigInteger[] ans = n.divideAndRemainder(BigInteger.valueOf(t));
			long numeroVeces = ans[0].mod(mod).longValue();
			long resParcial = actual.ciclo.sumatoria(0, actual.ciclo.tamCiclo) * numeroVeces;
			long t1 = ans[1].longValue();
			int posicionCiclo = (int) (t1 / ((r - 1) * (c - 1)));
			resParcial += actual.ciclo.sumatoria(actual.posCiclo, posicionCiclo);
			int numeroRestantes = (int) (t1 % ((r - 1) * (c - 1)));
			resParciales[i] = resParcial;
			queries[i] = new Query(actual.ciclo.quien[actual.posCiclo + posicionCiclo], numeroRestantes);
			pq.add(queries[i]);
		}
		int actual = 1;
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
			{
				todosNumeros[actual] = new Numero();
				todosNumeros[actual].nOriginal = actual;
				todosNumeros[actual].filaOriginal = i;
				todosNumeros[actual].columnaOriginal = j;
				numeroOriginales[i][j] = actual;
				tableroActual[i][j] = todosNumeros[actual++];
			}
		int turnoActual = 0;
		for(int i = 0; i < r - 1; i++)
			for(int j = 0; j < c - 1; j++)
			{
				while(!pq.isEmpty() && pq.peek().m == turnoActual)
				{
					Query q = pq.poll();
					q.respuesta = todosNumeros[q.n].numeroImpresiones;
				}
				Numero temp = tableroActual[i][j];
				temp.numeroImpresiones++;
				if(tableroCambios[i][j] == 'L')
				{
					tableroActual[i][j] = tableroActual[i][j + 1];
					tableroActual[i][j + 1] = tableroActual[i + 1][j + 1];
					tableroActual[i + 1][j + 1] = tableroActual[i + 1][j];
					tableroActual[i + 1][j] = temp;
				}
				else if(tableroCambios[i][j] == 'R')
				{
					tableroActual[i][j] = tableroActual[i + 1][j];
					tableroActual[i + 1][j] = tableroActual[i + 1][j + 1];
					tableroActual[i + 1][j + 1] = tableroActual[i][j + 1];
					tableroActual[i][j + 1] = temp;
				}
				turnoActual++;
			}
		while(!pq.isEmpty() && pq.peek().n == turnoActual)
		{
			Query q = pq.poll();
			q.respuesta = todosNumeros[q.n].numeroImpresiones;
		}
		for(int i = 1; i <= r * c; i++)
			System.out.println((resParciales[i] + queries[i].respuesta) % 100000);
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner();
		boolean inicio = false;
		while(!sc.endLine())
		{
			if(!inicio)
				inicio = true;
			else
				System.out.println();
			r = sc.nextInt();
			c = sc.nextInt();
			BigInteger n = sc.nextBigInteger();
			for(int i = 0; i < r - 1; i++)
			{
				char[] este = sc.next().toCharArray();
				int actual = 0;
				for(char c : este)
					tableroCambios[i][actual++] = c;
			}
			llenar();
			resolver(n);
		}
		System.out.flush();
	}
}
