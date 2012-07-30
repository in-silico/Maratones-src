import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
	
	static boolean leq(int a1, int a2,   int b1, int b2) 
	{
		return(a1 < b1 || a1 == b1 && a2 <= b2);
	}             

	static boolean leq(int a1, int a2, int a3, int b1, int b2, int b3) 
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
		final int n;
		final int[] g, b, sa, lcp, rmq, aux, ii;
		final static int[] gg = new int[262144], bb = new int[262144], sasa = new int[262144], lcplcp = new int[262144], rmqrmq = new int[262144 * 18], auxaux = new int[262144], iiii = new int[262144];
		final static Prefijo [] entradasentradas = new Prefijo[100001];
		final Prefijo [] entradas;
		final static boolean[] esSufijoesSufijo = new boolean[262144];
		final boolean[] esSufijo;
		final char[] t;
		final static Prefijo [] dfsdfs = new Prefijo[100001];
		final Prefijo [] dfs;
		final static int[] dfsLdfsL = new int[100001];
		final int [] dfsL;

		SuffixArray(char[] entrada, int tam)
		{
			ks = ksks;
			es = eses;
			n = tam;
			g = gg;
			b = bb;
			sa = sasa;
			lcp = lcplcp;
			aux = auxaux;
			ii = iiii;
			esSufijo = esSufijoesSufijo;
			dfs = dfsdfs;
			dfsL = dfsLdfsL;
			rmq = rmqrmq;
			entradas = entradasentradas;
			for(int i = 0; i < n; i++)
				esSufijo[i] = false;
			t = entrada;
			buildSA(entrada, tam);
		}

		void buildSA(char[] sas, int tam)
		{
			for(int i = 0; i < n; i++)
				aux[i] = t[i];
			aux[n] = aux[n + 1] = aux[n + 2] = 0;
			suffixArray(aux, sa, n, diff + 200);
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
		
		long solve(TreeSet <Prefijo> prefijos)
		{
			prefijos.toArray(entradas);
			final int tam = prefijos.size();
			final int numeroSufijos = ii[n - 1];
			long cuenta = numeroSufijos;
			cuenta *= tam;
			int actual = 0;
			int lcp = 0;
			Prefijo anterior = null;
			for(int i = 0; i < tam; i++)
			{
				if(anterior == null)
				{
					anterior = entradas[i];
					dfs[0] = anterior;
					dfsL[0] = 0;
					actual = 1;
				}
				else
				{
					Prefijo siguiente = entradas[i];
					int akl = anterior.tam;
					int skl = siguiente.tam;
					int svi = siguiente.padre.inicio;
					int res = lcp(b[anterior.padre.inicio], b[svi]);
					if(akl < res)
						res = akl;
					if(skl < res)
						res = skl;
					if(res > lcp)
					{
						dfs[actual] = siguiente;
						dfsL[actual++] = res;
						int temp1 = b[svi + akl];
						int temp2 = skl - res;
						cuenta -= binarySearch(temp1, n - 1, temp2);
						cuenta += binarySearch2(temp1, n - 1, temp2);
						anterior = siguiente;
						lcp = res;
					}
					else
					{
						while(actual >= 1 && dfsL[actual - 1] >= res)
							actual--;
						anterior = actual == 0 ? null : dfs[actual - 1];
						lcp = actual == 0 ? 0 : dfsL[actual - 1];
						i--;
					}
				}
			}
			return cuenta;
		}
		
		void buildII() 
		{
			for(int i = 0; i < s; i++)
			{
				final int inicio = sufijos[i].inicio;
				final int tam = sufijos[i].p.length();
				for(int j = inicio; j < inicio + tam; j++)
					esSufijo[j] = true;
			}
			int cuenta = 0;
			for(int i = 0; i < n;)
			{
				ii[i] = cuenta;
				boolean algunSufijo = esSufijo[sa[i]];
				int j = i + 1;
				if(j == n)
				{
					ii[i] = algunSufijo ? ++cuenta : cuenta;
					break;
				}
				int l = lcp[j];
				while(j < n && lcp[j] == l && t[sa[j] + lcp[j]] < diff)
				{
					ii[j] = cuenta;
					algunSufijo |= esSufijo[sa[j]];
					j++;
				}
				if(algunSufijo)
					cuenta++;
				ii[j - 1] = cuenta;
				i = j;
			}
		}
		
		int binarySearch(int a, int b, int actual)
		{
			int a1 = a;
			int b1 = b;
			while(a1 < b1)
			{
				int mid = a1 + b1;
				mid >>= 1;
				if(a1 == mid)
				{
					if(lcp(a, b1) < actual)
						b1 = a1;
					break;
				}
				int res = lcp(a, mid);
				if(res >= actual)
					a1 = mid;
				else
					b1 = mid - 1;
			}
			int a2 = 0;
			int b2 = a;
			while(a2 < b2)
			{
				int mid = a2 + b2;
				mid >>= 1;
				if(a2 == mid)
				{
					if(lcp(a, a2) < actual)
						a2 = b2;
					break;
				}
				int res = lcp(a, mid);
				if(res >= actual)
					b2 = mid;
				else
					a2 = mid + 1;
			}
			return a2 == 0 ? ii[b1] : ii[b1] - ii[a2 - 1];
		}
		
		int binarySearch2(int a, int b, int actual)
		{
			int a2 = 0;
			int b2 = a;
			if(t[sa[a] + actual] < diff)
				a2 = a;
			else
			{
				while(a2 < b2)
				{
					int mid = a2 + b2;
					mid >>= 1;
					if(a2 == mid)
						break;
					int res = lcp(a, mid);
					if(res == actual && t[sa[mid] + actual] < diff)
					{
						a2 = mid;
						break;
					}
					else if(res < actual)
						a2 = mid + 1;
					else
						b2 = mid;
				}
			}
			if(!((a == a2 || lcp(a, a2) == actual) && t[sa[a2] + actual] < diff))
				return 0;
			int a1 = a2;
			int b1 = b;
			while(a1 < b1)
			{
				int mid = a1 + b1;
				mid >>= 1;
				if(a1 == mid)
					break;
				int res = lcp(a, mid);
				if(res == actual && t[sa[mid] + actual] < diff)
					a1 = mid;
				else
					b1 = mid - 1;
			}
			if(!((a == b1 || lcp(a, b1) == actual) && t[sa[b1] + actual] < diff))
				if((a == a1 || lcp(a, a1) == actual) && t[sa[a1] + actual] < diff)
					b1 = a1;
			return a2 == 0 ? ii[b1] : ii[b1] - ii[a2 - 1];
		}

		// longest common prefix between suffixes sa[x] and sa[y]
		int lcp(int x, int y)
		{
			return x == y ? n - sa[x] : x > y ? minimum(y + 1, x) : minimum(x + 1, y);
		}
		
		static final int[] ksks = new int[262144];
		static final int[] eses = new int[262144];
		final int[] ks;
		final int[] es;
		
		static void precalcular()
		{
			for(int i = 0; i < 262144; i++)
			{
				int z = i, k = 0, e = 1, s;
				s = (((z & 0xffff0000) != 0) ? 1 : 0) << 4; z >>= s; e <<= s; k |= s;
				s = (((z & 0x0000ff00) != 0) ? 1 : 0) << 3; z >>= s; e <<= s; k |= s;
				s = (((z & 0x000000f0) != 0) ? 1 : 0) << 2; z >>= s; e <<= s; k |= s;
				s = (((z & 0x0000000c) != 0) ? 1 : 0) << 1; z >>= s; e <<= s; k |= s;
				s = (((z & 0x00000002) != 0) ? 1 : 0) << 0; z >>= s; e <<= s; k |= s;
				ksks[i] = k;
				eses[i] = e;
			}
		}
		
		// range minimum query of lcp array
		int minimum(int x, int y) 
		{
			int z = y - x;
			int nk = n * ks[z];
			int a = rmq[x + nk];
			int b = rmq[y + nk - es[z] + 1];
			return a < b ? a : b;
		}
	}
	
	static class Prefijo implements Comparable <Prefijo>
	{
		final Palabra padre;
		final String prefijo;
		final int tam;
		
		public Prefijo(Palabra p, String pref)
		{
			padre = p;
			prefijo = pref;
			tam = prefijo.length();
		}

		@Override
		public int compareTo(Prefijo o) 
		{
			if(o.padre == padre)
				return tam - o.tam;
			else
				return prefijo.compareTo(o.prefijo);
		}
	}
	
	static class Palabra
	{
		String p;
		int inicio;
		
		public Palabra(String p) 
		{
			this.p = p;
		}
	}

	static final Palabra[] sufijos = new Palabra[1001];
	static final Palabra[] prefijos = new Palabra[1001];
	static SuffixArray sa;
	static int p, s;
	static int diff;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		TreeSet <Prefijo> prefijosT = new TreeSet <Prefijo> ();
		char[] prefijosSufijos = new char[300000];
		SuffixArray.precalcular();
		while(true)
		{
			prefijosT.clear();
			p = sc.nextInt();
			s = sc.nextInt();
			if(p == 0 && s == 0)
				return;
			for(int i = 0; i < p; i++)
			{
				String port = sc.nextLine();
				Palabra nueva = new Palabra(port);
				for(int j = 1; j <= port.length(); j++)
					prefijosT.add(new Prefijo(nueva, port.substring(0, j)));
				prefijos[i] = nueva;
			}
			for(int i = 0; i < s; i++)
			{
				String esp = sc.nextLine();
				sufijos[i] = new Palabra(esp);
			}
			int posicionActual = 0;
			for(int i = 0; i < p; i++)
			{
				prefijos[i].inicio = posicionActual;
				prefijos[i].p.getChars(0, prefijos[i].p.length(), prefijosSufijos, posicionActual);
				posicionActual += prefijos[i].p.length();
				prefijosSufijos[posicionActual++] = 0;
			}
			for(int i = 0; i < s; i++)
			{
				sufijos[i].inicio = posicionActual;
				sufijos[i].p.getChars(0, sufijos[i].p.length(), prefijosSufijos, posicionActual);
				posicionActual += sufijos[i].p.length();
				prefijosSufijos[posicionActual++] = 0;
			}
			diff = (p + s) + 2;
			char indicadorActual = 0;
			for(int i = 0; i < posicionActual; i++)
			{
				if(prefijosSufijos[i] == 0)
					prefijosSufijos[i] = indicadorActual++;
				else
					prefijosSufijos[i] += diff;
			}
			sa = new SuffixArray(prefijosSufijos, posicionActual);
			System.out.println(sa.solve(prefijosT));
		}
	}
}
