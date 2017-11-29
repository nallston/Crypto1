/**
 * Created by Brendan on 11/29/2017.
 */
public class Straddling_Checkerboard {
    private char[] characters;
    private int transitionKey;
    int firstNumber;
    int secondNumber;
    private String plaintextKey;
    String plaintextToEncrypt;


    public Straddling_Checkerboard(char[] Characters){
        this.characters = Characters;
    }

    public char[] encrypt(){

        char[][] checkerboard;
        String cipherText = "";
        checkerboard = fill();

        for(int i = 0; i<plaintextToEncrypt.length(); i++){
            for(int j = 0; j < 3; j++){
                for(int q = 0; q < 10; q++){
                    if(plaintextToEncrypt.charAt(i) == checkerboard[q][j]){
                        if(j!=0){
                            cipherText+= Integer.toString(j);
                        }
                        cipherText += Integer.toString(q);
                    }
                }
            }
        }


        characters = cipherText.toCharArray();
        return characters;
    }

    public char[] decrypt(){


        return characters;
    }

    public char[][] fill(){

        char[][] checkerboard = new char[3][10];

        String key = new String(keyCompressor());

        //first row
        int i = 0;
        int counter = 0;
        System.out.println(key);
        while(i<10){
            if(i!=firstNumber && i!=secondNumber){
                checkerboard[0][i] = key.charAt(counter);
                counter++;
            }
            i++;
        }
        while(i<20){
            checkerboard[1][i-10] = key.charAt(counter);
            counter++;
            i++;
        }
        while(i<30){
            if(i<key.length()+2) {
                checkerboard[2][i-20] = key.charAt(counter);
                counter++;
            }
            i++;
        }



        return checkerboard;
    }

    public String keyCompressor(){

        String finalKey = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        boolean repeatCharacter = false;
        int i = 0;
        finalKey += plaintextKey.charAt(0);
        while(i<plaintextKey.length()){
            for(int j = 0; j < finalKey.length(); j++){
                if(finalKey.charAt(j) == plaintextKey.charAt(i)){
                    repeatCharacter = true;
                }
            }
            if(repeatCharacter == false) {
                finalKey += plaintextKey.charAt(i);
            }
            repeatCharacter = false;
            i++;
        }

        //add rest of alphabet
        i=0;
        while(i<alphabet.length()){
            for(int j = 0; j < finalKey.length(); j++){
                if(finalKey.charAt(j) == alphabet.charAt(i)){
                    repeatCharacter = true;
                }
            }
            if(repeatCharacter == false) {
                finalKey += alphabet.charAt(i);
            }
            repeatCharacter = false;
            i++;
        }


        return finalKey;
    }

    public void setKey(String key){
        this.plaintextKey = key;
    }

}
