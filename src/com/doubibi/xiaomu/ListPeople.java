package com.doubibi.xiaomu;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class ListPeople extends Activity {

	private MyAdapter adapter;  
	private ListView listview;  
	private Button checkAll;  
	private Button noCheckAll;  
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_people);

		listview = (ListView)findViewById(R.id.lvAllPeople);  
		checkAll = (Button)findViewById(R.id.btnAll);  
		noCheckAll = (Button)findViewById(R.id.btnConcel);  
		adapter = new MyAdapter();  
		listview.setAdapter(adapter);  

		checkAll.setOnClickListener(new OnClickListener() {  

			@Override  
			public void onClick(View v) {  
				adapter.checkAll();  
			}  
		});  
		noCheckAll.setOnClickListener(new OnClickListener() {  

			@Override  
			public void onClick(View v) {  
				adapter.noCheckAll();  
			}  
		});  

	}  


	public static ArrayList<ListCellData> CheckedPeople = new ArrayList<ListCellData>();
	public static ArrayList<ListCellData> data= new ArrayList<ListCellData>();  
	private class MyAdapter extends BaseAdapter{  


		public MyAdapter(){  
			data.add(new ListCellData("������", "��Ŀ����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("����־", "��׿����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("����", "��׿����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("������", "��׿����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("��ΰ��", "��׿����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("��ѩ��", "��׿����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("����Բ", "��̨����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("��־��", "��̨����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("���", "ios����", "���ȱ�", "Сľ"));
			data.add(new ListCellData("�ܳ���", "UI���", "���ȱ�", "Сľ"));
		}  

		public void checkAll(){  
			for(ListCellData msg:data){  
				msg.isCheck = true; 
				CheckedPeople.add(msg);
			}  
			notifyDataSetChanged();  
		}  
		public void noCheckAll(){  
			for(ListCellData msg:data){  
				msg.isCheck = false;  
			}  
			CheckedPeople.clear();
			notifyDataSetChanged();  
		}  

		@Override  
		public int getCount() {  
			return data.size(); 
		}  

		@Override  
		public ArrayList<ListCellData> getItem(int position) {  
			return data;  
		}  

		@Override  
		public long getItemId(int position) {  
			return position;  
		}  

		@Override  
		public View getView(int position, View convertView, ViewGroup parent) {  
			ViewHolder viewHolder;  
			if(convertView == null){  
				LayoutInflater inflater = LayoutInflater.from(ListPeople.this);  
				convertView = inflater.inflate(R.layout.list_cell_all, null);  
				viewHolder = new ViewHolder();  
				viewHolder.textView = (TextView) convertView.findViewById(R.id.tvPeople);
				viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.checkBox);  
				convertView.setTag(viewHolder);  
			}else{  
				viewHolder = (ViewHolder)convertView.getTag();  
			}  
			final ListCellData msg = data.get(position);  
			viewHolder.textView.setText(msg.toString());  
			viewHolder.checkBox.setChecked(msg.isCheck);  
			//ע���������õĲ���onCheckedChangListener������ֵ��˼��һ�µ�  
			viewHolder.checkBox.setOnClickListener(new OnClickListener() {  

				@Override  
				public void onClick(View v) {  
					if(msg.isCheck){  
						msg.isCheck = false; 
						CheckedPeople.remove(msg);
					}else{  
						msg.isCheck = true;  
						CheckedPeople.add(msg);
					}  

				}  
			});  
			return convertView;  
		}  

	}  
	private class ViewHolder{  
		TextView textView;
		CheckBox checkBox;  
	}  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_people, menu);
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

	
	public void commitPeopleList(View view){		
		Intent intent = new Intent();
		Bundle data = new Bundle();
		data.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) CheckedPeople);
		intent.putExtras(data);
		setResult(0, intent);
		finish();

	}
}
