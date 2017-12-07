/**
 * Created by Nathan on 12/4/2017.
 */


import java.util.Arrays;

import static java.lang.Math.min;
import static sun.swing.MenuItemLayoutHelper.max;

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

            k++;
        }

        int size = 3;
        for(int p =0; p < uniqie_chars.length(); p++){
            if(p % size == 0){
                System.out.println();
            }
            System.out.print(uniqie_chars.charAt(p) + ":  " + count[p] + "    ");
        }


        double avg = 0;
        int Max = count[0];
        int Min = count[0];
        for(int p =0; p<uniqie_chars.length(); p++){
            avg+=count[p];
            Max = max(Max,count[p]);
            Min = min(Min,count[p]);
        }
        avg = avg/uniqie_chars.length();

        double standdev =0;
        for(int o =0; o<uniqie_chars.length(); o++){
            double iteration = count[o];
            iteration = ((iteration - avg)*(iteration-avg));
            standdev +=iteration;
        }
        standdev = Math.sqrt((standdev/(uniqie_chars.length()-1)));

        System.out.println("\nAverage per is: " + (avg));
        System.out.println("Range goes from: " + Min + " to " + Max);
        System.out.println("Standard Deviation is: " + standdev);
        return;
    }


}
