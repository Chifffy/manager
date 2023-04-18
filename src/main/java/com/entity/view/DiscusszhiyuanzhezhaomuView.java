package com.entity.view;

import com.entity.DiscusszhiyuanzhezhaomuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 志愿者招募评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
@TableName("discusszhiyuanzhezhaomu")
public class DiscusszhiyuanzhezhaomuView  extends DiscusszhiyuanzhezhaomuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhiyuanzhezhaomuView(){
	}
 
 	public DiscusszhiyuanzhezhaomuView(DiscusszhiyuanzhezhaomuEntity discusszhiyuanzhezhaomuEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhiyuanzhezhaomuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
