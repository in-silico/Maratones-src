package UVA;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class frieze
{
	public static int[][] matriz = new int[1000][2500];
	public static int numeroFilas;
	public static boolean termino = false;
	public static Scanner sc;
	
	public static void main (String [] args) throws FileNotFoundException
	{
		sc = new Scanner(System.in);
		for(;;)
		{
			solucion();
			if(termino)
			{
				return;
			}
		}
	}
	public static void solucion() throws FileNotFoundException
	{
		int diagonal = 0;
		int fila = 0;
		Scanner sc2;
		sc2 = new Scanner(sc.nextLine());
		numeroFilas = sc2.nextInt();
		if(numeroFilas == 0)
		{
			termino = true;
			return;
		}
		sc2 = new Scanner(sc.nextLine());
		fila = sc2.nextInt() - 1;
		diagonal = sc2.nextInt();
		sc2 = new Scanner(sc.nextLine());
		for(int i = 0; i < numeroFilas; i++)
		{
			try
			{
				matriz [i][i] = sc2.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("0");
			}
		}
		for(int i = 0; i < 2500; i++)
		{
			matriz [0][i] = 1;
			matriz [numeroFilas - 1][i] = 1;
		}
		try
		{
		int numeroPatron = encontrarPatron();
		if(diagonal < numeroPatron)
		{
			diagonal = diagonal - 1;
		}
		else
		{
			try
			{
				diagonal = (diagonal - 1) % (numeroPatron - 1);
			}
			catch(Exception e)
			{
				System.out.println("0");
				return;
			}
		}
		System.out.println(matriz[fila][fila + diagonal]);
	    return;
		}
		catch(Exception e)
		{
			System.out.println("0");
			return;
		}
	}
	
	public static int encontrarPatron()
	{
		int fila = 1;
		int columna = 2;
		int columnaActual = 2;
		boolean igual = true;
		while (columna < 2500)
		{
			matriz[fila][columna] = (matriz[fila - 1][columna - 1] * matriz[fila + 1][columna] + 1) / matriz[fila][columna - 1];
			igual = igual && matriz[fila][columna] == matriz[fila][fila];
			if(fila == numeroFilas - 2)
			{
				fila = 1;
				columna = ++columnaActual;
				if(igual)
				{
					return (--columnaActual);
				}
				igual = true;
			}
			else
			{
				fila++;
				columna++;
			}
		}
		return 0;
	}
}