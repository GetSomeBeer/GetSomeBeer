package winwin.study.gsbmemo.rebecka.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dongju on 2016. 10. 11..
 */

public class JPreference {
    public static void saveString(Context context, String key, String value) { //SharedPreferences에 값 저장하기
        SharedPreferences pref = context.getSharedPreferences("mgreen", 0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static String loadString(Context context, String key) {//SharedPreferences에서 값 불러오기
        SharedPreferences pref = context.getSharedPreferences("mgreen", 0);
        return pref.getString(key, "");
    }

}
