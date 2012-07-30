import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class A 
{
	static abstract class Referencia
	{
		abstract boolean igual(Referencia otra);
	}

	static class Variable extends Referencia
	{
		Referencia referencia;

		Referencia buscarPadre()
		{
			if(referencia == null)
				return this;
			if(!(referencia instanceof Variable))
				return referencia;
			Variable padre = (Variable) referencia;
			return referencia = padre.buscarPadre();
		}

		boolean igual(Referencia otra)
		{
			if(otra instanceof Variable)
				otra = ((Variable) otra).buscarPadre();
			Referencia padre = buscarPadre();
			if(padre instanceof Variable && otra instanceof Variable)
			{
				if(otra == padre)
					return true;
				((Variable) padre).referencia = otra;
				return true;
			}
			else if(padre instanceof Variable)
			{
				if(contiene(otra, (Variable) padre))
					return false;
				((Variable) padre).referencia = otra;
				return true;
			}
			else
				return padre.igual(otra);
		}
	}

	static class Constante extends Referencia
	{
		String valor;

		boolean igual(Referencia otra)
		{
			if(otra instanceof Funcion)
				return false;
			if(otra instanceof Constante)
			{
				Constante otraC = (Constante) otra;
				return otraC.valor.equals(valor);
			}
			else
				return otra.igual(this);
		}
	}

	static class Funcion extends Referencia
	{
		String valor;
		ArrayList <Referencia> referencias = new ArrayList <Referencia> ();

		boolean igual(Referencia otra)
		{
			if(otra instanceof Constante)
				return false;
			if(otra instanceof Funcion)
			{
				Funcion otraF = (Funcion) otra;
				if(!otraF.valor.equals(valor))
					return false;
				if(otraF.referencias.size() != referencias.size())
					return false;
				int i = 0;
				for(Referencia r : referencias)
					if(!r.igual(otraF.referencias.get(i++)))
						return false;
				return true;
			}
			else
				return otra.igual(this);
		}
	}
	
	static int actual = 0;

	static Referencia leerReferencia(char[] s)
	{
		int j = actual;
		while(j < s.length && s[j] >= 'A') j++;
	    if (j == s.length || s[j] != '(') 
	    {
	    	if(s[actual] >= 'A' && s[actual] <= 'Z')
	    	{
				String variable = new String(s, actual, j - actual);
		    	actual = j;
				if(variables.containsKey(variable))
					return variables.get(variable);
				else
				{
					Variable nueva = new Variable();
					variables.put(variable, nueva);
					return nueva;
				}
	    	}
	    	else
	    	{
				String constante = new String(s, actual, j - actual);
		    	actual = j;
				Constante nueva = new Constante();
				nueva.valor = constante;
	    		return nueva;
	    	}
	    }
	    Funcion respuesta = new Funcion();
	    respuesta.valor = new String(s, actual, j - actual);
	    actual = j;
	    while(s[actual] != ')')
	    {
	    	actual++;
	    	respuesta.referencias.add(leerReferencia(s));
	    }
	    actual++;
	    return respuesta;
	}


	static TreeMap <String, Referencia> variables = new TreeMap <String, Referencia> ();

	static boolean contiene(Referencia a, Variable b)
	{
		if(a instanceof Variable)
		{
			Variable aa = (Variable) a;
			a = aa.buscarPadre();
		}
		if(a == b)
			return true;
		if(a instanceof Funcion)
		{
			Funcion aa = (Funcion) a;
			for(Referencia x : aa.referencias)
				if(contiene(x, b))
					return true;
		}
		return false;
	}

	static boolean match(ArrayList <Referencia> funciones)
	{
		for(int i = 0; i < funciones.size() - 1; i++)
			if(!funciones.get(i).igual(funciones.get(i + 1)))
				return false;
		return true;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String nombre = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			if(nombre.equals("END") && n == 0)
				return;
			variables.clear();
			ArrayList <Referencia> funciones = new ArrayList <Referencia> ();
			for(int i = 0; i < n; i++)
			{
				String lectura = br.readLine().replace(" ", "");
				actual = 0;
				funciones.add(leerReferencia(lectura.toCharArray()));
			}
			if(!match(funciones))
				System.out.println(nombre + " is a Starflyer agent");
			else
				System.out.println("analysis inconclusive on " + nombre);
		}
	}
}