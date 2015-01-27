package com.doubibi.xiaomu;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnItemClickListener {

	private ListView lv;
	private ArrayAdapter<ListCellData> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        adapter = new ArrayAdapter<ListCellData>(this, R.layout.list_cell);
      
        lv = (ListView) findViewById(R.id.lvPeople);
        lv.setAdapter(adapter);
        
//        adapter.add(new ListCellData("������", "��Ŀ����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("����־", "��׿����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("����", "��׿����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("������", "��׿����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("��ΰ��", "��׿����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("��ѩ��", "��׿����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("����Բ", "��̨����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("��־��", "��̨����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("���", "ios����", "���ȱ�", "Сľ"));
//        adapter.add(new ListCellData("�ܳ���", "UI���", "���ȱ�", "Сľ"));
        

        
        lv.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		ListCellData data = adapter.getItem(position);
		
		Toast.makeText(this, String.format("����:%s ְλ:%s ����:%s ����:%s", data.getName(),data.getPosition(),data.getDepartment(),data.getClub()), Toast.LENGTH_SHORT).show();
	}
	
	public void startListPeople(View view){
		Intent intent = new Intent(this, ListPeople.class);
		adapter.clear();
		startActivityForResult(intent, 0);
	}
	
	public ArrayList<ListCellData> data=new ArrayList<ListCellData>();
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		data = arg2.getExtras().getParcelableArrayList("list");
		for(ListCellData d:data){
			adapter.add(d);
		}
		lv.setAdapter(adapter);
		
		super.onActivityResult(arg0, arg1, arg2);
	}
	
	
	public void returnLast(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		
	}
}
