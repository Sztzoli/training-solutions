package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Bold extends TextDecorator{

    public Bold(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return String.format("<b>%s</b>", getTextSource().getPlainText());
    }
}
