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

    public void Bigram(char[] Text){
        Key_Manipulator keyer = new Key_Manipulator();
        String StringText = new String(Text);



        int firstchar =97;
        int secondchar=97;

        String[] Examples = new String[676];

        for(int i =0; i< 676; i++){
            if(secondchar == 123){
                secondchar -=26;
                firstchar++;
            }

            Examples[i]= Character.toString((char) firstchar) + Character.toString((char) secondchar);
            secondchar++;
        }
        int[] count = new int[676];
        int p =0;
        while(p < StringText.length()-1){

            String temp = StringText.substring(p,p+2);

            for(int i=0;i<Examples.length;i++){

                if(Examples[i].equals(temp)){
                    count[i]++;
                    break;
                }
            }



            p++;
        }
        int size = 10;
        for(int h =0; h < 676; h++){
            if(h % size == 0){
                System.out.println();
            }
            System.out.print(Examples[h] + ":  " + count[h] + "    ");
        }


        double avg = 0;
        int Max = count[0];
        int Min = count[0];
        for(p =0; p<Examples.length; p++){
            avg+=count[p];
            Max = max(Max,count[p]);
            Min = min(Min,count[p]);
        }
        avg = avg/Examples.length;

        double standdev =0;
        for(int o =0; o<Examples.length; o++){
            double iteration = count[o];
            iteration = ((iteration - avg)*(iteration-avg));
            standdev +=iteration;
        }
        standdev = Math.sqrt((standdev/(Examples.length-1)));

        System.out.println("\nAverage per is: " + (avg));
        System.out.println("Range goes from: " + Min + " to " + Max);
        System.out.println("Standard Deviation is: " + standdev);





        return;




    }


}
