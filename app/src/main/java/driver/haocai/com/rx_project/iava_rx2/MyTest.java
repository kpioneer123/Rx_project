package driver.haocai.com.rx_project.iava_rx2;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class MyTest {
    public  static  void main(String[] args )throws  Exception
    {
        SimpleObservable simple = new SimpleObservable();
        SimpleObserver observer = new SimpleObserver(simple);
        simple.setData(1);
        simple.setData(2);
        simple.setData(2);
        simple.setData(3);


    }
}
