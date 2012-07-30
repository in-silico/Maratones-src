import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class A
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
	}
	
	static LinkedList <Character> caracteres = new LinkedList <Character> ();
	
	static String funcion()
	{
		char primero = caracteres.poll();
		if(primero == '(')
		{
			StringBuilder sb = new StringBuilder();
			char actual = caracteres.poll();
			while(actual < '0' || actual > '9')
			{
				if(actual == '(')
				{
					caracteres.push('(');
					sb.append(funcion());
				}
				else
				{
					sb.append(actual);
				}
				actual = caracteres.poll();
			}
			String num = "";
			while(actual >= '0' && actual <= '9')
			{
				num += actual;
				actual = caracteres.poll();
			}
			caracteres.push(actual);
			int numero = Integer.parseInt(num);
			StringBuilder sb1 = new StringBuilder();
			for(int i = 0; i < numero; i++)
				sb1.append(sb);
			caracteres.poll();
			return sb1.toString();
		}
		else
		{
			return primero + "";
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			String entrada = sc.nextLine();
			if(entrada.equals("$"))
				return;
			else
			{
				caracteres.clear();
				for(char c : entrada.toCharArray())
					if(c != ' ')
						caracteres.add(c);
				System.out.println(funcion());
			}
		}
	}
}
