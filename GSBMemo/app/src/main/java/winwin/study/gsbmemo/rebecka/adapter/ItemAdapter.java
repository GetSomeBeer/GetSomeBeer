package winwin.study.gsbmemo.rebecka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import winwin.study.gsbmemo.R;
import winwin.study.gsbmemo.rebecka.data.Data;

/**
 * Created by Dongju on 2017. 5. 24..
 */

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Data> datas;
    public ItemAdapter(Context context, ArrayList<Data> datas) {
        this.context = context;
        this.datas = datas;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list,null);
        }

        TextView mNum = (TextView) convertView.findViewById(R.id.num);
        mNum.setText(datas.get(position).getmId());

        TextView mContent = (TextView) convertView.findViewById(R.id.content);
        mContent.setText(datas.get(position).getmContents());


        return convertView;
    }
}
