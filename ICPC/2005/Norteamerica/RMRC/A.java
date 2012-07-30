import java.util.Scanner;

public class A 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
		{
			String s = sc.nextLine();
			Scanner sc1 = new Scanner(s);
			sc1.next();
			double a = sc1.nextDouble();
			sc1.next();
			double b = sc1.nextDouble();
			sc1.next();
			if(!sc1.hasNextDouble())
				sc1.next();
			double c = sc1.nextDouble() * 2.54;
			double pos = (a * b) / 1000 * 2;
			pos += c;
			System.out.println(s + ": " + Math.round(pos * Math.PI));
		}
	}
}
