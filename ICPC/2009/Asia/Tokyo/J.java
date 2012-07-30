import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;


public class J 
{
	static int n;
	
	static char[][] actual = new char[10][10];
	static char[][] temp = new char[10][10];
	
	static String darSiguiente()
	{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
			{
				if(actual[i][j] == '@')
				{
					temp[i][j] = '@';
					continue;
				}
				int adyacentes = calcularAdj(i, j);
				if(actual[i][j] == '#')
				{
					if(adyacentes == 2 || adyacentes == 3)
						temp[i][j] = '#';
					else
						temp[i][j] = '.';
				}
				else
				{
					if(adyacentes == 3)
						temp[i][j] = '#';
					else
						temp[i][j] = '.';
				}
			}
		return convertirString(temp);
	}
	
	static StringBuilder sb = new StringBuilder();
	
	private static String convertirString(char[][] temp2)
	{
		sb.setLength(0);
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				sb.append(temp2[i][j]);
		return sb.toString();
	}
	
	private static void ponerActual(String s)
	{
		int cuenta = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				actual[i][j] = s.charAt(cuenta++);
	}
	
	private static int calcularAdj(int i, int j)
	{
		int cuenta = 0;
		if(i != 0)
			cuenta += actual[i - 1][j] == '#' || actual[i - 1][j] == '@' ? 1 : 0;
		if(i != n - 1)
			cuenta += actual[i + 1][j] == '#' || actual[i + 1][j] == '@' ? 1 : 0;
		if(j != n - 1)
			cuenta += actual[i][j + 1] == '#' || actual[i][j + 1] == '@' ? 1 : 0;
		if(j != 0)
			cuenta += actual[i][j - 1] == '#' || actual[i][j - 1] == '@' ? 1 : 0;
		if(i != 0 && j != 0)
			cuenta += actual[i - 1][j - 1] == '#' || actual[i - 1][j - 1] == '@' ? 1 : 0;
		if(i != 0 && j != n - 1)
			cuenta += actual[i - 1][j + 1] == '#' || actual[i - 1][j + 1] == '@'  ? 1 : 0;
		if(i != n - 1 && j != n - 1)
			cuenta += actual[i + 1][j + 1] == '#' || actual[i + 1][j + 1] == '@' ? 1 : 0;
		if(i != n - 1 && j != 0)
			cuenta += actual[i + 1][j - 1] == '#' || actual[i + 1][j - 1] == '@' ? 1 : 0;
		return cuenta;
	}
	
	private static boolean cambiar(int i, int j, int num)
	{
		if(num == 0 && i != 0)
		{
			if(actual[i - 1][j] == '#')
				return false;
			else
			{
				actual[i - 1][j] = '@';
				return true;
			}
		}
		if(num == 1 && i != n - 1)
		{
			if(actual[i + 1][j] == '#')
				return false;
			else
			{
				actual[i + 1][j] = '@';
				return true;
			}
		}
		if(num == 2 && j != n - 1)
		{
			if(actual[i][j + 1] == '#')
				return false;
			else
			{
				actual[i][j + 1] = '@';
				return true;
			}
		}
		if(num == 3 && j != 0)
		{
			if(actual[i][j - 1] == '#')
				return false;
			else
			{
				actual[i][j - 1] = '@';
				return true;
			}
		}
		if(num == 4 && i != 0 && j != 0)
		{
			if(actual[i - 1][j - 1] == '#')
				return false;
			else
			{
				actual[i - 1][j - 1] = '@';
				return true;
			}
		}
		if(num == 5 && i != 0 && j != n - 1)
		{
			if(actual[i - 1][j + 1] == '#')
				return false;
			else
			{
				actual[i - 1][j + 1] = '@';
				return true;
			}
		}
		if(num == 6 && i != n - 1 && j != n - 1)
		{
			if(actual[i + 1][j + 1] == '#')
				return false;
			else
			{
				actual[i + 1][j + 1] = '@';
				return true;
			}
		}
		if(num == 7 && i != n - 1 && j != 0)
		{
			if(actual[i + 1][j - 1] == '#')
				return false;
			else
			{
				actual[i + 1][j - 1] = '@';
				return true;
			}
		}
		return false;
	}
	

	static class Estado
	{
		String s;
		int num;
		
		public Estado(String ss, int nu)
		{
			s = ss;
			num = nu;
		}
	}
	
	static HashSet <String> set = new HashSet <String> ();
	
	public static int iniciar(String s)
	{
		set.clear();
		LinkedList <Estado> cola = new LinkedList <Estado> ();
		cola.add(new Estado(s, 0));
		set.add(s);
		while(!cola.isEmpty())
		{
			Estado este = cola.poll();
			if(!este.s.contains("#"))
				return este.num;
			int indice = este.s.indexOf("@");
			int ii = indice / n;
			int jj = indice % n;
			for(int i = 0; i < 8; i++)
			{
				ponerActual(este.s);
				if(cambiar(ii, jj, i))
				{
					actual[ii][jj] = '.';
					String siguiente = darSiguiente();
					if(set.contains(siguiente))
						continue;
					set.add(siguiente);
					cola.add(new Estado(siguiente, este.num + 1));
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			char[][] t = new char[n][];
			actual = new char[n][n];
			temp = new char[n][n];
			for(int i = 0; i < n; i++)
				t[i] = br.readLine().trim().toCharArray();
			System.out.println(iniciar(convertirString(t)));
		}
	}
}
