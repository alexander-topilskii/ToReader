package dto;

public class ElementRestriction {
    private Enumeration[] enumeration;
    private String base;
    private Prefix prefix;

    public Enumeration[] getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(Enumeration[] value) {
        this.enumeration = value;
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
