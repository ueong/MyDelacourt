package xyz.ueong.mydelacourt.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.ueong.mydelacourt.App;
import xyz.ueong.mydelacourt.model.DelacourtMenu;
import xyz.ueong.mydelacourt.presenter.DelacourtPresenter;
import xyz.ueong.mydelacourt.R;

public class DelacourtViewImpl extends Activity implements DelacourtView {
    @Inject
    DelacourtPresenter presenter;
    @Inject
    DelacourtMenuAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.emptyView)
    TextView emptyView;
    @BindView(R.id.errorView)
    TextView errorView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_delacourt_main);
        App.getComponent().inject(this);
        ButterKnife.bind(this);
        presenter.setView(this);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getMenus();
            }
        });
        initializeList();

    }

    private void initializeList() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        swipeLayout.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        swipeLayout.setRefreshing(true);
        presenter.getMenus();
    }

    @Override
    public void showMenus(List<DelacourtMenu> menus) {
        emptyView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setItems(menus);
        adapter.setOnItemClickListener(new DelacourtMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DelacourtMenu menu) {
                presenter.showDetail(menu);
            }
        });
    }

    @Override
    public void showEmptyView() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        adapter.clear();
    }

    @Override
    public void hideEmptyView() {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showErrorView() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        adapter.clear();
    }

    @Override
    public void hideErrorView() {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showDetailView(DelacourtMenu menu) {
        Intent intent = new Intent(this, DelacourtDetailViewImpl.class);
        Bundle extras = new Bundle();
        extras.putSerializable("menu", menu);
        intent.putExtras(extras);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    @Override
    public void showProgressBar() {
        swipeLayout.setRefreshing(true);
    }

    @Override
    public void hideProgressBar() {
        swipeLayout.setRefreshing(false);
    }
}
