

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
}
