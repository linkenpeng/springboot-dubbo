package com.intecsec.mall.user.mapper;

import com.intecsec.mall.user.entity.IdGen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IdGenMapper {

	/**
	 * 根据idName，获取配置对象
	 */
	IdGen getById(@Param("idName") String idName);

	/**
	 * 修改指定IdGen记录的起始位置<br>
	 * 必须指定当前值：next_start_id = ${currentStart}<br>
	 * <br>
	 * 返回的int决定修改是否成功
	 */
	int updateNextStart(@Param("idName") String idName, @Param("currentStart") long currentStart);

}