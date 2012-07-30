import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class C 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1000000);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 1000000);
		boolean[][] patron = new boolean[60][52];
		int casos = Integer.parseInt(br.readLine());
		for(int caso = 0; caso < casos; caso++)
		{
			final char[] patronE = br.readLine().trim().toCharArray();
			final char[] entrada = br.readLine().trim().toCharArray();
			for(int i = 0; i < entrada.length; i++)
			{
				if(entrada[i] >= 'a')
					entrada[i] -= 'a';
				else
				{
					entrada[i] -= 'A';
					entrada[i] += 26;
				}
			}
			int tamPatron = 0;
			int actualPatron = 0;
			boolean enCiclo = false;
			boolean cicloPositivo = false;
			while(actualPatron < patronE.length)
			{
				if(!enCiclo)
				{
					if(patronE[actualPatron] == '?')
					{
						for(int i = 0; i < 52; i++)
							patron[tamPatron][i] = true;
						tamPatron++;
						actualPatron++;
					}
					else if(patronE[actualPatron] != '{' && patronE[actualPatron] != '[')	
					{
						for(int i = 0; i < 52; i++)
							patron[tamPatron][i] = false;
						if(patronE[actualPatron] >= 'a')
							patronE[actualPatron] -= 'a';
						else
						{
							patronE[actualPatron] -= 'A';
							patronE[actualPatron] += 26;
						}
						patron[tamPatron++][patronE[actualPatron++]] = true;
					}
					else
					{
						if(patronE[actualPatron++] == '[')
						{
							enCiclo = true;
							cicloPositivo = true;
							for(int i = 0; i < 52; i++)
								patron[tamPatron][i] = false;
						}
						else
						{
							enCiclo = true;
							cicloPositivo = false;
							for(int i = 0; i < 52; i++)
								patron[tamPatron][i] = true;
						}
					}
				}
				else
				{
					if(patronE[actualPatron] == '}' || patronE[actualPatron] == ']')	
					{
						actualPatron++;
						tamPatron++;
						enCiclo = false;
					}
					else
					{
						if(patronE[actualPatron] >= 'a')
							patronE[actualPatron] -= 'a';
						else
						{
							patronE[actualPatron] -= 'A';
							patronE[actualPatron] += 26;
						}
						if(cicloPositivo)
							patron[tamPatron][patronE[actualPatron++]] = true;
						else
							patron[tamPatron][patronE[actualPatron++]] = false;
					}
				}
			}
			boolean empezo = false;
			final int tamEntrada = entrada.length - tamPatron + 1;
			final int tamPat = tamPatron;
			for(int i = 0; i < tamEntrada; i++)
			{
				boolean paila = true;
				for(int j = 0; j < tamPat; j++)
				{
					if(!patron[j][entrada[i + j]])
					{
						paila = false;
						break;
					}
				}
				if(paila)
				{
					if(!empezo)
						empezo = true;
					else
						bw.write(" ");
					bw.write("" + (i + 1));
				}
			}
			if(!empezo)
				bw.write("no match");
			bw.write("\r\n");
		}
		bw.flush();
	}

}
