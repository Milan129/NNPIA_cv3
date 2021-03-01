package upce.st43189.NNPIA;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterServiceImp implements  CounterService{

    private Integer counter = 0;

    @Override
    public Integer getCounter() {
        return counter;
    }

    @Override
    public void add(){
        ++counter;
    }
}
