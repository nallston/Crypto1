/**
 * Created by Brendan on 12/3/2017.
 */
public class Vigenere {

    Vigenere(){

    }

    public char[] encrypt(char[] message, String key){

        Key_Manipulator km = new Key_Manipulator();
        String keyString = km.keyRepeater(key,message.length);
        String output = "";

        int one = 0;
        int two = 0;
        int finalNumber = 0;

        int counter = 0;
        while(counter < message.length){

            one = km.charValue(message[counter]);
            two = km.charValue(keyString.charAt(counter));

            finalNumber = (one + two) % 26;

            output += km.intValue(finalNumber);

            counter++;
        }

        return output.toCharArray();
    }

}
