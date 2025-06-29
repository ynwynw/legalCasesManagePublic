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


import com.dao.AnjiantongjiDao;
import com.entity.AnjiantongjiEntity;
import com.service.AnjiantongjiService;
import com.entity.vo.AnjiantongjiVO;
import com.entity.view.AnjiantongjiView;

@Service("anjiantongjiService")
public class AnjiantongjiServiceImpl extends ServiceImpl<AnjiantongjiDao, AnjiantongjiEntity> implements AnjiantongjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnjiantongjiEntity> page = this.selectPage(
                new Query<AnjiantongjiEntity>(params).getPage(),
                new EntityWrapper<AnjiantongjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnjiantongjiEntity> wrapper) {
		  Page<AnjiantongjiView> page =new Query<AnjiantongjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<AnjiantongjiVO> selectListVO(Wrapper<AnjiantongjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AnjiantongjiVO selectVO(Wrapper<AnjiantongjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AnjiantongjiView> selectListView(Wrapper<AnjiantongjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnjiantongjiView selectView(Wrapper<AnjiantongjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<AnjiantongjiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<AnjiantongjiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<AnjiantongjiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
