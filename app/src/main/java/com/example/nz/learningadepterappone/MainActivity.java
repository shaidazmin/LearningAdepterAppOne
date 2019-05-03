package com.example.nz.learningadepterappone;

import android.content.Context;
import android.hardware.input.InputManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // Variable...............

    EditText editText;
    Button button;
    ListView listView;
    ArrayList<Item> arrayList;
    BaseAdapter adapter;

    // Main Activity .............


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilization();




    }


// initilaziton method...........

    public  void  initilization (){
        editText = (EditText) findViewById(R.id.inputText);
        button = (Button) findViewById(R.id.saveButton);
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<Item>();
        final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // start adapter.......

        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup parent) {
                if(view == null){
                    view = inflater.inflate(R.layout.layout,null);
                }

                TextView savedData = (TextView) view.findViewById(R.id.savedInputData);
                TextView currentDate = (TextView) view.findViewById(R.id.savedInputDate);

                savedData.setText(arrayList.get(position).getInputString());
                Date date = arrayList.get(position).getDate();
                //currentDate.setText(DateFormat.DATE_FIELD,("dd/mm/yyy date));
                return view;
            }
        };
        // End Adapter..........
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string= editText.getText().toString();
                Date date = new Date();
                Item item = new Item(string,date);
                arrayList.add(item);
                adapter.notifyDataSetChanged();
                editText.setText("");
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromInputMethod(editText.getWindowToken(),0);
                Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_SHORT).show();
            }

        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),"Data deleted",Toast.LENGTH_SHORT).show();
                return false;
            }
        });




    }


}
