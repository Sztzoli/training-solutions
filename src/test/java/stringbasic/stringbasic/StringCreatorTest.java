package stringbasic.stringbasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCreatorTest {

    @Test
    public void TestPoolAndHeap() {
        String s1=new StringCreator().createStringForPool();
        String s3=new StringCreator().createStringForPool();
        String s2=new StringCreator().createStringForHeap();


        assertFalse(s1==s2);
        assertTrue(s1.equals(s2));
        assertTrue(s1==s3);


    }

    @Test
    public void TestIntern() {
        String s1=new StringCreator().createStringForPool();
        String s3=new StringCreator().createStringForPool();
        String s2=new StringCreator().createStringForHeap();

        assertTrue(s1.intern()==s2.intern());
        assertTrue(s1.intern()==s3.intern());
    }
}