package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private OrderServiceV2 target;

    private LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {

        TraceStatus begin = null;
        try {
            begin = logTrace.begin("OrderRepository.save()");
            target.orderItem(itemId);
            logTrace.end(begin);
        } catch (Exception e){
            logTrace.exception(begin, e);
            throw e;
        }
    }
}
