package dto;

public class IndigoExtension {
    private IndigoAttribute attribute;
    private String base;
    private Prefix prefix;

    public IndigoAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(IndigoAttribute value) {
        this.attribute = value;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String value) {
        this.base = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }
}
