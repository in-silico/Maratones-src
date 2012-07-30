import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class A 
{
	
	static class Nodo
	{
		Nodo izquierdo;
		Nodo derecho;
		Variable variable;
		Boolean valor;
		
		
		public Nodo(Nodo izquierdo, Nodo derecho, Variable variable,
				Boolean valor)
		{
			super();
			this.izquierdo = izquierdo;
			this.derecho = derecho;
			this.variable = variable;
			this.valor = valor;
		}


		public static Nodo crearNodo(int actual)
		{
			if(actual == n)
				return new Nodo(null, null, null, null);
			else
				return new Nodo(crearNodo(actual + 1), crearNodo(actual + 1), variables[actual], null);
		}
		
		public void llenar()
		{
			if(izquierdo == null)
			{
				valor = actuales.poll();
			}
			else
			{
				izquierdo.llenar();
				derecho.llenar();
			}
		}
		
		public boolean visitar() 
		{
			if(izquierdo == null)
				return valor;
			if(variable.valor)
				return derecho.visitar();
			else
				return izquierdo.visitar();
		}
	}
	
	static class Variable implements Comparable<Variable>
	{
		int numero;
		Boolean valor;
		
		Variable(int n)
		{
			numero = n;
		}

		@Override
		public int compareTo(Variable o)
		{
			return Integer.valueOf(numero).compareTo(o.numero);
		}
	}
	
	static Variable[] variables = new Variable[10];
	static Variable[] enOrden = new Variable[10];
	static LinkedList <Boolean> actuales = new LinkedList <Boolean> ();
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int actual = 1;
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			String[] s = br.readLine().trim().split("\\s+");
			for(int i = 0; i < n; i++)
				variables[i] = new Variable(s[i].charAt(1) - '0');
			for(int i = 0; i < n; i++)
				enOrden[i] = variables[i];
			Arrays.sort(enOrden, 0, n);
			actuales.clear();
			Nodo raiz = Nodo.crearNodo(0);
			char[] entrada = br.readLine().trim().toCharArray();
			for(char c : entrada)
				if(c == '0')
					actuales.add(false);
				else
					actuales.add(true);
			raiz.llenar();
			int m = Integer.parseInt(br.readLine());
			System.out.println("S-Tree #" + actual++);
			for(int i = 0; i < m; i++)
			{
				actuales.clear();
				entrada = br.readLine().trim().toCharArray();
				for(char c : entrada)
					if(c == '0')
						actuales.add(false);
					else
						actuales.add(true);
				for(int j = 0; j < n; j++)
					enOrden[j].valor = actuales.poll();
				boolean cual = raiz.visitar();
				if(cual)
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
			System.out.println();
		}
	}

}
