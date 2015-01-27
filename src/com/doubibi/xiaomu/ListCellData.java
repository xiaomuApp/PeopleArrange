package com.doubibi.xiaomu;

import android.os.Parcel;
import android.os.Parcelable;


public class ListCellData implements Parcelable{

	public ListCellData(String name, String position, String department,
			String club) {
		super();
		this.name = name;
		this.position = position;
		this.department = department;
		this.club = club;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
	@Override
	public String toString() {
		return department + " - " + name;
	}

	private String name=" ";
	private String position=" ";
	private String department=" ";
	private String club=" ";
	public boolean isCheck; 

	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(position);
		dest.writeString(department);
		dest.writeString(club);
	}
	
	public static final Parcelable.Creator<ListCellData> CREATOR = new Parcelable.Creator<ListCellData>() {

		@Override
		public ListCellData createFromParcel(Parcel source) {			
			return new ListCellData(source);
		}

		@Override
		public ListCellData[] newArray(int size) {
			return new ListCellData[size];
		}
	};
	
	public ListCellData(Parcel source){
		name = source.readString();
		position = source.readString();
		department = source.readString();
		club = source.readString();
	}
}

