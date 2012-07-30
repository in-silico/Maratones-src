import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class C 
{
	
	static int[][] mundo = new int[200][200];
	static int maxX;
	static int puertaActual;
	static ArrayList <Path> puertas = new ArrayList <Path> (10000);
	static LinkedList<Path> puertasQuedan = new LinkedList <Path> ();
	static LinkedList<Path> puertasQuedanNuevas = new LinkedList <Path> ();
	static Salida salida;
	static final int derecha = 0;
	static final int izquierda = 1;
	static final int arriba = 2;
	static final int abajo = 3;
	
	static class Punto
	{
		int x, y;
		boolean derecha;
		
		public Punto(int i, int j, boolean d)
		{
			x = i;
			y = j;
			derecha = d;
		}
	}
	
	static class Path
	{
		int iS, jS;
		int numeroEntradas = 0;
		int entradasActuales = 0;
		Path a = null, b = null, salida = null;
		Boolean valorCalculado;
		
		public boolean CalcularValor()
		{
			return false;
		}
	}
	
	static class Or extends Path
	{
		public Or()
		{
			numeroEntradas = 2;
		}
		
		public boolean CalcularValor()
		{
			if(valorCalculado != null)
				return valorCalculado;
			return valorCalculado = a.CalcularValor() | b.CalcularValor();
		}
	}
	
	static class And extends Path
	{
		public And()
		{
			numeroEntradas = 2;
		}
		
		public boolean CalcularValor()
		{
			if(valorCalculado != null)
				return valorCalculado;
			return valorCalculado = a.CalcularValor() & b.CalcularValor();
		}
	}
	
	static class Not extends Path
	{
		public Not()
		{
			numeroEntradas = 1;
		}
		
		public boolean CalcularValor()
		{
			if(valorCalculado != null)
				return valorCalculado;
			return valorCalculado = !a.CalcularValor();
		}
	}
	
	static class Entrada extends Path
	{
		char num;
		boolean derecha;
		ArrayList <Punto> puntos = new ArrayList <Punto> ();
		
		public Entrada(char c)
		{
			num = c;
			numeroEntradas = 0;
		}
		
		public boolean CalcularValor()
		{
			return valorCalculado;
		}
	}
	
	static class Salida extends Path
	{
		public Salida()
		{
			numeroEntradas = 1;
		}
		
		public boolean CalcularValor()
		{
			return a.CalcularValor();
		}
		
	}
	
	public static Path darPath(int i, int j, int direccion)
	{
		if(mundo[i][j] == ':')
		{
			if(i > 0 && mundo[i - 1][j] == ':')
			{
				Path nuevo = mundo[i - 1][j + 2] == '>' ? new Or() : new And();
				nuevo.iS = i - 1;
				nuevo.jS = j + 3;
				for(int ii = i - 2; ii <= i; ii++)
				{
					for(int jj = j; jj < j + 2; jj++)
					{
						mundo[ii][jj] = 1000 + puertaActual;
					}
				}
				puertas.add(nuevo);
				puertasQuedanNuevas.add(nuevo);
				puertaActual++;
				return nuevo;
			}
			else if(i < maxX - 1 && mundo[i + 1][j] == ':')
			{
				Path nuevo = mundo[i + 1][j + 2] == '>' ? new Or() : new And();
				nuevo.iS = i + 1;
				nuevo.jS = j + 3;
				for(int ii = i; ii <= i + 2; ii++)
				{
					for(int jj = j; jj < j + 2; jj++)
					{
						mundo[ii][jj] = 1000 + puertaActual;
					}
				}
				puertas.add(nuevo);
				puertasQuedanNuevas.add(nuevo);
				puertaActual++;
				return nuevo;
			}
		}
		if(mundo[i][j] == 'o')
		{
			Path nuevo = new Not();
			nuevo.iS = i;
			nuevo.jS = j + 1;
			mundo[i][j] = 1000 + puertaActual;
			puertas.add(nuevo);
			puertasQuedanNuevas.add(nuevo);
			puertaActual++;
			return nuevo;
		}
		if(mundo[i][j] == '-')
		{
			return direccion == derecha ? darPath(i, j + 1, direccion) : darPath(i, j - 1, direccion);
		}
		else if(mundo[i][j] == '+')
		{
			if(direccion == derecha || direccion == izquierda)
			{
				if(i > 0 && mundo[i - 1][j] == '|')
				{
					return darPath(i - 1, j, arriba);
				}
				else
				{
					return darPath(i + 1, j, abajo);
				}
			}
			else
			{
				if(j > 0 && mundo[i][j - 1] == '-')
				{
					return darPath(i, j - 1, izquierda);
				}
				else
				{
					return darPath(i, j + 1, derecha);
				}
			}
		}
		else if(mundo[i][j] == '|')
		{
			return direccion == arriba ? darPath(i - 1, j, direccion) : darPath(i + 1, j, direccion);
		}
		else if(mundo[i][j] == '?')
		{
			Path nuevo = new Salida();
			mundo[i][j] = 1000 + puertaActual;
			puertas.add(nuevo);
			puertasQuedanNuevas.add(nuevo);
			puertaActual++;
			return salida = (Salida) nuevo;
		}
		else
		{
			return puertas.get(mundo[i][j] - 1000);
		}
	}
	

	static Entrada[] entradas = new Entrada[27];
	static ArrayList <Entrada> entradasR = new ArrayList <Entrada> (27);
	
	public static void main(String[] args) throws IOException
	{
		int empezo = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			maxX = 0;
			puertaActual = 0;
			for(int i = 0; i < 101; i++)
			{
				for(int j = 0; j < 101; j++)
				{
					mundo[i][j] = 0;
				}
			}
			while(true)
			{
				String linea = br.readLine();
				if(linea == null)
					return;
				if(maxX == 0 && empezo++ != 0)
					System.out.println();
				if(linea.equals("*"))
					break;
				for(int i = 0; i < linea.length(); i++)
				{
					mundo[maxX][i] = linea.charAt(i);
				}
				maxX++;
			}
			for(int i = 0; i < 27; i++)
				entradas[i] = null;
			entradasR.clear();
			for(int i = 0; i < maxX; i++)
				for(int j = 0; j < 101; j++)
				{
					if(mundo[i][j] >= 'A' && mundo[i][j] <= 'Z')
					{
						if(entradas[mundo[i][j] - 'A'] == null)
						{
							entradas[mundo[i][j] - 'A'] = new Entrada((char) mundo[i][j]);
						}
						entradas[mundo[i][j] - 'A'].puntos.add(new Punto(mundo[i][j + 1] == '-' ? i : i + 1, mundo[i][j + 1] == '-' ? j + 1 : j, mundo[i][j + 1] == '-'));
					}
				}
			for(int i = 0; i < 27; i++)
				if(entradas[i] != null)
					entradasR.add(entradas[i]);
			puertas.clear();
			for(Entrada a : entradasR)
			{
				for(Punto p : a.puntos)
				{
					Path siguiente = darPath(p.x, p.y, p.derecha ? derecha : abajo);
					if(siguiente.a == null)
					{
						siguiente.a = a;
						siguiente.entradasActuales++;
					}
					else
					{
						siguiente.b = a;
						siguiente.entradasActuales++;
					}
				}
			}
			puertasQuedan.clear();
			for(Path p : puertas)
			{
				puertasQuedan.add(p);
			}
			puertasQuedanNuevas.clear();
			while(!puertasQuedan.isEmpty())
			{
				ListIterator <Path> it = puertasQuedan.listIterator();
				while(it.hasNext())
				{
					Path p = it.next();
					if(p.entradasActuales == p.numeroEntradas)
					{
						if(!(p instanceof Salida))
						{
							Path siguiente = darPath(p.iS, p.jS, derecha);
							if(siguiente.a == null)
							{
								siguiente.a = p;
								siguiente.entradasActuales++;
							}
							else
							{
								siguiente.b = p;
								siguiente.entradasActuales++;
							}
						}
						it.remove();
					}
				}
				puertasQuedan.addAll(puertasQuedanNuevas);
				puertasQuedanNuevas.clear();
			}
			while(true)
			{
				String entrada = br.readLine();
				if(entrada.equals("*"))
				{
					break;
				}
				int i = 0;
				for(char c : entrada.toCharArray())
				{
					if(entradas[i] != null)
					{
						entradas[i].valorCalculado = c == '1';
					}
					i++;
				}
				for(Path p : puertas)
				{
					p.valorCalculado = null;
				}
				System.out.println(salida.CalcularValor() ? "1" : "0");
			}
		}
	}
}
