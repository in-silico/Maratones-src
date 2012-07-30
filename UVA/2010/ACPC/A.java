import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class A 
{
	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(Exception e)
				{
					throw new RuntimeException(e.getMessage());
				}
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public long nextLong()
		{
			return Long.parseLong(next());
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			ArrayDeque <Integer> lista = new ArrayDeque <Integer> ();
			for(int i = 0; i < n; i++)
				lista.add(sc.nextInt());
			if(n == 1)
			{
				System.out.println();
				continue;
			}
			StringBuilder sb = new StringBuilder();
			int limite = 2 * n * n;
			for(int i = 0; i < limite; i++)
			{
				int a = lista.peekFirst();
				lista.poll();
				int b = lista.peek();
				lista.addFirst(a);
				if(a == n && b == 1)
				{
					lista.addFirst(lista.pollLast());
					sb.append(2);
					i++;
					if(i > limite)
						break;
					lista.addFirst(lista.pollLast());
					sb.append(2);
				}
				else
				{
					if(a > b)
					{
						lista.poll();
						lista.poll();
						lista.addFirst(a);
						lista.addFirst(b);
						sb.append(1);
						i++;
						if(i > limite)
							break;
//						if(ordenada(lista))
//							break;
					}
					lista.addFirst(lista.pollLast());
					sb.append(2);
				}
			}
			int numero = 0;
			for(int i : lista)
			{
				if(i == 1)
					break;
				else
					numero++;
			}
			for(int i = 0; i < numero; i++)
				sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.reverse());
		}
	}
}
