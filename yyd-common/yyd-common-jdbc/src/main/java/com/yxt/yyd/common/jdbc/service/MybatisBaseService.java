package com.yxt.yyd.common.jdbc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class MybatisBaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {


    public T fetchBySid(String sid) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.eq("sid", sid);
        return baseMapper.selectOne(qw);
    }
}
