import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


public class ygame 
{

	static class Nodo
	{
		int x = 0;
		int y = 0;
		int z = 0;
		int grupo = 0;
		
		ArrayList <Nodo> vecinos = new ArrayList <Nodo> ();
		
		
		public Nodo(int xx, int yy, int zz)
		{
			x = xx;
			y = yy;
			z = zz;
		}
	}
	
	static boolean xside = false;
	static boolean yside = false;
	static boolean zside = false;
	public static void main(String [] args) throws IOException
	{
		//System.setIn(new FileInputStream("ygame.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea = br.readLine()) != null)
		{
			String read =linea;
			String [] readA = read.split(" ");
			int n = Integer.parseInt(readA[0]);
			int m = Integer.parseInt(readA[1]);
			if(n == 0 && m == 0)
				return;
			int grupoActual = 1;
			ArrayList <Nodo> nodos = new ArrayList <Nodo> ();
			Nodo[][][] nodosOrden = new Nodo[n + 1][n + 1][n + 1];
			
			for(int i = 0; i < m; i++)
			{
				String [] readA1 = br.readLine().split(" ");
				int x = Integer.parseInt(readA1[0]);
				int y = Integer.parseInt(readA1[1]);
				int z = Integer.parseInt(readA1[2]);
				nodosOrden[x][y][z] = new Nodo(x, y, z);
				nodos.add(nodosOrden[x][y][z]);
			}
			for(Nodo actual : nodos)
			{
				try
				{
					actual.vecinos.add(nodosOrden[actual.x + 1][actual.y - 1][actual.z]);
				}
				catch(Exception e)
				{
				}
				try
				{
					actual.vecinos.add(nodosOrden[actual.x - 1][actual.y + 1][actual.z]);
				}
				catch(Exception e)
				{
				}
				try
				{
					actual.vecinos.add(nodosOrden[actual.x][actual.y + 1][actual.z - 1]);
				}
				catch(Exception e)
				{
				}
				try
				{
					actual.vecinos.add(nodosOrden[actual.x + 1][actual.y][actual.z - 1]);
				}
				catch(Exception e)
				{
				}
				try
				{
					actual.vecinos.add(nodosOrden[actual.x - 1][actual.y][actual.z + 1]);
				}
				catch(Exception e)
				{
				}
				try
				{
					actual.vecinos.add(nodosOrden[actual.x][actual.y - 1][actual.z + 1]);
				}
				catch(Exception e)
				{
				}
			}
			boolean termino = false;
			for(Nodo actual : nodos)
			{
				if(actual.grupo != 0)
					continue;
				xside = false;
				yside = false;
				zside = false;
				dfs(actual, grupoActual);
				if(xside && yside && zside)
				{
					termino = true;
					break;
				}
			}
			if(termino)
				System.out.println("Benny");
			else
				System.out.println("Willy");
		}
	}

	private static void dfs(Nodo actual, int grupoActual) 
	{
		if(actual == null)
			return;
		if(actual.grupo == grupoActual)
			return;
		actual.grupo = grupoActual;
		if(actual.x == 0)
			xside = true;
		if(actual.y == 0)
			yside = true;
		if(actual.z == 0)
			zside = true;
		if(xside && yside && zside)
			return;
		else
		{
			for(Nodo n : actual.vecinos)
				dfs(n, grupoActual);
		}
	}
}
