package dto;

public class PurpleAttribute {
    private String name;
    private String type;
    private Use use;
    private String attributeDefault;
    private Prefix prefix;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public Use getUse() {
        return use;
    }

    public void setUse(Use value) {
        this.use = value;
    }

    public String getAttributeDefault() {
        return attributeDefault;
    }

    public void setAttributeDefault(String value) {
        this.attributeDefault = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }
}
