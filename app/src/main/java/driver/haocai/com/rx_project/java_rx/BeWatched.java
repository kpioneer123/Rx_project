package driver.haocai.com.rx_project.java_rx;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public interface BeWatched {
    public  void addWatcher(Watcher watcher);
    public  void removeWatcher(Watcher watcher);
    public  void notifyWatchers(String str);

}
