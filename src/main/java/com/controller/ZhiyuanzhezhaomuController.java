package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhiyuanzhezhaomuEntity;
import com.entity.view.ZhiyuanzhezhaomuView;

import com.service.ZhiyuanzhezhaomuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 志愿者招募
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-04 15:53:23
 */
@RestController
@RequestMapping("/zhiyuanzhezhaomu")
public class ZhiyuanzhezhaomuController {
    @Autowired
    private ZhiyuanzhezhaomuService zhiyuanzhezhaomuService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu,
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzhezhaomuEntity> ew = new EntityWrapper<ZhiyuanzhezhaomuEntity>();

		PageUtils page = zhiyuanzhezhaomuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhezhaomu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanzhezhaomuEntity> ew = new EntityWrapper<ZhiyuanzhezhaomuEntity>();

		PageUtils page = zhiyuanzhezhaomuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhezhaomu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu){
       	EntityWrapper<ZhiyuanzhezhaomuEntity> ew = new EntityWrapper<ZhiyuanzhezhaomuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanzhezhaomu, "zhiyuanzhezhaomu")); 
        return R.ok().put("data", zhiyuanzhezhaomuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu){
        EntityWrapper< ZhiyuanzhezhaomuEntity> ew = new EntityWrapper< ZhiyuanzhezhaomuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanzhezhaomu, "zhiyuanzhezhaomu")); 
		ZhiyuanzhezhaomuView zhiyuanzhezhaomuView =  zhiyuanzhezhaomuService.selectView(ew);
		return R.ok("查询志愿者招募成功").put("data", zhiyuanzhezhaomuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu = zhiyuanzhezhaomuService.selectById(id);
		zhiyuanzhezhaomu.setClicknum(zhiyuanzhezhaomu.getClicknum()+1);
		zhiyuanzhezhaomu.setClicktime(new Date());
		zhiyuanzhezhaomuService.updateById(zhiyuanzhezhaomu);
        return R.ok().put("data", zhiyuanzhezhaomu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu = zhiyuanzhezhaomuService.selectById(id);
		zhiyuanzhezhaomu.setClicknum(zhiyuanzhezhaomu.getClicknum()+1);
		zhiyuanzhezhaomu.setClicktime(new Date());
		zhiyuanzhezhaomuService.updateById(zhiyuanzhezhaomu);
        return R.ok().put("data", zhiyuanzhezhaomu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu = zhiyuanzhezhaomuService.selectById(id);
        if(type.equals("1")) {
        	zhiyuanzhezhaomu.setThumbsupnum(zhiyuanzhezhaomu.getThumbsupnum()+1);
        } else {
        	zhiyuanzhezhaomu.setCrazilynum(zhiyuanzhezhaomu.getCrazilynum()+1);
        }
        zhiyuanzhezhaomuService.updateById(zhiyuanzhezhaomu);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu, HttpServletRequest request){
    	zhiyuanzhezhaomu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzhezhaomu);
        zhiyuanzhezhaomuService.insert(zhiyuanzhezhaomu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu, HttpServletRequest request){
    	zhiyuanzhezhaomu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanzhezhaomu);
        zhiyuanzhezhaomuService.insert(zhiyuanzhezhaomu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanzhezhaomu);
        zhiyuanzhezhaomuService.updateById(zhiyuanzhezhaomu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanzhezhaomuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZhiyuanzhezhaomuEntity> wrapper = new EntityWrapper<ZhiyuanzhezhaomuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zhiyuanzhezhaomuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhiyuanzhezhaomuEntity zhiyuanzhezhaomu, HttpServletRequest request,String pre){
        EntityWrapper<ZhiyuanzhezhaomuEntity> ew = new EntityWrapper<ZhiyuanzhezhaomuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zhiyuanzhezhaomuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanzhezhaomu), params), params));
        return R.ok().put("data", page);
    }









}
