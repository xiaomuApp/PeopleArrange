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
			data.add(new ListCellData("余湘如", "项目经理", "逗比比", "小木"));
			data.add(new ListCellData("冼立志", "安卓开发", "逗比比", "小木"));
			data.add(new ListCellData("黄炫", "安卓开发", "逗比比", "小木"));
			data.add(new ListCellData("龙宇文", "安卓开发", "逗比比", "小木"));
			data.add(new ListCellData("吴伟峰", "安卓开发", "逗比比", "小木"));
			data.add(new ListCellData("池雪辉", "安卓开发", "逗比比", "小木"));
			data.add(new ListCellData("杜梦圆", "后台开发", "逗比比", "小木"));
			data.add(new ListCellData("刘志杰", "后台开发", "逗比比", "小木"));
			data.add(new ListCellData("李凯旋", "ios开发", "逗比比", "小木"));
			data.add(new ListCellData("周楚鹏", "UI设计", "逗比比", "小木"));
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
			//注意这里设置的不是onCheckedChangListener，还是值得思考一下的  
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
