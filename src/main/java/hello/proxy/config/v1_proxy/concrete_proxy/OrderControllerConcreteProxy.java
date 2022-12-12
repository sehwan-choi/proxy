package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private OrderControllerV2 target;

    private LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {

        TraceStatus begin = null;
        try {
            begin = logTrace.begin("OrderRepository.save()");
            String request = target.request(itemId);
            logTrace.end(begin);
            return request;
        } catch (Exception e){
            logTrace.exception(begin, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
