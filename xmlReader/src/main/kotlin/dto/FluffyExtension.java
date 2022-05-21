package dto;

public class FluffyExtension {
    private ExtensionAttributeClass attribute;
    private String base;
    private Prefix prefix;

    public ExtensionAttributeClass getAttribute() {
        return attribute;
    }

    public void setAttribute(ExtensionAttributeClass value) {
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
