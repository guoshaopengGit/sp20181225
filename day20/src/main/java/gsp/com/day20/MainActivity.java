package gsp.com.day20;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
private String uristring= "http://api.tianapi.com/meinv/?key=3304a8bc9414f97e30928b80163cf098&num=10";
List<Shuju.NewslistBean>list=new ArrayList<Shuju.NewslistBean>();
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        myadapter = new Myadapter(MainActivity.this,list);
        listview.setAdapter(myadapter);

        new MAsyncTask().execute(uristring);

    }
    public class MAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return NetWorkUtils.getJson(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Shuju shuju = gson.fromJson(s, Shuju.class);
            List<Shuju.NewslistBean> newslist = shuju.getNewslist();
            list.addAll(newslist);
            myadapter.notifyDataSetChanged();
        }
    }
}
