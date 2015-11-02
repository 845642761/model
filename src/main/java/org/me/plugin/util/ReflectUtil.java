package org.me.plugin.util;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReflectUtil {
	/**
	 * 获取类的参数集合
	 * @author: chengbo
	 * @date: 2015年10月21日 11:45:15
	 */
	public ArrayList<String> getDeclaredFields(Object ob) {
		if(ob == null)
			return null;
		ArrayList<String> al=new ArrayList<>();
		Field field[] = ob.getClass().getDeclaredFields();
		for (Field f : field) {
			String name=f.getName();
			if("serialVersionUID".equals(name))
				continue;
			al.add(name);
		}
		return al;
	}
}
