package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghutixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YonghutixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghutixingView;


/**
 * 用户提醒
 *
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface YonghutixingService extends IService<YonghutixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghutixingVO> selectListVO(Wrapper<YonghutixingEntity> wrapper);
   	
   	YonghutixingVO selectVO(@Param("ew") Wrapper<YonghutixingEntity> wrapper);
   	
   	List<YonghutixingView> selectListView(Wrapper<YonghutixingEntity> wrapper);
   	
   	YonghutixingView selectView(@Param("ew") Wrapper<YonghutixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghutixingEntity> wrapper);
   	

}

