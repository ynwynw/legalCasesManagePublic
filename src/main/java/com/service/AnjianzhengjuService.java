package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnjianzhengjuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.AnjianzhengjuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.AnjianzhengjuView;


/**
 * 案件证据
 *
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface AnjianzhengjuService extends IService<AnjianzhengjuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AnjianzhengjuVO> selectListVO(Wrapper<AnjianzhengjuEntity> wrapper);
   	
   	AnjianzhengjuVO selectVO(@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);
   	
   	List<AnjianzhengjuView> selectListView(Wrapper<AnjianzhengjuEntity> wrapper);
   	
   	AnjianzhengjuView selectView(@Param("ew") Wrapper<AnjianzhengjuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AnjianzhengjuEntity> wrapper);
   	

}

