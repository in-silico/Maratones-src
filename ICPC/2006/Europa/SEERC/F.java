import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class F {
	
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
	
	
	public static void main(String args[]) throws IOException
	{
		System.setIn(new FileInputStream("f.in"));
		long tiempo = System.currentTimeMillis(); 
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		
		DisjointSet ds=new DisjointSet(6000005);
			
		String cad;
		StringTokenizer tk;
		String cmd;
		int n1;
		int src, dst, nnn, dststep, srcstep;
		int nconnected,nunconnected;
		while(true)
		{
			cad=rd.readLine();
			if (cad==null)
			{
				System.out.println(System.currentTimeMillis() - tiempo);
				break;
			}
			tk=new StringTokenizer(cad);
			nconnected=0;
			nunconnected=0;
			cmd=tk.nextToken();
			if (cmd.equals("D")||cmd.equals("d"))
			{
				n1=Integer.valueOf(tk.nextToken());
				for(int i=0;i<=n1;i++)
				{
					ds.make_set(i);
				}
				continue;
			}
			src=Integer.valueOf(tk.nextToken());
			dst=Integer.valueOf(tk.nextToken());
			if (tk.hasMoreTokens()==false)
			{
				if (cmd.equals("Q")||cmd.equals("q"))
				{
					if (ds.find_set(src)==ds.find_set(dst))
						System.out.println("1 - 0");
					else
						System.out.println("0 - 1");
				}
				else
				{
					ds.merge(src, dst);
				}
				continue;
			}
			
			nnn=Integer.valueOf(tk.nextToken());
			if (tk.hasMoreTokens()==false)
			{
				if (cmd.equals("Q")||cmd.equals("q"))
				{
					for(int i=0;i<nnn;i++)
					{
						if (ds.find_set(src)==ds.find_set(dst+i))
							nconnected++;
						else
							nunconnected++;
					}
					System.out.println(String.valueOf(nconnected)+" - "+String.valueOf(nunconnected));
				}
				else
				{
					for(int i=0;i<nnn;i++)
					{
						ds.merge(src, dst+i);
					}
				}
				continue;
			}
			
			dststep=Integer.valueOf(tk.nextToken());
			
			if (tk.hasMoreTokens()==false)
			{
				if (cmd.equals("Q")||cmd.equals("q"))
				{
					for(int i=0;i<nnn;i++)
					{
						if (ds.find_set(src)==ds.find_set(dst+(i*dststep)))
							nconnected++;
						else
							nunconnected++;
					}
					System.out.println(String.valueOf(nconnected)+" - "+String.valueOf(nunconnected));
				}
				else
				{
					for(int i=0;i<nnn;i++)
					{
						ds.merge(src, dst+(i*dststep));
					}
				}
				continue;
			}
			
			srcstep=Integer.valueOf(tk.nextToken());
			

			if (cmd.equals("Q")||cmd.equals("q"))
			{
				for(int i=0;i<nnn;i++)
				{
					if (ds.find_set(src+(i*srcstep))==ds.find_set(dst+(i*dststep)))
						nconnected++;
					else
						nunconnected++;
				}
				System.out.println(String.valueOf(nconnected)+" - "+String.valueOf(nunconnected));
			}
			else
			{
				for(int i=0;i<nnn;i++)
				{
					ds.merge(src+(i*srcstep), dst+(i*dststep));
				}
			}
		}
		
	}

}
