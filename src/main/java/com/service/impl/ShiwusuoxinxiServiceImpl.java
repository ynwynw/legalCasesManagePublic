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


import com.dao.ShiwusuoxinxiDao;
import com.entity.ShiwusuoxinxiEntity;
import com.service.ShiwusuoxinxiService;
import com.entity.vo.ShiwusuoxinxiVO;
import com.entity.view.ShiwusuoxinxiView;

@Service("shiwusuoxinxiService")
public class ShiwusuoxinxiServiceImpl extends ServiceImpl<ShiwusuoxinxiDao, ShiwusuoxinxiEntity> implements ShiwusuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiwusuoxinxiEntity> page = this.selectPage(
                new Query<ShiwusuoxinxiEntity>(params).getPage(),
                new EntityWrapper<ShiwusuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiwusuoxinxiEntity> wrapper) {
		  Page<ShiwusuoxinxiView> page =new Query<ShiwusuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShiwusuoxinxiVO> selectListVO(Wrapper<ShiwusuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShiwusuoxinxiVO selectVO(Wrapper<ShiwusuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShiwusuoxinxiView> selectListView(Wrapper<ShiwusuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiwusuoxinxiView selectView(Wrapper<ShiwusuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
