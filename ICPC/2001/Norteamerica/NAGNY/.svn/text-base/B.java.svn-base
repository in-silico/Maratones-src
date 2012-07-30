import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class B 
{	
	static class Punto implements Comparable <Punto>
	{
		int x, y, distancia, in_q = 0;
		
		public Punto(int xNuevo, int yNuevo, int i) 
		{
			x = xNuevo;
			y = yNuevo;
			distancia = i;
		}

		@Override
		public int compareTo(Punto o) 
		{
			return Integer.valueOf(distancia).compareTo(o.distancia);
		}
	}
	
	static char[][] mundoA = new char[50][];
	static int[][] mundo = new int[50][50];
	static int[][] adjacencias = new int[102][102];
	static ArrayList <Punto> todos = new ArrayList <Punto> (101);
	static boolean[][] visitados = new boolean[50][50];
	static int[][] difs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Punto longitud;
	static ArrayList <Punto> aristas = new ArrayList <Punto> (101 * 101);
	static int[] conexiones = new int[102];
	
	public static void llenarAdjacencias()
	{
		LinkedList <Punto> cola = new LinkedList <Punto> ();
		int ii = 1;
		for(Punto p : todos)
		{
			for(int i = 0; i < longitud.x; i++)
				for(int j = 0; j < longitud.y; j++)
					visitados[i][j] = false;
			p.distancia = 0;
			cola.add(p);
			visitados[p.x][p.y] = true;
			while(!cola.isEmpty())
			{
				Punto actual = cola.pollFirst();
				if(mundo[actual.x][actual.y] > 0)
				{
					adjacencias[ii][mundo[actual.x][actual.y]] = actual.distancia;
				}
				for(int[] a : difs)
				{
					int xNuevo = actual.x + a[0];
					int yNuevo = actual.y + a[1];
					if(xNuevo >= 0 && xNuevo < longitud.x && yNuevo >= 0 && yNuevo < longitud.y && mundo[xNuevo][yNuevo] >= 0 && !visitados[xNuevo][yNuevo])
					{
						visitados[xNuevo][yNuevo] = true;
						cola.add(new Punto(xNuevo, yNuevo, actual.distancia + 1));
					}
				}
			}
			ii++;
		}
	}
	
	public static int prim()
	{
		aristas.clear();
		for(int i = 0; i < todos.size(); i++)
		{
			for(int j = i + 1; j < todos.size(); j++)
			{
				aristas.add(new Punto(i + 1, j + 1, adjacencias[i + 1][j + 1]));
			}
			conexiones[i + 1] = 0;
		}
		Collections.sort(aristas);
		todos.get(0).in_q = 1;
		int suma = 0;
		for(int i = 0; i < todos.size(); i++)
		{
			for(Punto a : aristas)
			{
				if(conexiones[a.x] <= 2 && todos.get(a.x - 1).in_q == 1 && todos.get(a.y - 1).in_q == 0)
				{
					todos.get(a.y - 1).in_q = 1;
					conexiones[a.x]++;
					suma += a.distancia;
					break;
				}
				else if(conexiones[a.y] <= 2 && todos.get(a.y - 1).in_q == 1 && todos.get(a.x - 1).in_q == 0)
				{
					todos.get(a.x - 1).in_q = 1;
					conexiones[a.y]++;
					suma += a.distancia;
					break;
				}
			}
		}
		return suma;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String[] pedazos = br.readLine().split(" ");
			int y = Integer.parseInt(pedazos[0]);
			int x = Integer.parseInt(pedazos[1]);
			longitud = new Punto(x, y, -1);
			int cuenta = 2;
			todos.clear();
			for(int j = 0; j < x; j++)
			{
				mundoA[j] = br.readLine().toCharArray();
				for(int k = 0; k < y; k++)
				{
					if(mundoA[j][k] == '#')
						mundo[j][k] = -1;
					if(mundoA[j][k] == 'A')
					{
						mundo[j][k] = cuenta++;
						todos.add(new Punto(j, k, -1));
					}
					if(mundoA[j][k] == 'S')
					{
						mundo[j][k] = 1;
						todos.add(0, new Punto(j, k, -1));
					}
					if(mundoA[j][k] == ' ')
						mundo[j][k] = 0;
				}
			}
			llenarAdjacencias();
			System.out.println(prim());
		}
	}

}
