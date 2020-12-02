package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedAndItalicAndBoldHtmlText extends HtmlText {

    public UnderlinedAndItalicAndBoldHtmlText(String plainText) {
        super(plainText);
    }


    @Override
    public String getPlainText() {
        return String.format("<u><i><b>%s</b></i></u>",super.getPlainText());
    }
}
