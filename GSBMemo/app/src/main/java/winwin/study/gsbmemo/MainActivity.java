package winwin.study.gsbmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import winwin.study.gsbmemo.bomi.BomiActivity;
import winwin.study.gsbmemo.keit.KeitActivity;
import winwin.study.gsbmemo.rebecka.RebeckaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        findViewById(R.id.go_bomi_activity).setOnClickListener(this);
        findViewById(R.id.go_keit_activity).setOnClickListener(this);
        findViewById(R.id.go_reb_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_bomi_activity :
                goActivity("bomi");
                break;
            case R.id.go_keit_activity :
                goActivity("keit");
                break;
            case R.id.go_reb_activity :
                goActivity("reb");
                break;
        }

    }
    private void goActivity(String name){
        Class activity ;
        if(name.equalsIgnoreCase("bomi")){
            activity = BomiActivity.class;
        }else if(name.equalsIgnoreCase("keit")){
            activity = KeitActivity.class;
        }else{
            activity = RebeckaActivity.class;
        }

        Intent intent = new Intent(MainActivity.this,activity);
        startActivity(intent);

    }
}
