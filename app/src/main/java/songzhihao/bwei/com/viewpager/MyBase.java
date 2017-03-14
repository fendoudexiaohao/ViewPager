package songzhihao.bwei.com.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * 作者： 宋智豪
 * * 时间： 2017/3/14 13:06
 * * 描述： 尚未编写描述
 */

public class MyBase extends PagerAdapter{


    private Context context;
    private ArrayList<ImageView> arrayList;
    public MyBase(Context context, ArrayList<ImageView> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = arrayList.get(position % arrayList.size());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
