import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Quadtrees 
{
	static LinkedList <Character> caracteres = new LinkedList <Character> ();
	
	public static void tree(int xi, int xf, int yi, int yf, boolean[][] arbol)
	{
		char este = caracteres.pollFirst();
		if(este == 'p')
		{
			tree((xf + xi) / 2, xf, yi, (yf + yi) / 2, arbol);
			tree(xi, (xf + xi) / 2, yi, (yf + yi) / 2, arbol);
			tree(xi, (xf + xi) / 2, (yf + yi) / 2, yf, arbol);
			tree((xf + xi) / 2, xf, (yf + yi) / 2, yf, arbol);
		}
		else
		{
			boolean llenado = este == 'f';
			for(int i = xi; i < xf; i++)
				for(int j = yi; j < yf; j++)
					arbol[i][j] = llenado;
		}
	}
	
	static boolean arbolA[][] = new boolean[32][32];
	static boolean arbolB[][] = new boolean[32][32];
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		while(n-- != 0)
		{
			for(char c : br.readLine().toCharArray())
				caracteres.add(c);
			tree(0, 32, 0, 32, arbolA);
			for(char c : br.readLine().toCharArray())
				caracteres.add(c);
			tree(0, 32, 0, 32, arbolB);
			int cuenta = 0;
			for(int i = 0; i < 32; i++)
				for(int j = 0; j < 32; j++)
					cuenta += arbolA[i][j] || arbolB[i][j] ? 1 : 0;
			System.out.println("There are " + cuenta + " black pixels.");
		}
	}

}
