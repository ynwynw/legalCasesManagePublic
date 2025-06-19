package com.dao;

import com.entity.YonghutixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YonghutixingVO;
import com.entity.view.YonghutixingView;


/**
 * 用户提醒
 * 
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface YonghutixingDao extends BaseMapper<YonghutixingEntity> {
	
	List<YonghutixingVO> selectListVO(@Param("ew") Wrapper<YonghutixingEntity> wrapper);
	
	YonghutixingVO selectVO(@Param("ew") Wrapper<YonghutixingEntity> wrapper);
	
	List<YonghutixingView> selectListView(@Param("ew") Wrapper<YonghutixingEntity> wrapper);

	List<YonghutixingView> selectListView(Pagination page,@Param("ew") Wrapper<YonghutixingEntity> wrapper);
	
	YonghutixingView selectView(@Param("ew") Wrapper<YonghutixingEntity> wrapper);
	

}
