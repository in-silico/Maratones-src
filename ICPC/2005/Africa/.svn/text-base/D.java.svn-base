import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class D 
{
	static class Posicion
	{
		long cola;
		long a;
		long b;
		int jugadas;
		
		public Posicion(long cola2, long a2, long b2, int j)
		{
			cola = cola2;
			a = a2;
			b = b2;
			jugadas = j;
		}
		
		@Override
		public int hashCode() 
		{
			return (int) (cola ^ a ^ b);
		}
		
		@Override
		public boolean equals(Object obj)
		{
			Posicion otra = (Posicion) obj;
			return cola == otra.cola && a == otra.a && b == otra.b;
		}
	}
	
	static int numeros;
	
	
	static boolean esSolucion(long cola)
	{
		if(tamano(cola) != numeros)
			return false;
		int actual = 1;
		for(int i = 0; i < numeros; i++)
		{
			if((cola & 15) != actual++)
				return false;
			cola >>= 4;
		}
		return true;
	}
	
	static int tamano(long x)
	{
		int cuenta = 0;
		for(int i = 0; i < 100; i++)
		{
			if((x & 15) == 0)
				break;
			cuenta++;
			x >>= 4;
		}
		return cuenta;
	}
	
	static int mayor(long x)
	{
		int mayor = 0;
		for(int i = 0; i < x; i++)
		{
			if((x & 15) == 0)
				break;
			mayor = (int) Math.max(mayor, (x & 15));
			x >>= 4;
		}
		return mayor;
	}
	
	static void arreglar(Posicion pos)
	{
		int tamA = tamano(pos.a);
		int tamB = tamano(pos.b);
		if(tamA > tamB)
		{
			long temp = pos.a;
			pos.a = pos.b;
			pos.b = temp;
		}
		else if(tamA == tamB)
		{
			if(mayor(pos.a) > mayor(pos.b))
			{
				long temp = pos.a;
				pos.a = pos.b;
				pos.b = temp;
			}
		}
	}
	
	static LinkedList <Posicion> lista = new LinkedList <Posicion> ();
	static HashSet <Posicion> visitados = new HashSet <Posicion> ();
	
	public static void generarHijos(Posicion pos)
	{
		int tamanoCola = tamano(pos.cola);
		int tamanoA = tamano(pos.a);
		int tamanoB = tamano(pos.b);
		{
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoCola; i++)
			{
				long numero = cola & 15;
				a <<= 4;
				a |= numero;
				cola >>= 4;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
		{
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoCola; i++)
			{
				long numero = cola & 15;
				b <<= 4;
				b |= numero;
				cola >>= 4;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
		{
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoCola; i++)
			{
				long numero = cola & 15;
				cola >>= 4;
				numero <<= (tamanoCola - 1) * 4;
				cola |= numero;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
		{
			int tamanoCola1 = tamanoCola;
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoA; i++)
			{
				long numero = a & 15;
				a >>= 4;
				numero <<= tamanoCola1++ * 4;
				cola |= numero;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
		{
			int tamanoCola1 = tamanoCola;
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoB; i++)
			{
				long numero = b & 15;
				b >>= 4;
				numero <<= tamanoCola1++ * 4;
				cola |= numero;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
		{
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoA; i++)
			{
				long numero = a & 15;
				a >>= 4;
				b <<= 4;
				b |= numero;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
		{
			long cola = pos.cola;
			long a = pos.a;
			long b = pos.b;
			for(int i = 0; i < tamanoB; i++)
			{
				long numero = b & 15;
				b >>= 4;
				a <<= 4;
				a |= numero;
				Posicion hijo = new Posicion(cola, a, b, pos.jugadas + 1);
				arreglar(hijo);
				if(!visitados.contains(hijo))
					lista.add(hijo);
			}
		}
	}
	
	public static int bfs(Posicion inicial)
	{
		visitados.clear();
		lista.clear();
		lista.add(inicial);
		while(!lista.isEmpty())
		{
			Posicion actual = lista.poll();
			if(visitados.contains(actual))
				continue;
			if(esSolucion(actual.cola))
				return actual.jugadas;
			visitados.add(actual);
			generarHijos(actual);
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			numeros = sc.nextInt();
			if(numeros == 0)
				return;
			Stack <Integer> s = new Stack <Integer> ();
			for(int i = 0; i < numeros; i++)
				s.add(sc.nextInt());
			long cola = 0;
			while(!s.isEmpty())
			{
				cola |= s.pop() + 1; 
				if(!s.isEmpty())
					cola <<= 4;
			}
			System.out.println(bfs(new Posicion(cola, 0, 0, 0)));
		}
	}
}
