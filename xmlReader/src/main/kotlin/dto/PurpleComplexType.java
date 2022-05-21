package dto;

public class PurpleComplexType {
    private FluffySimpleContent simpleContent;
    private Prefix prefix;
    private PurpleComplexContent complexContent;
    private FluffySequence sequence;
    private PurpleChoice choice;
    private AttributeElement attribute;

    public FluffySimpleContent getSimpleContent() {
        return simpleContent;
    }

    public void setSimpleContent(FluffySimpleContent value) {
        this.simpleContent = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public PurpleComplexContent getComplexContent() {
        return complexContent;
    }

    public void setComplexContent(PurpleComplexContent value) {
        this.complexContent = value;
    }

    public FluffySequence getSequence() {
        return sequence;
    }

    public void setSequence(FluffySequence value) {
        this.sequence = value;
    }

    public PurpleChoice getChoice() {
        return choice;
    }

    public void setChoice(PurpleChoice value) {
        this.choice = value;
    }

    public AttributeElement getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeElement value) {
        this.attribute = value;
    }
}
