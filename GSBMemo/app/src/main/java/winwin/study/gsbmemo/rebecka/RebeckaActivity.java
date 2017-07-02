package winwin.study.gsbmemo.rebecka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import winwin.study.gsbmemo.R;
import winwin.study.gsbmemo.rebecka.adapter.ItemAdapter;
import winwin.study.gsbmemo.rebecka.data.Data;
import winwin.study.gsbmemo.rebecka.data.JPreference;

/**
 * Created by Dongju on 2017. 5. 16..
 */

public class RebeckaActivity extends Activity implements View.OnClickListener {

    private ArrayList<Item> array = null;
    private int count;
    private final int REQUEST_CODE = 0000;

    ListView listView;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Common.RContext = this;
        setContentView(R.layout.activity_rebecka);

        setListener();
        init();

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemAdapter = new ItemAdapter(RebeckaActivity.this, Common.datas));

    }

    @Override
    protected void onResume() {
        super.onResume();
        itemAdapter.notifyDataSetChanged();
    }

    private void init() {
//        count = 0;

        String str = JPreference.loadString(Common.RContext,"size");

        int length = 0;
        if(str == null || str.equalsIgnoreCase("")){
            return;
        }else{
            length = Integer.parseInt(str);

        }


        if(length == 0 ){
            return;
        }
        if (Common.datas == null) {
            Common.datas = new ArrayList<>();
        }
        for(int i = 0; i < length; i++){

//            JPreference.loadString(Common.RContext,"key"+i);
            Log.e("item", JPreference.loadString(Common.RContext,"key"+i));

            Data data = new Data();
            data.setmId(String.valueOf(i));
            data.setmContents(JPreference.loadString(Common.RContext,"key"+i));

            Common.datas.add(data);

        }
    }

    private void setListener() {
        findViewById(R.id.create).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.search).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.e("TEST", resultCode + "");

        if (resultCode == 0) {
            Toast.makeText(RebeckaActivity.this, "SAVED", Toast.LENGTH_SHORT).show();
            listView.setAdapter(itemAdapter = new ItemAdapter(RebeckaActivity.this, Common.datas));
//            itemAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(RebeckaActivity.this, "CANCLE", Toast.LENGTH_SHORT).show();

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create:
                Intent intent = new Intent(this, PopUpActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

                break;
            case R.id.delete:

                break;
            case R.id.search:

                break;

        }
    }
}
