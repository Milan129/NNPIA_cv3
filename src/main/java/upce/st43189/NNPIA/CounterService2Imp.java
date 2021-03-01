package upce.st43189.NNPIA;

import org.springframework.stereotype.Service;

@Service
public class CounterService2Imp implements  CounterService{

    private Integer counter = 1;

    @Override
    public Integer getCounter() {
        return counter;
    }

    @Override
    public void add(){
        counter *= 2;
    }
}
