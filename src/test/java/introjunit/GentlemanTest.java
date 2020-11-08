package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {

    @Test
    public void sayHello() {

        assertThat(new Gentleman().SayHello(null),equalTo("Hello Anonymous"));
    }
}