/**
 * Created by Nathan on 11/20/2017.
 */
public class Main {
    public static void main(String[] args){

        String Hello = "helloworld";
        char[] Temp = Hello.toCharArray();

        Transition Test1 = new Transition(Temp,3);

        char[] Output = Test1.Encrypt();


        for(int i =0; i < Output.length; i++){
            System.out.print(Output[i]);
        }

        System.out.printf("\n");

        Transition Undo = new Transition(Output, 3);
        Output = Undo.Decrypt();


        for(int i =0; i < Output.length; i++){
            System.out.print(Output[i]);
        }
    }



}
