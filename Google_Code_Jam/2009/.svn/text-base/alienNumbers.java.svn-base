package GoogleCode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class alienNumbers
{
	public static String resolver(String numero, char [] alien1)
	{
		double decimal = 0;
		int punto = numero.substring(0, numero.indexOf('.') == -1 ? numero.length() : numero.indexOf('.')).length();
		for(int i = punto - 1; i > -1; i--)
		{
			char actual = numero.charAt(i);
			for(int j = 0; j < alien1.length; j++)
			{
				if(actual == alien1[j])
					decimal += j * Math.pow(alien1.length, punto - 1 - i);
			}
		}
		for(int i = punto + 1; i < numero.length(); i++)
		{
			char actual = numero.charAt(i);
			for(int j = 0; j < alien1.length; j++)
			{
				if(actual == alien1[j])
					decimal += j * Math.pow(alien1.length, -(i - punto));
			}
		}
		boolean prueba = (int)(decimal) == decimal;
		if(!prueba)
		{
			return numero + " equivale a: " + ((decimal) + "").replace('.', ',') + " en decimal.";
		}
		else
		{
			int dec = (int)(decimal);
			return numero + " equivale a: " + dec + " en decimal.";
			
		}
		
	}
	
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new File("in.txt"));
		String sistema = sc.next();
		FileWriter fw = new FileWriter("out.txt");
		sc.nextLine();
		while(sc.hasNext())
		{
			String p = sc.nextLine();
			Scanner sc2 = new Scanner(p);
			sc2.useDelimiter("	");
			fw.write(resolver(sc2.next().replace(',', '.'), sistema.toCharArray()) + System.getProperty("line.separator"));
		}
		fw.close();
	}
}
