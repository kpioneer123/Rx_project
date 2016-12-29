package driver.haocai.com.rx_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import driver.haocai.com.rx_project.android_rx.RxUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void createMethod(View view){
        RxUtils.createObserable();
    }
    public void createMethod2(View view){
        RxUtils.createPrint();
    }
    public void from(View view){
        RxUtils.from();
    }
    public void just(View view){
        RxUtils.just();
    }
    public void filter(View view){
        RxUtils.filter();
    }
}
