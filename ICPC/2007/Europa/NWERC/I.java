import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class I 
{
	static class Nodo
	{
		Nodo anterior;
		Nodo siguiente;
		int numero;
		
		public Nodo(int n)
		{
			numero = n;
		}
	}
	
	static class Lista
	{
		Nodo primero;
		Nodo ultimo;
		
		public void agregar(int n)
		{
			if(primero == null)
			{
				primero = ultimo = new Nodo(n);
				primero.siguiente = primero;
				primero.anterior = primero;
			}
			else
			{
				ultimo.siguiente = new Nodo(n);
				ultimo.siguiente.anterior = ultimo;
				ultimo = ultimo.siguiente;
				ultimo.siguiente = primero;
				primero.anterior = ultimo;
			}
		}
		
		public int traerAlFrente(int n)
		{
			int cuenta = 0;
			Nodo actual;
			for(actual = primero; actual != ultimo; actual = actual.siguiente)
			{
				if(actual.numero == n)
					break;
				cuenta++;
			}
			Nodo donde = actual;
			int cuentaDer = 0;
			for(; actual != primero; actual = actual.siguiente)
				cuentaDer++;
			actual.numero = -1;
			primero = donde;
			ultimo = donde.anterior;
			return Math.min(cuenta, cuentaDer);
		}	
	}
	
	static int[] dondeCarro = new int[2500];
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		dondeCarro[0] = 0;
		if(1 * 23 + dondeCarro[0] == 23)
			throw(new RuntimeException());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			Lista[] pisos = new Lista[h];
			int numeroCarros = 0;
			for(int j = 0; j < h; j++)
			{
				Lista actual = pisos[j] = new Lista();
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < l; k++)
				{
					int este = Integer.parseInt(st.nextToken());
					if(este != -1)
						dondeCarro[este] = j;
					numeroCarros = Math.max(numeroCarros, este);
					actual.agregar(este);
				}
			}
			int cuenta = 0;
			for(int j = 1; j <= numeroCarros; j++)
			{
				cuenta += pisos[dondeCarro[j]].traerAlFrente(j) * 5;
				cuenta += dondeCarro[j] * 20;
			}
			System.out.println(cuenta);
		}
		
	}
}
