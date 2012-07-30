import java.io.FileNotFoundException;
import java.util.Scanner;


public class Army
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			int g = sc.nextInt();
			int mg = sc.nextInt();
			int mejorG = 0;
			for(int j = 0; j < g; j++)
				mejorG = Math.max(mejorG, sc.nextInt());
			int mejorMG = 0;
			for(int j = 0; j < mg; j++)
				mejorMG = Math.max(mejorMG, sc.nextInt());
			if(mejorG >= mejorMG)
				System.out.println("Godzilla");
			else
				System.out.println("MechaGodzilla");
		}
		
	}

}
