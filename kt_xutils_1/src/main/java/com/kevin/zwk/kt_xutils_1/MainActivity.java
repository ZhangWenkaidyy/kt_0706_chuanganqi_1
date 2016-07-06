package com.kevin.zwk.kt_xutils_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.listView)
    private ListView listView;
    DbManager.DaoConfig config = new DbManager.DaoConfig().setDbName("Myshujuku")
            .setDbVersion(1).setDbOpenListener(new DbManager.DbOpenListener() {
                @Override
                public void onDbOpened(DbManager db) {

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        DbManager dbManager=x.getDb(config);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        //创建网络请求url和参数
        NewsParams params = new NewsParams();
        //连接网络,第一参数RequestParams包含了host path params
        //返回值是Cancelable可以取消该次网络连接
        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback<NewsResponse>() {
            @Override
            public void onSuccess(NewsResponse result) {
                List<NewsInfo.T1348649776727Bean> list = result.getNewsInfo().getT1348649776727();
                for (NewsInfo.T1348649776727Bean bean : list
                        ) {
                    Log.i("-------", "" + bean.getTitle());

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
