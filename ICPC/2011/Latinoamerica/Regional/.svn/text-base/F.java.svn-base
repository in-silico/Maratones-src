import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class F 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	
	static boolean leq(int a1, int a2,   int b1, int b2) 
	{
		return(a1 < b1 || a1 == b1 && a2 <= b2);
	}             

	static boolean leq(int a1, int a2, int a3,   int b1, int b2, int b3) 
	{
		return(a1 < b1 || a1 == b1 && leq(a2,a3, b2,b3));
	}

	static int[] c;

	static void radixPass(int[] a, int[] b, int[] r, int n, int K, int delta)
	{
		if(c == null || c.length != K + 1) c = new int[K + 1];
		for(int i = 0;  i <= K; i++) c[i] = 0;
		for(int i = 0;  i < n;  i++) c[r[a[i] + delta]]++;
		for(int i = 0, sum = 0;  i <= K;  i++) 
		{
			int t = c[i];
			c[i] = sum;
			sum += t;
		}
		for (int i = 0;  i < n;  i++) b[c[r[a[i] + delta]]++] = a[i];
	}

	// find the suffix array SA of s[0..n-1] in {1..K}^n
	// require s[n]=s[n+1]=s[n+2]=0, n>=2
	static void suffixArray(int[] s, int[] SA, int n, int K) 
	{
		int n0=(n+2)/3, n1=(n+1)/3, n2=n/3, n02=n0+n2;
		int[] s12  = new int[n02 + 3];  s12[n02] = s12[n02+1] = s12[n02+2] = 0;
		int[] SA12 = new int[n02 + 3]; SA12[n02]=SA12[n02+1]=SA12[n02+2]=0;
		int[] s0   = new int[n0];
		int[] SA0  = new int[n0];
		for (int i=0, j=0; i < n + (n0 - n1); i++) if (i % 3 != 0) s12[j++] = i;
		radixPass(s12, SA12, s, n02, K, 2);
		radixPass(SA12, s12 , s, n02, K, 1);
		radixPass(s12, SA12, s, n02, K, 0);
		int name = 0, c0 = -1, c1 = -1, c2 = -1;
		for(int i = 0; i < n02; i++) 
		{
			if(s[SA12[i]] != c0 || s[SA12[i] + 1] != c1 || s[SA12[i] + 2] != c2) 
			{
				name++;
				c0 = s[SA12[i]];
				c1 = s[SA12[i] + 1];
				c2 = s[SA12[i] + 2];
			}
			if(SA12[i] % 3 == 1) s12[SA12[i] / 3] = name;
			else s12[SA12[i] / 3 + n0] = name;
		}
		if (name < n02) 
		{
			suffixArray(s12, SA12, n02, name);
			for (int i = 0; i < n02; i++) s12[SA12[i]] = i + 1;
		} 
		else for(int i = 0; i < n02; i++) SA12[s12[i] - 1] = i;
		for (int i = 0, j = 0; i < n02; i++) if (SA12[i] < n0) s0[j++] = 3 * SA12[i];
		radixPass(s0, SA0, s, n0, K, 0);
		for(int p = 0,  t = n0 - n1,  k = 0;  k < n;  k++) 
		{
			int i = (SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2);
			int j = SA0[p];
			if (SA12[t] < n0 ? leq(s[i], s12[SA12[t] + n0], s[j], s12[j/3]) :
				leq(s[i],s[i+1],s12[SA12[t]-n0+1], s[j],s[j+1],s12[j/3+n0]))
			{
				SA[k] = i;
				t++;
				if (t == n02) for(k++; p < n0; p++, k++) SA[k] = SA0[p]; 
			} 
			else 
			{
				SA[k] = j;
				p++;
				if(p == n0) for(k++; t < n02; t++, k++) SA[k] = (SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2); 
			}
		}
	}
	
	static class SuffixArray
	{
		static int n;
		static int realSize;
		static final int[] g = new int[600100];
		static final int[] quien = new int[600100];
		static final int[] b = new int[600100];
		static final int[] sa = new int[600100];
		static final int[] lcp = new int[600100];
		static final int[] rmq = new int[600100 * 21];
		static final int[] aux = new int[600103];
		static final char[] t = new char[600100];
		static final int[][] integralImage = new int[60][600000];

		SuffixArray()
		{
			buildSA();
		}

		void buildSA()
		{
			for(int i = 0; i < n; i++)
				aux[i] = t[i];
			aux[n] = aux[n + 1] = aux[n + 2] = 0;
			suffixArray(aux, sa, n, 230);
			buildLCP();
			buildRMQ();
			buildII();
		}

		void buildLCP()
		{
			int[] a = sa;
			int h = 0;
			for(int i = 0; i < n; i++) b[a[i]] = i;
			for(int i = 0; i < n; i++) 
			{
				if (b[i] != 0)
				{
					for(int j = a[b[i] - 1]; j + h < n && i + h < n && t[j + h] == t[i + h]; ++h);
					lcp[b[i]] = h;
				} 
				else lcp[b[i]] = -1;
				if(h > 0) --h;
			}
		}

		void buildRMQ() 
		{
			int[] b = rmq; 
			System.arraycopy(lcp, 0, b, 0, n);
			int delta = 0;
			for(int k = 1; k < n; k *= 2) 
			{
				System.arraycopy(b, delta, b, n + delta, n);
				delta += n;
				for(int i = 0; i < n - k; i++) b[i + delta] = Math.min(b[i + delta], b[i + k + delta]);
			}
		}
		
		static final int temp[] = new int[60];
		
		void buildII()
		{
			final int tam = n - nn;
			final int n = nn;
			for(int i = 0; i < n; i++)
			{
				temp[i] = 0;
			}
			for(int i = 0; i < tam; i++)
			{
				temp[quien[sa[i]]]++;
				for(int j = 0; j < n; j++)
					integralImage[j][i] = temp[j];
			}
		}
		
		long generateII(int a, int b)
		{

			final int tam = nn;
			for(int i = 0; i < tam; i++)
				temp[i] = integralImage[i][b];
			if(a != 0)
			{
				final int a1 = a - 1;
				for(int i = 0; i < tam; i++)
					temp[i] -= integralImage[i][a1];
			}
			long res = 0;
			for(int i = 0; i < tam; i++)
				if(temp[i] > 0)
					res |= 1L << i;
			return res;
		}
		
		void solve(int a, int b, int actual, boolean agregar)
		{
			if(a >= b || a == realSize)
				return;
			if(agregar)
				sets.add(generateII(a, b));
			int a1 = a;
			int b1 = b;
			while(a1 < b1)
			{
				int mid = a1 + b1;
				mid >>= 1;
				if(a1 == mid)
					break;
				int res = lcp(a, mid);
				if(res > actual)
					a1 = mid;
				else
					b1 = mid - 1;
			}
			if(b1 > a1)
			{
				int res = lcp(a, b1);
				if(res > actual)
					a1 = b1;
			}		
			cola.addFirst(new Query(a1 + 1, b, actual, false));
			cola.addFirst(new Query(a, a1, lcp(a, a1), true));
		}

		// longest common prefix between suffixes sa[x] and sa[y]
		int lcp(int x, int y)
		{
			return x == y ? n - sa[x] : x > y ? minimum(y + 1, x) : minimum(x + 1, y);
		}
		
		// range minimum query of lcp array
		int minimum(int x, int y) 
		{
			int z = y - x, k = 0, e = 1, s;
			s = (((z & 0xffff0000) != 0) ? 1 : 0) << 4; z >>= s; e <<= s; k |= s;
			s = (((z & 0x0000ff00) != 0) ? 1 : 0) << 3; z >>= s; e <<= s; k |= s;
			s = (((z & 0x000000f0) != 0) ? 1 : 0) << 2; z >>= s; e <<= s; k |= s;
			s = (((z & 0x0000000c) != 0) ? 1 : 0) << 1; z >>= s; e <<= s; k |= s;
			s = (((z & 0x00000002) != 0) ? 1 : 0) << 0; z >>= s; e <<= s; k |= s;
			return Math.min(rmq[x + n * k], rmq[y + n * k - e + 1]);
		}

		class Query
		{
			int a;
			int b;
			int actual;
			boolean agregar;
			
			public Query(int a, int b, int actual, boolean agregar) 
			{
				this.a = a;
				this.b = b;
				this.actual = actual;
				this.agregar = agregar;
			}
		}
		
		static LinkedList <Query> cola;
		
		public void solveAll() 
		{
			cola = new LinkedList <Query> ();
			cola.add(new Query(0, realSize, 0, false));
			while(!cola.isEmpty())
			{
				Query actual = cola.poll();
				solve(actual.a, actual.b, actual.actual, actual.agregar);
			}
		}
	}
	
	static int nn;
	static final HashSet <Long> sets = new HashSet <Long> ();
	static final HashSet <String> palabras = new HashSet <String> ();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			sets.clear();
			palabras.clear();
			int tamActual = 0;
			char indicadorActual = 150;
			for(int i = 0; i < n; i++)
				palabras.add(sc.next());
			nn = palabras.size();
			int actual = 0;
			for(String siguiente : palabras)
			{
				final int tam = tamActual + siguiente.length();
				siguiente.getChars(0, siguiente.length(), SuffixArray.t, tamActual);
				for(int j = tamActual; j < tam; j++)
					SuffixArray.quien[j] = actual;
				tamActual += siguiente.length();
				SuffixArray.t[tamActual] = indicadorActual++;
				SuffixArray.quien[tamActual++] = -1;
				actual++;
			}
			SuffixArray.n = tamActual;
			SuffixArray.realSize = tamActual - palabras.size() - 1;
			actual = 0;
			for(String s : palabras)
			{
				boolean esta = false;
				for(String s1 : palabras)
				{
					if(s.equals(s1))
						continue;
					if(s1.contains(s))
						esta = true;
				}
				if(!esta)
					sets.add(1L << actual);
				actual++;
			}
			new SuffixArray().solveAll();
			System.out.println(Math.max(1, sets.size()));
		}
	}
}