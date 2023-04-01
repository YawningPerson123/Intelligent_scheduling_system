package com.pilifenghuolang.ISS.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pilifenghuolang.ISS.schedule.Time;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeDao extends BaseMapper<Time> {
}
