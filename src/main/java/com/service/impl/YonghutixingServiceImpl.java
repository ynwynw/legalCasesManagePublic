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


import com.dao.YonghutixingDao;
import com.entity.YonghutixingEntity;
import com.service.YonghutixingService;
import com.entity.vo.YonghutixingVO;
import com.entity.view.YonghutixingView;

@Service("yonghutixingService")
public class YonghutixingServiceImpl extends ServiceImpl<YonghutixingDao, YonghutixingEntity> implements YonghutixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghutixingEntity> page = this.selectPage(
                new Query<YonghutixingEntity>(params).getPage(),
                new EntityWrapper<YonghutixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghutixingEntity> wrapper) {
		  Page<YonghutixingView> page =new Query<YonghutixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghutixingVO> selectListVO(Wrapper<YonghutixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YonghutixingVO selectVO(Wrapper<YonghutixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghutixingView> selectListView(Wrapper<YonghutixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghutixingView selectView(Wrapper<YonghutixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
