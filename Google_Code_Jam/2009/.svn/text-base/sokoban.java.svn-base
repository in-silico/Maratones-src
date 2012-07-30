package GoogleCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class sokoban 
{
	
	enum punto
	{
		VACIO, PARED, CAJA;
	}

	static class estado
	{
		punto [][] tablero;
		boolean peligroso;
		int pasos;
		int ncajas;
		
		public estado(punto [][] t, int p, int n)
		{
			tablero = t;
			pasos = p;
			ncajas = n;
			for(int i = 0; i < tablero.length; i++)
			{
				for(int j = 0; j < tablero[0].length; j++)
				{
					if(tablero[i][j] == punto.CAJA)
					{
						visitados = new boolean[tablero.length][tablero[0].length];
						peligroso = visitar(i, j) != ncajas;
						return;
					}
				}
			}
		}
		
		boolean [][] visitados;
		
		private int visitar(int i, int j) 
		{
			if(i > -1 && i < tablero.length && j > -1 && j < tablero[0].length)
			{
				if(tablero[i][j] == punto.CAJA && !visitados[i][j])
				{
					visitados[i][j] = true;
					return 1 + visitar(i - 1, j) + visitar(i + 1, j) + visitar(i, j + 1) + visitar(i, j - 1);
				}
			}
			return 0;
		}
		
		public ArrayList <estado> generarHijos()
		{
			ArrayList <estado> hijos = new ArrayList <estado> ();
			for(int i = 0; i < tablero.length; i++)
			{
				for(int j = 0; j < tablero[0].length; j++)
				{
					if(tablero[i][j] == punto.CAJA)
					{
						try
						{
							if(tablero[i - 1][j] == punto.VACIO && tablero[i + 1][j] == punto.VACIO)
							{
								hijos.add(generarHijo(i, j, i - 1, j));
								hijos.add(generarHijo(i, j, i + 1, j));
							}
						}
						catch(Exception e)
						{
						}
						try
						{
							if(tablero[i][j - 1] == punto.VACIO && tablero[i][j + 1] == punto.VACIO)
							{
								hijos.add(generarHijo(i, j, i, j - 1));
								hijos.add(generarHijo(i, j, i, j + 1));
							}
						}
						catch(Exception e)
						{
						}
					}
				}
			}
			return hijos;
		}

		private estado generarHijo(int i, int j, int k, int l) 
		{
			punto [][] tableroNuevo = new punto[tablero.length][tablero[0].length];
			for(int a = 0; a < tablero.length; a++)
			{
				for(int b = 0; b < tablero[0].length; b++)
				{
					tableroNuevo[a][b] = tablero[a][b];
				}
			}
			tableroNuevo[i][j] = punto.VACIO;
			tableroNuevo[k][l] = punto.CAJA;
			return new estado(tableroNuevo, pasos + 1, ncajas);
		}
		
		@Override
		public int hashCode()
		{
			String t = "";
			for(int i = 0; i < tablero.length; i++)
			{
				for(int j = 0; j < tablero[0].length; j++)
				{
					t += tablero[i][j] == punto.CAJA ? "o" : tablero[i][j] == punto.PARED ? "#" : ".";
				}
			}
			return t.hashCode();
		}
		
		@Override
		public boolean equals(Object otro)
		{
			estado eOtro = (estado)otro;
			for(int i = 0; i < tablero.length; i++)
			{
				for(int j = 0; j < tablero[0].length; j++)
				{
					if(tablero[i][j] != eOtro.tablero[i][j])
						return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String [] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("a.in"));
		Scanner sc = new Scanner(System.in);
		int ncasos = sc.nextInt();
		for(int i = 0; i < ncasos; i++)
		{
			int nfilas = sc.nextInt();
			int ncolumnas = sc.nextInt();
			punto [][] tableroInicial = new punto[nfilas][ncolumnas];
			punto [][] tableroFinal = new punto[nfilas][ncolumnas];
			estado estadoFinal = new estado(tableroFinal, 0, 0);
			int ncajas = 0;
			for(int a = 0; a < nfilas; a++)
			{
				String actual = sc.next();
				for(int b = 0; b < ncolumnas; b++)
				{
					tableroInicial[a][b] = actual.charAt(b) == '.' ? punto.VACIO : actual.charAt(b) == '#' ? punto.PARED : actual.charAt(b) == 'w' || actual.charAt(b) == 'o' ? punto.CAJA : punto.VACIO;
					if(tableroInicial[a][b] == punto.CAJA) 
						ncajas++;
					tableroFinal[a][b] = actual.charAt(b) == '.' ? punto.VACIO : actual.charAt(b) == '#' ? punto.PARED : actual.charAt(b) == 'w' || actual.charAt(b) == 'x' ? punto.CAJA : punto.VACIO;
				}
			}
			Hashtable <estado, Integer> visitados = new Hashtable<estado, Integer> ();
			Stack <estado> pila = new Stack <estado> ();
			pila.add(new estado(tableroInicial, 0, ncajas));
			int numerofinal = -1;
			while(!pila.isEmpty())
			{
				estado actual = pila.remove(0);
				if(visitados.containsKey(actual))
					continue;
				visitados.put(actual, actual.hashCode());
				if(actual.equals(estadoFinal))
				{
					numerofinal = actual.pasos;
					break;
				}
				ArrayList <estado> hijos = actual.generarHijos();
				for(estado h : hijos)
				{
					if(!visitados.containsKey(h))
					{
						if(actual.peligroso)
						{
							if(!h.peligroso)
							{
								pila.add(h);
							}
							continue;
						}
						pila.add(h);
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ":" + " " + numerofinal);
		}
	}
}
