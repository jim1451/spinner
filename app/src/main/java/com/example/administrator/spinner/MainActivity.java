package com.example.administrator.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView ls;
    List<String> list = new ArrayList<String>();
    private  String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.spinner);
        ls = findViewById(R.id.lv);

        initListview1();

        final List<String> list = getDatas();

        //第二个参数是显示数据使用的布局文件的id
        //第三个参数是显示每个数据使用的布局中的TextView的 id
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, list);
        spinner.setAdapter(adapter);
        //让第一个数据项已经被选中
        spinner.setSelection(0, true);

        //给Spinner添加事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //当选中某一个数据项时触发该方法
            /*
             * parent接收的是被选择的数据项所属的 Spinner对象，
             * view参数接收的是显示被选择的数据项的TextView对象
             * position接收的是被选择的数据项在适配器中的位置
             * id被选择的数据项的行号
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(spinner==parent);//true
                //System.out.println(view);
                //String data = adapter.getItem(position);//从适配器中获取被选择的数据项
                //String data = list.get(position);//从集合中获取被选择的数据项
                data = (String)spinner.getItemAtPosition(position);//从spinner中获取被选择的数据
           //    Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                initListview();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
    public void initListview(){
        List<String> list1 = new ArrayList<String>();
        for (int j = 0;j < list.size();j++){
            if (list.get(j).contains(data)){
                list1.add(list.get(j));
            }
//            list1.add(list.get(j));
        }
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list1);
        ls.setAdapter(adapter);

    }



    public void initListview1(){
     //   List<String> list = new ArrayList<String>();
        list.add("ttttt");
        list.add("sssss");
        list.add("zzzz");
        list.add("ttttt");
        list.add("ttttt");
        list.add("sssss");
        list.add("zzzz");
        list.add("sssss");
        list.add("zzzz");
        list.add("sssss");
        list.add("zzzz");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        ls.setAdapter(adapter);

    }


    public List<String> getDatas() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 10; i++){
            list.add("zzzz");
            list.add("Jack-->" + i);
        }
        return list;

    }
}
