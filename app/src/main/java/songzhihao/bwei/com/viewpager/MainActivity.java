package songzhihao.bwei.com.viewpager;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager vp;
    private LinearLayout layout;
    private DisplayImageOptions displayImageOptions;
    private ArrayList<ImageView> arrayList;
    private ArrayList<ImageView> arrayList2;
    private String[] image = new String[] {
            "http://l2.51fanli.net//tuan//images//1//5806eac956808.jpg",
            "http://l2.51fanli.net//tuan//images//b//580991bb30560.jpg",
            "http://l0.51fanli.net//tuan//images//b//58115f2593dc3.jpg",
            "http://l2.51fanli.net//tuan//images//0//57923840b054d.jpg",
            "http://l2.51fanli.net//tuan//images//e//58101e11ab164.jpg" };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
                int currentItem = vp.getCurrentItem();
                currentItem++;
                handler.sendEmptyMessageDelayed(1,2000);
                vp.setCurrentItem(currentItem);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        vp = (ViewPager) findViewById(R.id.vp);
        layout = (LinearLayout) findViewById(R.id.line);
        //赋值图片
        setImage();
        //初始化小圆点
        setYuan();
        //适配器
        vp.setAdapter(new MyBase(this,arrayList));
        //延时发送
        handler.sendEmptyMessageDelayed(1,2000);
        //viewpager设置监听
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < image.length ; i++) {
                    if (position%arrayList2.size() == i){
                        arrayList2.get(i).setImageResource(R.drawable.dianji);
                    }else {
                        arrayList2.get(i).setImageResource(R.drawable.budianji);
                    }
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //给图片赋值
    private void setImage() {
        //实例化ImageLodear
        displayImageOptions = new DisplayImageOptions.Builder().build();
        //创建一个存放图片的集合
        arrayList = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            ImageView imageView = new ImageView(MainActivity.this);
            //请求图片
            ImageLoader.getInstance().displayImage(image[i],imageView,displayImageOptions);
            //存放如集合
            arrayList.add(imageView);
        }
    }
    //初始化小圆点
    private void setYuan() {
        //创建存放小圆点的集合
        arrayList2 = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            ImageView imageView = new ImageView(MainActivity.this);
            if (i == 0){
                imageView.setImageResource(R.drawable.dianji);
            }else{
                imageView.setImageResource(R.drawable.budianji);
            }
            //第一个参数为宽的设置，第二个参数为高的设置。
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            //设置它的上下左右的margin：4个参数按顺序分别是左上右下
            params.setMargins(5,0,5,0);
            //添加进Linlayout中
            layout.addView(imageView,params);
            //添加到小圆点的集合中
            arrayList2.add(imageView);
        }
    }
}
