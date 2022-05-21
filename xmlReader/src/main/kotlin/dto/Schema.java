package dto;

public class Schema {
    private Import[] schemaImport;
    private ComplexTypeElement[] complexType;
    private SimpleTypeClass element;
    private SimpleTypeClass[] simpleType;
    private String xmlnsGenre;
    private String xmlnsXlink;
    private String xmlnsXs;
    private String xmlns;
    private String targetNamespace;
    private String elementFormDefault;
    private String attributeFormDefault;
    private Prefix prefix;

    public Import[] getSchemaImport() {
        return schemaImport;
    }

    public void setSchemaImport(Import[] value) {
        this.schemaImport = value;
    }

    public ComplexTypeElement[] getComplexType() {
        return complexType;
    }

    public void setComplexType(ComplexTypeElement[] value) {
        this.complexType = value;
    }

    public SimpleTypeClass getElement() {
        return element;
    }

    public void setElement(SimpleTypeClass value) {
        this.element = value;
    }

    public SimpleTypeClass[] getSimpleType() {
        return simpleType;
    }

    public void setSimpleType(SimpleTypeClass[] value) {
        this.simpleType = value;
    }

    public String getXmlnsGenre() {
        return xmlnsGenre;
    }

    public void setXmlnsGenre(String value) {
        this.xmlnsGenre = value;
    }

    public String getXmlnsXlink() {
        return xmlnsXlink;
    }

    public void setXmlnsXlink(String value) {
        this.xmlnsXlink = value;
    }

    public String getXmlnsXs() {
        return xmlnsXs;
    }

    public void setXmlnsXs(String value) {
        this.xmlnsXs = value;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String value) {
        this.xmlns = value;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    public String getElementFormDefault() {
        return elementFormDefault;
    }

    public void setElementFormDefault(String value) {
        this.elementFormDefault = value;
    }

    public String getAttributeFormDefault() {
        return attributeFormDefault;
    }

    public void setAttributeFormDefault(String value) {
        this.attributeFormDefault = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }
}
