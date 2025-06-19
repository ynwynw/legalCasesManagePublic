package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiwusuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShiwusuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwusuoxinxiView;


/**
 * 事务所信息
 *
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface ShiwusuoxinxiService extends IService<ShiwusuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiwusuoxinxiVO> selectListVO(Wrapper<ShiwusuoxinxiEntity> wrapper);
   	
   	ShiwusuoxinxiVO selectVO(@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);
   	
   	List<ShiwusuoxinxiView> selectListView(Wrapper<ShiwusuoxinxiEntity> wrapper);
   	
   	ShiwusuoxinxiView selectView(@Param("ew") Wrapper<ShiwusuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiwusuoxinxiEntity> wrapper);
   	

}

