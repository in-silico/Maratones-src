import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class H 
{
	
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextDouble())
		{
			double[] numeros = new double[] { sc.nextDouble(), sc.nextDouble(), sc.nextDouble()};
			if(numeros[0] == 0 && numeros[1] == 0 && numeros[2] == 0)
				return;
			Arrays.sort(numeros);
			double thickness = numeros[0];
			double length = numeros[2];
			double height = numeros[1];
			if(length >= 125 && length <= 290 && height >= 90 && height <= 155 && thickness >= 0.25 && thickness <= 7)
				System.out.println("letter");
			else if((length > 290 || height > 155 || thickness > 7) && (length >= 125 && height >= 90 && thickness >= 0.25) && (length <= 380 && height <= 300 && thickness <= 50))
				System.out.println("packet");
			else if((length >= 125 && height >= 90 && thickness >= 0.25) && (length > 380 || height > 300 || thickness > 50) && (length + 2 * height + 2 * thickness <= 2100))
				System.out.println("parcel");
			else
				System.out.println("not mailable");
				
		}
	}

}
