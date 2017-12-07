import java.util.ArrayList;

/**
 * Created by Brendan on 12/4/2017.
 */
public class Nihilist {

    Nihilist(){}

    public char[] encrypt(char[] message, String key, String squareKey) {
        Key_Manipulator km = new Key_Manipulator();
        ArrayList<Integer> ctext = new ArrayList<Integer>();
        ArrayList<Integer> keytext = new ArrayList<Integer>();
        String orderedAlphabet = km.keyAddAlphabet(km.keyShortener(squareKey),"abcdefghiklmnopqrstuvwxyz");
        String output = "";

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

                        number = ((i+1) * 10) + (j + 1);
                        //add key to number
                        ctext.add(number);
                        i = 5;
                        j = 5;
                    }

                }
            }

        }

        String keystream = km.keyRepeater(key,message.length);

        for(int k = 0; k < message.length; k++){
            //adding key value to each ctext index
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){

                    if(square[i][j] == keystream.charAt(k)){

                        number = ((i+1) * 10) + (j + 1);
                        //add key to number
                        keytext.add(number);
                        i = 5;
                        j = 5;
                    }

                }
            }

        }



        for(int i = 0; i < message.length; i++){

            output += Integer.toString(keytext.get(i) + ctext.get(i));

        }

        return output.toCharArray();

    }


}
