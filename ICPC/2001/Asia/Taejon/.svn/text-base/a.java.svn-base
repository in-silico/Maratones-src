import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;


public class a 
{
	public static class Entrada 
	{
		Calendar c;
		boolean adam;
		
		public Entrada(Calendar cc, boolean a)
		{
			c = cc;
			adam = a;
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			Entrada otra = (Entrada) obj;
			return otra.c.equals(c) && otra.adam == adam;
		}
		
		@Override
		public int hashCode() {
			int hash = c.hashCode();
			if(adam)
				return hash * 2;
			return hash;
		}
	}
	
	static HashMap <Entrada, Boolean> dp = new HashMap <Entrada, Boolean> ();
	static Calendar fecha;
	
	
	public static void poner(Calendar c, int year, int month, int day)
	{
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.HOUR, 1);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DATE, day);
	}
	
	public static boolean jugar(Entrada e)
	{
		Boolean posible = dp.get(e);
		if(posible != null)
			return posible;
		if(e.c.after(fecha))
		{
			dp.put(e, e.adam);
			return e.adam;
		}
		Calendar nuevo = Calendar.getInstance();
		poner(nuevo, e.c.get(Calendar.YEAR), e.c.get(Calendar.MONTH), e.c.get(Calendar.DATE));
		nuevo.add(Calendar.MONTH, 1);
		boolean respuesta = false;
		if(nuevo.get(Calendar.DAY_OF_MONTH) == e.c.get(Calendar.DAY_OF_MONTH))
		{
			if(nuevo.equals(fecha))
			{
				dp.put(e, e.adam);
				return e.adam;
			}
			respuesta = jugar(new Entrada(nuevo, !e.adam));
			if((respuesta && e.adam) || (!respuesta && !e.adam))
			{
				dp.put(e, e.adam);
				return e.adam;
			}
		}
		poner(nuevo, e.c.get(Calendar.YEAR), e.c.get(Calendar.MONTH), e.c.get(Calendar.DATE));
		nuevo.add(Calendar.DAY_OF_MONTH, 1);
		if(nuevo.equals(fecha))
		{
			dp.put(e, e.adam);
			return e.adam;
		}
		respuesta = jugar(new Entrada(nuevo, !e.adam));
		dp.put(e, respuesta);
		return respuesta;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		fecha = Calendar.getInstance();
		poner(fecha, 2001, 10, 4);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++)
		{
			Calendar posible = Calendar.getInstance();
			String[] pedazos = br.readLine().split(" ");
			poner(posible, Integer.parseInt(pedazos[0]), Integer.parseInt(pedazos[1]) - 1, Integer.parseInt(pedazos[2]));
			Entrada nueva = new Entrada(posible, true);
			dp.clear();
			if(jugar(nueva))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
