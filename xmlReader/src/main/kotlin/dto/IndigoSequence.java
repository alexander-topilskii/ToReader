package dto;

public class IndigoSequence {
    private IndigoElement element;
    private Prefix prefix;
    private ChoiceElement[] choice;

    public IndigoElement getElement() {
        return element;
    }

    public void setElement(IndigoElement value) {
        this.element = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public ChoiceElement[] getChoice() {
        return choice;
    }

    public void setChoice(ChoiceElement[] value) {
        this.choice = value;
    }
}
