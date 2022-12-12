package hello.proxy.pureproxy.inner;

import hello.proxy.pureproxy.inner.decorator.AttributeClient;
import hello.proxy.pureproxy.inner.decorator.AttributeImpl;
import hello.proxy.pureproxy.inner.decorator.MessageAttributeDecorator;
import hello.proxy.pureproxy.inner.decorator.SortAttributeDecorator;
import org.junit.jupiter.api.Test;

public class InnerTest {

    @Test
    void test() {
        AttributeImpl attribute = new AttributeImpl();
        SortAttributeDecorator sortAttributeDecorator = new SortAttributeDecorator(attribute);
        MessageAttributeDecorator messageAttributeDecorator = new MessageAttributeDecorator(sortAttributeDecorator);
        AttributeClient client = new AttributeClient(messageAttributeDecorator);

        client.execute();
    }
}
