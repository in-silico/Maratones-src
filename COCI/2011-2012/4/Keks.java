import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Keks 
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
	
	static class Digito implements Comparable <Digito>
	{
		char valor;
		int posicion;
		
		public Digito(char valor, int posicion) 
		{
			this.valor = valor;
			this.posicion = posicion;
		}


		@Override
		public int compareTo(Digito o) 
		{
			if(valor != o.valor)
				return Character.valueOf(o.valor).compareTo(valor);
			return Integer.valueOf(posicion).compareTo(o.posicion);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		PriorityQueue <Digito> pq = new PriorityQueue <Digito> ();
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[] digitos = sc.next().toCharArray();
		char[] resultado = new char[n - k];
		int i;
		for(i = 0; n - pq.size() != n - k - 1; i++)
			pq.add(new Digito(digitos[i], i));
		int actual = 0;
		Digito dActual = pq.poll();
		resultado[actual++] = dActual.valor;
		for(; i < n; i++)
		{
			pq.add(new Digito(digitos[i], i));
			while(pq.peek().posicion < dActual.posicion)
				pq.poll();
			dActual = pq.poll();
			resultado[actual++] = dActual.valor;
		}
		System.out.println(new String(resultado));
	}
}