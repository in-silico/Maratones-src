import java.util.LinkedList;
import java.util.Scanner;


public class Slikar 
{
	static int r, c;
	static boolean[][][] visitados = new boolean[2500][50][50];
	
	static class Entrada
	{
		int i;
		int j;
		int tiempo;
		
		public Entrada(int i, int j, int tiempo) 
		{
			super();
			this.i = i;
			this.j = j;
			this.tiempo = tiempo;
		}
	}
	static int[][] diffs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();
		char[][] mapa = new char[r][];
		for(int i = 0; i < r; i++)
			mapa[i] = sc.nextLine().trim().toCharArray();
		int iInicio = 0;
		int jInicio = 0;
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				if(mapa[i][j] == 'S')
				{
					iInicio = i;
					jInicio = j;
					mapa[i][j] = '.';
 				}
		char[][][] mapas = new char[2500][][];
		mapas[0] = mapa;
		LinkedList <Entrada> cola = new LinkedList <Entrada> ();
		cola.add(new Entrada(iInicio, jInicio, 0));
		visitados[0][iInicio][jInicio] = true;
		boolean paila = true;
		while(!cola.isEmpty())
		{
			Entrada actual = cola.poll();
			if(mapa[actual.i][actual.j] == 'D')
			{
				System.out.println(actual.tiempo);
				paila = false;
				break;
			}
			if(mapas[actual.tiempo] == null)
				mapas[actual.tiempo] = generarSiguiente(mapas[actual.tiempo - 1]);
			if(mapas[actual.tiempo][actual.i][actual.j] == '*' || mapas[actual.tiempo][actual.i][actual.j] == 'X')
				continue;
			for(int[] diff : diffs)
			{
				int iNuevo = actual.i + diff[0];
				int jNuevo = actual.j + diff[1];
				if(iNuevo >= 0 && iNuevo < r && jNuevo >= 0 && jNuevo < c && !visitados[actual.tiempo + 1][iNuevo][jNuevo])
				{
					visitados[actual.tiempo + 1][iNuevo][jNuevo] = true;
					cola.add(new Entrada(iNuevo, jNuevo, actual.tiempo + 1));
				}
			}
		}
		if(paila)
			System.out.println("KAKTUS");
	}
	
	static char[][] generarSiguiente(char[][] mapa)
	{
		char[][] nuevo = new char[r][c];
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				nuevo[i][j] = mapa[i][j];
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				if(mapa[i][j] == '*')
				{
					poner(nuevo, i - 1, j);
					poner(nuevo, i + 1, j);
					poner(nuevo, i, j + 1);
					poner(nuevo, i, j - 1);
				}
		return nuevo;
	}

	private static void poner(char[][] nuevo, int i, int j)
	{
		if(i < 0 || i >= r || j < 0 || j >= c)
			return;
		if(nuevo[i][j] != '.')
			return;
		nuevo[i][j] = '*';
	}
}