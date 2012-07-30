import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class b
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
			System.out.println(lookAndSay(br.readLine()));
	}
	
	static String lookAndSay(String entrada)
	{
		StringBuilder sb = new StringBuilder(1001);
		char anterior = entrada.charAt(0);
		int numero = 1;
		for(char c : entrada.substring(1).toCharArray())
		{
			if(c == anterior)
				numero++;
			else
			{
				sb.append(numero + "" + anterior);
				anterior = c;
				numero = 1;
			}
		}
		if(entrada.trim().length() > 0)
			sb.append(numero + "" + anterior);
		return sb.toString();
	}

}
