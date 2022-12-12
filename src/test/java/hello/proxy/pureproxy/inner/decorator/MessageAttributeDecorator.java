package hello.proxy.pureproxy.inner.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageAttributeDecorator extends AbstractDecorator{

    public MessageAttributeDecorator(Attribute target) {
        super(target);
    }

    @Override
    public void operation() {
        log.info("MessageAttributeDecorator.operation()");
        this.target.operation();
    }
}
