package GoogleCode;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class tree 
{

	public static Scanner sc;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc2 = new Scanner(new File("a.in"));
		int n = sc2.nextInt();
		for(int i = 0; i < n; i++)
		{
			System.out.println("Case #" + (i + 1) + ":");
			int l = sc2.nextInt();
			sc2.nextLine();
			String s = "";
			for(int j = 0; j < l; j++)
			{
				s = s + sc2.nextLine();
			}
			sc = new Scanner(s);
			sc.useDelimiter("[ \\n()]");
			Arbol raiz = arbol();
			int nanimales = sc2.nextInt();
			for(int k = 0; k < nanimales; k++)
			{
				sc2.next();
				int m = sc2.nextInt();
				ArrayList <String> caracteristicas = new ArrayList <String> ();
				for(int b = 0; b < m; b++)
				{
					caracteristicas.add(sc2.next());
				}
				System.out.println(new BigDecimal(recorrer(1, caracteristicas, raiz)).divide(BigDecimal.ONE, 7, BigDecimal.ROUND_HALF_UP));
			}
		}
	}
	
	private static double recorrer(double acumulado, ArrayList <String> caracteristicas, Arbol raiz) 
	{
		acumulado *= raiz.peso;
		if(raiz.caracteristica == null)
		{
			return acumulado;
		}
		else
		{
			if(caracteristicas.contains(raiz.caracteristica))
			{
				return recorrer(acumulado, caracteristicas, raiz.izq);
			}
			else
			{
				return recorrer(acumulado, caracteristicas, raiz.der);
			}
		}
	}

	private static Arbol arbol() 
	{
		Arbol a = new Arbol();
		String s = "";
		while((s = sc.next()).equals(""))
		{	
		}
		a.peso = Double.parseDouble(s);
		while(sc.hasNext(""))
		{
			sc.next();
		}
		if(sc.hasNext("[a-z]*"))
		{
			a.caracteristica = sc.next();
			a.izq = arbol();
			a.der = arbol();
			return a;
		}
		else
		{
			return a;
		}
	}
	
	static class Arbol
	{
		double peso;
		String caracteristica;
		Arbol izq;
		Arbol der;
	}
}
