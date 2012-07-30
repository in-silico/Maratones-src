import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class G
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
	
	static class Entrada
	{
		Entrada anterior;
		int cajaI;
		int cajaJ;
		int i;
		int j;
		int pasos;
		
		public Entrada(int cajaI, int cajaJ, int i, int j) 
		{
			this.cajaI = cajaI;
			this.cajaJ = cajaJ;
			this.i = i;
			this.j = j;
		}

		public void generarHijos() 
		{
			generarHijo(i + 1, j, 1, 0);
			generarHijo(i - 1, j, -1, 0);
			generarHijo(i, j + 1, 0, 1);
			generarHijo(i, j - 1, 0, -1);
		}

		private void generarHijo(int ii, int jj, int deltaI, int deltaJ)
		{	
			if(ii < 0 || ii >= n || jj < 0 || jj >= m || mapa[ii][jj] == '#' || ((cajaI != ib || cajaJ != jb) && (ii == id && jj == jd)))
				return;
			if(cajaI == ii && cajaJ == jj)
			{
				ponerCaja(ii, jj, ii + deltaI, jj + deltaJ);
			}
			else
			{
				Entrada nueva = new Entrada(cajaI, cajaJ, ii, jj);
				nueva.pasos = pasos + 1;
				if(!visitados[cajaI][cajaJ][ii][jj])
				{
					visitados[cajaI][cajaJ][ii][jj] = true;
					cola.add(nueva);
				}
			}
		}

		private void ponerCaja(int ic, int jl, int ii, int jj) 
		{
			if(ii < 0 || ii >= n || jj < 0 || jj >= m || mapa[ii][jj] == '#' || (ii == id && jj == jd))
				return;
			Entrada nueva = new Entrada(ii, jj, ic, jl);
			nueva.pasos = pasos + 1;
			if(!visitados[ii][jj][ic][jl])
			{
				visitados[ii][jj][ic][jl] = true;
				cola.add(nueva);
			}
		}
	}
	static int n, m;
	static int ib, jb, id, jd, ia, ja, ix, jx;
	static char[][] mapa = new char[20][];
	static boolean[][][][] visitados = new boolean[20][20][20][20];
	static LinkedList <Entrada> cola = new LinkedList <Entrada> ();
	
	private static String bfs()
	{
		cola.clear();
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
				for(int k = 0; k < 20; k++)
					for(int l = 0; l < 20; l++)
						visitados[i][j][k][l] = false;
		Entrada inicial = new Entrada(ix, jx, ia, ja);
		visitados[ix][jx][ia][ja] = true;
		cola.add(inicial);
		while(!cola.isEmpty())
		{
			Entrada actual = cola.poll();
			if(actual.cajaI == ib && actual.cajaJ == jb && actual.i == id && actual.j == jd)
				return actual.pasos + "";
			actual.generarHijos();
		}
		return "No Way!";
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				mapa[i] = sc.next().toCharArray();
			}
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					if(mapa[i][j] == '@')
					{
						ia = i;
						ja = j;
					}
					if(mapa[i][j] == 'd')
					{
						id = i;
						jd = j;
					}
					if(mapa[i][j] == 'b')
					{
						ib = i;
						jb = j;
					}
					if(mapa[i][j] == 'x')
					{
						ix = i;
						jx = j;
					}
				}
			}
			System.out.println(bfs());
		}
	}
}
