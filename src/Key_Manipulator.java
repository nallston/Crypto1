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

}
