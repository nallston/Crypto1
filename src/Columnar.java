import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Brendan on 12/4/2017.
 */
public class Columnar {

    Columnar(){}

    public void encrypt(char[] message, String key){
        Key_Manipulator km = new Key_Manipulator();
        ArrayList<Integer> order = km.keyNumericalOrderer(key);
        String finalOutput = "";

        ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();

        for(int i = 0; i < key.length(); i++){
            columns.add(new ArrayList<>());
        }

        int counter = 0;
        int index = 0;
        while(counter<message.length){
            if(index>order.size()){
                index = 0;
            }

            columns.get(index).add(Character.toString(key.charAt(counter)));


            counter++;
        }

        counter = 0;


        for(int i = 0; i<key.length(); i++){

            if(counter==order.get(i)){
                finalOutput += Integer.toString(order.get(i));
                counter++;
            }


        }

    }

}
