package org.me.core.common.base;

import java.util.List;
import org.me.core.common.Resoult;

/**
 * @description: 基类
 * @author: cheng_bo
 * @date: 2015年7月3日 13:56:21
 */
public interface BaseService<T> {
	public Resoult save(T t);//保存
	public Resoult get(String id);//get
	public Resoult del(List<String> ids);//删除
	public Resoult update(T t);//修改
	public Resoult list(T t);//查询
}
