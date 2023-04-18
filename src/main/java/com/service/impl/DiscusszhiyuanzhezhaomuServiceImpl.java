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


import com.dao.DiscusszhiyuanzhezhaomuDao;
import com.entity.DiscusszhiyuanzhezhaomuEntity;
import com.service.DiscusszhiyuanzhezhaomuService;
import com.entity.vo.DiscusszhiyuanzhezhaomuVO;
import com.entity.view.DiscusszhiyuanzhezhaomuView;

@Service("discusszhiyuanzhezhaomuService")
public class DiscusszhiyuanzhezhaomuServiceImpl extends ServiceImpl<DiscusszhiyuanzhezhaomuDao, DiscusszhiyuanzhezhaomuEntity> implements DiscusszhiyuanzhezhaomuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhiyuanzhezhaomuEntity> page = this.selectPage(
                new Query<DiscusszhiyuanzhezhaomuEntity>(params).getPage(),
                new EntityWrapper<DiscusszhiyuanzhezhaomuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper) {
		  Page<DiscusszhiyuanzhezhaomuView> page =new Query<DiscusszhiyuanzhezhaomuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhiyuanzhezhaomuVO> selectListVO(Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhiyuanzhezhaomuVO selectVO(Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhiyuanzhezhaomuView> selectListView(Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhiyuanzhezhaomuView selectView(Wrapper<DiscusszhiyuanzhezhaomuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
