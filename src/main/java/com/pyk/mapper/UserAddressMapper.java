package com.pyk.mapper;

import com.pyk.entity.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2022-03-18
 */
public interface UserAddressMapper extends BaseMapper<UserAddress> {
    public int setDefault();
}
