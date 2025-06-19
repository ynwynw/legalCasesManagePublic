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

import com.entity.AnjianxinxiEntity;
import com.entity.view.AnjianxinxiView;

import com.service.AnjianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 案件信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
@RestController
@RequestMapping("/anjianxinxi")
public class AnjianxinxiController {
    @Autowired
    private AnjianxinxiService anjianxinxiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AnjianxinxiEntity anjianxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			anjianxinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			anjianxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<AnjianxinxiEntity> ew = new EntityWrapper<AnjianxinxiEntity>();

		PageUtils page = anjianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anjianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AnjianxinxiEntity anjianxinxi, 
		HttpServletRequest request){
        EntityWrapper<AnjianxinxiEntity> ew = new EntityWrapper<AnjianxinxiEntity>();

		PageUtils page = anjianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anjianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AnjianxinxiEntity anjianxinxi){
       	EntityWrapper<AnjianxinxiEntity> ew = new EntityWrapper<AnjianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( anjianxinxi, "anjianxinxi")); 
        return R.ok().put("data", anjianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AnjianxinxiEntity anjianxinxi){
        EntityWrapper< AnjianxinxiEntity> ew = new EntityWrapper< AnjianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( anjianxinxi, "anjianxinxi")); 
		AnjianxinxiView anjianxinxiView =  anjianxinxiService.selectView(ew);
		return R.ok("查询案件信息成功").put("data", anjianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnjianxinxiEntity anjianxinxi = anjianxinxiService.selectById(id);
        return R.ok().put("data", anjianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AnjianxinxiEntity anjianxinxi = anjianxinxiService.selectById(id);
        return R.ok().put("data", anjianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnjianxinxiEntity anjianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anjianxinxi);
        anjianxinxiService.insert(anjianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AnjianxinxiEntity anjianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anjianxinxi);
        anjianxinxiService.insert(anjianxinxi);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnjianxinxiEntity anjianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(anjianxinxi);
        anjianxinxiService.updateById(anjianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        anjianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
