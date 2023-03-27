package com.pilifenghuolang.ISS.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pilifenghuolang.ISS.domain.Stuff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuffDAO extends BaseMapper<Stuff> {
}
