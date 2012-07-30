import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class E 
{
	public static boolean validarFecha(int dia, int mes, int anio)
	{
		if(mes == 2)
		{
			if((anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0)))
				return dia <= 29;
			return dia <= 28;
		}
		else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
		{
			return dia <= 31;
		}
		else
			return dia <= 30;
	}

	static ArrayList <String> palindromos = new ArrayList <String> ();
	
	static void generarPalindromos(int i)
	{
		if(i < 100)
			intentarPalindromo("0" + i);
		else if(i < 1000)
		{
			intentarPalindromo("0" + i);
			intentarPalindromo("00" + i);
		}
		else if(i < 10000)
		{
			intentarPalindromo("0" + i);
			intentarPalindromo("00" + i);
			intentarPalindromo("000" + i);
		}
		else if(i < 100000)
		{
			intentarPalindromo("0" + i);
			intentarPalindromo("00" + i);
			intentarPalindromo("000" + i);
			intentarPalindromo("0000" + i);
		}
		else
		{
			intentarPalindromo("0" + i);
			intentarPalindromo("00" + i);
			intentarPalindromo("000" + i);
			intentarPalindromo("0000" + i);
		}
		intentarPalindromo(i + "");
	}
	
	private static void intentarPalindromo(String string)
	{
		for(int i = 0; i < string.length() / 2; i++)
			if(string.charAt(i) != string.charAt(string.length() - 1 - i))
				return;
		palindromos.add(string);
	}
	
	public static boolean esPalindromo(String string)
	{
		for(int i = 0; i < string.length() / 2; i++)
			if(string.charAt(i) != string.charAt(string.length() - 1 - i))
				return false;
		return true;
	}

	public static void main(String[] args) throws IOException
	{
		palindromos.add("");
		for(int i = 0; i < 1000000; i++)
			generarPalindromos(i);
		palindromos.add("0");
		palindromos.add("00");
		palindromos.add("000");
		palindromos.add("0000");
		palindromos.add("00000");
		palindromos.add("000000");
		String[] diez = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09"};
		ArrayList <String> numeros = new ArrayList <String> ();
		numeros.add("00");
		for(String s : diez)
			numeros.add(s);
		for(int i = 10; i <= 31; i++)
			numeros.add(i + "");
		ArrayList <String> numerosInversos = new ArrayList <String> ();
		for(String s : numeros)
		{
			String nuevo = s.charAt(1) + "" + s.charAt(0);
			numerosInversos.add(nuevo);
		}
		ArrayList <Long> todosPalindromos = new ArrayList <Long> ();
		for(int mes = 1; mes <= 12; mes++)
			for(int dia = 1; dia <= 31; dia++)
			{
				for(int an = 1; an <= 1000; an++)
				{
					String anio = an + "";
					if(anio.startsWith("0") || Long.parseLong(anio) > Integer.MAX_VALUE)
						continue;
					if(!esPalindromo(anio + numeros.get(mes) + numeros.get(dia)))
						continue;
					if(!validarFecha(dia, mes, an))
						continue;
					long fecha = Long.parseLong(anio);
					fecha *= 100;
					fecha += mes;
					fecha *= 100;
					fecha += dia;
					todosPalindromos.add(fecha);
				}
			}
		for(int mes = 1; mes <= 12; mes++)
			for(int dia = 1; dia <= 31; dia++)
			{
				for(String p : palindromos)
				{
					String anio = numerosInversos.get(dia) + numerosInversos.get(mes) + p;
					if(anio.startsWith("0") || Long.parseLong(anio) > Integer.MAX_VALUE)
						continue;
					
					long fecha = Long.parseLong(anio);
					if(!validarFecha(dia, mes, (int) fecha))
						continue;
					fecha *= 100;
					fecha += mes;
					fecha *= 100;
					fecha += dia;
					todosPalindromos.add(fecha);
				}
			}
		Collections.sort(todosPalindromos);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String siguiente = br.readLine();
			if(siguiente == null)
				return;
			StringTokenizer st = new StringTokenizer(siguiente, "/");
			String s = st.nextToken();
			if(s.startsWith("0"))
				s = s.substring(1);
			int dia = Integer.parseInt(s);
			s = st.nextToken();
			if(s.startsWith("0"))
				s = s.substring(1);
			int mes = Integer.parseInt(s);
			s = st.nextToken();
			long anio = Integer.parseInt(s);
			anio *= 100;
			anio += mes;
			anio *= 100;
			anio += dia;
			int res = Collections.binarySearch(todosPalindromos, anio);
			if(res < 0)
			{
				res++;
				res = -res;
			}
			else
				res++;
			long r = todosPalindromos.get(res);
			dia = (int) (r % 100);
			r /= 100;
			mes = (int) (r % 100);
			r /= 100;
			System.out.println(numeros.get(dia) + "/" + numeros.get(mes) + "/" + r);
			
		}
	}
}
