import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class H 
{
	static TreeMap <Integer, Boolean > dp = new TreeMap <Integer, Boolean > ();
	
	
	static class Vertex
	{
		char value;
		DLL sons;
		int consecutivo;
		
		public Vertex(LinkedList <Character> entrada, ArrayList <Vertex> destiny)
		{
			consecutivo = destiny.size();
			destiny.add(this);
			value = entrada.pollFirst();
			if(entrada.isEmpty() || entrada.peekFirst() != '(')
			{
				sons = new DLL();
			}
			else
			{
				entrada.pollFirst();
				Vertex actual = new Vertex(entrada, destiny);
				actual.sons.add(this);
				sons = new DLL(actual);
				while(entrada.peekFirst() == ',')
				{
					entrada.pollFirst();
					actual = new Vertex(entrada, destiny);
					actual.sons.add(this);
					sons.add(actual);
				}
				entrada.pollFirst();
			}
		}
		
		public static Boolean tiene(int a, int b, int c, int d)
		{
			int numero = (a | (b << 8) | (c << 16) | (d << 24));
			return dp.get(numero);
		}
		
		public static boolean poner(int a, int b, int c, int d, boolean valor)
		{
			int numero = (a | (b << 8) | (c << 16) | (d << 24));
			dp.put(numero, valor);
			return valor;
		}
		
		public static boolean iguales(Vertex desdeA, Vertex a, Vertex desdeB, Vertex b)
		{
			if(a.sons.size != b.sons.size || a.value != b.value)
				return false;
			if(desdeA != null && desdeB != null)
			{
				Boolean posible = tiene(desdeA.consecutivo, a.consecutivo, desdeB.consecutivo, b.consecutivo);
				if(posible != null)
					return posible;
			}
			else
			{
				if(a.value == b.value && a.sons.size == b.sons.size && a.sons.size == 0)
					return true;
				Node fijo = a.sons.first;
				Node variable = b.sons.first;
				Node actual = variable;
				int cuenta = 0;
				while(true)
				{
					if(actual == variable)
						cuenta++;
					if(cuenta == 2)
						break;
					Node actualA = fijo;
					Node actualB = actual;
					int cuenta1 = 0;
					boolean coinciden = true;
					while(true)
					{
						if(actualA == fijo)
							cuenta1++;
						if(cuenta1 == 2)
							break;
						if(actualA.current.value != actualB.current.value || actualA.current.sons.size != actualB.current.sons.size)
						{
							coinciden = false;
							break;
						}
						actualA = actualA.next;
						actualB = actualB.next;
					}
					if(coinciden)
					{
						actualA = fijo;
						actualB = actual;
						cuenta1 = 0;
						coinciden = true;
						while(true)
						{
							if(actualA == fijo)
								cuenta1++;
							if(cuenta1 == 2)
								break;
							if(!iguales(a, actualA.current, b, actualB.current))
							{
								coinciden = false;
								break;
							}
							actualA = actualA.next;
							actualB = actualB.next;
						}
						if(coinciden)
							return true;
					}
					actual = actual.next;
				}
				return false;
			}
			Node inicioA = a.sons.buscar(desdeA);
			Node inicioB = b.sons.buscar(desdeB);
			Node actualA = inicioA.next;
			Node actualB = inicioB.next;
			boolean coinciden = true;
			while(coinciden && actualA != inicioA)
			{
				if(actualA.current.value != actualB.current.value || actualA.current.sons.size != actualB.current.sons.size)
				{
					coinciden = false;
				}
				actualA = actualA.next;
				actualB = actualB.next;
			}
			actualA = inicioA.next;
			actualB = inicioB.next;
			while(coinciden && actualA != inicioA)
			{
				if(!iguales(a, actualA.current, b, actualB.current))
				{
					coinciden = false;
				}
				actualA = actualA.next;
				actualB = actualB.next;
			}
			return poner(desdeA.consecutivo, a.consecutivo, desdeB.consecutivo, b.consecutivo, coinciden);
		}
	}
	
	static class Node
	{
		Node next;
		Vertex current;
	}
	
	static class DLL
	{	
		Node first;
		Node last;
		int size;
		
		public DLL()
		{
			size = 0;
		}
		
		public DLL(Vertex root)
		{
			first = new Node();
			first.current = root;
			first.next = last = first;
			size = 1;
		}
		
		public void add(Vertex next)
		{
			if(size == 0)
			{
				first = new Node();
				first.current = next;
				first.next = last = first;
				size = 1;
			}
			else
			{
				last.next = new Node();
				last.next.current = next;
				last.next.next = first;
				last = last.next;
				size++;
			}
		}
		
		public Node buscar(Vertex v)
		{
			Node actual = first;
			if(actual.current == v)
				return actual;
			actual = actual.next;
			while(actual != first)
			{
				if(actual.current == v)
					return actual;
				actual = actual.next;
			}
			return null;
		}
	}
	
	static class Tree
	{
		Vertex raiz;
		ArrayList <Vertex> vertexs = new ArrayList <Vertex> ();
		
		public Tree(LinkedList <Character> entrada)
		{
			raiz = new Vertex(entrada, vertexs);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList <Character> actuales = new LinkedList <Character> ();
		for(int i = 0; i < n; i++)
		{
			dp.clear();
			actuales.clear();
			for(char c : br.readLine().toCharArray())
				actuales.add(c);
			Tree a = new Tree(actuales);
			actuales.clear();
			for(char c : br.readLine().toCharArray())
				actuales.add(c);
			Tree b = new Tree(actuales);
			Vertex aBuscar = a.vertexs.get(0);
			boolean igual = false;
			for(Vertex vb : b.vertexs)
			{
				if(Vertex.iguales(null, aBuscar, null, vb))
				{
					igual = true;
					break;
				}
			}
			if(igual)
				System.out.println("same");
			else
				System.out.println("different");	
		}
	}
}
