import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B 
{
    public static class Scanner
    {
        BufferedReader br;
        StringTokenizer st;

        public Scanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next()
        {
            try
            {
                while(st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
            }
            catch(Exception e)
            {
                throw(new RuntimeException());
            }
            return st.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
    
    static class Set implements Comparable <Set>
    {
        int id;
        int tam;
        int[] valores;

        public Set(int i, int len)
        {
            id = i;
            valores = new int[len];
            tam = len;
        }

		@Override
		public int compareTo(Set o)
		{
			if(o.tam != tam)
				return tam - o.tam;
			else
			{
				for(int i = 0; i < tam; i++)
				{
					if(o.valores[i] != valores[i])
						return valores[i] - o.valores[i];
				}
				return 0;
			}
		}
		
		public Set darTemporal()
		{
			if(sets.containsKey(temporal))
				return sets.get(temporal);
			Set nuevo = new Set(todos.size(), temporal.tam);
			for(int i = 0; i < temporal.tam; i++)
				nuevo.valores[i] = temporal.valores[i];
			sets.put(nuevo, nuevo);
			todos.add(nuevo);
			return nuevo;
		}
		
		static Set temporal = new Set(0, 10000);
		
		public Set union(Set otro)
		{
			int indiceI = 0;
			int indiceJ = 0;
			int tamI = 0;
			while(indiceI != tam || indiceJ != otro.tam)
			{
				int a = indiceI == tam ? Integer.MAX_VALUE : valores[indiceI];
				int b = indiceJ == otro.tam ? Integer.MAX_VALUE : otro.valores[indiceJ];
				if(a == b)
				{
					temporal.valores[tamI++] = a;
					indiceI++;
					indiceJ++;
				}
				else if(a < b)
				{
					temporal.valores[tamI++] = a;
					indiceI++;
				}
				else
				{
					temporal.valores[tamI++] = b;
					indiceJ++;
				}
			}
			temporal.tam = tamI;
			Set temporal = darTemporal();
			return temporal;
		}
		
		public Set intersect(Set otro)
		{
			int indiceI = 0;
			int indiceJ = 0;
			int tamI = 0;
			while(indiceI != tam || indiceJ != otro.tam)
			{
				int a = indiceI == tam ? Integer.MAX_VALUE : valores[indiceI];
				int b = indiceJ == otro.tam ? Integer.MAX_VALUE : otro.valores[indiceJ];
				if(a == b)
				{
					temporal.valores[tamI++] = a;
					indiceI++;
					indiceJ++;
				}
				else if(a < b)
					indiceI++;
				else
					indiceJ++;
			}
			temporal.tam = tamI;
			Set temporal = darTemporal();
			return temporal;
		}
		
		public Set add(Set other)
		{
			int idO = other.id;
			for(int i = 0; i < tam; i++)
			{
				temporal.valores[i] = valores[i];
				if(valores[i] == idO)
					return this;
			}
			temporal.valores[tam] = idO;
			temporal.tam = tam + 1;
			Arrays.sort(temporal.valores, 0, temporal.tam);
			Set temporal = darTemporal();
			return temporal;
		}
		
		@Override
		public String toString() 
		{
			String salida = "{";
			for(int i = 0; i < tam; i++)
				salida += todos.get(valores[i]);
			salida += "}";
			return salida;
		}
    }
    
    static TreeMap <Set, Set> sets = new TreeMap <Set, Set> (); 
	static ArrayList <Set> todos = new ArrayList <Set> ();
    
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner();
    	int t = sc.nextInt();
    	Set vacio = new Set(0, 0);
    	for(int caso = 0; caso < t; caso++)
    	{
    		todos.clear();
    		sets.clear();
    		todos.add(vacio);
    		sets.put(vacio, vacio);
    		int nInstrucciones = sc.nextInt();
    		LinkedList <Set> pila = new LinkedList <Set> ();
    		for(int i = 0; i < nInstrucciones; i++)
    		{
    			String instruccion = sc.next();
    			if(instruccion.equals("PUSH"))
    				pila.push(vacio);
    			else if(instruccion.equals("DUP"))
    			{
    				Set actual = pila.pop();
    				pila.push(actual);
    				pila.push(actual);
    			}
    			else if(instruccion.equals("UNION"))
    			{
    				Set a = pila.pop();
    				Set b = pila.pop();
    				pila.push(a.union(b));
    			}
    			else if(instruccion.equals("INTERSECT"))
    			{
    				Set a = pila.pop();
    				Set b = pila.pop();
    				pila.push(a.intersect(b));
    			}
    			else
    			{
    				Set a = pila.pop();
    				Set b = pila.pop();
    				pila.push(b.add(a));
    			}
    			System.out.println(pila.peek().tam);
    		}
    		System.out.println("***");
    	}
    }
}