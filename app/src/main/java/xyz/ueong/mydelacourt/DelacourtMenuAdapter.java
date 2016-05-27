package xyz.ueong.mydelacourt;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtMenuAdapter extends RecyclerView.Adapter<DelacourtMenuAdapter.ViewHolder> {
    private List<DelacourtMenu> menus = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(DelacourtMenu menu);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delacourt_menu, parent, false);
        return new ViewHolder(v);
    }

    public void clear() {
        menus.clear();
    }

    public void setItems(List<DelacourtMenu> menus) {
        clear();
        this.menus.addAll(menus);
        notifyDataSetChanged();
    }

    public DelacourtMenu getItem(int position) {
        return menus.get(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DelacourtMenu menu = getItem(position);
        holder.setItem(menu);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (DelacourtMenuAdapter.this.onItemClickListener != null) {
                    DelacourtMenuAdapter.this.onItemClickListener.onItemClick(menu);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        DelacourtMenu item;
        View itemView;

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

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, this.itemView);
        }

        public void setItem(DelacourtMenu item) {
            this.item = item;
            tvtitleKor.setText(item.getTitle_kor());
            tvTitleEng.setText(item.getTitle_eng());
            tvPrice.setText(item.getPrice() + "원");
            tvPrice.setPaintFlags(tvPayments.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); //취소선을 긋는다.
            tvPayments.setText(item.getPayments() + "원");
            tvKcal.setText(item.getKcal());
            tvKcal.setTextColor(decorateKcalTextColor(item));
            tvCorner.setText(item.getCorner());
            tvFloor.setText(item.getFloor().toUpperCase());
            Picasso.with(this.itemView.getContext()).load(Constants.BASE_URL + item.getImg_src()).error(R.drawable.no_image_available).into(ivImage);
        }

        private int decorateKcalTextColor(DelacourtMenu item) {
            if (item.isHigh_cal()) return Color.RED;
            if (item.isLow_cal()) return Color.BLUE;
            if (item.isVery_low_cal()) return Color.GREEN;
            return Color.BLACK;
        }
    }
}
