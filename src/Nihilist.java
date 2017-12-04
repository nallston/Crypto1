import java.util.ArrayList;

/**
 * Created by Brendan on 12/4/2017.
 */
public class Nihilist {

    Nihilist(){}

    public void encrpyt(char[] message, String key) {
        Key_Manipulator km = new Key_Manipulator();
        ArrayList<Integer> ctext = new ArrayList<Integer>();
        String orderedAlphabet = km.keyAddAlphabet(km.keyShortener(key),"abcdefghiklmnopqrstuvwxyz");

        char[][] square = new char[5][5];
        int counter = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                square[i][j] = orderedAlphabet.charAt(counter);
                counter++;
            }
        }

        int number;

        for(int k=0; k<message.length; k++){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){

                    if(square[i][j] == message[k]){

                        number = ((i+1) * 10) + j;
                        //add key to number
                        ctext.add(number);
                        i = 5;
                        j = 5;
                    }

                }
            }

        }



    }

}
