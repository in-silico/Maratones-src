import java.util.LinkedList;
import java.util.Scanner;


public class A 
{
	static class Expresion
	{
		boolean parentesis;
		boolean variable;
		boolean suma;
		Expresion izquierda;
		Expresion derecha;
		char var;
		
		public Expresion(boolean par, boolean var, boolean su, Expresion iz, Expresion der)
		{
			parentesis = par;
			variable = var;
			suma = su;
			izquierda = iz;
			derecha = der;
		}
		
		public String toString()
		{
			if(variable)
				return var + "";
			if(parentesis)
				return "(" + izquierda.toString() + (suma ? "+" : "") + derecha.toString() + ")";
			else
				return izquierda.toString() + (suma ? "+" : "") + derecha.toString();

		}
	}
	
	static LinkedList <Character> siguientes = new LinkedList <Character> ();
	
	public static Expresion e()
	{
		Expresion siguiente = p();
		if(siguientes.isEmpty() || siguientes.peek().charValue() != '+')
			return siguiente;
		siguientes.poll();
		Expresion nueva = new Expresion(false, false, true, siguiente, e());
		nueva.izquierda.parentesis = false;
		nueva.derecha.parentesis = false;
		return nueva;
	}

	private static Expresion p() 
	{
		Expresion siguiente = f();
		if(siguientes.isEmpty() || (siguientes.peek().charValue() != '(' && (siguientes.peek().charValue() > 'z' || siguientes.peek().charValue() < 'a')))
			return siguiente;
		Expresion nueva = new Expresion(false, false, false, siguiente, p());
		if(!nueva.izquierda.suma)
			nueva.izquierda.parentesis = false;
		if(!nueva.derecha.suma)
			nueva.derecha.parentesis = false;
		return nueva;
	}

	private static Expresion f() 
	{
		if(siguientes.peek() >= 'a' && siguientes.peek() <= 'z')
		{
			Expresion siguiente = new Expresion(false, true, false, null, null);
			siguiente.var = siguientes.poll();
			return siguiente;
		}
		siguientes.poll();
		Expresion siguiente = e();
		siguientes.poll();
		if(siguiente.variable)
			siguiente.parentesis = false;
		else
			siguiente.parentesis = true;
		return siguiente;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
		{
			siguientes.clear();
			for(char c : sc.nextLine().toCharArray())
				siguientes.add(c);
			Expresion e = e();
			e.parentesis = false;
			System.out.println(e.toString());
		}
	}
}
