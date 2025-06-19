package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnjiantongjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AnjiantongjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AnjiantongjiView;


/**
 * 案件统计
 *
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface AnjiantongjiService extends IService<AnjiantongjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnjiantongjiVO> selectListVO(Wrapper<AnjiantongjiEntity> wrapper);
   	
   	AnjiantongjiVO selectVO(@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);
   	
   	List<AnjiantongjiView> selectListView(Wrapper<AnjiantongjiEntity> wrapper);
   	
   	AnjiantongjiView selectView(@Param("ew") Wrapper<AnjiantongjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnjiantongjiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<AnjiantongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<AnjiantongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<AnjiantongjiEntity> wrapper);



}

