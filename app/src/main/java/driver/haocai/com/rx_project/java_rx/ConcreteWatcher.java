package driver.haocai.com.rx_project.java_rx;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class ConcreteWatcher implements Watcher{
    @Override
    public void update(String str) {
        System.out.println(str);

    }
}
