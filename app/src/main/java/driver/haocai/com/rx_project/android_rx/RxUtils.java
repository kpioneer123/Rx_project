package driver.haocai.com.rx_project.android_rx;



import android.nfc.Tag;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
    public static void createPrint(){
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(!subscriber.isUnsubscribed())
                {

                    for(int i=1;i<=10;i++)
                    {
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG,"result-->>"+integer);
            }
        });
    }

    /**
     * 使用在被观察者，返回的对象一般都是数值类型
     */
    public static  void from()
    {
        Integer[]  items = {1,2,3,4,5,6,7,8,9};
        Observable observable =Observable.from(items);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG,o.toString());
            }
        });
    }


    /**
     * 指定某一时刻进行数据发送
     */
    public static  void interval(){
        Integer[]  items = {1,2,3,4,5,6};
        Observable observable =Observable.interval(1,1, TimeUnit.SECONDS);//每隔一秒发送数据
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG,o.toString());
            }
        });

    }

    /**
     * 处理数组集合
     */
    public static void just(){
        Integer[] item1 = {1,2,3,4,5,6};
        Integer[] item2 = {3,5,6,8,3,8};
        Observable observable = Observable.just(item1,item2);
        observable.subscribe(new Subscriber<Integer[]>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

                    Log.i(TAG,e.getMessage());
            }

            @Override
            public void onNext(Integer[] integers) {
                for(int i=0;i<integers.length;i++)
                {
                    Log.i(TAG,"next:"+integers[i]);
                }
            }


        });

    }

    /**
     * 使用范围数据，指定输出数据的范围
     */
    public static void range(){
        Observable observable = Observable.range(1,40);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG,"next:"+integer);
            }
        });

    }


    /**
     * 使用过滤功能
     */
    public static void filter(){
        Observable observable = Observable.just(1,2,3,4,5,6,7,8);
        observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer integer) {
               return integer<5;


        }
    }).observeOn(Schedulers.io()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                Log.i(TAG,"next:"+o);
            }
        });

    }
}
