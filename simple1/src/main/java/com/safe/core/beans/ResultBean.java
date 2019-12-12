package com.safe.core.beans;

import java.util.List;

public class  ResultBean<T> {
private String msg;
private long code;
private int count;
private List<T> data;
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public List<T> getData() {
	return data;
}
public void setData(List<T> data) {
	this.data = data;
	this.count = data.size();
	if(data!=null){
		this.code=0;
		this.msg="ok";
	}
} 

}
