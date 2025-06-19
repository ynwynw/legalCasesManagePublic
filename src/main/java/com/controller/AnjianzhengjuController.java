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

import com.entity.AnjianzhengjuEntity;
import com.entity.view.AnjianzhengjuView;

import com.service.AnjianzhengjuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 案件证据
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
@RestController
@RequestMapping("/anjianzhengju")
public class AnjianzhengjuController {
    @Autowired
    private AnjianzhengjuService anjianzhengjuService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AnjianzhengjuEntity anjianzhengju,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			anjianzhengju.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yuangong")) {
			anjianzhengju.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<AnjianzhengjuEntity> ew = new EntityWrapper<AnjianzhengjuEntity>();

		PageUtils page = anjianzhengjuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anjianzhengju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AnjianzhengjuEntity anjianzhengju, 
		HttpServletRequest request){
        EntityWrapper<AnjianzhengjuEntity> ew = new EntityWrapper<AnjianzhengjuEntity>();

		PageUtils page = anjianzhengjuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anjianzhengju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AnjianzhengjuEntity anjianzhengju){
       	EntityWrapper<AnjianzhengjuEntity> ew = new EntityWrapper<AnjianzhengjuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( anjianzhengju, "anjianzhengju")); 
        return R.ok().put("data", anjianzhengjuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AnjianzhengjuEntity anjianzhengju){
        EntityWrapper< AnjianzhengjuEntity> ew = new EntityWrapper< AnjianzhengjuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( anjianzhengju, "anjianzhengju")); 
		AnjianzhengjuView anjianzhengjuView =  anjianzhengjuService.selectView(ew);
		return R.ok("查询案件证据成功").put("data", anjianzhengjuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnjianzhengjuEntity anjianzhengju = anjianzhengjuService.selectById(id);
        return R.ok().put("data", anjianzhengju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AnjianzhengjuEntity anjianzhengju = anjianzhengjuService.selectById(id);
        return R.ok().put("data", anjianzhengju);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnjianzhengjuEntity anjianzhengju, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anjianzhengju);
        anjianzhengjuService.insert(anjianzhengju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AnjianzhengjuEntity anjianzhengju, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anjianzhengju);
        anjianzhengjuService.insert(anjianzhengju);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnjianzhengjuEntity anjianzhengju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(anjianzhengju);
        anjianzhengjuService.updateById(anjianzhengju);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        anjianzhengjuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
