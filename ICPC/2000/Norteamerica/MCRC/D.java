import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class D
{
	static class Nodo
	{
		public Nodo(int valor)
		{
			llave = valor;
			cuenta = 1;
			altura = 1;
		}
		
		int cuenta;
		int altura;
		int llave;
		boolean borrado = false;
		Nodo padre;
		Nodo izquierdo;
		Nodo derecho;
	}
	
	static class ArbolAVL
	{
		Nodo raiz;
		
		public ArbolAVL(int inicial)
		{
			raiz = new Nodo(inicial);
			raiz.cuenta = 1;
			raiz.altura = 1;
		}
		
		public void eliminarLogico(Nodo b)
		{
			b.borrado = true;
			calcular(b);
			while(b != raiz)
			{
				b = b.padre;
				calcular(b);
			}
		}
		public void insertar(int valor)
		{
			insertar(raiz, valor);
			Nodo res = ultimoInsertado;
			res = res.padre;
			while(res != null)
			{
				int d = (res.izquierdo == null ? 0 : res.izquierdo.altura) - (res.derecho == null ? 0 : res.derecho.altura);
				if(d >= 2)
					res = rightRotate(res);
				else if(d <= -2)
					res = leftRotate(res);
				res = res.padre;
			}
		}
		
		public Nodo rightRotate(Nodo a)
		{
			Nodo p = a.padre;
			Nodo b = a.izquierdo;
			Nodo beta = b.derecho;
			b.derecho = a;
			a.izquierdo = beta;
			calcular(a);
			calcular(b);
			b.padre = p;
			a.padre = b;
			if(beta != null)
				beta.padre = a;
			if(p == null)
				raiz = b;
			else if(p.izquierdo == a)
				p.izquierdo = b;
			else
				p.derecho = b;
			return b;
		}
		
		public Nodo leftRotate(Nodo b)
		{
			Nodo p = b.padre;
			Nodo a = b.derecho;
			Nodo beta = a.izquierdo;
			b.derecho = beta;
			a.izquierdo = b;
			calcular(a);
			calcular(b);
			b.padre = a;
			a.padre = p;
			if(beta != null)
			beta.padre = b;
			if(p == null)
				raiz = a;
			else if(p.izquierdo == b)
				p.izquierdo = a;
			else
				p.derecho = a;
			return a;
		}
		
		private void calcular(Nodo a)
		{
			a.altura = Math.max(a.izquierdo == null ? 0 : a.izquierdo.altura, a.derecho == null ? 0 : a.derecho.altura) + 1;
			a.cuenta = (a.izquierdo == null ? 0 : a.izquierdo.cuenta) + (a.derecho == null ? 0 : a.derecho.cuenta)+ (a.borrado ? 0 : 1);
		}

		Nodo ultimoInsertado;
		
		private Nodo insertar(Nodo actual, int valor) 
		{
			if(actual == null)
				return ultimoInsertado = new Nodo(valor);
			if(valor < actual.llave)
			{
				actual.izquierdo = insertar(actual.izquierdo, valor);
				actual.izquierdo.padre = actual;
			}
			else
			{
				actual.derecho = insertar(actual.derecho, valor);
				actual.derecho.padre = actual;
			}
			actual.altura = Math.max(actual.izquierdo == null ? 0 : actual.izquierdo.altura, actual.derecho == null ? 0 : actual.derecho.altura) + 1;
			actual.cuenta = (actual.izquierdo == null ? 0 : actual.izquierdo.cuenta) + (actual.derecho == null ? 0 : actual.derecho.cuenta) + (actual.borrado ? 0 : 1);
			return actual;
		}
		
		public int rank(Nodo buscado)
		{
			int cuenta = buscado.izquierdo == null ? 0 : buscado.izquierdo.cuenta;
			int valor = buscado.llave;
			while(buscado != null)
			{
				if(buscado.padre != null)
				{
					Nodo padre = buscado.padre;
					if(padre.izquierdo != buscado)
						cuenta += padre.izquierdo == null ? 0 : padre.izquierdo.cuenta;
				}
				if(buscado.llave < valor && !buscado.borrado)
					cuenta++;
				buscado = buscado.padre;
			}
			return cuenta;
		}
	}
	
    static class Scanner
    {
            BufferedReader br;
            StringTokenizer st;
            
            public Scanner()
            {
            System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
                    br = new BufferedReader(new InputStreamReader(System.in));
            }
            
            public String next()
            {

                    while(st == null || !st.hasMoreTokens())
                    {
                            try { st = new StringTokenizer(br.readLine()); }
                            catch(Exception e) { throw new RuntimeException(); }
                    }
                    return st.nextToken();
            }

            public int nextInt()
            {
                    return Integer.parseInt(next());
            }
            
            public double nextDouble()
            {
                    return Double.parseDouble(next());
            }
            
            public String nextLine()
            {
                    st = null;
                    try { return br.readLine(); }
                    catch(Exception e) { throw new RuntimeException(); }
            }
            
            public boolean endLine()
            {
                    try 
                    {
                            String next = br.readLine();
                            while(next != null && next.trim().isEmpty())
                                    next = br.readLine();
                            if(next == null)
                                    return true;
                            st = new StringTokenizer(next);
                            return st.hasMoreTokens();
                    }
                    catch(Exception e) { throw new RuntimeException(); }
            }
    }

    
	public static void main(String [] args)
	{
		Scanner sc = new Scanner();
		int nCasos = sc.nextInt();
		for(int caso = 0; caso < nCasos; caso++)
		{
			ArbolAVL arbol = new ArbolAVL(1);
			int n = sc.nextInt();
			int m = sc.nextInt();
			Nodo[] nodos = new Nodo[n + 1];
			nodos[1] = arbol.raiz;
			for(int i = 2; i <= n; i++)
			{
				arbol.insertar(i);
				nodos[i] = arbol.ultimoInsertado;
			}
			int contadorActual = 0;
			for(int i = 0; i < m; i++)
			{
				int buscado = sc.nextInt();
				Nodo b = nodos[buscado];
				if(i != 0)
					System.out.print(" ");
				System.out.print(arbol.rank(b));
				arbol.eliminarLogico(b);
				arbol.insertar(contadorActual--);
				nodos[buscado] = arbol.ultimoInsertado;
			}
			System.out.println();
		}
	}
}
