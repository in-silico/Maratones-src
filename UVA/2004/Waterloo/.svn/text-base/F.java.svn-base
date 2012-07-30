import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;


public class F 
{
	static class Nodo implements Comparable <Nodo>
	{
		int numero;
		int nPadres = 0;
		int valor = 0;
		ArrayList <Nodo> siguientes = new ArrayList <Nodo> ();
		
		@Override
		public int compareTo(Nodo o) 
		{
			return Integer.valueOf(valor).compareTo(o.valor);
		}
	}
	
	static class Respuesta
	{
		int valor;
		int numero;
		
		public Respuesta(int valor, int numero) {
			super();
			this.valor = valor;
			this.numero = numero;
		}
	}
	static ArrayList <Nodo> nodos = new ArrayList <Nodo> ();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern p = Pattern.compile(" ");
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			while(n + 1 > nodos.size())
			{
				nodos.add(new Nodo());
			}
			for(int i = 1; i <= n; i++)
			{
				nodos.get(i).nPadres = 0;
			}
			for(int i = 0; i < n; i++)
			{
				String[] pedazos = p.split(br.readLine());
				int esta = Integer.parseInt(pedazos[0]);
				int bolas = Integer.parseInt(pedazos[1]);
				Nodo actual = nodos.get(esta);
				actual.numero = bolas;
				actual.siguientes.clear();
				int nHijos = Integer.parseInt(pedazos[2]);
				for(int j = 0; j < nHijos; j++)
				{
					actual.siguientes.add(nodos.get(Integer.parseInt(pedazos[3 + j])));
					nodos.get(Integer.parseInt(pedazos[3 + j])).nPadres++;
				}
			}
			Nodo raiz = null;
			for(int i = 1; i <= n; i++)
			{
				if(nodos.get(i).nPadres == 0)
					raiz = nodos.get(i);
			}
			System.out.println(valor(raiz).valor);
		}
	}

	private static int visitar(Nodo nodo) 
	{
		if(nodo.siguientes.isEmpty())
			return nodo.numero - 1;
		int cuenta = nodo.numero - 1;
		for(Nodo siguiente : nodo.siguientes)
		{
			cuenta += visitar(siguiente);
		}
		return cuenta;
	}
	
	private static Respuesta valor(Nodo nodo) 
	{
		for(Nodo siguiente : nodo.siguientes)
		{
			siguiente.valor = visitar(siguiente);
		}
		Collections.sort(nodo.siguientes, Collections.reverseOrder());
		Respuesta inicial = new Respuesta(0, nodo.numero - 1); 
		for(Nodo siguiente : nodo.siguientes)
		{
			Respuesta actual = valor(siguiente);
			inicial.numero += actual.numero;
			inicial.valor += actual.valor;
		}
		inicial.valor += Math.abs(inicial.numero);
		return inicial;
	}
}
