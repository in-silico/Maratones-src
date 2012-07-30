import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B
{
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
	
	static class SuperWriter
	{
		char[] buffer;
		OutputStreamWriter os;
		int pos;
		
		public SuperWriter() throws FileNotFoundException
		{
			buffer = new char[6000001];
			os = new OutputStreamWriter(System.out);
			pos = 0;
		}
		
		public void println(String s)
		{
			print(s);
			print("\n");
		}
		
		public void print(String s)
		{
			int tam = s.length();
			if(pos + tam > buffer.length)
				tam = buffer.length - pos;
			s.getChars(0, tam, buffer, pos);
			pos += tam;
			if(pos == buffer.length)
			{
				try
				{
					os.write(buffer);
					pos = 0;
					print(s.substring(tam));
				}
				catch(Exception e)
				{
					throw(new RuntimeException());
				}
			}
		}

		public void flush() 
		{
			try 
			{
				os.write(buffer, 0, pos);
				pos = 0;
				os.flush();
			}
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
	}
	
	
	static char[] entrada = new char[0];
	static int actual = 0;
	static HashMap <Nodo, Nodo> mapa = new HashMap <Nodo, Nodo> ();
	static int cuenta = 1;
	
	static class Nodo
	{
		String num;
		Nodo izquierda;
		Nodo derecha;
		int id;
		Integer hash;
		boolean impreso = false;
		
		public Nodo()
		{
			num = "";
			while(actual != entrada.length && entrada[actual] >= 'a' && entrada[actual] <= 'z')
				num += entrada[actual++];
		}
		
		void imprimir()
		{
			if(impreso)
			{
				sw.print(id + "");
				return;
			}
			impreso = true;
			if(izquierda == null)
			{
				sw.print(num);
				max = Math.max(max, id);
			}
			else
			{
				max = Math.max(max, id);
				sw.print(num + "(");
				izquierda.imprimir();
				sw.print(",");
				derecha.imprimir();
				sw.print(")");
			}
		}
		
		@Override
		public int hashCode() 
		{
			if(hash != null)
				return hash;
			if(izquierda == null)
				return hash = num.hashCode();
			return hash = num.hashCode() ^ (izquierda.hashCode() ^ derecha.hashCode());
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			if(obj == null)
				return false;
			Nodo otro = (Nodo) obj;
			if(izquierda == null)
				return otro.izquierda == null && otro.num.equals(num);
			else if(otro.izquierda == null)
				return false;
			return num.equals(otro.num) && izquierda.id == otro.izquierda.id && derecha.id == otro.derecha.id;
		}
	}
	
	static Nodo leerNodo()
	{
		Nodo a = new Nodo();
		a.id = cuenta++;
		if(actual == entrada.length)
			return a;
		if(entrada[actual] == '(')
		{
			actual++;
			a.izquierda = leerNodo();
			actual++;
			a.derecha = leerNodo();
			actual++;
		}
		else
		{
			a.izquierda = null;
			a.derecha = null;
		}
		if(mapa.containsKey(a))
		{
			cuenta--;
			return mapa.get(a);
		}
		else
		{
			mapa.put(a, a);
			return a;
		}
	}
	
	static int max = -1;
	static SuperWriter sw;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		sw = new SuperWriter();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			mapa.clear();
			cuenta = 1;
			actual = 0;
			max = -1;
			entrada = br.readLine().toCharArray();
			Nodo raiz = leerNodo();
			raiz.imprimir();
			sw.println("");
		}
		sw.flush();
	}
}