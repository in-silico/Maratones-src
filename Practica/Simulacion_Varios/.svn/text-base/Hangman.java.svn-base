import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Hangman 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int ronda = Integer.parseInt(br.readLine());
			if(ronda == -1)
				return;
			System.out.println("Round " + ronda);
			char[] solucion = br.readLine().toCharArray();
			char[] jugadas = br.readLine().toCharArray();
			boolean[] solucionados = new boolean[solucion.length];
			boolean termino = false;
			int cuenta = 0;
			HashSet <Character> anteriores = new HashSet <Character> (solucion.length);
			for(char c : jugadas)
			{
				if(anteriores.contains(c))
					continue;
				anteriores.add(c);
				boolean cambio = false;
				boolean gano = true;
				for(int i = 0; i < solucion.length; i++)
				{
					if(c == solucion[i])
					{
						solucionados[i] = true;
						cambio = true;
					}
					gano &= solucionados[i];
				}
				if(gano)
				{
					System.out.println("You win.");
					termino = true;
					break;
				}
				if(!cambio)
					cuenta++;
				if(cuenta == 7)
				{
					System.out.println("You lose.");
					termino = true;
					break;
				}
			}
			if(!termino)
				System.out.println("You chickened out.");
		}
	}

}
