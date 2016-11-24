package driver.haocai.com.rx_project.java_rx;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class Test {
    public static  void main(String[] args) throws  Exception{
        BeWatched xiaoming = new ConcreteWatched();
        Watcher   watcher1  = new ConcreteWatcher();
        Watcher   watcher2  = new ConcreteWatcher();
        Watcher   watcher3  = new ConcreteWatcher();

        xiaoming.addWatcher(watcher1);
        xiaoming.addWatcher(watcher2);
        xiaoming.addWatcher(watcher3);

        xiaoming.notifyWatchers("我要笑了");

    }
}
