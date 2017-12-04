import java.util.ArrayList;

/**
 * Created by Brendan on 12/3/2017.
 */
public class Key_Manipulator {

    Key_Manipulator(){

    }

    public String keyShortener(String key){
        String finalKey = "";

        boolean repeatCharacter = false;
        int i = 0;
        finalKey += key.charAt(0);
        while(i<key.length()){
            for(int j = 0; j < finalKey.length(); j++){
                if(finalKey.charAt(j) == key.charAt(i)){
                    repeatCharacter = true;
                }
            }
            if(repeatCharacter == false) {
                finalKey += key.charAt(i);
            }
            repeatCharacter = false;
            i++;
        }

        return finalKey;
    }

    public String keyAddAlphabet(String key, String alphabet){

        int i=0;
        boolean repeatCharacter = false;
        while(i<alphabet.length()){
            for(int j = 0; j < key.length(); j++){
                if(key.charAt(j) == alphabet.charAt(i)){
                    repeatCharacter = true;
                }
            }
            if(repeatCharacter == false) {
                key += alphabet.charAt(i);
            }
            repeatCharacter = false;
            i++;
        }

        return key;
    }

    public String keyRepeater(String key, int size){

        String returner = "";

        int keyPointer = 0;
        int counter = 0;

        while(counter<size){
            returner += key.charAt(keyPointer);

            counter++;
            keyPointer++;

            if(keyPointer>=key.length()){
                keyPointer = 0;
            }

        }

        return returner;
    }

    public String keyAutokey(String key, String message){
        String output = "";

        int counter = 0;
        while(counter < key.length()){

            output += key.charAt(counter);
            counter++;
        }
            counter = 0;
        while(counter < (message.length()-key.length())){

            output += message.charAt(counter);
            counter++;
        }

        return output;
    }

    public ArrayList keyNumericalOrderer(String key){

        char[] splitKey = key.toCharArray();
        Character_Set cs = new Character_Set(26);
        ArrayList<Integer> order = new ArrayList();
        for(int i = 0; i<key.length(); i++){
            order.add(0);
        }
        int counter = 1;
        for(int j=0; j<26; j++) {

            for (int i = 0; i < key.length(); i++) {

                if(splitKey[i]==cs.Characters_Array[j]){
                    order.set(i,counter);
                    counter++;
                }

            }

        }

        return order;

    }

    public int charValue(char x){
        Character_Set cs = new Character_Set(26);

        int i = 0;
        while(i<26){
            if(x == cs.Characters_Array[i]){
                return i;
            }
            i++;
        }

        return -1;

    }

    public char intValue(int x){
        Character_Set cs = new Character_Set(26);
        return cs.Characters_Array[x];
    }

}
