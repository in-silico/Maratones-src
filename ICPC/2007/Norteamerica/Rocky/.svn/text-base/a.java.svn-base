import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class a
{
	static LinkedList <Character> entrada = new LinkedList <Character> ();
	
	public static class Nodo
	{
		ArrayList <Nodo> hijos = new ArrayList <Nodo> ();
		Nodo izquierdo;
		Nodo derecho;
		Nodo papa;
		
		public Nodo(Nodo nodo) 
		{
			papa = nodo;
		}
		
		public Nodo() 
		{
		}

		int alturaA()
		{
			if(hijos.size() == 0)
				return 1;
			int mejor = Integer.MIN_VALUE;
			for(Nodo n : hijos)
				mejor = Math.max(n.alturaA(), mejor);
			return mejor + 1;
		}
		
		int alturaB()
		{
			if(izquierdo == null && derecho == null)
				return 1;
			int mejor = Integer.MIN_VALUE;
			if(izquierdo !=  null)
				mejor = Math.max(izquierdo.alturaB(), mejor);
			if(derecho !=  null)
				mejor = Math.max(derecho.alturaB(), mejor);
			return mejor + 1;
		}

		void iniciar()
		{
			if(entrada.size() == 0)
				return;
			char actual = entrada.pollFirst();
			if(actual == 'u')
			{
				if(papa == null)
					return;
				papa.iniciar();
			}
			else
			{
				hijos.add(new Nodo(this));
				hijos.get(hijos.size() - 1).iniciar();
			}
		}
		
		void cambiar(Nodo hermano)
		{
			if(hijos.size() != 0)
				izquierdo = hijos.get(0);
			derecho = hermano;
			for(int i = 0; i < hijos.size() - 1; i++)
			{
				hijos.get(i).cambiar(hijos.get(i + 1));
			}
			if(hijos.size() != 0)
				hijos.get(hijos.size() - 1).cambiar(null);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int actual = 1;
		while(true)
		{
			String entradaS = br.readLine();
			if(entradaS.charAt(0) == '#')
				return;
			Nodo raiz = new Nodo();
			entrada.clear();
			for(char c : entradaS.toCharArray())
				entrada.add(c);
			raiz.iniciar();
			int alturaI = raiz.alturaA();
			raiz.cambiar(null);
			int alturaF = raiz.alturaB();
			System.out.println("Tree " + actual++ + ": " + --alturaI + " => " + --alturaF);
		}
	}
}