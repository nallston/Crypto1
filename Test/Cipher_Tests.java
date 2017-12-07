

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

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

        Myszkowski test1 = new Myszkowski();

        char[] output = test1.Encrypt(Text_Array,"hello");

        String Output_String = new String(output);
        assertEquals("tqlowaktfatauiybrenceed",Output_String);


    }
    @Test
    public void MyszkowskiEncrypt2(){

        String Text = "attackquietlybeforedawn";
        char[] Text_Array = Text.toCharArray();

        Myszkowski test1 = new Myszkowski();

        char[] output = test1.Encrypt(Text_Array,"dqrkbnfaddloue");

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

    @Test
    public void KeyShortenerTest(){

        Key_Manipulator km = new Key_Manipulator();

        String key = "boyohboy";
        String finalKey = "boyh";

        String resultKey = km.keyShortener(key);

        assertEquals(finalKey,resultKey);

    }

    @Test
    public void KeyAddAlphabetTest(){

        Key_Manipulator km = new Key_Manipulator();

        String key = "boyohboy";
        String finalKey = "boyhacdefgijklmnpqrstuvwxz";

        String resultKey = km.keyShortener(key);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String finalResult = km.keyAddAlphabet(resultKey,alphabet);

        assertEquals(finalResult,finalKey);

    }

    @Test
    public void PlayfairKeyTest(){
        Playfair p = new Playfair();
        String charArray = "hey";
        String key = "playfair";
        String encryption = new String(p.encrypt(charArray.toCharArray(),key));

        assertEquals("playfirbcdeghkmnoqstuvwxz",encryption);

    }

    @Test
    public void KeyRepeaterTest(){
        Key_Manipulator km = new Key_Manipulator();

        int size = 10;
        String key = "hey";
        String finalOutput = "heyheyheyh";

        assertEquals(finalOutput,km.keyRepeater(key,size));


    }

    @Test
    public void charValueTest(){
        Key_Manipulator km = new Key_Manipulator();

        assertEquals(km.charValue('c'),2);

        assertEquals(km.charValue('z'),25);

        assertEquals(km.charValue('a'),0);

    }

    @Test
    public void intValueTest(){
        Key_Manipulator km = new Key_Manipulator();

        assertEquals(km.intValue(2),'c');
        assertEquals(km.intValue(25),'z');
        assertEquals(km.intValue(0),'a');
    }

    @Test
    public void vigenereAutokeyTest(){

        Key_Manipulator km = new Key_Manipulator();

        String msg = "hellothere";
        String key = "boy";

        String output = "boyhelloth";

        assertEquals(output,km.keyAutokey(key,msg));

    }

    @Test
    public void vigenereEncryptionTest(){
        Vigenere v = new Vigenere();

        String msg = "hello";
        String key = "key";

        String actual = "rijvs";
        String returned = new String(v.encrypt(msg.toCharArray(), key));

        assertEquals(actual,returned);

    }

    @Test
    public void vigenereAutokeyEncryptionTest(){
        Vigenere_Autokey va = new Vigenere_Autokey();

        String msg = "helloworld";
        String key = "key";

        String actual = "rijsshzfhr";
        String returned = new String(va.encrypt(msg.toCharArray(),key));

        assertEquals(actual,returned);
    }

    @Test
    public void arrayListColumnOrderTest(){
        Key_Manipulator km = new Key_Manipulator();

        String key = "brendan";

        ArrayList correctOrder = new ArrayList();
        correctOrder.add(2);
        correctOrder.add(7);
        correctOrder.add(4);
        correctOrder.add(5);
        correctOrder.add(3);
        correctOrder.add(1);
        correctOrder.add(6);

        ArrayList order = km.keyNumericalOrderer(key);


        for(int i = 0; i < key.length(); i++){
            assertEquals(correctOrder.get(i),order.get(i));
        }

    }

    @Test
    public void nihilistTest(){
        Nihilist n = new Nihilist();
        String key = "key";
        String message = "hello";
        String squareKey = "hey";
        String returned = new String(n.encrypt(message.toCharArray(),key,squareKey));

        System.out.println(returned);


    }

    @Test
    public void fileReaderTest() throws IOException {
        Filetostring fts = new Filetostring();

        String returned = fts.Filetostring("src/example.txt");
        Vigenere v = new Vigenere();
        String str = new String(v.encrypt(returned.toCharArray(),"key"));
        Histogram h = new Histogram();
        //h.AggregateNumbers(str.toCharArray());
    }

    @Test
    public void declarationHistogramTest() throws IOException {

        Filetostring fts = new Filetostring();
        String returned = fts.Filetostring("src/declaration.txt");
        Key_Manipulator km = new Key_Manipulator();
        String nopunc = km.keyConformer(returned);

        Histogram h = new Histogram();
        h.AggregateNumbers(nopunc.toCharArray());

        Vigenere v = new Vigenere();
        Vigenere_Autokey va = new Vigenere_Autokey();
        String str = new String(v.encrypt(va.encrypt(nopunc.toCharArray(),"gator"),"gator"));
        h.AggregateNumbers(str.toCharArray());


        String str2 = new String(va.encrypt(v.encrypt(nopunc.toCharArray(),"gator"), "gator"));
        h.AggregateNumbers(str2.toCharArray());

    }
    @Test
    public void BigramTest() throws IOException {
        Filetostring fts = new Filetostring();
        Key_Manipulator ky = new Key_Manipulator();
        String returned = fts.Filetostring("src/example.txt");
        returned = ky.keyConformer(returned);

        Histogram h = new Histogram();
        h.Bigram(returned.toCharArray());
    }
    @Test
    public void BigramVTest() throws IOException {
        Filetostring fts = new Filetostring();
        Key_Manipulator ky = new Key_Manipulator();
        String returned = fts.Filetostring("src/example.txt");
        returned = ky.keyConformer(returned);
        Vigenere v = new Vigenere();
        String str = new String(v.encrypt(returned.toCharArray(),"key"));
        Histogram h = new Histogram();
        h.Bigram(str.toCharArray());
    }

}
