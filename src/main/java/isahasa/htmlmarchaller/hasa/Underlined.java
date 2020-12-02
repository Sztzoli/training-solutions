package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Underlined extends TextDecorator{

    public Underlined(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return String.format("<u>%s</u>", getTextSource().getPlainText());
    }
}
