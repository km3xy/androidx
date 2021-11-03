package cn.a7e7.caipiao2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 实例化控件
        Button btnSuiJi = findViewById(R.id.BtnSuiJi);
        final TextView tv1 = findViewById(R.id.tvTv1);
        final TextView tv2 = findViewById(R.id.tvTv2);
        final TextView tv3 = findViewById(R.id.tvTv3);
        final TextView tv4 = findViewById(R.id.tvTv4);
        final TextView tv5 = findViewById(R.id.tvTv5);
        final TextView tv6 = findViewById(R.id.tvTv6);
        


        // 首次启动显示
        int[] ToInt6 = toInt7();
        tv1.setText(Integer.toString(ToInt6[0]));
        tv2.setText(Integer.toString(ToInt6[1]));
        tv3.setText(Integer.toString(ToInt6[2]));
        tv4.setText(Integer.toString(ToInt6[3]));
        tv5.setText(Integer.toString(ToInt6[4]));
        tv6.setText(Integer.toString(ToInt6[5]));
        

        // 设置tv显示字号
        final int TEXT_VIEW_SIZE =20;
        tv1.setTextSize(TEXT_VIEW_SIZE);
        tv2.setTextSize(TEXT_VIEW_SIZE);
        tv3.setTextSize(TEXT_VIEW_SIZE);
        tv4.setTextSize(TEXT_VIEW_SIZE);
        tv5.setTextSize(TEXT_VIEW_SIZE);
        tv6.setTextSize(TEXT_VIEW_SIZE);
        



        btnSuiJi.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // 生成一个随机数并显示出来
                //stv1.setText(Integer.toString((int)(Math.random() * (31 + 1))));
                // 首次启动显示
                int[] btnToInt6 = toInt7();
                tv1.setText(Integer.toString(btnToInt6[0]));
                tv2.setText(Integer.toString(btnToInt6[1]));
                tv3.setText(Integer.toString(btnToInt6[2]));
                tv4.setText(Integer.toString(btnToInt6[3]));
                tv5.setText(Integer.toString(btnToInt6[4]));
                tv6.setText(Integer.toString(btnToInt6[5]));
                
            }
			
        });
    }

    /**
     * 返回一个七个随机数的数组
     * 前六位，范围为1-32；最后一位，范围1-16；七个数字互不重复
     * 前六位从小到大排列
     */
    public int[] toInt7() {
//        int[] a = new int[7];
//        // 生成7个随机数放入数组中
//        for (int i = 0; i < 7; i++) {
//            a[i] = (int) (Math.random() * (34 + 1));
//        }

        // 避免重复的生成7个随机数
        final int RANDOM_MIN = 1; // 随机生成最小的数
        final int RANDOM_BLUE_BALL_MAX = 35; //35// 随机蓝色球生成最大的数
        final int RANDOM_RED_BALL_MAX = 35; //12//随机红色球生成最大的数
        final int RANDOM_SUMBER = 6; // 生成随机数的个数
        // 声明数组准备存放随机数
        int[] a = new int[RANDOM_SUMBER];
        // 将数组第一个位放入一个随机数
        a[0] = (int) (Math.random() * RANDOM_BLUE_BALL_MAX + RANDOM_MIN);
        // 循环放入随机数
        for (int i = 1; i < a.length; i++) {
            // 判断是否为第一位，如果是第一个位则直接放入随机数 如果不是则生成一个随机数去和数组已有的随机数进行比对
            // - 有重复：生成一个新都随机数后，再执行上述操作
            // - 无重复：将该值放入数组
            if (i != 5) {
                int b = (int) (Math.random() * RANDOM_BLUE_BALL_MAX + RANDOM_MIN);
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == b) {
                        b = (int) (Math.random() * RANDOM_BLUE_BALL_MAX + RANDOM_MIN);
                        j = 0;
                    }
                }
                a[i] = b;
            } else {
                int b = (int) (Math.random() * RANDOM_RED_BALL_MAX + RANDOM_MIN);
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == b) {
                        b = (int) (Math.random() * RANDOM_RED_BALL_MAX + RANDOM_MIN);
                       
		
                        j = 0;
						
						j = 0;
                    }
                }
                a[i] = b;
                
        
                
            }
        }

        //  数组的前六位进行排序（从小到大）
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i] > a[j]) {
                    int c = a[i];
                    a[i] = a[j];
                    a[j] = c;
                }
            }
        }


        return a;
    }

}


