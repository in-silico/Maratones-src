import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class C 
{
	
	
	public static String aRomano(int pos, int valor)
	{
		if(pos == 4)
		{
			switch(valor)
			{
				case 1: return "M";
				case 2: return "MM";
				case 3: return "MMM";
			}
		}
		else if(pos == 3)
		{
			switch(valor)
			{
				case 1: return "C";
				case 2: return "CC";
				case 3: return "CCC";
				case 4: return "CD";
				case 5: return "D";
				case 6: return "DC";
				case 7: return "DCC";
				case 8: return "DCCC";
				case 9: return "CM";
				default: return "";
			}
		}
		else if(pos == 2)
		{
			switch(valor)
			{
				case 1: return "X";
				case 2: return "XX";
				case 3: return "XXX";
				case 4: return "XL";
				case 5: return "L";
				case 6: return "LX";
				case 7: return "LXX";
				case 8: return "LXXX";
				case 9: return "XC";
				default: return "";
			}
		}
		else if(pos == 1)
		{
			switch(valor)
			{
				case 1: return "I";
				case 2: return "II";
				case 3: return "III";
				case 4: return "IV";
				case 5: return "V";
				case 6: return "VI";
				case 7: return "VII";
				case 8: return "VIII";
				case 9: return "IX";
				default: return "";
			}
		}
		return "";
	}

	
	public static String aRomano(char[] a)
	{
		int actual = a.length;
		StringBuilder sb = new StringBuilder(16);
		int n = 0;
		for(int i = actual; i >= 1; i--)
		{
			sb.append(aRomano(i, a[n++] - '0'));
		}
		return sb.toString();
	}
	
	static HashMap <String, Integer> hash = new HashMap <String, Integer> (4000);
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i < 4000; i++)
		{
			hash.put(aRomano((i + "").toCharArray()), i);
		}
		while(true)
		{
			String linea = br.readLine();
			if(linea == null)
				return;
			Integer posible = hash.get(linea);
			if(posible == null)
				System.out.println(aRomano(linea.toCharArray()));
			else
				System.out.println(posible);
		}
	}
}
