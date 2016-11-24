package driver.haocai.com.rx_project.java_rx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class ConcreteWatched implements BeWatched {
    private List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        for (Watcher watcher : list) {
            watcher.update(str);
        }
    }
}
