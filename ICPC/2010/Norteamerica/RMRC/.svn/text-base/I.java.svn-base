import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class I
{
	static String[] ped = new String[] {"one","first","two","second","three","third","four","fourth","five","fifth","six","sixth","seven","seventh","eight","eighth","nine","ninth","ten","tenth","eleven","eleventh","twelve","twelfth","thirteen","thirteenth","fourteen","fourteenth","fifteen","fifteenth","sixteen","sixteenth","seventeen","seventeenth","eighteen","eighteenth","nineteen","nineteenth","twenty","twentieth","thirty","thirtieth","forty","fortieth","fifty","fiftieth","sixty","sixtieth","seventy","seventieth","eighty","eightieth","ninety","ninetieth","hundred","hundredth","thousand","thousandth"};
	static String inicial = "tisthe";
	static ArrayList <Character> lista = new ArrayList <Character> ();
	static ArrayList <Integer> consecutivo = new ArrayList <Integer> ();
	
	public static String dar(String numero, boolean terminar)
	{
		if(numero.replace("0", "").isEmpty())
			return "";
		if(numero.length() == 1)
			return ped[(numero.charAt(0) - '0' - 1) * 2 + (terminar ? 1 : 0)];
		if(numero.length() == 2)
		{
			if(Integer.parseInt(numero) < 20)
				return ped[(Integer.parseInt(numero) - 1) * 2 + (terminar ? 1 : 0)];
			String siguiente = dar(numero.substring(1), terminar);
			if(siguiente.isEmpty())
				return terminar ? ped[(numero.charAt(0) - '0' - 1) * 2 + 36 + 1] : ped[(numero.charAt(0) - '0' - 1) * 2 + 36];
			else
				return ped[(numero.charAt(0) - '0' - 1) * 2 + 36] + siguiente;
		}
		else if(numero.length() == 3)
		{
			String siguiente = dar(numero.substring(1), terminar);
			if(siguiente.isEmpty())
				return terminar ? ped[(numero.charAt(0) - '0' - 1) * 2] + "hundredth" : ped[(numero.charAt(0) - '0' - 1) * 2] + "hundred";
			else
				return ped[(numero.charAt(0) - '0' - 1) * 2] + "hundred" + siguiente;
			
		}
		else
		{
			String num = numero.substring(numero.length() - 3);
			while(num.startsWith("0") && num.length() >= 1)
				num = num.substring(1);
			String pedazo;
			if(num.isEmpty())
				pedazo = "";
			else
				pedazo = dar(num, true);
			return dar(numero.substring(0, numero.length() - 3), false) + (pedazo.isEmpty() ? "thousandth" : "thousand") + pedazo;
		}
	}
	
	public static void agregar(String s)
	{
		for(char c : s.toCharArray())
			lista.add(c);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream(new File("salida.txt")));
		agregar(inicial);
		int actual = 1;
		while(consecutivo.size() <= 100000)
		{
			if(lista.get(actual - 1) == 't')
			{
				consecutivo.add(actual);
				agregar(dar(actual + "", true));
			}
			actual++;
		}
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int siguiente = sc.nextInt();
			if(siguiente == 0)
				return;
			System.out.println(consecutivo.get(siguiente - 1));
		}
	}

}
