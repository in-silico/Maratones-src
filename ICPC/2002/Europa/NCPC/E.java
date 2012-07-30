import java.util.PriorityQueue;
import java.util.Scanner;


public class E
{
	static class Entrada implements Comparable <Entrada>
	{
		int cost;
		int number;
		
		public Entrada(int cost, int number) 
		{
			this.cost = cost;
			this.number = number;
		}

		@Override
		public int compareTo(Entrada o)
		{
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int caso = 0; caso < tc; caso++)
		{
			final int l = sc.nextInt();
			int nOp = sc.nextInt();
			int nW = sc.nextInt();
			String[] ops = new String[nOp];
			int[] costs = new int[nOp];
			for(int i = 0; i < nOp; i++)
			{
				ops[i] = new StringBuilder(sc.next()).reverse().toString();
				costs[i] = sc.nextInt();
			}
			int[] visited = new int[1 << l];
			for(int i = 0; i < nW; i++)
			{
				for(int j = 0; j < 1 << l; j++)
					visited[j] = Integer.MAX_VALUE;
				String a = sc.next();
				String b = sc.next();
				while(a.length() > 1 && a.charAt(0) == '0')
					a = a.substring(1);
				while(b.length() > 1 && b.charAt(0) == '0')
					b = b.substring(1);
				int inicio = Integer.parseInt(a, 2);
				int objetivo = Integer.parseInt(b, 2);
				visited[inicio] = 0;
				PriorityQueue <Entrada> pq = new PriorityQueue <Entrada> ();
				pq.add(new Entrada(0, inicio));
				boolean paila = true;
				while(!pq.isEmpty())
				{
					Entrada actual = pq.poll();
					if(visited[actual.number] > actual.cost)
						continue;
					if(actual.number == objetivo)
					{
						System.out.print((i == 0 ? "" : " ") + actual.cost);
						paila = false;
						break;
					}
					for(int j = 0; j < nOp; j++)
					{
						int nuevo = actual.number;
						for(int k = 0; k < l; k++)
						{
							boolean puesto = ((actual.number >> k) & 1) == 1;
							if(ops[j].charAt(k) == 'F')
							{
								if(puesto)
									nuevo -= 1 << k;
								else
									nuevo += 1 << k;
							}
							else if(ops[j].charAt(k) == 'S')
							{
								if(!puesto)
									nuevo += 1 << k;
							}
							else if(ops[j].charAt(k) == 'C')
								if(puesto)
									nuevo -= 1 << k;
						}
						if(visited[nuevo] <= actual.cost + costs[j])
							continue;
						visited[nuevo] = actual.cost + costs[j];
						pq.add(new Entrada(actual.cost + costs[j], nuevo));
					}
				}
				if(paila)
					System.out.print(i == 0 ? "NP" : " NP");
			}
			System.out.println();
		}
	}

}
