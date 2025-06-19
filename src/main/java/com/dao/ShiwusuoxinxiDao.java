package com.dao;

import com.entity.ShiwusuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShiwusuoxinxiVO;
import com.entity.view.ShiwusuoxinxiView;


/**
 * 事务所信息
 * 
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface ShiwusuoxinxiDao extends BaseMapper<ShiwusuoxinxiEntity> {
	
	List<ShiwusuoxinxiVO> selectListVO(@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);
	
	ShiwusuoxinxiVO selectVO(@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);
	
	List<ShiwusuoxinxiView> selectListView(@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);

	List<ShiwusuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);
	
	ShiwusuoxinxiView selectView(@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);
	

}
