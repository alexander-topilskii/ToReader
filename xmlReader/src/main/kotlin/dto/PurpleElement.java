package dto;

public class PurpleElement {
    private String name;
    private String type;
    private Prefix prefix;
    private String maxOccurs;

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

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }
}
