/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package maraton;
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Estudiante
 */
public class H {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.valueOf(rd.readLine());
        String cad1;
        String cad2;
        char[] c1;
        char[] c2;
        int[] array1=new int[30];
        int[] array2=new int[30];
        int changes;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<30;j++)
            {
                array1[j]=0;
                array2[j]=0;
            }
            cad1=rd.readLine();
            cad2=rd.readLine();
            c1=cad1.toCharArray();
            c2=cad2.toCharArray();
            for(int j=0;j<cad1.length();j++)
            {
                array1[c1[j]-'a']+=1;
            }
            for(int j=0;j<cad2.length();j++)
            {
                array2[c2[j]-'a']+=1;
            }

            changes=0;
            for(int j=0;j<30;j++)
            {
                changes+=Math.abs(array1[j]-array2[j]);
            }
            /*
            if (i<N-1)
                System.out.println("Case #"+String.valueOf(i+1)+":\t"+String.valueOf(changes));
            else
                System.out.print("Case #"+String.valueOf(i+1)+":\t"+String.valueOf(changes));
             *
             */


            System.out.print("Case #"+String.valueOf(i+1)+":  "+String.valueOf(changes) + "\r\n");

        }
    }

}
