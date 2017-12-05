/**
 * Created by Nathan on 12/4/2017.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
public class Histogram {
    public Histogram(){}

    public void AggregateNumbers(char[] text){

        Key_Manipulator keyer = new Key_Manipulator();
        String StringText = new String(text);


        String uniqie_chars = keyer.keyShortener(StringText);





        char[] sorted = uniqie_chars.toCharArray();
        Arrays.sort(sorted);
        uniqie_chars = new String(sorted);



        int[] count = new int[uniqie_chars.length()];
        int k = 0;
        int i;
        while(k < uniqie_chars.length()) {
            int amount = 0;
            for (i = 0; i < StringText.length(); i++) {
                if (StringText.charAt(i) == uniqie_chars.charAt(k)){

                    amount++;
                }

            }
            count[k] = amount;
            System.out.println(uniqie_chars.charAt(k) + ":  " + amount);
            k++;
        }

        return;
    }


}
