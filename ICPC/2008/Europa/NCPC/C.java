import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class C {

	static class Scanner 
	{
		InputStreamReader i;
		char b[];
		int p = -1, d, h, t;
		
		public Scanner() throws IOException
		{
			b = new char[250000];
			i = new InputStreamReader(System.in);
			i.read(b);
		}
		
		public boolean noTieneMas()
		{
			return (p != -1 && p != b.length && b[p] == '\0') || (p != -1 && p < b.length - 1 && b[p + 1] == '\0');
		}
		
		
		public void leer(char c) throws IOException
		{
			try
			{
				while(b[++p] <= c);
				d = p;
				h = d - 1;
				while(b[++h] > c);
				p = h--;
			}
			catch(Exception e)
			{
				organizar();
				leer(c);
			}
		}
		
		void organizar() throws IOException
		{
			int hd = 0;
			if(p != b.length)
			{
				hd = h - d;
				System.arraycopy(b, d, b, 0, hd);
				d = 0;
			}
			p = -1;
			int l = i.read(b, hd, b.length - hd);
			if(hd + l < b.length)
				b[hd + (l == -1 ? 0 : -1)] = '\0';
		}
		
		public String next() throws IOException
		{
			leer(' ');
			return new String(b, d, h - d + 1);
		}
		
		public String nextLine() throws IOException
		{
			if(p != -1 && b[p] != '\n')
			{
				p--;
				leer('\n');
			}
			leer('\n');
			return new String(b, d, h - d + 1);
		}
		
		public int nextInt() throws IOException
		{
			return (int) nextLong();
		}

		public long nextLong() throws IOException
		{
			leer(' ');
			long r = 0;
			boolean n = b[d] == '-';
			if(n) d++;
			r -= b[d++] - '0';
			while(d <= h && (r *= 10) <= 0)
				r -= b[d++] - '0';
			return n ? r : -r;
		}
		
		public double nextDouble() throws IOException
		{
			return Double.parseDouble(next());
		}
	}
	
	
	public static String trim(String a)
	{
		char[] entrada = a.toCharArray();
		int i = 0;
		if(a.length() == 0)
			return a;
		while(i < entrada.length && entrada[i] == ' ') i++;
		int inicio = i;
		i = entrada.length - 1;
		while(i >= 0 && entrada[i] == ' ') i--;
		return a.substring(inicio, Math.max(inicio, i + 1));
	}
	
	public static int copia(String original)
	{
		char[] entrada = trim(original).toCharArray();
		StringBuilder sb = new StringBuilder(entrada.length);
		for(int i = 0; i < entrada.length; i++)
		{
			if(entrada[i] == ' ')
			{
				sb.append(' ');
				while(entrada[i] == ' ')
					i++;
				i--;
			}
			else
			{
				sb.append(entrada[i]);
			}
		}
		String nuevo = sb.toString();
		if(nuevo.length() == 0)
			return -1;
		Integer numero = lineas.get(nuevo);
		if(numero != null)
			return numero;
		lineas.put(nuevo, numeroActual);
		return numeroActual++;
	}
	
	static int numeroActual = 0;
	static class Archivo
	{
		String nombre; 
		int[] linea = new int[10000];
		int tamLinea = 0;
		public Archivo(String n)
		{
			nombre = n;
		}
	}
	static HashMap <String, Integer > lineas = new HashMap<String, Integer> (100000);
	static HashMap <Integer, ArrayList <Integer> > archivoInicial = new HashMap<Integer, ArrayList <Integer> >(100001);
	static Archivo[] archivos = new Archivo[101];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 101; i++)
			archivos[i] = new Archivo("");
		Archivo inicial = new Archivo("");
		while(true)
		{
			numeroActual = 0;
			archivoInicial.clear();
			lineas.clear();
			String sga = br.readLine();
			if(sga == null)
				return;
			int n = Integer.parseInt(sga);
			for(int i = 0; i < n; i++)
			{
				archivos[i].nombre = br.readLine();
				archivos[i].tamLinea = 0;
				while(true)
				{
					String siguiente = br.readLine();
					if(siguiente.equals("***END***"))
						break;
					int nSiguiente = copia(siguiente);
					if(nSiguiente == -1)
						continue;
					archivos[i].linea[archivos[i].tamLinea++] = nSiguiente;
				}
			}
			int indice = 0;
			inicial.tamLinea = 0;
			while(true)
			{
				String siguiente = br.readLine();
				if(siguiente.equals("***END***"))
					break;
				int esta = copia(siguiente);
				if(esta == -1)
					continue;
				inicial.linea[inicial.tamLinea++] = esta;
				ArrayList <Integer> posible = archivoInicial.get(esta);
				if(posible != null)
				{
					posible.add(indice);
				}
				else
				{
					ArrayList <Integer> nuevo = new ArrayList <Integer> ();
					nuevo.add(indice);
					archivoInicial.put(esta, nuevo);
				}
				indice++;
			}
			int cuentaMayor = 0;
			ArrayList <Archivo> quienesMayor = new ArrayList <Archivo> (); 
			for(int i = 0; i < n; i++)
			{
				Archivo archivoActual = archivos[i];
				int tam = archivoActual.tamLinea;
				int[] este = archivoActual.linea;
				boolean agregadoActual = false;
				for(int j = 0; j < tam; j++)
				{
					ArrayList <Integer> posible = archivoInicial.get(este[j]);
					if(posible != null)
					{
						for(int in : posible)
						{
							int cuentaActual = 0;
							int indice1 = j;
							while(in < inicial.tamLinea && indice1 < tam)
							{
								if(inicial.linea[in] == este[indice1])
									cuentaActual++;
								else
									break;
								indice1++;
								in++;
							}
							if(cuentaActual > cuentaMayor)
							{
								quienesMayor.clear();
								quienesMayor.add(archivoActual);
								cuentaMayor = cuentaActual;
								agregadoActual = true;
							}
							else if(cuentaActual == cuentaMayor)
							{
								if(!agregadoActual)
								{
									agregadoActual = true;
									quienesMayor.add(archivoActual);
								}
							}
						}
					}
				}
			}
			System.out.print(cuentaMayor);
			for(Archivo a : quienesMayor)
				System.out.print(" " + a.nombre);
			System.out.println();
		}
		
	}
}
