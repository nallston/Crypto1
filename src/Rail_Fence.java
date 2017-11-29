/**
 * Created by Nathan on 11/21/2017.
 */
public class Rail_Fence {
    private char[] characters;
    private int Transition_Key;


    public Rail_Fence(char[] Characters){
        this.characters = Characters;

    }
    public char[] Encrypt(){
        String Level1 = "";
        String Level2 = "";
        for (int i = 0; i < characters.length; i++){
            if(i%2 == 0){
                Level1 = Level1 + characters[i];
            }
            else{
                Level2 = Level2 + characters[i];
            }
        }

        return (Level1 + Level2).toCharArray();
    }
    public char[] decrypt(){
        int size = characters.length;
        int halfwayPoint = (size/2);
        String decryptedOutput = "";

        if(size%2==0){
            int i = 0;
            while(i<halfwayPoint){

                decryptedOutput += characters[i];
                decryptedOutput += characters[halfwayPoint+i];

                i++;
            }
        }
        else{
            //odd
            int i = 0;
            while(i<halfwayPoint){
                decryptedOutput += characters[i];
                if(i+halfwayPoint < size) {
                    decryptedOutput += characters[halfwayPoint + i + 1];
                }
                i++;
            }
            decryptedOutput += characters[halfwayPoint];
        }

        return decryptedOutput.toCharArray();
    }
}
