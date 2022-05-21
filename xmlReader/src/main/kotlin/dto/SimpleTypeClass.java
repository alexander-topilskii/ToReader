package dto;

public class SimpleTypeClass {
    private Annotation annotation;
    private SimpleTypeComplexType complexType;
    private String name;
    private Prefix prefix;
    private ElementRestriction restriction;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    public SimpleTypeComplexType getComplexType() {
        return complexType;
    }

    public void setComplexType(SimpleTypeComplexType value) {
        this.complexType = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public ElementRestriction getRestriction() {
        return restriction;
    }

    public void setRestriction(ElementRestriction value) {
        this.restriction = value;
    }
}
