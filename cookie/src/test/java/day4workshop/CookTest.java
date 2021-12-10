package day4workshop;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import junit.framework.TestResult;

public class CookTest {
    public static void main(String[] args) throws IOException {
        CookTest aa=new CookTest();
        aa.testReturn();

    }
    @Test
    
        public void testReturn() throws IOException
        {
            Cookie testercookie=new Cookie();
            try{
testercookie.returnCookie();
System.out.println("aaaaaa");
}
catch (Exception e){
System.out.println("not working");
}
        }

    
}
