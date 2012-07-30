import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class D 
{
	static StringBuilder sb = new StringBuilder(1000000);
	
	static boolean agregar(char[] s)
	{
		int tamano = s.length;
		for(int actual = 0; actual < tamano; actual++)
		{
			if(actual + 2 < tamano && s[actual] == 'E' && s[actual + 1] == 'O' && s[actual + 2] == 'F')
			{
				return true;
			}
			if(s[actual] >= 'a' && s[actual] <= 'z')
			{	
				if(actual + 1 < tamano && s[actual] == 'd' && s[actual + 1] == 'd')
				{
					sb.append('p');
					actual += 1;
				}
				else if(actual + 1 < tamano && s[actual] == 'e' && s[actual + 1] == 'i' && (actual == 0 || s[actual - 1] != 'c'))
				{
					sb.append("ie");
					actual += 1;
				}
				else if(actual + 3 < tamano && s[actual] == 'p' && s[actual + 1] == 'i' && s[actual + 2] == 'n' && s[actual + 3] == 'k')
				{
					sb.append("floyd");
					actual += 3;
				}
				else
				{
					sb.append(s[actual]);
				}
			}
			else
			{
				if(s[actual] == ' ')
					sb.append(' ');
			}
		}
		sb.append('\n');
		return false;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb.setLength(0);
		while(true)
		{
			String lectura = br.readLine();
			if(agregar(lectura.toCharArray()))
			{
				System.out.println(sb.toString());
				return;
			}
			
		}
	}
}
