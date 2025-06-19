package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongtixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuangongtixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongtixingView;


/**
 * 员工提醒
 *
 * @author 
 * @email 
 * @date 2023-12-25 16:07:02
 */
public interface YuangongtixingService extends IService<YuangongtixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongtixingVO> selectListVO(Wrapper<YuangongtixingEntity> wrapper);
   	
   	YuangongtixingVO selectVO(@Param("ew") Wrapper<YuangongtixingEntity> wrapper);
   	
   	List<YuangongtixingView> selectListView(Wrapper<YuangongtixingEntity> wrapper);
   	
   	YuangongtixingView selectView(@Param("ew") Wrapper<YuangongtixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongtixingEntity> wrapper);
   	

}

