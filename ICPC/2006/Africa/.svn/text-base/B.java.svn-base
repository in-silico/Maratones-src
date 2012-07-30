import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class B 
{
	static String sP = "4 1\n1\n1\n1\n1\n\n1 4\n1111\n\n2 3\n110\n011\n\n3 2\n01\n11\n10\n\n2 3\n111\n001\n\n2 3\n100\n111\n\n3 2\n01\n01\n11\n\n3 2\n11\n10\n10\n\n2 3\n111\n010\n\n2 3\n010\n111\n\n3 2\n10\n11\n10\n\n3 2\n01\n11\n01\n\n2 2\n11\n11\n0";
	
	static ArrayList <char[][]> patrones = new ArrayList <char[][]> ();
	
	static int[][] grid;
	
	static int n;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(sP);
		while(true)
		{
			int h = sc.nextInt();
			if(h == 0)
				break;
			int w = sc.nextInt();
			char[][] actual = new char[h][w];
			for(int i = 0; i < h; i++)
				actual[i] = sc.next().toCharArray();
			patrones.add(actual);
		}
		int caso = 1;
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			grid = new int[n][n];
			for(int i = 0; i < n; i++)
			{
				String[] pedazos = br.readLine().trim().split("\\s+");
				for(int j = 0; j < n; j++)
					grid[i][j] = Integer.parseInt(pedazos[j]);
			}
			System.out.println(caso++ + ". " + intentar());
		}
		
	}
	private static int intentar() 
	{
		int mejor = Integer.MIN_VALUE;
		for(char[][] patron : patrones)
		{
			int altura = n - (patron.length - 1);
			int ancho = n - (patron[0].length - 1);
			for(int i = 0; i < altura; i++)
				for(int j = 0; j < ancho; j++)
				{
					int cuenta = 0;
					for(int k = 0; k < patron.length; k++)
						for(int l = 0; l < patron[0].length; l++)
							if(patron[k][l] == '1')
								cuenta += grid[i + k][j + l];
					mejor = Math.max(mejor, cuenta);
				}
		}
		return mejor;
	}
}
