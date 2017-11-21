/**
 * Created by Nathan on 11/21/2017.
 */
public class Rail_Fence {
    private char[] Characters;
    private int Transition_Key;


    public Rail_Fence(char[] Characters){
        this.Characters = Characters;

    }
    public char[] Encrypt(){
        String Level1 = "";
        String Level2 = "";
        for (int i =0; i < Characters.length;i++){
            if(i%2 == 0){
                Level1 = Level1 + Characters[i];
            }
            else{
                Level2 = Level2 + Characters[i];
            }
        }

        return (Level1 + Level2).toCharArray();
    }
    public char[] Decrypt(){
        int size = Characters.length;

    }
}
