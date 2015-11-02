package org.me.core.common.base;

import java.util.List;

public interface ListDao<T> {
	public List<T> list(T t);//查询
	public int listSize(T t);//查询列表大小(分页)
}
