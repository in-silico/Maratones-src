import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class E 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern p = Pattern.compile(" ");
		String[] pedazos;
		pedazos = p.split(br.readLine());
		int n = Integer.parseInt(pedazos[0]);
		for(int i = 0; i < n; i++)
		{
			pedazos = p.split(br.readLine());
			int m = Integer.parseInt(pedazos[0]);
			int cuenta = 0;
			for(int j = 0; j < m; j++)
				cuenta += Integer.parseInt(pedazos[j + 1]) - 1;
			System.out.println(++cuenta);
		}
	}
}
