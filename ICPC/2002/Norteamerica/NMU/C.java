import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C
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
	
	static char[][] todos = new char[500][500];
	
	static void pintar(int delta, int tamano)
	{
		int actual = 1;
		int columna = delta + 2 * tamano;
		for(int fila = 0; fila < 2 * tamano; fila++)
		{
			for(int i = 0; i < actual; i++)
				todos[fila][i + columna] = '*';
			actual += 2;
			columna--;
		}
		for(int fila = 2 * tamano; fila < 3 * tamano; fila++)
			todos[fila][delta + 2 * tamano] = '*';
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0)
				return;
			for(int i = 0; i < 500; i++)
				for(int j = 0; j < 500; j++)
					todos[i][j] = ' ';
			pintar(-1, a);
			pintar(4 * a - 1, b);
			for(int i = 0; i < 500; i++)
			{
				String pos = new String(todos[i]);
				int ultima = pos.lastIndexOf('*');
				if(ultima == -1)
					break;
				System.out.println(pos.substring(0, ultima + 1));
			}
			System.out.println();
		}
	}

}
