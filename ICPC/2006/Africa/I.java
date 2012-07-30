import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class I 
{
	
	public static void main(String[] args) throws IOException
	{
		System.setOut(new PrintStream("salida.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true)
		{
			String a = br.readLine().trim();
			if(a.charAt(0) == '.')
				return;
			StringTokenizer st = new StringTokenizer(a, "+*=.");
			int cuentaA = 0;
			for(char c : st.nextToken().toCharArray())
				cuentaA += c - '0';
			int cuentaB = 0;
			for(char c : st.nextToken().toCharArray())
				cuentaB += c - '0';
			int cuentaC = 0;
			for(char c : st.nextToken().toCharArray())
				cuentaC += c - '0';
			boolean paila = false;
			if(a.contains("*"))
				paila = ((cuentaA * cuentaB) % 9) != (cuentaC % 9);
			else
				paila = ((cuentaA + cuentaB) % 9) != (cuentaC % 9);
			System.out.print(caso++ + ". ");
			if(paila)
				System.out.println("NOT!");
			else
				System.out.println("PASS");
		}
		
	}

}
