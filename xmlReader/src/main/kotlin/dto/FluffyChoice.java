package dto;

public class FluffyChoice {
    private IndigoElement[] element;
    private String minOccurs;
    private String maxOccurs;
    private Prefix prefix;
    private IndigoSequence[] sequence;

    public IndigoElement[] getElement() {
        return element;
    }

    public void setElement(IndigoElement[] value) {
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

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public IndigoSequence[] getSequence() {
        return sequence;
    }

    public void setSequence(IndigoSequence[] value) {
        this.sequence = value;
    }
}
