package com.threewater.order.mapper;

import com.threewater.order.entity.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
