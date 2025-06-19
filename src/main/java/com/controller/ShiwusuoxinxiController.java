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

import com.entity.ShiwusuoxinxiEntity;
import com.entity.view.ShiwusuoxinxiView;

import com.service.ShiwusuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 事务所信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
@RestController
@RequestMapping("/shiwusuoxinxi")
public class ShiwusuoxinxiController {
    @Autowired
    private ShiwusuoxinxiService shiwusuoxinxiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiwusuoxinxiEntity shiwusuoxinxi,
		HttpServletRequest request){
        EntityWrapper<ShiwusuoxinxiEntity> ew = new EntityWrapper<ShiwusuoxinxiEntity>();

		PageUtils page = shiwusuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwusuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiwusuoxinxiEntity shiwusuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShiwusuoxinxiEntity> ew = new EntityWrapper<ShiwusuoxinxiEntity>();

		PageUtils page = shiwusuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwusuoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiwusuoxinxiEntity shiwusuoxinxi){
       	EntityWrapper<ShiwusuoxinxiEntity> ew = new EntityWrapper<ShiwusuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiwusuoxinxi, "shiwusuoxinxi")); 
        return R.ok().put("data", shiwusuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiwusuoxinxiEntity shiwusuoxinxi){
        EntityWrapper< ShiwusuoxinxiEntity> ew = new EntityWrapper< ShiwusuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiwusuoxinxi, "shiwusuoxinxi")); 
		ShiwusuoxinxiView shiwusuoxinxiView =  shiwusuoxinxiService.selectView(ew);
		return R.ok("查询事务所信息成功").put("data", shiwusuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiwusuoxinxiEntity shiwusuoxinxi = shiwusuoxinxiService.selectById(id);
        return R.ok().put("data", shiwusuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiwusuoxinxiEntity shiwusuoxinxi = shiwusuoxinxiService.selectById(id);
        return R.ok().put("data", shiwusuoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwusuoxinxiEntity shiwusuoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shiwusuoxinxi);
        shiwusuoxinxiService.insert(shiwusuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiwusuoxinxiEntity shiwusuoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shiwusuoxinxi);
        shiwusuoxinxiService.insert(shiwusuoxinxi);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiwusuoxinxiEntity shiwusuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiwusuoxinxi);
        shiwusuoxinxiService.updateById(shiwusuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiwusuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
