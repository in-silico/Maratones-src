import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Split
{
	static HashMap <Integer, Integer> mapa = new HashMap <Integer, Integer> (250000, 1f);
	
	static long sumas[] = new long[532000];
	static int tamSumas = 0;
	
	private static void generarSumas(List <Integer> lista)
	{
		tamSumas = 0;
		long actual = lista.get(0);
		sumas[tamSumas++] = (((actual << 32) >>> 32) | actual << 32);
		sumas[tamSumas++] = (0L);
		for(int i = 1; i < lista.size(); i++)
		{
			actual = lista.get(i);
			int tamanoActual = tamSumas;
			for(int j = 0; j < tamanoActual; j++)
			{
				long esta = sumas[j];
				int sumaA = (int) ((esta << 32) >>> 32);
				long acumulado = esta >> 32;
				long suma = sumaA + actual;
				long resta = sumaA - actual;
				resta = Math.abs(resta);
				sumas[tamSumas++] = (((suma << 32) >>> 32) | (acumulado + actual) << 32);
				sumas[tamSumas++] = (((resta << 32) >>> 32) | (acumulado + actual) << 32);
			}
		}
		mapa.clear();
		for(int i = 0; i < tamSumas; i++)
		{
			long l = sumas[i];
			int sumaA = (int)((l << 32) >>> 32);
			int acumulado = (int) (l >> 32);
			Integer posible = mapa.get(sumaA);
			if(posible != null)
				mapa.put(sumaA, Math.max(posible, acumulado));
			else
				mapa.put(sumaA, acumulado);
		}
	}
	
	static long sumas1[] = new long[532000];
	static int tamSumas1 = 0;
	
	private static int generarSumas1(List <Integer> lista)
	{
		tamSumas1 = 0;
		long actual = lista.get(0);
		sumas1[tamSumas1++] = (((actual << 32) >>> 32) | actual << 32);
		sumas1[tamSumas1++] = (0L);
		for(int i = 1; i < lista.size(); i++)
		{
			actual = lista.get(i);
			int tamanoActual = tamSumas1;
			for(int j = 0; j < tamanoActual; j++)
			{
				long esta = sumas1[j];
				int sumaA = (int) ((esta << 32) >>> 32);
				long acumulado = esta >> 32;
				long suma = sumaA + actual;
				long resta = sumaA - actual;
				resta = Math.abs(resta);
				sumas1[tamSumas1++] = (((suma << 32) >>> 32) | (acumulado + actual) << 32);
				sumas1[tamSumas1++] = (((resta << 32) >>> 32) | (acumulado + actual) << 32);
			}
		}
		int mejor = -1;
		if(mapa.containsKey(0))
			mejor = Math.max(mejor, mapa.get(0));
		for(int i = 0; i < tamSumas1; i++)
		{
			long l = sumas1[i];
			int sumaA = (int)((l << 32) >>> 32);
			int acumulado = (int) (l >> 32);
			if(sumaA == 0)
				mejor = Math.max(mejor, acumulado);
			Integer posible = mapa.get(sumaA);
			if(posible != null)
					mejor = Math.max(mejor, acumulado + posible);
		}
		return mejor;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			ArrayList <Integer> numeros = new ArrayList <Integer> ();
			int acumTotal = 0;
			for(int i = 0; i < n; i++)
			{
				int valorNuevo = Integer.parseInt(br.readLine());
				numeros.add(valorNuevo);
				acumTotal += valorNuevo;
			}
			if(numeros.size() == 1)
				System.out.println(numeros.get(0));
			else
			{
				generarSumas(numeros.subList(0, n / 2));
				System.out.println((acumTotal - generarSumas1(numeros.subList(n / 2, n))));
			}
		}
	}
}