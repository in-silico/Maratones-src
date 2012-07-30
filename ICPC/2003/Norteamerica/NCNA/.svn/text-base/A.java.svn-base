import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class A 
{
	static HashSet <String> visitados = new HashSet <String> ();
	
	static class Solucion
	{
		String s;
		int n;
		
		public Solucion(String ss, int nn)
		{
			s = ss;
			n = nn;
		}
	}

	static int mejorNivel;
	static int mejorTam;
	
	public static void solucionar(String a)
	{
		LinkedList <Solucion> cola = new LinkedList <Solucion> ();
		cola.add(new Solucion(a, 0));
		visitados.add(a);
		mejorNivel = 5;
		mejorTam = 0;
		while(true)
		{
			Solucion actual = cola.poll();
			if(actual.n > mejorNivel)
				return;
			if(palindrome(actual.s))
			{
				mejorNivel = actual.n;
				mejorTam = Math.max(mejorTam, actual.s.length());
			}
			String hijo = actual.s.substring(1);
			if(hijo.length() != 0 && !visitados.contains(hijo))
			{
				visitados.add(hijo);
				cola.add(new Solucion(hijo, actual.n + 1));
			}
			hijo = actual.s.substring(0, actual.s.length() - 1);
			if(hijo.length() != 0 && !visitados.contains(hijo))
			{
				visitados.add(hijo);
				cola.add(new Solucion(hijo, actual.n + 1));
			}
			for(int i = 0; i < actual.s.length(); i++)
			{
				hijo = actual.s.charAt(i) + actual.s;
				if(!visitados.contains(hijo))
				{	
					visitados.add(hijo);
					cola.add(new Solucion(hijo, actual.n + 1));
				}
				hijo = actual.s + actual.s.charAt(i);
				if(!visitados.contains(hijo))
				{
					visitados.add(hijo);
					cola.add(new Solucion(hijo, actual.n + 1));
				}
			}
		}
	}
	
	private static boolean palindrome(String s) 
	{
		for(int i = 0; i < s.length() / 2; i++)
			if(s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		return true;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caso = 1;
		while(sc.hasNext())
		{
			visitados.clear();
			String s;
			solucionar(s = sc.next());
			System.out.println("Case " + caso++ + ", sequence = " + s + ", cost = " + mejorNivel + ", length = " + mejorTam);
		}
	}

}

