package hello.proxy.pureproxy.inner.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortAttributeDecorator extends AbstractDecorator{

    public SortAttributeDecorator(Attribute target) {
        super(target);
    }

    @Override
    public void operation() {
        log.info("SortAttributeDecorator.operation()");
        this.target.operation();
    }
}
