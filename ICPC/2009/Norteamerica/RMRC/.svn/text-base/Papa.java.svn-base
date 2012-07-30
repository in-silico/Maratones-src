import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Papa 
{
	static class Persona
	{
		Boolean hombre;
		Persona ancestro;
		HashMap <String, Persona> hijos = new HashMap <String, Persona> ();
		Persona pareja;
		String nombre;
		
		public Persona(String nombre1)
		{
			nombre = nombre1;
		}
	}
	
	static HashMap <String, Persona> personas = new HashMap <String, Persona> ();
	
	public static void leer(Persona a, Persona b, String relacion)
	{
		if(relacion.equals("husband"))
		{
			a.hombre = true;
			b.hombre = false;
			if(a.pareja == b)
				return;
			a.pareja = b;
			b.pareja = a;
			a.hijos.putAll(b.hijos);
			b.hijos = a.hijos;
			for(Persona p : a.hijos.values())
				p.ancestro = a;
		}
		else if(relacion.equals("wife"))
		{
			b.hombre = true;
			a.hombre = false;
			if(a.pareja == b)
				return;
			Persona temp = a;
			a = b;
			b = temp;
			a.pareja = b;
			b.pareja = a;
			a.hijos.putAll(b.hijos);
			b.hijos = a.hijos;
			for(Persona p : a.hijos.values())
				p.ancestro = a;
		}
		else if(relacion.equals("partner"))
		{
			if(a.pareja == b)
				return;
			a.pareja = b;
			b.pareja = a;
			a.hijos.putAll(b.hijos);
			b.hijos = a.hijos;
			for(Persona p : a.hijos.values())
				p.ancestro = a;
		}
		else if(relacion.equals("daughter"))
		{
			a.hombre = false;
			if(a.pareja != null)
				a.pareja.hombre = true;
			if(a.ancestro == null)
				a.ancestro = b;
			else
			{
				if(a.ancestro.pareja == null)
				{
					if(a.ancestro.hombre != null)
						leer(a.ancestro, b, a.ancestro.hombre ? "husband" : "wife");
					else
						leer(a.ancestro, b, "partner");
				}
			}
			b.hijos.put(a.nombre, a);
		}
		else if(relacion.equals("son"))
		{
			a.hombre = true;
			if(a.pareja != null)
				a.pareja.hombre = false;
			if(a.ancestro == null)
				a.ancestro = b;
			else
			{
				if(a.ancestro.pareja == null)
				{
					if(a.ancestro.hombre != null)
						leer(a.ancestro, b, a.ancestro.hombre ? "husband" : "wife");
					else
						leer(a.ancestro, b, "partner");
				}
			}
			b.hijos.put(a.nombre, a);
		}
		else if(relacion.equals("mother"))
		{
			a.hombre = false;
			if(a.pareja != null)
				a.pareja.hombre = true;
			if(b.ancestro == null)
				b.ancestro = a;
			else if(b.ancestro.pareja == null)
				leer(a, b.ancestro, a.hombre ? "husband" : "wife");
			a.hijos.put(b.nombre, b);
		}
		else if(relacion.equals("father"))
		{
			a.hombre = true;
			if(a.pareja != null)
				a.pareja.hombre = false;
			if(b.ancestro == null)
				b.ancestro = a;
			else if(b.ancestro.pareja == null)
				leer(a, b.ancestro, a.hombre ? "husband" : "wife");
			a.hijos.put(b.nombre, b);
		}
	}
	
	public static int respuesta(Persona a, Persona b, String relacion)
	{
		if(relacion.equals("wife"))
		{
			if(a.pareja == b)
			{
				if(a.hombre == null)
					return 2;
				else if(!a.hombre)
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
		else if(relacion.equals("husband"))
		{
			if(a.pareja == b)
			{
				if(a.hombre == null)
					return 2;
				else if(a.hombre)
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
		else if(relacion.equals("daughter"))
		{
			if(b.hijos.containsKey(a.nombre))
			{
				if(a.hombre == null)
					return 2;
				else if(!a.hombre)
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
		else if(relacion.equals("son"))
		{
			if(b.hijos.containsKey(a.nombre))
			{
				if(a.hombre == null)
					return 2;
				else if(a.hombre)
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
		else if(relacion.equals("mother"))
		{
			if(a.hijos.containsKey(b.nombre))
			{
				if(a.hombre == null)
					return 2;
				else if(!a.hombre)
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
		else if(relacion.equals("father"))
		{
			if(a.hijos.containsKey(b.nombre))
			{
				if(a.hombre == null)
					return 2;
				else if(a.hombre)
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
		else if(relacion.equals("niece"))
		{
			if(a.ancestro == null)
				return 0;
			else
			{
				if(a.ancestro.ancestro != null)
				{
					for(Persona p : a.ancestro.ancestro.hijos.values())
					{
						if(p == a.ancestro)
							continue;
						if(p == b)
						{
							if(a.hombre == null)
								return 2;
							else if(!a.hombre)
								return 1;
							else
								return 0;
						}
					}
				}
				if(a.ancestro.pareja != null && a.ancestro.pareja.ancestro != null)
				{
					for(Persona p : a.ancestro.pareja.ancestro.hijos.values())
					{
						if(p == a.ancestro.pareja)
							continue;
						if(p == b)
						{
							if(a.hombre == null)
								return 2;
							else if(!a.hombre)
								return 1;
							else
								return 0;
						}
					}
				}
				return 0;
			}
		}
		else if(relacion.equals("nephew"))
		{
			if(a.ancestro == null)
				return 0;
			else
			{
				if(a.ancestro.ancestro != null)
				{
					for(Persona p : a.ancestro.ancestro.hijos.values())
					{
						if(p == a.ancestro)
							continue;
						if(p == b)
						{
							if(a.hombre == null)
								return 2;
							else if(a.hombre)
								return 1;
							else
								return 0;
						}
					}
				}
				if(a.ancestro.pareja != null && a.ancestro.pareja.ancestro != null)
				{
					for(Persona p : a.ancestro.pareja.ancestro.hijos.values())
					{
						if(p == a.ancestro.pareja)
							continue;
						if(p == b)
						{
							if(a.hombre == null)
								return 2;
							else if(a.hombre)
								return 1;
							else
								return 0;
						}
					}
				}
				return 0;
			}
		}
		else if(relacion.equals("grandfather"))
		{
			for(Persona p : a.hijos.values())
				for(Persona p1 : p.hijos.values())
					if(p1 == b)
					{
						if(a.hombre == null)
							return 2;
						else if(a.hombre)
							return 1;
						else
							return 0;
					}
			return 0;
		}
		else if(relacion.equals("grandmother"))
		{
			for(Persona p : a.hijos.values())
				for(Persona p1 : p.hijos.values())
					if(p1 == b)
					{
						if(a.hombre == null)
							return 2;
						else if(!a.hombre)
							return 1;
						else
							return 0;
					}
			return 0;
		}
		else if(relacion.equals("grandson"))
		{
			if(a.ancestro == null)
				return 0;
			else
			{
				if(a.ancestro.ancestro == b || (a.ancestro.ancestro != null && a.ancestro.ancestro.pareja == b))
				{
					if(a.hombre == null)
						return 2;
					else if(a.hombre)
						return 1;
					else
						return 0;
				}
				if(a.ancestro.pareja == null)
					return 0;
				if(a.ancestro.pareja.ancestro == b || (a.ancestro.pareja.ancestro != null && a.ancestro.pareja.ancestro.pareja == b))
				{
					if(a.hombre == null)
						return 2;
					else if(a.hombre)
						return 1;
					else
						return 0;
				}
				return 0;
			}
		}
		else if(relacion.equals("granddaughter"))
		{
			if(a.ancestro == null)
				return 0;
			else
			{
				if(a.ancestro.ancestro == b || (a.ancestro.ancestro != null && a.ancestro.ancestro.pareja == b))
				{
					if(a.hombre == null)
						return 2;
					else if(!a.hombre)
						return 1;
					else
						return 0;
				}
				if(a.ancestro.pareja == null)
					return 0;
				if(a.ancestro.pareja.ancestro == b || (a.ancestro.pareja.ancestro != null && a.ancestro.pareja.ancestro.pareja == b))
				{
					if(a.hombre == null)
						return 2;
					else if(!a.hombre)
						return 1;
					else
						return 0;
				}
				return 0;
			}
		}
		return 0;
	}
	
	public static Persona darPersona(String p)
	{
		if(!personas.containsKey(p))
			personas.put(p, new Persona(p));
		return personas.get(p);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			personas.clear();
			while(true)
			{
				String linea = br.readLine();
				if(linea == null)
					return;
				linea = linea.trim();
				if(linea.isEmpty())
					break;
				StringTokenizer st = new StringTokenizer(linea);
				String a = st.nextToken();
				st.nextToken();
				String b = st.nextToken();
				b = b.substring(0, b.length() - 2);
				String c = st.nextToken();
				c = c.substring(0, c.length() - 1);
				leer(darPersona(a), darPersona(b), c);
			}
			for(Persona p : personas.values())
				for(Persona p1 : p.hijos.values())
					p1.ancestro = p;
			while(true)
			{
				String linea = br.readLine();
				if(linea == null)
					return;
				linea = linea.trim();
				if(linea.isEmpty())
					break;
				StringTokenizer st = new StringTokenizer(linea);
				st.nextToken();
				String a = st.nextToken();
				String b = st.nextToken();
				b = b.substring(0, b.length() - 2);
				String c = st.nextToken();
				c = c.substring(0, c.length() - 1);
				int respuesta = respuesta(darPersona(a), darPersona(b), c);
				System.out.println(respuesta == 0 ? "no" : respuesta == 1 ? "yes" : "unknown");
			}
			System.out.println();
		}
	}
}
