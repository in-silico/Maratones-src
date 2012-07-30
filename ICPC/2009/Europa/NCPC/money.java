package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class money
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args)
	{
		int a = leerNumero();
		for(int i = 0; i < a; i++)
		{
			int n = leerNumero();
			int m = leerNumero();
			amigos = new TreeMap <Integer, Amigo> ();
			for(int j = 0; j < n; j++)
			{
				amigos.put(j, new Amigo(leerNumero(), j));
			}
			for(int j = 0; j < m; j++)
			{
				int primero = leerNumero();
				int segundo = leerNumero();
				amigos.get(primero).amigos.add(segundo);
				amigos.get(segundo).amigos.add(primero);
			}
			boolean termino = false;
			while(amigos.size() > 0)
			{
				numeroActual = 0;
				visitados = new boolean[n];
				visitar(amigos.pollFirstEntry().getValue());
				if(numeroActual != 0)
				{
					termino = true;
					break;
				}
			}
			if(termino)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println("POSSIBLE");
		}
	}
	
	private static void visitar(Amigo amigo) 
	{
		visitados[amigo.i] = true;
		numeroActual += amigo.dinero;
		for(int a : amigo.amigos)
		{
			if(!visitados[a])
				visitar(amigos.get(a));
		}
		amigos.remove(amigo.i);
	}
	
	static TreeMap <Integer, Amigo> amigos;
	static double numeroActual = 0;
	static boolean[] visitados;
	
	public static class Amigo
	{
		int dinero;
		int i;
		ArrayList <Integer> amigos = new ArrayList <Integer> (20);
		
		public Amigo(int leerNumero, int n) 
		{
			dinero = leerNumero;
			i = n;
		}
		
	}
	
	public static int leerNumero()
	{
		char[] numero = new char[6];
		int i;
		int indice = 0;
		try
		{
			while((i = br.read()) == ' ' || i == '\n');
			numero[indice++] = (char) i;
			while((i = br.read()) != ' ' && i != '\n' && i != '\r') numero[indice++] = (char) i;
			
			return Integer.parseInt(new String(numero, 0, indice));
		} 
		catch (IOException e) 
		{
			return 0;
		}
	}
}
