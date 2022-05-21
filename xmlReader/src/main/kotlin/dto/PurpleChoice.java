package dto;

public class PurpleChoice {
    private PurpleElement[] element;
    private String maxOccurs;
    private Prefix prefix;

    public PurpleElement[] getElement() {
        return element;
    }

    public void setElement(PurpleElement[] value) {
        this.element = value;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }
}
