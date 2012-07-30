import java.util.Scanner;


public class Herman 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double r = sc.nextInt();
		System.out.printf("%.6f", Math.PI * r * r);
		System.out.println();
		System.out.printf("%.6f", r * (2 * r));
		System.out.println();
	}
}
