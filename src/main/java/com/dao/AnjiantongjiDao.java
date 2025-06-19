package com.dao;

import com.entity.AnjiantongjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnjiantongjiVO;
import com.entity.view.AnjiantongjiView;


/**
 * 案件统计
 * 
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface AnjiantongjiDao extends BaseMapper<AnjiantongjiEntity> {
	
	List<AnjiantongjiVO> selectListVO(@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);
	
	AnjiantongjiVO selectVO(@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);
	
	List<AnjiantongjiView> selectListView(@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);

	List<AnjiantongjiView> selectListView(Pagination page,@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);
	
	AnjiantongjiView selectView(@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);



}
