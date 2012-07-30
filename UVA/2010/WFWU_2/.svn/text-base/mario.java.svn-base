package UVA;

import java.util.Scanner;


public class mario {
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++){
			int wall=in.nextInt();
			int ab=0;
			int arr=0;
			int anterior;
			if(wall==0)
				anterior=0;
			else
			anterior=in.nextInt();
			int actual=0;
			int aux=0;
			for(int j=0;j<wall-1;j++){
				actual=in.nextInt();
				aux=anterior-actual;
				if(aux<0)
					arr+=1;
				if(aux>0)
					ab+=1;
				anterior=actual;
			}
			System.out.println("Case "+(i+1)+": "+ arr+ " "+ab);
		}
	}
}
