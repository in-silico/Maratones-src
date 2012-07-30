import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class C
{
	static String hacker = "HACKERUP";
	
	public static int solve(String line)
	{
		int[] count = new int[hacker.length()];
		for(char c : line.toCharArray())
			for(int i = 0; i < count.length; i++)
				if(c == hacker.charAt(i))
					count[i]++;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < count.length; i++)
				min = Math.min(min, hacker.charAt(i) == 'C' ? count[i] >> 1 : count[i]);
		return min;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("input.txt"));
		System.setOut(new PrintStream("output.out"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 1; i <= n; i++)			
			System.out.println("Case #" + i + ": " + solve(sc.nextLine()));

	}

}
