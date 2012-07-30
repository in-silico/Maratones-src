import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Mazes 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean termino = false;
		while(true)
		{
			String linea = br.readLine();
			if(linea == null || termino)
			{
				bw.flush();
				return;
			}
			String acum = "";
			int in = 0;
			while(!linea.replace(" ", "").equals(""))
			{
				if(in++ != 0)
					acum += "!";
				acum = acum + linea;
				linea = br.readLine();
				if(linea == null)
				{
					termino = true;
					break;
				}
			}
			char[] caracteres = acum.toCharArray();
			int cuenta = 0;
			for(char c : caracteres)
			{
				if(c >= '0' && c <= '9')
					cuenta += c - '0';
				else if(c == '!')
					bw.write("\n");
				else
				{
					for(int i = 0; i < cuenta; i++)
						if(c == 'b')
							bw.write(' ');
						else
							bw.write(c);
					cuenta = 0;
				}
			}
			bw.write("\n");
			if(!termino)
				bw.write("\n");
			bw.flush();
		}
	}
}
