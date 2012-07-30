import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class D 
{
	static class Paragrafo
	{
		String[] lineas;
		int delta;
	}
	
	static class Hoja
	{
		String[] lineas = new String[n];
		int pos = 0;
	}

	static int n;
	
	public static ArrayList <Hoja> llenar(LinkedList <Paragrafo> paragrafos)
	{
		ArrayList <Hoja> resultantes = new ArrayList <Hoja> ();
		Hoja actual = new Hoja();
		Paragrafo pActual = paragrafos.poll();
		while(!paragrafos.isEmpty() || (pActual != null && pActual.delta != pActual.lineas.length))
		{
			if((pActual.lineas.length - pActual.delta) <= (n - actual.pos))
			{
				int tam = pActual.lineas.length - pActual.delta;
				for(int i = 0; i < tam; i++)
					actual.lineas[actual.pos++] = pActual.lineas[pActual.delta++];
				if(actual.pos != actual.lineas.length)
					actual.lineas[actual.pos++] = "";
				if(actual.pos == actual.lineas.length)
				{
					resultantes.add(actual);
					actual = new Hoja();
				}
				pActual = paragrafos.poll();
			}
			else
			{
				if(actual.pos == actual.lineas.length - 1)
				{
					actual.lineas[actual.pos] = "";
					resultantes.add(actual);
					actual = new Hoja();
				}
				else
				{
					if((pActual.lineas.length - pActual.delta) - (n - actual.pos) == 1)
					{
						if(pActual.lineas.length == 2 || pActual.lineas.length == 3)
						{
							while(actual.pos != n)
								actual.lineas[actual.pos++] = "";
							resultantes.add(actual);
							actual = new Hoja();
						}
						else
						{
							int tam = pActual.lineas.length - pActual.delta;
							for(int i = 0; i < tam - 2; i++)
								actual.lineas[actual.pos++] = pActual.lineas[pActual.delta++];
							resultantes.add(actual);
							actual = new Hoja();
							while(pActual.delta != pActual.lineas.length)
								actual.lineas[actual.pos++] = pActual.lineas[pActual.delta++];
						}
					}
					else
					{
						while(actual.pos != n)
							actual.lineas[actual.pos++] = pActual.lineas[pActual.delta++];
						resultantes.add(actual);
						actual = new Hoja();
					}
				}
			}
		}
		while(actual.pos != n)
			actual.lineas[actual.pos++] = "";
		resultantes.add(actual);
		return resultantes;
	}
	
	static LinkedList <Paragrafo> paragrafos = new LinkedList <Paragrafo> ();
	static boolean termino = false;

	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		boolean empezo = false;
		while(true)
		{
			if(!empezo)
				empezo = true;
			else
			{
				if(termino)
				{
					bw.flush();
					return;
				}
				bw.write("\n");
			}
			n = Integer.parseInt(br.readLine());
			paragrafos.clear();
			while(leerParagrafo());
			ArrayList <Hoja> hojas = llenar(paragrafos);
			TreeMap <String, ArrayList <Integer> > palabras = new TreeMap <String, ArrayList <Integer> > ();
			int nHoja = 1;
			String llenar = "";
			for(char a = 0; a <= 256; a++)
			{
				boolean ok = true;
				if(a < 'A' || (a > 'Z' && a < 'a') || a > 'z')
					ok = false;
				if(!ok)
					llenar += a;
			}
			for(Hoja h : hojas)
			{
				for(String s : h.lineas)
				{
					if(s == null)
						continue;
					StringTokenizer st = new StringTokenizer(s, llenar);
					while(st.hasMoreTokens())
					{
						String token = st.nextToken().toUpperCase();
						boolean ok = true;
						for(char c : token.toCharArray())
						{
							if(c < 'A' || (c > 'Z' && c < 'a') || c > 'z')
								ok = false;
						}
						if(!ok)
							continue;
						if(palabras.containsKey(token))
						{
							ArrayList <Integer> a = palabras.get(token);
							if(a.get(a.size() - 1) == nHoja)
								continue;
							else
								a.add(nHoja);
						}
						else
						{
							ArrayList <Integer> a = new ArrayList <Integer> ();
							a.add(nHoja);
							palabras.put(token, a);
						}
					}
				}
				nHoja++;
			}
			for(Map.Entry<String, ArrayList <Integer>> e : palabras.entrySet())
			{
				boolean empezoE = false;
				bw.write(e.getKey() + " ");
				int inicio = -1;
				int fin = -1;
				for(int i : e.getValue())
				{
					if(inicio == -1)
					{
						inicio = i;
						fin = i;
					}
					else if(i > fin + 1)
					{
						if(fin - inicio > 1)
						{
							if(!empezoE)
							{
								bw.write(inicio + "-" + fin);
								empezoE = true;
							}
							else
								bw.write("," + inicio + "-" + fin);
						}
						else
						{
							if(!empezoE)
							{
								if(fin != inicio)
									bw.write(inicio + "," + fin);
								else
									bw.write(inicio + "");
								empezoE = true;
							}
							else
								if(fin != inicio)
									bw.write("," + inicio + "," + fin);
								else
									bw.write("," + inicio);
						}
						inicio = i;
						fin = i;
					}
					else
					{
						fin = i;
					}
				}
				if(fin - inicio > 1)
				{
					if(!empezoE)
					{
						bw.write(inicio + "-" + fin);
						empezoE = true;
					}
					else
						bw.write("," + inicio + "-" + fin);
				}
				else
				{
					if(inicio != -1)
						if(!empezoE)
						{
							bw.write(inicio + "");
							empezoE = true;
						}
						else
							bw.write("," + inicio);
					if(fin != -1 && fin != inicio)
						if(!empezoE)
						{
							bw.write(fin + "");
							empezoE = true;
						}
						else
							bw.write("," + fin);
				}
				bw.write("\n");
			}
		}
	}

	private static boolean leerParagrafo() throws IOException 
	{
		ArrayList <String> lineas = new ArrayList <String> ();
		while(true)
		{
			String s = br.readLine();
			if(s == null)
			{
				termino = true;
				break;
			}
			if(s.trim().isEmpty())
				break;
			lineas.add(s);
		}
		if(lineas.isEmpty())
			return false;
		Paragrafo nuevo = new Paragrafo();
		nuevo.lineas = lineas.toArray(new String[0]);
		paragrafos.add(nuevo);
		return true;
	}
}