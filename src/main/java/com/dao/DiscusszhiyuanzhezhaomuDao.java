package com.dao;

import com.entity.DiscusszhiyuanzhezhaomuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhiyuanzhezhaomuVO;
import com.entity.view.DiscusszhiyuanzhezhaomuView;


/**
 * 志愿者招募评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
public interface DiscusszhiyuanzhezhaomuDao extends BaseMapper<DiscusszhiyuanzhezhaomuEntity> {
	
	List<DiscusszhiyuanzhezhaomuVO> selectListVO(@Param("ew") Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper);
	
	DiscusszhiyuanzhezhaomuVO selectVO(@Param("ew") Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper);
	
	List<DiscusszhiyuanzhezhaomuView> selectListView(@Param("ew") Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper);

	List<DiscusszhiyuanzhezhaomuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper);
	
	DiscusszhiyuanzhezhaomuView selectView(@Param("ew") Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper);
	

}
