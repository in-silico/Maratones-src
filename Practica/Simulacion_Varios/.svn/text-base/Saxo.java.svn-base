import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Saxo
{
	static int[][] notas = new int[][]
			{
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 1},
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
			{0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
			{0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
			{0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 0, 0, 1, 1, 1, 0},
			{1, 1, 1, 1, 0, 0, 1, 1, 0, 0},
			{1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
			{1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			};

	public static int[] darLetra(char c)
	{
		switch(c)
		{
			case 'c': return notas[0];
			case 'd': return notas[1];
			case 'e': return notas[2];
			case 'f': return notas[3];
			case 'g': return notas[4];
			case 'a': return notas[5];
			case 'b': return notas[6];
			case 'C': return notas[7];
			case 'D': return notas[8];
			case 'E': return notas[9];
			case 'F': return notas[10];
			case 'G': return notas[11];
			case 'A': return notas[12];
			case 'B': return notas[13];
			default: return notas[-1];
		}
	}
	
	static int[] inicial = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		while(n-- != 0)
		{
			String entrada = br.readLine();
			int[] anterior = inicial;
			int[] cuenta = new int[10];
			for(char c : entrada.trim().toCharArray())
			{
				int[] actual = darLetra(c);
				for(int i = 0; i < 10; i++)
					if(anterior[i] == 0 && actual[i] == 1)
						cuenta[i]++;
				anterior = actual;
			}
			for(int i = 0; i < 10; i++)
			{
				if(i != 0)
					System.out.print(" ");
				System.out.print(cuenta[i]);
			}
			System.out.println();
				
		}
	}
}
