package hello.proxy.pureproxy.inner.decorator;

public class AttributeClient {

    private final Attribute attribute;

    public AttributeClient(Attribute attribute) {
        this.attribute = attribute;
    }

    public void execute() {
        attribute.operation();
    }
}
