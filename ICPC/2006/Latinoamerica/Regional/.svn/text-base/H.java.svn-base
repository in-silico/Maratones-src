import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class H
{
	static class Empleado
	{
		String nombre;
		String ventas;
		ArrayList <int[]> posiblesVentas = new ArrayList <int[]> ();
		
		public Empleado(String n, String v)
		{
			nombre = n;
			ventas = v;
		}
		void generarPosibles()
		{
			posible = new int[nP + 1];
			generar(0, ventas);
		}
		
		int[] posible;
		
		void generar(int actual, String faltante)
		{
			if(actual == nP + 1)
			{
				if(!faltante.equals(""))
					return;
				int cuenta = 0;
				for(int i = 0; i < nP; i++)
					cuenta += posible[i];
				if(cuenta == posible[nP])
					posiblesVentas.add(posible.clone());
				return;
			}
			if(faltante.equals(""))
				return;
			for(int i = 1; i < Math.min(actual == nP ? 5 : 4, faltante.length() + 1); i++)
			{
				try
				{
					String pedazo = faltante.substring(0, i);
					if(pedazo.startsWith("0") && i != 1)
						return;
					int nPosible = Integer.parseInt(faltante.substring(0, i));
					posible[actual] = nPosible;
					generar(actual + 1, faltante.substring(i));
				}
				catch(Exception e)
				{
					return;
				}
			}
		}
	}

	private static String partirEncabezado(String encabezado) 
	{
		int indice = encabezado.indexOf("Totals");
		int nP = indice;
		nP >>>= 1;
		String acum = "";
		for(int i = 0; i < nP; i++)
			acum += encabezado.substring(2 * i, 2 * i + 2) + " ";
		acum += "Totals";
		return acum;
	}
	

	private static Empleado leerEmpleado(String cadena)
	{
		int indice = 0;
		for(char c : cadena.toCharArray())
		{
			if(c <= '9' && c >= '0')
				break;
			indice++;
		}
		String nombre = cadena.substring(0, indice);
		String ventas = cadena.substring(indice);
		return new Empleado(nombre, ventas);
	}
	
	static int nP;
	static String ultima;
	static String encabezado;
	static ArrayList <Empleado> empleados = new ArrayList <Empleado> ();
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		for(int ii = 0; ii < n; ii++)
		{
			empleados.clear();
			encabezado = br.readLine();
			encabezado = partirEncabezado(encabezado);
			nP = encabezado.split("\\s+").length - 1;
			String cadena = "";
			while(true)
			{
				cadena = br.readLine();
				if(cadena.startsWith("TP"))
					break;
				empleados.add(leerEmpleado(cadena));
			}
			ultima = cadena;
			for(Empleado e : empleados)
				e.generarPosibles();
			permutar(0, new int[nP + 1], new int[empleados.size()]);
		}
	}
	
	static boolean permutar(int actual, int[] sumas, int[] escogidas)
	{
		if(actual == empleados.size())
		{
			String salida = "TP";
			for(int i = 0; i < sumas.length; i++)
				salida += sumas[i] + "";
			if(salida.equals(ultima))
			{
				System.out.println(encabezado);
				for(int i = 0; i < escogidas.length; i++)
				{
					System.out.print(empleados.get(i).nombre);
					for(int nu : empleados.get(i).posiblesVentas.get(escogidas[i]))
						System.out.print(" " + nu);
					System.out.println();
				}
				System.out.print("TP");
				for(int i = 0; i < sumas.length; i++)
					System.out.print(" " + sumas[i]);
				System.out.println();
				return true;
			}
			else
				return false;
		}
		int cuenta = 0;
		for(int[] posible : empleados.get(actual).posiblesVentas)
		{
			for(int i = 0; i < posible.length; i++)
				sumas[i] += posible[i];
			escogidas[actual] = cuenta++;
			if(permutar(actual + 1, sumas, escogidas))
				return true;
			for(int i = 0; i < posible.length; i++)
				sumas[i] -= posible[i];
		}
		return false;
	}
}
