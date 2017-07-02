package winwin.study.gsbmemo.rebecka;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import winwin.study.gsbmemo.R;
import winwin.study.gsbmemo.rebecka.data.Data;
import winwin.study.gsbmemo.rebecka.data.JPreference;

/**
 * Created by Dongju on 2017. 5. 24..
 */

public class PopUpActivity extends Activity {

    // 바탕화면 터치시 팝업창 없어지지 않게 하려고 오버라이딩 한것
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Rect rect = new Rect();
        getWindow().getDecorView().getHitRect(rect);
        if (!rect.contains((int) ev.getX(), (int) ev.getY())) {

            return false;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        //TODO 현재 메모장 역할하는 PopupActivity size 하드코딩 픽스 해놓은 상태  = > 동적으로 수정시키기 .

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

    private void save() {
        EditText text = (EditText) findViewById(R.id.edit_text);

        String str = String.valueOf(text.getText());

        if (str.length() < 0 || str.equalsIgnoreCase("")) {
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
            return;
        }

//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        /*
        * TODO
        * 1. 데이타 있을 시 DB 등 데이터를 저장 하도록
        *  2. 임시로 log light 형식으로 해놓겠음
        *
        * */

        if (Common.datas == null) {
            Common.datas = new ArrayList<>();
        }
        int mId = Common.datas.size();

        Data data = new Data();
        data.setmId(String.valueOf(mId));
        data.setmContents(str);

        Common.datas.add(data);

        JPreference.saveString(Common.RContext,"key"+mId,str);
        JPreference.saveString(Common.RContext,"size",(mId+1)+"");

        setResult(0);
        finish();

    }

    private void cancel() {
        setResult(-1);
        finish();
    }

    @Override
    public void onBackPressed() {
        cancel();
    }
}
