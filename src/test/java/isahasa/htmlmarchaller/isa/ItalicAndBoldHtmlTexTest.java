package isahasa.htmlmarchaller.isa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItalicAndBoldHtmlTexTest {
    @Test
    public void getBytes() throws Exception {
        ItalicAndBoldHtmlText italicAndBoldHtmlText = new ItalicAndBoldHtmlText("asd");

        assertEquals("<i><b>asd</b></i>", italicAndBoldHtmlText.getPlainText());
    }

}