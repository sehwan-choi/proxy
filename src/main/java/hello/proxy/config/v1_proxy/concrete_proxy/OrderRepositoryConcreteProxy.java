package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;

    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {

        TraceStatus begin = null;
        try {
            begin = logTrace.begin("OrderRepository.save()");
            target.save(itemId);
            logTrace.end(begin);
        } catch (Exception e){
            logTrace.exception(begin, e);
            throw e;
        }
    }
}
