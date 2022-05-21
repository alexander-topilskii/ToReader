package dto;

public class StickySequence {
    private HilariousElement element;
    private Prefix prefix;
    private FluffyChoice choice;
    private String minOccurs;
    private String maxOccurs;

    public HilariousElement getElement() {
        return element;
    }

    public void setElement(HilariousElement value) {
        this.element = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public FluffyChoice getChoice() {
        return choice;
    }

    public void setChoice(FluffyChoice value) {
        this.choice = value;
    }

    public String getMinOccurs() {
        return minOccurs;
    }

    public void setMinOccurs(String value) {
        this.minOccurs = value;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }
}
