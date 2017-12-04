/**
 * Created by Brendan on 12/3/2017.
 */
public class Playfair {

    Playfair(){

    }

    public char[] encrypt(char[] message, String key){

        Key_Manipulator km = new Key_Manipulator();

        String orderedAlphabet = km.keyAddAlphabet(km.keyShortener(key),"abcdefghiklmnopqrstuvwxyz");
        String encr = "";
        char[][] square = new char[5][5];
        int counter = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                square[i][j] = orderedAlphabet.charAt(counter);
                counter++;
            }
        }

        //Square is properly filled at this point

        String msg = new String(message);
        counter = 0;
        char first;
        char second;

        int xc1 = 0;
        int xc2 = 0;
        int yc1 = 0;
        int yc2 = 0;


        while(counter+1<msg.length()){
            first = msg.charAt(counter);
            second = msg.charAt(counter+1);

            for(int i = 0; i < 5; i++){
                for(int j = 0; j<5; j++){

                    if(first == square[i][j]){
                        xc1 = i;
                        yc1 = j;
                    }
                    else if(second == square[i][j]){
                        xc2 = i;
                        yc2 = j;
                    }

                }
            }

            if(xc1 == xc2){
                if(xc1!=4){

                }
                else{
                    if(yc1==4){

                    }
                    else if(yc2==4){

                    }
                    else{

                    }
                }

            }
            else if(yc1 == yc2){
                if(yc1!=4){

                }
                else{
                    if(xc1==4){

                    }
                    else if(xc2==4){

                    }
                    else{

                    }

                }
            }
            else{
                //normal playfair
            }


            counter += 2;
        }


        return orderedAlphabet.toCharArray();

    }


}
