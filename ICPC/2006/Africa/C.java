import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class C
{
	
	public static void main(String[] args) throws IOException
	{
		System.setOut(new PrintStream("salida.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true)
		{
			char[] actual = br.readLine().trim().toCharArray();
			if(actual.length == 1 && actual[0] == '0')
				return;
			boolean malo = false;
			if(actual[0] != '1' || actual[actual.length - 1] != '2')
				malo = true;
			int nCinco = 0;
			int nSeis = 0;
			for(int i = 1; i < actual.length - 1; i++)
			{
				if(actual[i] == '1' || actual[i] == '2')
					malo = true;
				if(actual[i - 1] == '1' && !(actual[i] == '4' || actual[i] == '5'))
					malo = true;
				if(actual[i + 1] == '2' && !(actual[i] == '4' || actual[i] == '6')) 
					malo = true;
				if(actual[i] == '3' && !(actual[i - 1] == '4' || actual[i - 1] == '6')) 
					malo = true;
				if(actual[i] == '3' && !(actual[i + 1] == '4' || actual[i + 1] == '5')) 
					malo = true;
				if(actual[i] == '4' && !(actual[i - 1] == '3' || actual[i - 1] == '1')) 
					malo = true;
				if(actual[i] == '4' && !(actual[i + 1] == '3' || actual[i + 1] == '2')) 
					malo = true;
				if(actual[i] == '8' && !(actual[i + 1] == '6' || actual[i + 1] == '7')) 
					malo = true;
				if(actual[i] == '8' && !(actual[i - 1] == '5' || actual[i - 1] == '7')) 
					malo = true;
				if(actual[i] == '5' && actual[i + 1] != '8')
					malo = true;
				if(actual[i] == '5' && !(actual[i - 1] == '3' || actual[i - 1] == '1'))
					malo = true;
				if(actual[i] == '6' && actual[i - 1] != '8')
					malo = true;
				if(actual[i] == '6' && !(actual[i + 1] == '3' || actual[i + 1] == '2')) 
					malo = true;
				if(actual[i] == '7' && (actual[i - 1] != '8' || actual[i + 1] != '8'))
					malo = true;
				if(actual[i] == '5')
					nCinco++;
				if(actual[i] == '6')
					nSeis++;
			}
			if(nCinco != nSeis)
				malo = true;
			if(malo)
				System.out.println(caso++ + ". NOT");
			else
				System.out.println(caso++ + ". VALID");
		}
	}

}
