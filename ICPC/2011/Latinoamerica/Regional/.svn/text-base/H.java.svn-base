import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class H 
{
	static class Scanner
	{
		char[] buffer;
		InputStreamReader isr;
		int p;
		int start;
		
		public Scanner()
		{
			System.setOut(new PrintStream(new BufferedOutputStream(System.out, 1000000), false));
			buffer = new char[6000001];
			isr = new InputStreamReader(System.in);
			read(0);
		}
		
		void read(int init)
		{
			try
			{
				int tam;
				if((tam = isr.read(buffer, init, buffer.length - init)) < buffer.length - init)
				{
					if(tam < 0)
						tam = 0;
					buffer[tam] = '\0';
				}
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
		
		public void readNext()
		{
			int tam = buffer.length;
			int pos = p;
			while(pos < tam && buffer[pos] <= ' ')
				pos++;
			if(pos == tam)
			{
				read(0);
				readNext();
				return;
			}
			start = pos;
			while(pos < tam && buffer[pos] > ' ')
				pos++;
			if(pos == tam)
			{
				System.arraycopy(buffer, start, buffer, 0, buffer.length - start);
				read(buffer.length - start);
				p = start;
				readNext();
				return;
			}
			else
				p = pos;
		}
		
		public String next()
		{
			readNext();
			return new String(buffer, start, p - start);
		}
		
		
		public long nextLong()
        {
			readNext();
            int d = start;
            int pos = p;
            long r = 0;
            boolean n = buffer[d] == '-';
            if(n)
            	d++;
            r -= buffer[d++] - '0';
            while (d < pos && (r = (r << 1) + (r << 3)) <= 0)
                    r -= buffer[d++] - '0';
            return n ? r : -r;
        }
		
		public int nextInt()
		{
			return (int) nextLong();
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			int tam = buffer.length;
			int pos = p;
			while(pos < tam && buffer[pos] != '\n')
				pos++;
			if(pos == tam)
			{
				read(0);
				return nextLine();
			}
			start = ++pos;
			while(pos < tam && buffer[pos] != '\n')
				pos++;
			if(pos >= tam)
			{
				System.arraycopy(buffer, start, buffer, 0, buffer.length - start);
				read(buffer.length - start);
				return nextLine();
			}
			p = pos;
			return new String(buffer, start, p - start);
		}
		
		public boolean EOF()
		{
			int tam = buffer.length;
			int pos = p;
			while(pos < tam && buffer[pos] <= ' ')
				if(buffer[pos++] == '\0')
					return true;
			pos++;
			if(pos >= tam)
			{
				if(p == 0)
					return false;
				System.arraycopy(buffer, p, buffer, 0, buffer.length - p);
				read(buffer.length - p);
				p = 0;
				return EOF();
			}
			return false;
		}
	}
	
    static class DisjointSet
    {
            int[] p, rank;

            public DisjointSet(int size)
            {
                    rank = new int[size];
                    p = new int[size];
                    clear(size);
            }
            
            public void clear(int r)
            {
                for(int i = 0; i < r; i++)
                    make_set(i);
            }

            public void make_set(int x)
            {
                    p[x] = x;
                    rank[x] = 0;
            }

            public void merge(int x, int y)
            {
                    link(find_set(x), find_set(y));
            }

            public void link(int x, int y)
            {
                    if(rank[x] > rank[y])
                            p[y] = x;
                    else
                    {
                            p[x] = y;
                            if (rank[x] == rank[y])
                                    rank[y] += 1;
                    }
            }

            public int find_set(int x)
            {
                    if (x != p[x])
                            p[x] = find_set(p[x]);
                    return p[x];
            }
    }


	 
	static class Nodo
	{
		ArrayList <Nodo> adjacentes = new ArrayList <Nodo> ();
		int n;
		int nivel;
		Nodo parent;
		Nodo lastParent;
		boolean visited = false;
		boolean poisoned = false;
		
		public Nodo(int nn)
		{
			n = nn;
		}
	}
	
	static final Nodo[] qq = new Nodo[100001];
	static final Nodo[] tempt = new Nodo[10001];

	static void dfs(Nodo root)
	{
		final Nodo[] q = qq;
		final Nodo[] temp = tempt;
		root.nivel = 0;
		q[0] = root;
		int tam = 1;
		while(tam != 0)
		{
			Nodo x = q[--tam];
			if(x.visited)
				continue;
			x.visited = true;
			for(Nodo y : x.adjacentes)
			{
				if(x.parent == y)
					continue;
				if(!y.visited)
				{
					y.parent = x;
					y.lastParent = x;
					y.nivel = x.nivel + 1;
					q[tam++] = y;
				}
				else
				{
					int tamt = 0;
					Nodo k = x;
					while(k != null && (k != y && k.nivel > y.nivel))
					{
						temp[tamt++] = k;
						k.poisoned = true;
						k = k.lastParent;
					}
					for(int i = 0; i < tamt; i++)
						temp[i].lastParent = k;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Nodo[] nodos = new Nodo[10001];
		Scanner sc = new Scanner();
		for(int i = 1; i <= 10000; i++)
			nodos[i] = new Nodo(i);
		DisjointSet ds = new DisjointSet(10001);
		while(true)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			int q = sc.nextInt();
			if(r == 0)
			{
				System.out.flush();
				return;
			}
			for(int i = 1; i <= r; i++)
			{
				Nodo actual = nodos[i];
				actual.adjacentes.clear();
				actual.nivel = 0;
				actual.parent = null;
				actual.lastParent = null;
				actual.visited = false;
				actual.poisoned = false;
			}
			for(int i = 0; i < c; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				nodos[a].adjacentes.add(nodos[b]);
				nodos[b].adjacentes.add(nodos[a]);
			}
			ds.clear(r + 1);
			for(int i = 1; i <= r; i++)
			{
				if(nodos[i].visited)
				{
					if(!nodos[i].poisoned)
						ds.merge(i, nodos[i].parent.n);
				}
				else
					dfs(nodos[i]);
			}
			for(int i = 0; i < q; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(ds.find_set(a) == ds.find_set(b))
					System.out.println("Y");
				else
					System.out.println("N");
			}
			System.out.println("-");
		}
	}
}
