/**
 * Created by Nathan on 11/20/2017.
 */


//This is where we can determine the scope of the characters available
//
//For example a character set of 26 keys will be lowercase letters only, while lets say 52 is lower and UPPER
//can also be used to add ones with spaces etc.
//Plan on having a custom field option as well

public class Character_Set {
    private int Character_Number;
    private char[] Characters_Array;



    public Character_Set(int Character_Number){
        this.Character_Number = Character_Number;
        if(Character_Number == 26){
            String Set = "abcdefghijklmnopqrstuvwxyz";
            this.Characters_Array = Set.toCharArray();
        }
    }

    public char Char_Addition(char Input_char, int Add_Number){
        int Input_Int = 0;
        for(int i =0; i < Characters_Array.length; i++){
            if(Input_char == Characters_Array[i]){
                Input_Int = i;
            }
        }
        int Addition_Value = Input_Int + Add_Number;
        if(Addition_Value > Character_Number){
            Addition_Value -= 26;
        }



        return Characters_Array[Addition_Value];
    }

}
