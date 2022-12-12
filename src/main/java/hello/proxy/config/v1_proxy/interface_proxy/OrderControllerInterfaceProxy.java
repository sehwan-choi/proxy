package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;
    @Override
    public String request(String itemId) {

        TraceStatus begin = null;
        try {
            begin = logTrace.begin("OrderController.request()");
            String result = target.request(itemId);
            logTrace.end(begin);

            return result;
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
