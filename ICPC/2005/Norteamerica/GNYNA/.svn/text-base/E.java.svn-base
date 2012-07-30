import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Stack;


public class E {
	
	
	
	
	
	
	static char[] array=new char[32768];
	
	
	
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		System.setOut(new PrintStream(new BufferedOutputStream(System.out)));
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		String cad;
		int T=Integer.valueOf(rd.readLine().trim());
		//TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
		Stack<Integer> st=new Stack<Integer>();
		StringBuilder sb;
		char[] tmp;
		int[] tm=new int[128005];
		for(int k=0;k<T;k++)
		{
			
			for(int i=0;i<32768;i++)
				array[i]=0;
			//tm.clear();
			st.clear();
			int i=0;
			sb=new StringBuilder();
			boolean compile_error=false;
			while(true)
			{
				cad=rd.readLine().trim();
				if (cad.equals("end"))
					break;
				if (compile_error==true)
					continue;
				tmp=cad.toCharArray();
				for(char a: tmp)
				{
					if (a=='%')
						break;
					if (a=='<' || a=='>' || a=='+' || a=='.' || a=='-' || a=='[' || a==']')
					{
						tm[i]=0;
						if (a=='[')
						{
							st.push(i);
						}
						if (a==']')
						{
							if (st.empty())
							{
								compile_error=true;
								break;
							}
							int number=st.pop();
							tm[i]=number;
							tm[number]=i;
							//tm.put(i, number);
							//tm.put(number,i);
						}
						sb.append(a);
						i++;
					}
				}
				
			}
			
			if (st.empty()==false)
			{
				compile_error=true;
			}

			System.out.println("PROGRAM #"+String.valueOf(k+1)+":");
			if (compile_error)
			{
				System.out.println("COMPILE ERROR");
				continue;
			}
			char[] program = sb.toString().toCharArray();
			
			int pointer=0;
			int j=0;
			while(j<program.length)
			{
				if (program[j]=='>')
				{
					pointer=(pointer+1)%32768;
					j++;
					continue;
				}
				if (program[j]=='<')
				{
					pointer=(pointer-1+32768)%32768;
					j++;
					continue;
				}
				if (program[j]=='.')
				{
					System.out.print(array[pointer]);
					j++;
					continue;
				}
				if (program[j]=='+')
				{
					array[pointer]=(char) ((array[pointer]+1)%256);
					j++;
					continue;
				}
				if (program[j]=='-')
				{
					array[pointer]=(char) ((array[pointer]-1+256)%256);
					j++;
					continue;
				}
				if (program[j]=='[')
				{
					if (array[pointer]==0)
					{
						//j=tm.get(j);
						j=tm[j];
					}
					j++;
					continue;
				}
				if (program[j]==']')
				{
					if (array[pointer]!=0)
					{
						//j=tm.get(j);
						j=tm[j];
						continue;
					}
					j++;
					continue;
				}
			}
			
			System.out.println();
			
		
			
			
			
			
			
			
			
		}
		System.out.flush();
		
	}

}
