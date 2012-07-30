import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class districts 
{
	static class District
	{
		LinkedList <Node> nodos = new LinkedList <Node> ();
		TreeSet <Integer> visitados = new TreeSet <Integer> ();
		
		public boolean agregar(Node n)
		{
			int indice = 0;
			for(Node no : nodos)
			{
				if(no.numero > n.numero)
					break;
				indice++;
			}
			nodos.add(indice, n);
			int hash = darHash();
			if(visitados.contains(hash))
			{
				nodos.remove(n);
				return false;
			}
			visitados.add(hash);
			n.distrito = this;
			return true;
		}
		
		public void eliminar(Node n)
		{
			nodos.remove(n);
			n.distrito = null;
		}
		
		public int darHash()
		{
			int indice = 0;
			int hash = 0;
			for(Node n : nodos)
			{
				hash += n.numero << indice++;
			}
			return hash;
		}
	}
	
	static class Node implements Comparable <Node>
	{
		int numero;
		int votosA, votosB;
		boolean visitado = false;
		District distrito = null;
		ArrayList <Node> adjacentes = new ArrayList <Node> (4);

		public Node(int i)
		{
			numero = i;
		}

		@Override
		public int compareTo(Node o) 
		{
			return new Integer(numero).compareTo(o.numero);
		}

		public int cuentaConectados() 
		{
			visitado = true;
			int cuenta = 1;
			for(Node n : adjacentes)
			{
				if(n.distrito == null && !n.visitado)
					cuenta += n.cuentaConectados();
			}
			return cuenta;
		}
		
	}

	static int tam = 0;
	static int mejorCuenta = Integer.MIN_VALUE;
	static Node[][] nodos = new Node[5][5];
	static ArrayList <Node> nodosPlanos = new ArrayList <Node> ();
	static ArrayList <District> distritos = new ArrayList <District> (5);
	
	public static void visitarDistrito(District d)
	{
		if(d.nodos.size() == tam)
		{
			if(!verificarNodos())
				return;
			boolean termino = true;
			for(Node n : nodosPlanos)
			{
				if(n.distrito == null)
				{
					District nuevo = new District();
					nuevo.agregar(n);
					distritos.add(nuevo);
					visitarDistrito(nuevo);
					nuevo.eliminar(n);
					distritos.remove(nuevo);
					termino = false;
					break;
				}
			}
			if(termino)
			{
				int cuenta = 0;
				for(District di : distritos)
				{
					int votacionA = 0;
					int votacionB = 0;
					for(Node n : di.nodos)
					{
						votacionA += n.votosA;
						votacionB += n.votosB;
					}
					if(votacionA > votacionB)
						cuenta++;
					else if(votacionA < votacionB)
						cuenta--;
				}
				mejorCuenta = Math.max(mejorCuenta, cuenta);
			}
		}
		else
		{
			for(int i = 0; i < d.nodos.size(); i++)
			{
				Node n = d.nodos.get(i);
				for(Node v : n.adjacentes)
				{
					if(v.distrito == null)
					{
						if(d.agregar(v))
						{
							if(verificarNodos())
								visitarDistrito(d);
							d.eliminar(v);
						}
					}
				}
			}
		}
	}
	
	private static boolean verificarNodos() 
	{
		if(distritos.size() == tam)
			return true;
		for(Node n : nodosPlanos)
			n.visitado = false;
		for(Node n : nodosPlanos)
		{
			if(n.distrito == null && !n.visitado)
				if(n.cuentaConectados() < tam)
					return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++)
		{
			distritos.clear();
			nodosPlanos.clear();
			tam = Integer.parseInt(br.readLine());
			int cuenta = 1;
			for(int j = 0; j < tam; j++)
				for(int k = 0; k < tam; k++)
				{
					nodos[j][k] = new Node(cuenta++);
					nodosPlanos.add(nodos[j][k]);
				}
			for(int j = 0; j < tam; j++)
			{
				String[] esta = br.readLine().split(" ");
				for(int k = 0; k < tam; k++)
				{
					Node actual = nodos[j][k];
					actual.votosA = Integer.parseInt(esta[k]);
					if(j != 0)
					{
						actual.adjacentes.add(nodos[j - 1][k]);
					}
					if(k != 0)
					{
						actual.adjacentes.add(nodos[j][k - 1]);
					}
					if(j != tam - 1)
					{
						actual.adjacentes.add(nodos[j + 1][k]);
					}
					if(k != tam - 1)
					{
						actual.adjacentes.add(nodos[j][k + 1]);
					}
				}
			}
			for(int j = 0; j < tam; j++)
			{
				String[] esta = br.readLine().split(" ");
				for(int k = 0; k < tam; k++)
				{
					 nodos[j][k].votosB = Integer.parseInt(esta[k]);
				}
			}
			District primero = new District();
			primero.agregar(nodos[0][0]);
			mejorCuenta = Integer.MIN_VALUE;
			distritos.add(primero);
			visitarDistrito(primero);
			System.out.println(mejorCuenta);
		}
	}
}