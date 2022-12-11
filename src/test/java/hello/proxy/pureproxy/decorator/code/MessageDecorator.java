package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;
import org.mockito.ScopedMock;

@Slf4j
public class MessageDecorator implements Component{

    private Component target;

    public MessageDecorator(Component target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String operation = target.operation();
        String decoResult = "******" + operation + "*******";
        log.info("MessageDecorator 적용 전 = {} , 적용 후 = {}",operation, decoResult);
        return decoResult;
    }
}
