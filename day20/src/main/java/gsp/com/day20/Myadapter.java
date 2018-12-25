package gsp.com.day20;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class Myadapter extends BaseAdapter {
    private Context context;
    private List<Shuju.NewslistBean> list;

    public Myadapter(Context context, List<Shuju.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();
        if (convertView==null){
            convertView=View.inflate(context,R.layout.listview,null);
            holder.image=convertView.findViewById(R.id.image);
            holder.text=convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).getPicUrl(),holder.image);
        holder.text.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView image;
        TextView text;
    }
}
