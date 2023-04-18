package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhiyuanzhezhaomuDao;
import com.entity.ZhiyuanzhezhaomuEntity;
import com.service.ZhiyuanzhezhaomuService;
import com.entity.vo.ZhiyuanzhezhaomuVO;
import com.entity.view.ZhiyuanzhezhaomuView;

@Service("zhiyuanzhezhaomuService")
public class ZhiyuanzhezhaomuServiceImpl extends ServiceImpl<ZhiyuanzhezhaomuDao, ZhiyuanzhezhaomuEntity> implements ZhiyuanzhezhaomuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzhezhaomuEntity> page = this.selectPage(
                new Query<ZhiyuanzhezhaomuEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzhezhaomuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzhezhaomuEntity> wrapper) {
		  Page<ZhiyuanzhezhaomuView> page =new Query<ZhiyuanzhezhaomuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiyuanzhezhaomuVO> selectListVO(Wrapper<ZhiyuanzhezhaomuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiyuanzhezhaomuVO selectVO(Wrapper<ZhiyuanzhezhaomuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiyuanzhezhaomuView> selectListView(Wrapper<ZhiyuanzhezhaomuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzhezhaomuView selectView(Wrapper<ZhiyuanzhezhaomuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
