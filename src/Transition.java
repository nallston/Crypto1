/**
 * Created by Nathan on 11/20/2017.
 */



//Logic for a simple transition cypher takes in a character array and a key number, which is the offset
public class Transition {

    private char[] Characters;
    private int Transition_Key;


    public Transition(char[] Characters, int Transition_Key){
        this.Characters = Characters;
        this.Transition_Key = Transition_Key;
    }


    public char[] Encrypt(){

        char[] Encrypted = new char[Characters.length];
        Character_Set Alphabet = new Character_Set(26);

        for(int i =0; i < Characters.length; i++){
            Encrypted[i] = Alphabet.Char_Addition(Characters[i], Transition_Key);
        }


        return Encrypted;
    }


    public char[] Decrypt(){
        char[] Decrypted = new char[Characters.length];
        Character_Set Alphabet = new Character_Set(26);

        for(int i =0; i < Characters.length; i++){
            Decrypted[i] = Alphabet.Char_Addition(Characters[i], -Transition_Key);
        }


        return Decrypted;
    }



}
