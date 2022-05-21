package dto;

public class TentacledComplexType {
    private TentacledSequence sequence;
    private FluffyAttribute attribute;
    private Prefix prefix;

    public TentacledSequence getSequence() {
        return sequence;
    }

    public void setSequence(TentacledSequence value) {
        this.sequence = value;
    }

    public FluffyAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(FluffyAttribute value) {
        this.attribute = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }
}
