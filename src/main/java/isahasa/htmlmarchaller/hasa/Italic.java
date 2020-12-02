package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Italic extends TextDecorator {

    public Italic(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return String.format("<i>%s</i>", getTextSource().getPlainText());
    }
}
