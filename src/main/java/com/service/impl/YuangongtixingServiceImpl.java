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


import com.dao.YuangongtixingDao;
import com.entity.YuangongtixingEntity;
import com.service.YuangongtixingService;
import com.entity.vo.YuangongtixingVO;
import com.entity.view.YuangongtixingView;

@Service("yuangongtixingService")
public class YuangongtixingServiceImpl extends ServiceImpl<YuangongtixingDao, YuangongtixingEntity> implements YuangongtixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongtixingEntity> page = this.selectPage(
                new Query<YuangongtixingEntity>(params).getPage(),
                new EntityWrapper<YuangongtixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongtixingEntity> wrapper) {
		  Page<YuangongtixingView> page =new Query<YuangongtixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuangongtixingVO> selectListVO(Wrapper<YuangongtixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangongtixingVO selectVO(Wrapper<YuangongtixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangongtixingView> selectListView(Wrapper<YuangongtixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongtixingView selectView(Wrapper<YuangongtixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
