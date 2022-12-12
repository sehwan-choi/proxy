package hello.proxy.pureproxy.Concreteproxy;

import hello.proxy.pureproxy.Concreteproxy.code.ConcreteClient;
import hello.proxy.pureproxy.Concreteproxy.code.ConcreteLogic;
import hello.proxy.pureproxy.Concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();;
    }

    @Test
    void timeProxy() {
        TimeProxy timeProxy = new TimeProxy(new ConcreteLogic());
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
