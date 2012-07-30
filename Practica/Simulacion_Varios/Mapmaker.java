import java.util.HashMap;
import java.util.Scanner;


public class Mapmaker 
{
	
	static class Arreglo
	{
		String nombre;
		int tam;
		int base;
		int[] lower;
		int[] upper;
		int[] c;
		
		public void calcularC()
		{
			c = new int[lower.length];
			c[lower.length - 1] = tam;
			for(int j = lower.length - 2; j >= 1; j--)
				c[j] = c[j + 1] * (upper[j + 1] - lower[j + 1] + 1);
			c[0] = base;
			for(int i = 1; i < lower.length; i++)
				c[0] -= c[i] * lower[i];
		}
		
		
	}
	
	
	static HashMap <String, Arreglo> mapa = new HashMap <String, Arreglo> (1000);
	public static void  main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			String nombre = sc.next();
			Arreglo nuevo = new Arreglo();
			nuevo.base = sc.nextInt();
			nuevo.tam = sc.nextInt();
			int dimensiones = sc.nextInt();
			nuevo.nombre = nombre;
			nuevo.lower = new int[dimensiones + 1];
			nuevo.upper = new int[dimensiones + 1];
			for(int j = 1; j <= dimensiones; j++)
			{
				nuevo.lower[j] = sc.nextInt();
				nuevo.upper[j] = sc.nextInt();
			}
			nuevo.calcularC();
			mapa.put(nombre, nuevo);
		}
		for(int i = 0; i < r; i++)
		{
			String nombre = sc.next();
			Arreglo este = mapa.get(nombre);
			int cuenta = este.c[0];
			int[] entrada = new int[este.c.length];
			for(int j = 1; j < este.lower.length; j++)
				entrada[j] = sc.nextInt();
			System.out.print(nombre + "[");
			System.out.print(entrada[1]);
			for(int j = 2; j < este.lower.length; j++)
				System.out.print(", " + entrada[j]);
			System.out.print("] = ");
			for(int j = 1; j < este.lower.length; j++)
				cuenta += este.c[j] * entrada[j];
			System.out.println(cuenta);	
		}
	}

}
