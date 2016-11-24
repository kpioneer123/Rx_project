package driver.haocai.com.rx_project.android_rx;



import android.nfc.Tag;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by xionhgu on 2016/11/24.
 * Email：965705418@qq.com
 */

public class RxUtils {
    private static final  String TAG = RxUtils.class.getSimpleName();

    public static  void  createObserable(){
        //定义被观察者
        Observable<String> observable =Observable.create(new Observable.OnSubscribe<String>(){

            @Override
            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed())
                {
                    subscriber.onNext("hello");
                    subscriber.onNext("hi");
                    subscriber.onNext(downLoadJson());
                    subscriber.onNext("world");
                    subscriber.onCompleted();

                }
            }
        });
        Subscriber<String> showsub =new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG,"result-->>"+s);
            }
        };

        observable.subscribe(showsub);//关联被观察者
    }

    private static String downLoadJson() {
        return  "json data";
    }
}
