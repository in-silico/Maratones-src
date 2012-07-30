import java.util.Scanner;

public class G 
{
	static long respuesta(String s)
	{
		s = s.replace("5", "4");
		s = s.replace("6", "5");
		s = s.replace("7", "6");
		s = s.replace("8", "7");
		s = s.replace("9", "8");
		return Long.parseLong(s, 9);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String s = sc.next();
			if(s.equals("0"))
				return;
			System.out.println(s + ": " + respuesta(s));
		}
	}
}
