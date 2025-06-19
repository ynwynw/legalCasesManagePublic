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


import com.dao.AnjianzhengjuDao;
import com.entity.AnjianzhengjuEntity;
import com.service.AnjianzhengjuService;
import com.entity.vo.AnjianzhengjuVO;
import com.entity.view.AnjianzhengjuView;

@Service("anjianzhengjuService")
public class AnjianzhengjuServiceImpl extends ServiceImpl<AnjianzhengjuDao, AnjianzhengjuEntity> implements AnjianzhengjuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AnjianzhengjuEntity> page = this.selectPage(
                new Query<AnjianzhengjuEntity>(params).getPage(),
                new EntityWrapper<AnjianzhengjuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AnjianzhengjuEntity> wrapper) {
		  Page<AnjianzhengjuView> page =new Query<AnjianzhengjuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<AnjianzhengjuVO> selectListVO(Wrapper<AnjianzhengjuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AnjianzhengjuVO selectVO(Wrapper<AnjianzhengjuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AnjianzhengjuView> selectListView(Wrapper<AnjianzhengjuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AnjianzhengjuView selectView(Wrapper<AnjianzhengjuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
