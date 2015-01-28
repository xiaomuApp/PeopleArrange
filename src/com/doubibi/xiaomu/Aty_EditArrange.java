package com.doubibi.xiaomu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Aty_EditArrange extends Activity {
	
	TextView ev;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_task);
	}
	
	public void btnPeopleArrange(View view){
		ev = (TextView) findViewById(R.id.evTaskTheme);
		String taskTheme = ev.getText().toString();
		Intent intent = new Intent(this, Aty_PeopleArrange.class);
		Bundle data = new Bundle();
		data.putString("taskTheme", taskTheme);
		intent.putExtra("task", data);
		startActivity(intent);
	}
	
	public void btnSave(View view){
		
		Toast.makeText(this, "�˹��ܴ�����", Toast.LENGTH_SHORT).show();
	}

}
