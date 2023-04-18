package com.dao;

import com.entity.ZhiyuanzhezhaomuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanzhezhaomuVO;
import com.entity.view.ZhiyuanzhezhaomuView;


/**
 * 志愿者招募
 * 
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
public interface ZhiyuanzhezhaomuDao extends BaseMapper<ZhiyuanzhezhaomuEntity> {
	
	List<ZhiyuanzhezhaomuVO> selectListVO(@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
	
	ZhiyuanzhezhaomuVO selectVO(@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
	
	List<ZhiyuanzhezhaomuView> selectListView(@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);

	List<ZhiyuanzhezhaomuView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
	
	ZhiyuanzhezhaomuView selectView(@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
	

}
