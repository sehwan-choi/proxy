package hello.proxy.pureproxy.inner.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AttributeImpl implements Attribute{
    @Override
    public void operation() {
        log.info("AttributeImpl.operation()");
    }
}
