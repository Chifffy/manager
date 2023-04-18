package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiyuanzhezhaomuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiyuanzhezhaomuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanzhezhaomuView;


/**
 * 志愿者招募
 *
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
public interface ZhiyuanzhezhaomuService extends IService<ZhiyuanzhezhaomuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzhezhaomuVO> selectListVO(Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
   	
   	ZhiyuanzhezhaomuVO selectVO(@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
   	
   	List<ZhiyuanzhezhaomuView> selectListView(Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
   	
   	ZhiyuanzhezhaomuView selectView(@Param("ew") Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzhezhaomuEntity> wrapper);
   	

}

