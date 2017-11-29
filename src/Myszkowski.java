

/**
 * Created by Nathan on 11/29/2017.
 */
public class Myszkowski {

    private char[] characters;
    private int Transition_Key;
    private String key;

    public Myszkowski(char[] characters, String key){
        this.characters = characters;
        this.key = key;

    }
    public char[] Encrypt() {
        int rows = characters.length % key.length();
        if(rows > 0){
            rows = characters.length / key.length() +1;
        }
        else{
            rows = characters.length / key.length();
        }

        char[][] grid = new char[rows][key.length()];



        for(int i =0; i < rows; i++){
            for(int k=0; k < key.length(); k++){

                if((i * key.length() + k) >= characters.length){

                }
                else{

                    grid[i][k]= characters[(i * key.length()) + k];
                }





            }

        }


        String ciphertext ="";


        char[] key_array = key.toCharArray();

        int[][] Values = new int[key.length()][2];

        for(int k =0; k < key.length(); k++){

            Values[k][0] = (int)key_array[k];



        }
        int step_number = 0;
        for(int i =0; i < 256; i++){
            Boolean didstep = false;
            for(int k =0; k <key.length(); k++){
                if(Values[k][0] == i){
                    Values[k][1] = step_number;
                    didstep = true;
                }
            }
            if(didstep == true){
                step_number+=1;
            }
        }

        for(int i =0; i < step_number; i++){



            for(int p =0; p < rows; p++){

                for(int k=0; k < key.length(); k++){

                    if(grid[p][k] == 0){

                    }

                    else if(Values[k][1] == i){
                        ciphertext += grid[p][k];
                    }





                }
            }
        }


        char[] output = ciphertext.toCharArray();


        return output;
    }






























}
