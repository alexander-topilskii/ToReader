package dto;

public class TentacledExtension {
    private TentacledAttribute attribute;
    private String base;
    private Prefix prefix;

    public TentacledAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(TentacledAttribute value) {
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
