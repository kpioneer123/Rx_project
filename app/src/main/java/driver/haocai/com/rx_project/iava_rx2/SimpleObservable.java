package driver.haocai.com.rx_project.iava_rx2;

import java.util.Observable;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class SimpleObservable extends Observable{

    private int data = 0;
    public  int getData(){
        return data;
    }
    public  void setData(int i){
        if(this.data !=i)
        {
            this.data = i;
            setChanged();    //发生改变
            notifyObservers();//通知观察者，表示状况发生改变
        }
    }

}
