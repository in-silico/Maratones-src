import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;






public class A {
	
	static class DisjointSet
	{
		int[] p, rank;

		public DisjointSet(int size)
		{
			rank = new int[size];
			p = new int[size];
			for(int i = 0; i < size; i++)
			{
				make_set(i);
			}
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
	
	static class arista implements Comparable<arista>
	{
		int a,b;
		int w;
		public arista(int a, int b,int w)
		{
			this.a=a;
			this.b=b;
			this.w=w;
		}
		@Override
		public int compareTo(arista o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
	
	static class nodo
	{
		int number;
		LinkedList<pair> vecinos=new LinkedList<pair>();
		public nodo(int a)
		{
			this.number=a;
		}
		
	}
	
	static class pair
	{
		int x;
		int w;
		public pair(int x,int w)
		{
			this.x=x;
			this.w=w;
		}
	}
	
	
	static nodo[]  nodos=new nodo[3005];
	static boolean[]  visitados=new boolean[3005];
	
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.valueOf(rd.readLine());
		StringTokenizer tk;
		int a,b,l;
		LinkedList<arista> aristas=new LinkedList<arista>();
		LinkedList<arista> MST=new LinkedList<arista>();
		DisjointSet DS=new DisjointSet(3005);
		for(int t=0;t<3005;t++)
		{
			nodos[t]=new nodo(t);
		}
		for(int t=0;t<T;t++)
		{
			tk=new StringTokenizer(rd.readLine());
			int N=Integer.valueOf(tk.nextToken());
			int R=Integer.valueOf(tk.nextToken());
			aristas.clear();
			MST.clear();
			for(int i=0;i<=N;i++)
			{
				DS.make_set(i);
				nodos[i].vecinos.clear();
			}
			for(int i=0;i<R;i++)
			{
				tk=new StringTokenizer(rd.readLine());
				a=Integer.valueOf(tk.nextToken());
				b=Integer.valueOf(tk.nextToken());
				l=Integer.valueOf(tk.nextToken());
				aristas.add(new arista(a,b,l));
			}
			Collections.sort(aristas);
			while(MST.size()<N-1)
			{
				arista actual=aristas.poll();
				if (DS.find_set(actual.a)!=DS.find_set(actual.b))
				{
					DS.merge(actual.a, actual.b);
					MST.add(actual);
					nodos[actual.a].vecinos.add(new pair(actual.b,actual.w));
					nodos[actual.b].vecinos.add(new pair(actual.a,actual.w));
				}
			}
			
			//
			int Q=Integer.valueOf(rd.readLine());
			System.out.println("Case "+String.valueOf(t+1));
			for(int i=0;i<Q;i++)
			{
				tk=new StringTokenizer(rd.readLine());
				int k=Integer.valueOf(tk.nextToken());
				int kk=Integer.valueOf(tk.nextToken());
				int res=visitar(k,-1,kk);
				System.out.println(res);
				
				
			}
			System.out.println();
				
			
		}
		
	}
	
	
	
	static int visitar(int actual, int anterior, int destino)
	{
		if (actual==destino)
			return 0;
		int mejor = -1;
		for(pair vecino: nodos[actual].vecinos)
		{
			if(vecino.x == anterior)
				continue;
			int temp = visitar(vecino.x, actual, destino);
			if(temp >= 0)
				temp = Math.max(temp, vecino.w);
			mejor = Math.max(mejor, temp);
		}
		return mejor;
	}
	
	

}
