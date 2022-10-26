package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        //crear un array de Strings llamado grupos
//crear un array de Strings llamado alumnos
//crear una variable tv1 de tipo TextView
//crear una variable lv1 de tipo ListView
    private ListView lv1;
    private TextView tv1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lv1=(ListView) findViewById(R.id.lv1);
            tv1=(TextView) findViewById(R.id.tv1);
            //asignar a la variable lv1 el listview
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,grupos);
            lv1.setAdapter(adapter);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView adapterView, View view, int i, long l) {
//Mostrar en el textview el grupo seleccionado y su número de alumnos
                }
            });
        }
    }
}