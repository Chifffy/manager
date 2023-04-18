package com.entity.view;

import com.entity.DiscusszhiyuanzhehuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 志愿者活动评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
@TableName("discusszhiyuanzhehuodong")
public class DiscusszhiyuanzhehuodongView  extends DiscusszhiyuanzhehuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhiyuanzhehuodongView(){
	}
 
 	public DiscusszhiyuanzhehuodongView(DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodongEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhiyuanzhehuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
