package winwin.study.gsbmemo.rebecka;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import winwin.study.gsbmemo.R;

/**
 * Created by Dongju on 2017. 5. 24..
 */

public class PopUpActivity extends Activity {

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if(!rect.contains((int)ev.getX(),(int)ev.getY())){

            return false;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();

            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              save();
            }
        });
    }

    private void save(){
        setResult(0);
        finish();

    }
    private void cancel(){
        setResult(-1);
        finish();
    }
    @Override
    public void onBackPressed() {
        cancel();
    }
}
