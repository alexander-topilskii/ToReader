package dto;

public class ExtensionAttributeClass {
    private SimpleType simpleType;
    private String name;
    private Use use;
    private Prefix prefix;
    private String type;

    public SimpleType getSimpleType() {
        return simpleType;
    }

    public void setSimpleType(SimpleType value) {
        this.simpleType = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Use getUse() {
        return use;
    }

    public void setUse(Use value) {
        this.use = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }
}
