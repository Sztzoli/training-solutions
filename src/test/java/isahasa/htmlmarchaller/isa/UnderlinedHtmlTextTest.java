package isahasa.htmlmarchaller.isa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnderlinedHtmlTextTest {

    @Test
    public void getBytes() throws Exception {
        UnderlinedHtmlText underlinedHtmlText = new UnderlinedHtmlText("asd");

        assertEquals("<u>asd</u>", underlinedHtmlText.getPlainText());
    }
}