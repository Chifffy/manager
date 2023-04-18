package com.dao;

import com.entity.ZhiyuanzhebaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanzhebaomingVO;
import com.entity.view.ZhiyuanzhebaomingView;


/**
 * 志愿者报名
 * 
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
public interface ZhiyuanzhebaomingDao extends BaseMapper<ZhiyuanzhebaomingEntity> {
	
	List<ZhiyuanzhebaomingVO> selectListVO(@Param("ew") Wrapper<ZhiyuanzhebaomingEntity> wrapper);
	
	ZhiyuanzhebaomingVO selectVO(@Param("ew") Wrapper<ZhiyuanzhebaomingEntity> wrapper);
	
	List<ZhiyuanzhebaomingView> selectListView(@Param("ew") Wrapper<ZhiyuanzhebaomingEntity> wrapper);

	List<ZhiyuanzhebaomingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzhebaomingEntity> wrapper);
	
	ZhiyuanzhebaomingView selectView(@Param("ew") Wrapper<ZhiyuanzhebaomingEntity> wrapper);
	

}
