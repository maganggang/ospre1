package com.safe.core.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.safe.core.beans.ListMapVo;

public class TreeUtils {
private static boolean isLastChildern(List<ListMapVo>  list,Map<String,Object> map,String key,String parentKey){
	if(list!=null&&list.size()>0&&map.get(parentKey)!=null){
		for(Map<String,Object> temp : list){
			if(map.get(key).equals(temp.get(parentKey))){
				return false;
			}
		}
	}else{
		return false;
	}
	return true;
	}
	public static   List<ListMapVo> toTree(List<ListMapVo> list,String key,String parentKey){
		List<Map<String,Object>> newList=new ArrayList<Map<String,Object>>();
		if(list!=null&&list.size()>0){
			for(Map<String,Object> temp : list){
				if(isLastChildern(list, temp, key, parentKey)){
					//putToParent
					for(Map<String,Object> tempParent : list){
						if(temp.get(parentKey).equals(tempParent.get(key))){
							
							if(tempParent.get("children")!=null){
								List<ListMapVo> oldChildren=(List<ListMapVo>) tempParent.get("children");
								oldChildren.add((ListMapVo) temp);
							}else{
								List<ListMapVo> childreLlist=new ArrayList<ListMapVo>();
								childreLlist.add((ListMapVo) temp);
								tempParent.put("children", childreLlist);
							}
							list.remove(temp);
							return toTree(list, key, parentKey);
						}
					}
				}
			}
			
		}
		return list;
	}
public static void main(String[] args) {
	List<ListMapVo> newList=new ArrayList<ListMapVo>();
	ListMapVo m1=new ListMapVo();
	m1.put("id", 1);
	m1.put("parentId", null);
	newList.add( m1);
	
	ListMapVo m2=new ListMapVo();
	m2.put("id", 2);
	m2.put("parentId", null);
	newList.add(m2);
	
	ListMapVo m3=new ListMapVo();
	m3.put("id", 3);
	m3.put("parentId", 1);
	newList.add(m3);
	
	ListMapVo m4=new ListMapVo();
	m4.put("id", 4);
	m4.put("parentId", 3);
	newList.add(m4);
	System.out.println(newList);
	List l1=toTree(newList, "id", "parentId");
	System.out.println(l1);
}
}
