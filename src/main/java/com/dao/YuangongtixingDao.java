package com.dao;

import com.entity.YuangongtixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuangongtixingVO;
import com.entity.view.YuangongtixingView;


/**
 * 员工提醒
 * 
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface YuangongtixingDao extends BaseMapper<YuangongtixingEntity> {
	
	List<YuangongtixingVO> selectListVO(@Param("ew") Wrapper<YuangongtixingEntity> wrapper);
	
	YuangongtixingVO selectVO(@Param("ew") Wrapper<YuangongtixingEntity> wrapper);
	
	List<YuangongtixingView> selectListView(@Param("ew") Wrapper<YuangongtixingEntity> wrapper);

	List<YuangongtixingView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongtixingEntity> wrapper);
	
	YuangongtixingView selectView(@Param("ew") Wrapper<YuangongtixingEntity> wrapper);
	

}
