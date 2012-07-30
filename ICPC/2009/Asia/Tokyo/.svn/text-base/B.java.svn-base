import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class B {

	static class Entrada
	{
		String a;
		String b;
		
		public Entrada(String aa, String bb)
		{
			a = aa;
			b = bb;
		}
	}
	
	static class Nodo
	{
		String n;
		int turno;
		
		public Nodo(String nn, int tt)
		{
			n = nn;
			turno = tt;
		}
	}

	static HashSet <String> set = new HashSet <String> ();
	static LinkedList <Nodo> nodos = new LinkedList <Nodo> ();
	static ArrayList <Entrada> entradas = new ArrayList <Entrada> ();
	
	public static int empeza(String inicial, String ultimo)
	{
		Nodo actual = new Nodo(inicial, 0);
		nodos.clear();
		set.clear();
		nodos.add(actual);
		set.add(actual.n);
		while(!nodos.isEmpty())
		{
			actual = nodos.poll();
			if(actual.n.length() > ultimo.length())
				continue;
			String s = actual.n;
			if(actual.n.equals(ultimo))
				return actual.turno;
			for(Entrada e : entradas)
			{
				String siguiente = s.replace(e.a, e.b);
				if(set.contains(siguiente))
					continue;
				set.add(siguiente);
				nodos.add(new Nodo(siguiente, actual.turno + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			entradas.clear();
			for(int i = 0; i < n; i++)
			{
				String[] p = br.readLine().split("\\s+");
				entradas.add(new Entrada(p[0], p[1]));
			}
			System.out.println(empeza(br.readLine(), br.readLine()));
		}
	}

}
