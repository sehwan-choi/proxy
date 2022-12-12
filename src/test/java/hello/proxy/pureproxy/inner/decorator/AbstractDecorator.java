package hello.proxy.pureproxy.inner.decorator;

public abstract class AbstractDecorator implements Attribute{

    protected final Attribute target;

    public AbstractDecorator(Attribute target) {
        this.target = target;
    }

    @Override
    public abstract void operation();
}
