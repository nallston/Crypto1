

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

import java.io.FileReader;
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
    public void columnarTest(){
        Columnar C = new Columnar();
        String Text = "abcdefghijklmnopqrstuvwxyz";
        char[] Text_Array = Text.toCharArray();


        char[] output = C.Encrypt(Text_Array,"freshs");

        String Output_String = new String(output);
        assertEquals("ciouagmsyekqwbhntzdjpvflrx",Output_String);
    }
    @Test
    public void histogramAggregate(){
        Histogram H = new Histogram();
        String text = "the article’s main idea is to try and show the readers why the new proposed healthcare bill is worse than what we currently have. when comparing the two bills she first looks at the ideology of the two party’s positions on the issue. the democrats goal of healthcare as in the a.c.a. bill was to expand access and mandate health benefits to all citizens. while in contrast the republican bill focuses on lowering the cost of healthcare. the author then goes into detail about how having healthcare for everyone, even if it is more expensive is more important than having cheaper healthcare, that not everyone can have." +
                "now moving on to the anthropology terms, framing process is the first i will talk about. framing process is “the creation of shared meanings and definitions that motivate and justify collective action by social movements” (guest 563). with this article being an opinion piece making the reader connect with the author’s train of thought is critical. this anthropology term perfectly shows a technique that the author uses to resonate with the reader. for example, when she talks about the cost/benefit ratio with healthcare. making the claim that even if healthcare is more expensive, having it for everyone is worth the cost because essentially the price of life is invaluable. this is something everyone can relate to, where you have lost a loved one and what you would pay to bring them back. this idea is a cornerstone of the article. at the end she also includes a few paragraphs about how the proper way to reduce healthcare cost is, and how it isn’t how the proposed bill attempts to solve it. so, in the end she used a strategy to make the cost irrelevant and then in the end showed how the cost, if the reader wasn’t wholly convinced, wouldn’t be that impactful." +
                "while this next term might not be something you would think is prevalent in this article i believe it is, social movement. social movement is “collective group actions in response to uneven development, inequality, and injustice that seek to build institutional networks to transform ";

        Key_Manipulator km = new Key_Manipulator();
       String text2 = km.keyConformer(text);
        char[] Text = text2.toCharArray();
        H.AggregateNumbers(Text);

    }
    @Test
    public void histogramMyszkowskiAggregate(){
        Histogram H = new Histogram();
        String text = "the article’s main idea is to try and show the readers why the new proposed healthcare bill is worse than what we currently have. when comparing the two bills she first looks at the ideology of the two party’s positions on the issue. the democrats goal of healthcare as in the a.c.a. bill was to expand access and mandate health benefits to all citizens. while in contrast the republican bill focuses on lowering the cost of healthcare. the author then goes into detail about how having healthcare for everyone, even if it is more expensive is more important than having cheaper healthcare, that not everyone can have." +
                "now moving on to the anthropology terms, framing process is the first i will talk about. framing process is “the creation of shared meanings and definitions that motivate and justify collective action by social movements” (guest 563). with this article being an opinion piece making the reader connect with the author’s train of thought is critical. this anthropology term perfectly shows a technique that the author uses to resonate with the reader. for example, when she talks about the cost/benefit ratio with healthcare. making the claim that even if healthcare is more expensive, having it for everyone is worth the cost because essentially the price of life is invaluable. this is something everyone can relate to, where you have lost a loved one and what you would pay to bring them back. this idea is a cornerstone of the article. at the end she also includes a few paragraphs about how the proper way to reduce healthcare cost is, and how it isn’t how the proposed bill attempts to solve it. so, in the end she used a strategy to make the cost irrelevant and then in the end showed how the cost, if the reader wasn’t wholly convinced, wouldn’t be that impactful." +
                "while this next term might not be something you would think is prevalent in this article i believe it is, social movement. social movement is “collective group actions in response to uneven development, inequality, and injustice that seek to build institutional networks to transform ";

        Key_Manipulator km = new Key_Manipulator();
        String text2 = km.keyConformer(text);
        char[] Text = text2.toCharArray();
        Vigenere v = new Vigenere();
        Text = v.encrypt(Text,"dqrkbnfaddloue" );

        H.AggregateNumbers(Text);

    }
}
