package ca.six.java8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rx.Observable;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(v -> {
            System.out.println("szw");

            Observable.just(23, 24)
                    .map(it -> "test "+it)
                    .subscribe(it -> System.out.println("Result = "+it));
        });
    }
}
