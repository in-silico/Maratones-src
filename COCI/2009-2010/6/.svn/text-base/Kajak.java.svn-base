import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Kajak 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		sc.nextInt();
		sc.nextLine();
		int[][] distancia = new int[9][3];
		for(int i = 0; i < 9; i++)
			distancia[i][0] = i;
		for(int i = 0; i < r; i++)
		{
			String linea = sc.nextLine();
			for(char a = '1'; a <= '9'; a++)
				if(linea.contains(a + ""))
					distancia[a - '1'][1] = linea.lastIndexOf(a);
		}
		Arrays.sort(distancia, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) 
			{
				return o1[1] - o2[1];
			}
		});
		int posicion = 1;
		int anterior = distancia[8][1];
		for(int i = 8; i >= 0; i--)
		{
			if(distancia[i][1] == anterior)
				distancia[i][2] = posicion;
			else
			{
				posicion++;
				anterior = distancia[i][1];
				distancia[i][2] = posicion;
			}
		}
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				if(distancia[j][0] == i)
					System.out.println(distancia[j][2]);
		}
	}

}
