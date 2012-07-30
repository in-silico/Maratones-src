import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.HashMap;
import java.util.StringTokenizer;


public class K
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
	
	public static void main(String[] args)
	{
		HashMap <Integer, Integer> posiciones = new HashMap <Integer, Integer> ();
		HashMap <Integer, Integer> valores = new HashMap <Integer, Integer> ();
		Scanner sc = new Scanner();
		BitSet set = new BitSet(100000);
		int[] qx = new int[50000];
		int[] qy = new int[50000];
		boolean[] qq = new boolean[50000];
		BitSet[] sets = new BitSet[100];
		for(int i = 0; i < 100; i++)
			sets[i] = new BitSet(100000);
		int[] a = new int[100000];
		int n = sc.nextInt();
		int m = sc.nextInt();
		int valActual = 0;
		for(int i = 0; i < n; i++)
		{
			int val = sc.nextInt();
			if(valores.containsKey(val))
				val = valores.get(val);
			else
			{
				valores.put(val, valActual);
				val = valActual++;
			}
			posiciones.put(i, i);
			a[i] = val;
		}
		int posActual = n;
		for(int i = 0; i < m; i++)
		{
			qq[i] = sc.next().equals("Q");
			qx[i] = sc.nextInt();
			qy[i] = sc.nextInt();
			if(!qq[i])
			{
				int pos = qx[i];
				if(posiciones.containsKey(pos))
					pos = posiciones.get(pos);
				else
				{
					posiciones.put(pos, posActual);
					pos = posActual++;
				}
				int val = qy[i];
				if(valores.containsKey(val))
					val = valores.get(val);
				else
				{
					valores.put(val, valActual);
					val = valActual++;
				}
				qx[i] = pos;
				qy[i] = val;
			}
		}
		for(int i = 0; i < m; i++)
			if(qq[i])
			{
				qx[i] = posiciones.get(qx[i]);
				qy[i] = posiciones.get(qy[i] - 1) + 1;
			}
		for(int i = 0; i < m; i++)
			if(qq[i])
			{
				set.clear();
				int primero = qx[i];
				int ultimo = qy[i];
				if(primero / 1000 == (ultimo - 1) / 1000)
					for(int j = primero; j < ultimo; j++)
						set.set(a[j]);
				else
				{
					ultimo--;
					for(int j = primero; (j == primero) || (j % 1000 != 0); j++)
						set.set(a[j]);
					for(int j = ultimo - ultimo % 1000; j <= ultimo; j++)
						set.set(a[j]);
					int vInicial = primero / 1000 + 1;
					int vFinal = ultimo / 1000 - 1;
					while(vInicial <= vFinal)
						set.or(sets[vInicial++]);
				}
				System.out.println(set.cardinality());
			}
			else
			{
				a[qx[i]] = qy[i];
				int actual = qx[i] / 1000;
				BitSet esteSet = sets[actual];
				esteSet.clear();
				int ultimo = (actual + 1) * 1000;
				for(int j = actual * 1000; j < ultimo; j++)
					esteSet.set(a[j]);
			}
	}
}
