import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class G 
{
	static class SuperRespuesta
	{
		Respuesta padre;
		Respuesta noPadre;
		
		public SuperRespuesta(Respuesta a, Respuesta b)
		{
			padre = a;
			noPadre = b;
		}
	}
	
	static class Respuesta
	{
		int f;
		int i;
		
		public Respuesta(int fa, int in)
		{
			f = fa;
			i = in;
		}
		
		long darCosto()
		{
			return f * familiar + i * individual;
		}
		
		void sumar(Respuesta otra)
		{
			f += otra.f;
			i += otra.i;
		}
		
		boolean mejor(Respuesta otra)
		{
			long costoEsta = darCosto();
			long costoOtra = otra.darCosto();
			if(costoEsta < costoOtra)
				return true;
			else if(costoEsta > costoOtra)
				return false;
			else
			{
				int totalEsta = f + i;
				int totalOtra = otra.f + otra.i;
				if(totalEsta < totalOtra)
					return true;
				return false;
			}
		}
	}
	static long familiar, individual;
	
	static class Persona
	{
		String nombre;
		LinkedList <Persona> hijos = new LinkedList <Persona> ();
		boolean tienePadres = false;
		boolean visitado = false;
		
		public Persona(String n)
		{
			nombre = n;
		}
		
		SuperRespuesta mejor()
		{
			if(hijos.isEmpty())
					return new SuperRespuesta(new Respuesta(0, 0), familiar < individual ? new Respuesta(1, 0) : new Respuesta(0, 1));
			Respuesta costoTotalF = new Respuesta(1, 0);
			Respuesta costoTotalIP = new Respuesta(0, 0);
			Respuesta costoTotalIN = new Respuesta(0, 1);
			for(Persona h : hijos)
			{
				SuperRespuesta rh = h.mejor();
				costoTotalF.sumar(rh.padre);
				costoTotalIP.sumar(rh.noPadre);
				costoTotalIN.sumar(rh.noPadre);
			}
			return new SuperRespuesta(costoTotalF.mejor(costoTotalIP) ? costoTotalF : costoTotalIP, costoTotalF.mejor(costoTotalIN) ? costoTotalF : costoTotalIN);
		}
	}
	
	static TreeMap <String, Persona> mapa = new TreeMap <String, Persona> ();
	
	public static Persona darPersona(String s)
	{
		Persona posible = mapa.get(s);
		if(posible == null)
		{
			posible = new Persona(s);
			mapa.put(s, posible);
		}
		return posible;
	}

	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long individualS = Long.parseLong(st.nextToken());
		long familiarS = Long.parseLong(st.nextToken());
		int caso = 1;
		while(true)
		{
			individual = individualS;
			familiar = familiarS;
			if(individual == 0 && familiar == 0)
				return;
			mapa.clear();
			while(true)
			{
				st = new StringTokenizer(br.readLine());
				String siguiente = st.nextToken();
				if(siguiente.charAt(0) >= '0' && siguiente.charAt(0) <= '9')
				{
					individualS = Long.parseLong(siguiente);
					familiarS = Long.parseLong(st.nextToken());
					break;
				}
				Persona actual = darPersona(siguiente);
				while(st.hasMoreTokens())
					actual.hijos.add(darPersona(st.nextToken()));
				for(Persona p : actual.hijos)
					p.tienePadres = true;
			}
			Respuesta total = new Respuesta(0, 0);
			for(Persona p : mapa.values())
			{
				if(!p.tienePadres && !p.visitado)
				{
					total.sumar(p.mejor().noPadre);
					p.visitado = true;
				}
			}
			System.out.println(caso++ + ". " + total.i + " " + total.f + " " + total.darCosto());
		}
	}
}
