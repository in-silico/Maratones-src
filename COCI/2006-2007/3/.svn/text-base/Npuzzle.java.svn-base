import java.util.Scanner;


public class Npuzzle 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String[] puzzle = new String[4];
		for(int i = 0; i < 4; i++)
			puzzle[i] = sc.nextLine().trim();
		int cuenta = 0;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(puzzle[i].charAt(j) == '.')
					continue;
				int valor = puzzle[i].charAt(j) - 'A';
				int columnaValor = valor / 4;
				int filaValor = valor % 4;
				cuenta += Math.abs(i - columnaValor) + Math.abs(j - filaValor);
			}
		}
		System.out.println(cuenta);
	}

}
