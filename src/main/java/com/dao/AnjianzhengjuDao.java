package com.dao;

import com.entity.AnjianzhengjuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnjianzhengjuVO;
import com.entity.view.AnjianzhengjuView;


/**
 * 案件证据
 * 
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface AnjianzhengjuDao extends BaseMapper<AnjianzhengjuEntity> {
	
	List<AnjianzhengjuVO> selectListVO(@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);
	
	AnjianzhengjuVO selectVO(@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);
	
	List<AnjianzhengjuView> selectListView(@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);

	List<AnjianzhengjuView> selectListView(Pagination page,@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);
	
	AnjianzhengjuView selectView(@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);
	

}
