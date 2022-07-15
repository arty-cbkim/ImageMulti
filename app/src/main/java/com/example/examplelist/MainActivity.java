package com.example.examplelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

/**
 * 멀티 이미지 업로드
 * 다중 이미지 선택 및 업로드 가능
 * 다중 수정 , 삭제 가능
 *
 * */
public class MainActivity extends AppCompatActivity {

    private RecyclerView        recyclerView;
    private MultiImageAdapter   adapter;

    private ViewPager2          viewPager2;
    private ItemAdapter         itemAdapter;
    private boolean             orientationState = true; // 기본 가로방향
    private TextView            tvOrientation;
    int[] images = {
            R.drawable.image_1
            , R.drawable.image_2
            , R.drawable.image_3
            , R.drawable.image_4
            , R.drawable.image_5};

    private DotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // multiImageTest();

        viewPager2Test();
    }

    private void viewPager2Test() {
        viewPager2 = findViewById(R.id.viewPager2);
        tvOrientation = findViewById(R.id.tv_direction);
        dotsIndicator = findViewById(R.id.dotsIndicator);

        itemAdapter = new ItemAdapter(images);

        viewPager2.setAdapter(itemAdapter);

        dotsIndicator.setViewPager2(viewPager2);
    }

    public void setDirection(View view) {
        if(orientationState) {
            viewPager2.setOrientation(viewPager2.ORIENTATION_VERTICAL);
            orientationState = false;
            tvOrientation.setText("세로방향");
        } else {
            viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);
            orientationState = true;
            tvOrientation.setText("가로방향");
        }
    }

    /**************************************************/
    /**************************************************/

    private void multiImageTest() {
        recyclerView = findViewById(R.id.recycler_view_multi_image);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        adapter = new MultiImageAdapter(this);

        recyclerView.setAdapter(adapter);
        adapter.setImageList(setImage());
        adapter.notifyDataSetChanged();
    }

    private ArrayList<String> setImage() {
        ArrayList<String> list = new ArrayList<>();

        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3SmUpSnxbZhFVMGERXjghk45x63JrzONuCw&usqp=CAU");
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqcBUjUJTA2dmOKIFZbNA9wRAdr8O-4gh6Pg&usqp=CAU");
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiBDPH1TIaeU8IIU-0b2aR0L5FabZ_z-9zSw&usqp=CAU");
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6ngWPbJ0oidMCxIrgMTBSPps612WU44xr5Q&usqp=CAU");
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeOeq1_E2t7AGpmV_6QJS97cNisVqpNe2-kw&usqp=CAU");

        return list;
    }


}