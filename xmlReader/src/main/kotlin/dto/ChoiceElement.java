package dto;

public class ChoiceElement {
    private PurpleSequence[] sequence;
    private Prefix prefix;
    private PurpleElement[] element;
    private String minOccurs;
    private String maxOccurs;

    public PurpleSequence[] getSequence() {
        return sequence;
    }

    public void setSequence(PurpleSequence[] value) {
        this.sequence = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public PurpleElement[] getElement() {
        return element;
    }

    public void setElement(PurpleElement[] value) {
        this.element = value;
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
