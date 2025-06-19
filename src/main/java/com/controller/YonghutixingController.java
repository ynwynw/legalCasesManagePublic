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

import com.entity.YonghutixingEntity;
import com.entity.view.YonghutixingView;

import com.service.YonghutixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 用户提醒
 * 后端接口
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
@RestController
@RequestMapping("/yonghutixing")
public class YonghutixingController {
    @Autowired
    private YonghutixingService yonghutixingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YonghutixingEntity yonghutixing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yonghutixing.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YonghutixingEntity> ew = new EntityWrapper<YonghutixingEntity>();

		PageUtils page = yonghutixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghutixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YonghutixingEntity yonghutixing, 
		HttpServletRequest request){
        EntityWrapper<YonghutixingEntity> ew = new EntityWrapper<YonghutixingEntity>();

		PageUtils page = yonghutixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghutixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YonghutixingEntity yonghutixing){
       	EntityWrapper<YonghutixingEntity> ew = new EntityWrapper<YonghutixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yonghutixing, "yonghutixing")); 
        return R.ok().put("data", yonghutixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghutixingEntity yonghutixing){
        EntityWrapper< YonghutixingEntity> ew = new EntityWrapper< YonghutixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yonghutixing, "yonghutixing")); 
		YonghutixingView yonghutixingView =  yonghutixingService.selectView(ew);
		return R.ok("查询用户提醒成功").put("data", yonghutixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YonghutixingEntity yonghutixing = yonghutixingService.selectById(id);
        return R.ok().put("data", yonghutixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YonghutixingEntity yonghutixing = yonghutixingService.selectById(id);
        return R.ok().put("data", yonghutixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghutixingEntity yonghutixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yonghutixing);
        yonghutixingService.insert(yonghutixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YonghutixingEntity yonghutixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yonghutixing);
        yonghutixingService.insert(yonghutixing);
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YonghutixingEntity yonghutixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghutixing);
        yonghutixingService.updateById(yonghutixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yonghutixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
