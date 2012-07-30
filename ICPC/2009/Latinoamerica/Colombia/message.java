package UVA;

import java.util.Scanner;
import java.util.Stack;

public class message
{
	public static boolean [][] prision;
	public static boolean [][] visitados;
	public static Stack <Punto> pila;
	public static int rangoAlarma;
	public static int xFinal;
	public static int yFinal;
	public static boolean termino;
	
	static class Punto
	{
		int x, y;
		public Punto(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int nMuros = sc.nextInt();
			rangoAlarma = sc.nextInt();
			if(nMuros == 0 && rangoAlarma == 0)
				return;
			prision = new boolean[1001][1001];
			visitados = new boolean[1001][1001];
			int y0 = sc.nextInt();
			int x0 = sc.nextInt();
			int x1 = x0;
			int y1 = y0;
			for(int i = 1; i < nMuros; i++)
			{
				int y2 = sc.nextInt();
				int x2 = sc.nextInt();
				generarMuro(x1, y1, x2, y2);
				x1 = x2;
				y1 = y2;
			}
			generarMuro(x0, y0, x1, y1);
			int yInicial = sc.nextInt();
			int xInicial = sc.nextInt();
			if(prision[xInicial][yInicial])
			{
				System.out.println("No");
				continue;
			}
			yFinal = sc.nextInt();
			xFinal = sc.nextInt();
			if(prision[xFinal][yFinal])
			{
				System.out.println("No");
				continue;
			}
			prision[xFinal][yFinal] = true;
			termino = false;
			pila = new Stack <Punto> ();
			pila.push(new Punto(xInicial, yInicial));
			while(!termino && !pila.isEmpty())
			{
				Punto actual = pila.pop();
				visitar(actual.x, actual.y);
			}
			if(!termino)
			{
				System.out.println("No");
			}
		}
	}

	private static void visitar(int x, int y)
	{
		try
		{
			if(prision[x][y])
			{
				if(x == xFinal && y == yFinal)
				{
					System.out.println("Yes");
					termino = true;
				}
			}
			else if(!visitados[x][y])
			{
				visitados[x][y] = true;
				agregar(x - 1, y - 1);
				agregar(x - 1, y);
				agregar(x - 1, y + 1);
				agregar(x, y - 1);
				agregar(x, y + 1);
				agregar(x + 1, y - 1);
				agregar(x + 1, y);
				agregar(x + 1, y + 1);
			}
		}
		catch(Exception e)
		{
			return;
		}
	}

	private static void agregar(int x, int y) 
	{
		pila.push(new Punto(x, y));
	}

	private static void generarMuro(int x1, int y1, int x2, int y2)
	{
		if(x1 == x2)
		{
			if(y1 < y2)
			{
				for(int i = y1 + 1; i < y2; i++)
				{
					for(int j = x1 - rangoAlarma; j < x1 + rangoAlarma + 1; j++)
					{
						try
						{
							prision[j][i] = true;
						}
						catch(Exception e)
						{
						}
					}
				}
			}
			else
			{
				for(int i = y2 + 1; i < y1; i++)
				{
					for(int j = x1 - rangoAlarma; j < x1 + rangoAlarma + 1; j++)
					{
						try
						{
							prision[j][i] = true;
						}
						catch(Exception e)
						{
						}
					}
				}
			}
		}
		else
		{
			if(x1 < x2)
			{
				for(int i = x1 + 1; i < x2; i++)
				{
					for(int j = y1 - rangoAlarma; j < y1 + rangoAlarma + 1; j++)
					{
						try
						{
							prision[i][j] = true;
						}
						catch(Exception e)
						{
						}
					}			
				}
			}
			else
			{
				for(int i = x2 + 1; i < x1; i++)
				{
					for(int j = y1 - rangoAlarma; j < y1 + rangoAlarma + 1; j++)
					{
						try
						{
							prision[i][j] = true;
						}
						catch(Exception e)
						{
						}
					}			
				}
			}
		}
		prision[x1][y1] = true;
		int limitex = x1 + rangoAlarma + 1;
		int limitey = y1 + rangoAlarma + 1;
		for(int i = x1 - rangoAlarma; i < limitex; i++)
		{
			for(int j = y1 - rangoAlarma; j < limitey; j++)
			{
				if(Math.sqrt(((i - x1) * (i - x1)) + ((j - y1) * (j - y1))) <= rangoAlarma)
				{
					try
					{
						prision[i][j] = true;
					}
					catch(Exception e)
					{
					}
				}
			}
		}
		prision[x2][y2] = true;
		limitex = x2 + rangoAlarma + 1;
		limitey = y2 + rangoAlarma + 1;
		for(int i = x2 - rangoAlarma; i < limitex; i++)
		{
			for(int j = y2 - rangoAlarma; j < limitey; j++)
			{
				if(Math.sqrt(((i - x2) * (i - x2)) + ((j - y2) * (j - y2))) <= rangoAlarma)
				{
					try
					{
						prision[i][j] = true;
					}
					catch(Exception e)
					{
					}
				}
			}
		}
	}
}
