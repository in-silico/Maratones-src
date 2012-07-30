import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Laurel 
{
	
	static int r, c;
	static int iFin, jFin;
	static class Posicion
	{
		static char[][] TDP;
		char[][] tablero;
		int posI;
		int posJ;
		int log;
		int numero;
		String toString;
		static int[][] diferencias = {{0, 1, '-'}, {0, -1, '-'}, {1, 0, '|'}, {-1, 0, '|'}};
		
		
		public Posicion(char[][] t, int posI2, int posJ2, int cuenta, int num) 
		{
			tablero = new char[r][c];
			llenar(t, tablero);
			posI = posI2;
			posJ = posJ2;
			log = cuenta;
			numero = num;
			toString = toString();
		}
		
		public void llenar(char[][] in, char[][] fi)
		{
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					fi[i][j] = in[i][j];
		}
		
		public ArrayList <Posicion> generarHijos()
		{
			ArrayList <Posicion> hijos = new ArrayList <Posicion> ();
			if(log == 0)
			{
				for(int[] actual : diferencias)
				{
					llenar(tablero, TDP);
					int iActual = posI + actual[0];
					int jActual = posJ + actual[1];
					if(iActual < 0 || jActual < 0 || iActual >= r || jActual >= c || TDP[iActual][jActual] != actual[2])
						continue;
					int cuenta = 0;
					while(true)
					{
						TDP[iActual][jActual] = '.';
						cuenta++;
						iActual += actual[0];
						jActual += actual[1];
						if(iActual < 0 || jActual < 0 || iActual >= r || jActual >= c || TDP[iActual][jActual] != actual[2])
							break;
					}
					hijos.add(new Posicion(TDP, posI, posJ, cuenta, numero + 1));
				}
			}
			else
			{
				for(int[] actual : diferencias)
				{
					llenar(tablero, TDP);
					int iActual = posI + actual[0];
					int jActual = posJ + actual[1];
					if(iActual < 0 || jActual < 0 || iActual >= r || jActual >= c || TDP[iActual][jActual] != '.')
						continue;
					int cuenta = 0;
					while(true)
					{
						TDP[iActual][jActual] = (char) actual[2];
						cuenta++;
						iActual += actual[0];
						jActual += actual[1];
						if(iActual < 0 || jActual < 0 || iActual >= r || jActual >= c || TDP[iActual][jActual] != '.')
							break;
					}
					if(iActual >= 0 && jActual >= 0 && iActual < r && jActual < c && TDP[iActual][jActual] == 'S' && cuenta == log)
						hijos.add(new Posicion(TDP, posI, posJ, 0, numero + 1));
				}
			}
			for(int[] actual : diferencias)
			{
				llenar(tablero, TDP);
				int iActual = posI + actual[0];
				int jActual = posJ + actual[1];
				if(iActual < 0 || jActual < 0 || iActual >= r || jActual >= c || TDP[iActual][jActual] != actual[2])
					continue;
				while(true)
				{
					iActual += actual[0];
					jActual += actual[1];
					if(iActual < 0 || jActual < 0 || iActual >= r || jActual >= c || TDP[iActual][jActual] != actual[2])
						break;
				}
				if(iActual >= 0 && jActual >= 0 && iActual < r && jActual < c && TDP[iActual][jActual] == 'S')
					hijos.add(new Posicion(TDP, iActual, jActual, log, numero + 1));
			}
			return hijos;
		}
		
		
		@Override
		public boolean equals(Object obj) 
		{
			Posicion otra = (Posicion) obj;
			return toString.equals(otra.toString);
		}
		
		@Override 
		public int hashCode()
		{
			return toString.hashCode();
		}
		
		@Override
		public String toString()
		{
			String s = "";
			for(int i = 0; i < r; i++)
			{
				for(int j = 0; j < c; j++)
					if(i == posI && j == posJ)
						s += log;
					else
						s += tablero[i][j];
				s += '\n';
			}
			return s;
		}
	}
	
	static HashSet <Posicion> visitados = new HashSet <Posicion> (100007);
	
	public static int bfs(Posicion inicial)
	{
		visitados.clear();
		LinkedList <Posicion> actuales = new LinkedList <Posicion> ();
		actuales.addLast(inicial);
		while(!actuales.isEmpty())
		{
			Posicion actual = actuales.pollFirst();
			if(actual.posI == iFin && actual.posJ == jFin)
				return actual.numero;
			visitados.add(actual);
			for(Posicion hijo : actual.generarHijos())
			{
				if(!visitados.contains(hijo))
					actuales.add(hijo);
			}
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.valueOf(br.readLine());
		for(int a = 0; a < tc; a++)
		{
			Scanner sc = new Scanner(br.readLine());
			r = sc.nextInt();
			c = sc.nextInt();
			char[][] tablero = new char[r][];
			for(int j = 0; j < r; j++)
				tablero[j] = br.readLine().toCharArray();
			int iInicio = 0;
			int jInicio = 0;
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					if(tablero[i][j] == 'B')
					{
						tablero[i][j] = 'S';
						iInicio = i;
						jInicio = j;
					}
					else if(tablero[i][j] == 'E')
					{
						tablero[i][j] = 'S';
						iFin = i;
						jFin = j;
					}
			Posicion.TDP = new char[r][c];
			Posicion inicial = new Posicion(tablero, iInicio, jInicio, 0, 0);
			System.out.println(bfs(inicial));
		}
	}
}
