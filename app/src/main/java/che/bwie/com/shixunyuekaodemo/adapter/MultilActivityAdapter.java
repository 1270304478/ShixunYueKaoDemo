package che.bwie.com.shixunyuekaodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import che.bwie.com.shixunyuekaodemo.R;
import che.bwie.com.shixunyuekaodemo.bean.MultiBean;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/23 8:59
 */
public class MultilActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<MultiBean.SongListBean> list;

    public MultilActivityAdapter(Context context) {
        this.context = context;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    public void addData(List<MultiBean.SongListBean> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {

            ViewHolder holder1 = (ViewHolder) holder;

            holder1.listItemTextview.setText(list.get(position).getTitle());
            ImageLoader.getInstance().displayImage(list.get(position).getPic_radio(),holder1.listItemImageview);
           /* ((ViewHolder) holder).listItemImageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"点击",Toast.LENGTH_SHORT).show();


                }
            });*/
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 :list.size();
    }


  public  static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.list_item_imageview)
        ImageView listItemImageview;
        @Bind(R.id.list_item_textview)
        TextView listItemTextview;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
 /*  public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }*/
    //回调方法
  private Listener listener ;
    public void setIListener(Listener listener){
        this.listener = listener;
    }

    public interface  Listener {
        public void onClick(View view,int position);
        public void longClick(View view,int position);
    }

}
