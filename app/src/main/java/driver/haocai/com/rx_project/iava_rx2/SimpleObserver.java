package driver.haocai.com.rx_project.iava_rx2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class SimpleObserver implements Observer {

    public SimpleObserver(SimpleObservable observable) {
        observable.addObserver(this);

    }
    //当被观察者状态发生改变的时候会调用
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data is changed:" + ((SimpleObservable)o).getData());
    }


}
