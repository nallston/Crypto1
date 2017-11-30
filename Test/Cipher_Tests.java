

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
public class Cipher_Tests {

    @Before
    public void BeforeTests(){

    }
    @Test
    public void TransitionEncrypt(){
        String Text = "attackquietlybeforedawn";
        char[] Text_Array = Text.toCharArray();

        Transition Test1 = new Transition(Text_Array,4);

        char[] Output = Test1.Encrypt();

        String Output_String = new String(Output);
        assertEquals("exxegouymixpcfijsvihear",Output_String);
    }
    @Test
    public void TransitionDecrypt(){
        String Cipher_Text = "dwwdfntxlhwobehiruhgdzq";
        char[] Cipher_Text_Array = Cipher_Text.toCharArray();

        Transition Test1 = new Transition(Cipher_Text_Array,3);

        char[] Output = Test1.Decrypt();

        String Output_String = new String(Output);
        assertEquals("attackquietlybeforedawn",Output_String);
    }


    @Test
    public void RailFenceEncrypt(){
        String Text = "attackquietlybeforedawn";
        char[] Text_Array = Text.toCharArray();

        Rail_Fence test1 = new Rail_Fence(Text_Array);

        char[] Output = test1.Encrypt();
        String Output_String = new String(Output);
        assertEquals("atcqityeoeantakuelbfrdw",Output_String);
    }
    @Test
    public void MyszkowskiEncrypt(){

        String Text = "attackquietlybeforedawn";
        char[] Text_Array = Text.toCharArray();

        Myszkowski test1 = new Myszkowski(Text_Array,"hello");

        char[] output = test1.Encrypt();

        String Output_String = new String(output);
        assertEquals("tqlowaktfatauiybrenceed",Output_String);


    }
    @Test
    public void MyszkowskiEncrypt2(){

        String Text = "attackquietlybeforedawn";
        char[] Text_Array = Text.toCharArray();

        Myszkowski test1 = new Myszkowski(Text_Array,"dqrkbnfaddloue");

        char[] output = test1.Encrypt();

        String Output_String = new String(output);
        assertEquals("uwceaieenbqaartkdltftoy",Output_String);


    }
    @Test
    public void RailFenceDecryptEven(){
        String cipherText = "atcqityeoeatakuelbfrdw";
        char[] textArray = cipherText.toCharArray();

        Rail_Fence railFence = new Rail_Fence(textArray);

        char[] outputArray = railFence.decrypt();
        String outputString = new String(outputArray);
        assertEquals("attackquietlybeforedaw", outputString);


    }

    @Test
    public void RailFenceDecryptOdd(){
        String cipherText = "atcqityeoeantakuelbfrdw";
        char[] textArray = cipherText.toCharArray();

        Rail_Fence railFence = new Rail_Fence(textArray);

        char[] outputArray = railFence.decrypt();
        String outputString = new String(outputArray);
        assertEquals("attackquietlybeforedawn", outputString);


    }

    @Test
    public void CheckerboardKeyTest(){
        String cipherText = "atcqityeoeantakuelbfrdw";
        char[] textArray = cipherText.toCharArray();
        Straddling_Checkerboard sc = new Straddling_Checkerboard(textArray);

        sc.setKey("brendan");
        String output = "brendacfghijklmopqstuvwxyz";

        assertEquals(output, sc.keyCompressor());

    }

    @Test
    public void CheckerboardKeyTestTwo(){
        String cipherText = "atcqityeoeantakuelbfrdw";
        char[] textArray = cipherText.toCharArray();
        Straddling_Checkerboard sc = new Straddling_Checkerboard(textArray);

        sc.setKey("fuckbitchesgetmoney");
        String output = "fuckbithesgmonyadjlpqrvwxz";

        assertEquals(output, sc.keyCompressor());

    }

    @Test
    public void CheckerboardFillTest(){
        String cipherText = "atcqityeoeantakuelbfrdw";
        char[] textArray = cipherText.toCharArray();
        Straddling_Checkerboard sc = new Straddling_Checkerboard(textArray);

        sc.setKey("brendan");
        sc.firstNumber = 7;
        sc.secondNumber = 5;
        String output = "brendacfghijklmopqstuvwxyz";
        assertEquals(output, sc.keyCompressor());

        char[][] board = sc.fill();

        for(int i = 0; i < 10; i++){
           //System.out.print(board[0][i] + " ");
        }
        //System.out.println(" ");
        for(int i = 0; i < 10; i++){
            //System.out.print(board[1][i] + " ");
        }
        //System.out.println(" ");
        for(int i = 0; i < 10; i++){
            //System.out.print(board[2][i] + " ");
        }
        //System.out.println(" ");

        //System.out.println(output.length());

    }

    @Test
    public void SCEncryptionTest(){
        String cipherText = "712757577";
        char[] textArray = cipherText.toCharArray();
        Straddling_Checkerboard sc = new Straddling_Checkerboard(textArray);
        char[] returnedCipherText;

        sc.setKey("brendan");
        sc.firstNumber = 7;
        sc.secondNumber = 5;
        String output = "brendacfghijklmopqstuvwxyz";
        sc.plaintextToEncrypt = "hello";
        returnedCipherText = sc.encrypt();

        for(int i = 0; i<returnedCipherText.length; i++) {
            assertEquals(textArray[i], returnedCipherText[i]);
        }


    }

}
