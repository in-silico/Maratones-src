import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class I 
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s = br.readLine();
			if(s.equals("0"))
				return;
			long suma = 0;
			while(true)
			{
				suma = 0;
				for(char c : s.toCharArray())
				{
					suma += c - '0';
				}
				if(suma < 10)
					break;
				s = suma + "";
			}
			System.out.println(suma);
		}
	}

}
