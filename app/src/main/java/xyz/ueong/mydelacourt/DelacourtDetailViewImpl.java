package xyz.ueong.mydelacourt;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ueong on 16. 5. 27.
 */
public class DelacourtDetailViewImpl extends Activity implements DelacourtDetailView {
    @Inject
    DelacourtDetailPresenter presenter;

    @BindView(R.id.title_kor)
    TextView tvtitleKor;
    @BindView(R.id.title_eng)
    TextView tvTitleEng;
    @BindView(R.id.price)
    TextView tvPrice;
    @BindView(R.id.payments)
    TextView tvPayments;
    @BindView(R.id.kcal)
    TextView tvKcal;
    @BindView(R.id.corner)
    TextView tvCorner;
    @BindView(R.id.floor)
    TextView tvFloor;
    @BindView(R.id.image)
    ImageView ivImage;
    @OnClick(R.id.rootView)
    public void onClick(View v) {
        presenter.close();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_delacourt_menu_detail);
        App.getComponent().inject(this);
        ButterKnife.bind(this);
        presenter.setView(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("menu")) {
            presenter.setMenu((DelacourtMenu) bundle.getSerializable("menu"));
        }

        presenter.show();
    }

    @Override
    public void show(DelacourtMenu menu) {
        tvtitleKor.setText(menu.getTitle_kor());
        tvTitleEng.setText(menu.getTitle_eng());
        tvPrice.setText(menu.getPrice() + "원");
        tvPrice.setPaintFlags(tvPayments.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); //취소선을 긋는다.
        tvPayments.setText(menu.getPayments() + "원");
        tvKcal.setText(menu.getKcal());
        tvKcal.setTextColor(decorateKcalTextColor(menu));
        tvCorner.setText(menu.getCorner());
        tvFloor.setText(menu.getFloor().toUpperCase());
        Picasso.with(getApplicationContext()).load(menu.getImg_src()).error(R.drawable.no_image_available).into(ivImage);
    }


    private int decorateKcalTextColor(DelacourtMenu item) {
        if (item.isHigh_cal()) return Color.RED;
        if (item.isLow_cal()) return Color.BLUE;
        if (item.isVery_low_cal()) return Color.GREEN;
        return Color.BLACK;
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "Menu not found.", Toast.LENGTH_SHORT);
    }

    @Override
    public void close() {
        finish();
    }
}
