import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class h
{
	public static class Nodo
	{
		static LinkedList <Character> actual = new LinkedList <Character> ();
				
		ArrayList <Nodo> hijos = new ArrayList <Nodo> ();
		Nodo padre;
		Nodo izquierdo;
		Nodo derecho;
		
		public Nodo(Nodo nodo) 
		{
			padre = nodo;
		}

		public void visitar()
		{
			if(actual.isEmpty())
				return;
			char este = actual.pollFirst();
			if(este == 'u')
			{
				if(padre == null)
					return;
				padre.visitar();
			}
			else
			{
				hijos.add(new Nodo(this));
				hijos.get(hijos.size() - 1).visitar();
			}
		}
		
		public void organizar(Nodo hermano)
		{
			izquierdo = hijos.size() == 0 ? null : hijos.get(0);
			derecho = hermano;
			for(int i = 0 ; i < hijos.size() - 1; i++)
			{
				hijos.get(i).organizar(hijos.get(i + 1));
			}
			if(hijos.size() > 0)
				hijos.get(hijos.size() - 1).organizar(null);
		}
		
		public int tamanoPrimero()
		{
			int maximo = Integer.MIN_VALUE;
			if(hijos.size() == 0)
				return 1;
			for(int i = 0; i < hijos.size(); i++)
			{
				maximo = Math.max(maximo, hijos.get(i).tamanoPrimero() + 1);
			}
			return maximo;
		}
		
		public int tamanoSegundo()
		{
			if(izquierdo == null && derecho == null)
				return 1;
			int mejor = Integer.MIN_VALUE;
			if(izquierdo != null)
				mejor = izquierdo.tamanoSegundo() + 1;
			if(derecho != null)
				mejor = Math.max(mejor, derecho.tamanoSegundo() + 1);
			return mejor;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero = 1;
		while(true)
		{
			String entrada = br.readLine();
			if(entrada.length() != 0 && entrada.charAt(0) == '#')
			{
				return;
			}
			Nodo raiz = new Nodo(null);
			for(char c : entrada.toCharArray())
				Nodo.actual.add(c);
			raiz.visitar();
			int primero = raiz.tamanoPrimero() - 1;
			raiz.organizar(null);
			int segundo = raiz.tamanoSegundo() - 1;
			System.out.println("Tree " + numero++ + ": " + primero + " => " + segundo);
		}
	}
}
