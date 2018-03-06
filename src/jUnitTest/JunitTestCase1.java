package jUnitTest;


import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by deepakkole on 2/3/18.
 */
public class JunitTestCase1 {

    @Test
    public void testCase1(){
        System.out.println("Hello There");
        Assert.assertEquals("Message is not correct", 35, 5*7);

    }
}
