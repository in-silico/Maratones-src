import java.util.Scanner;


public class B 
{
	final static String vocales = "aeiuo";
	
	static boolean bien(String password)
	{
		boolean unaVocal = false;
		for(char c : vocales.toCharArray())
			if(password.contains(c + ""))
				unaVocal = true;
		if(!unaVocal)
			return false;
		for(char i = 'a'; i <= 'z'; i++)
			if(i == 'e' || i == 'o')
				continue;
			else if(password.contains(i + "" + i))
				return false;
		for(char i = 'a'; i <= 'z'; i++)
			if(vocales.contains(i + ""))
				password = password.replace(i, '0');
			else
				password = password.replace(i, '1');
		return !password.contains("111") && !password.contains("000");
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String p = sc.next().trim();
			if(p.equals("end"))
				return;
			System.out.println("<" + p + "> is" + (bien(p) ? " " : " not ") + "acceptable.");
		}
	}
}
