package xyz.ueong.mydelacourt;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

public class DelacourtViewImpl extends AppCompatActivity implements DelacourtView {
    private DelacourtPresenter presenter;
    private DelacourtMenuAdapter adapter;
    private DelacourtService service;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_delacourt_main);
        ButterKnife.bind(this);
        service = DelacourtServiceFactory.createService();
        presenter = new DelacourtPresenter(this, service);
        adapter = new DelacourtMenuAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.getMenus();
    }

    @Override
    public void showMenus(List<DelacourtMenu> menus) {
        adapter.setItems(menus);
    }

}
