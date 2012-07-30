import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class A 
{

	static StringBuilder sb = new StringBuilder(9);
	
	static class Tablero
	{
		String s;
		char[][] matriz;
		int numero;
	
		public Tablero(char[][] m, int n)
		{
			matriz = m;
			sb.setLength(0);
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					sb.append(matriz[i][j]);
			s = sb.toString();
			numero = n;
		}
		
		
		public char[][] rotar(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3, boolean izquierda)
		{
			char[][] anterior = matriz;
			char[][] nuevo = new char[3][3];
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					nuevo[i][j] = anterior[i][j];
			if(izquierda)
			{
				nuevo[x0][y0] = anterior[x1][y1];
				nuevo[x1][y1] = anterior[x3][y3];
				nuevo[x2][y2] = anterior[x0][y0];
				nuevo[x3][y3] = anterior[x2][y2];
			}
			else
			{
				nuevo[x0][y0] = anterior[x2][y2];
				nuevo[x1][y1] = anterior[x0][y0];
				nuevo[x2][y2] = anterior[x3][y3];
				nuevo[x3][y3] = anterior[x1][y1];
			}
			return nuevo;
		}
		
		public ArrayList <Tablero> generarHijos()
		{
			ArrayList <Tablero> hijos = new ArrayList <Tablero> ();
			hijos.add(new Tablero(rotar(0, 0, 0, 1, 1, 0, 1, 1, true), numero + 1));
			hijos.add(new Tablero(rotar(0, 0, 0, 1, 1, 0, 1, 1, false), numero + 1));
			hijos.add(new Tablero(rotar(0, 1, 0, 2, 1, 1, 1, 2, true), numero + 1));
			hijos.add(new Tablero(rotar(0, 1, 0, 2, 1, 1, 1, 2, false), numero + 1));
			hijos.add(new Tablero(rotar(1, 0, 1, 1, 2, 0, 2, 1, true), numero + 1));
			hijos.add(new Tablero(rotar(1, 0, 1, 1, 2, 0, 2, 1, false), numero + 1));
			hijos.add(new Tablero(rotar(1, 1, 1, 2, 2, 1, 2, 2, true), numero + 1));
			hijos.add(new Tablero(rotar(1, 1, 1, 2, 2, 1, 2, 2, false), numero + 1));
			return hijos;
		}
		
		@Override
		public int hashCode() {
			return s.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			Tablero otro = (Tablero) obj;
			return s.equals(otro.s);
		}
	}

	static HashSet <Tablero> visitados = new HashSet <Tablero> (10000);
	static Tablero objetivo = new Tablero(new char[][]{{'1','2','3'},{'4','5','6'},{'7','8','9'}}, 0);
	
	public static int bfs(Tablero inicial, int limite)
	{
		visitados.clear();
		LinkedList <Tablero> porVisitar = new LinkedList <Tablero> ();
		porVisitar.add(inicial);
		while(!porVisitar.isEmpty())
		{
			Tablero actual = porVisitar.pollFirst();
			visitados.add(actual);
			if(actual.numero > limite)
				return -1;
			if(actual.equals(objetivo))
				return actual.numero;
			if(actual.numero != limite)
				for(Tablero hijo : actual.generarHijos())
				{
					if(!visitados.contains(hijo))
						if(hijo.equals(objetivo))
							return hijo.numero > limite ? -1 : hijo.numero;
						else	
							porVisitar.add(hijo);
				}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nc = 1;
		while(true)
		{
			String lectura = br.readLine();
			if(lectura.startsWith("0000000000"))
				return;
			char[][] matriz = new char[3][3];
			int act = 1;
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					matriz[i][j] = lectura.charAt(act++);
			System.out.println(nc++ + ". " + bfs(new Tablero(matriz, 0), lectura.charAt(0) - '0'));
		}
	}
}
