package com.yxt.yyd.common.base.service;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxt.yyd.common.core.domain.BaseEntity;
import com.yxt.yyd.common.core.dto.Dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimengzhe
 * @date 2021/9/3 17:07
 * @description
 */

public class MybatisBaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    /**
     * 根据sid删除
     *
     * @param sid sid
     * @return
     */
    public int deleteBySid(String sid) {
        Map<String, Object> map = new HashMap<>();
        map.put("sid", sid);
        return baseMapper.deleteByMap(map);
    }

    /**
     * 根据sid更新数据
     *
     * @param dto 传输数据对象
     * @param sid sid
     * @return
     */
    public int updateBySid(Dto dto, String sid) {
        T t = fetchBySid(sid);
        if (t == null)
            return -1;
        BeanUtil.copyProperties(dto, t);
        if (t instanceof BaseEntity) {
            if (((BaseEntity) t).getLockVersion() != null) {
                ((BaseEntity) t).setLockVersion(((BaseEntity) t).getLockVersion() + 1);
            }
        }
        return baseMapper.updateById(t);
    }

    public T fetchBySid(String sid) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.eq("sid", sid);
        return baseMapper.selectOne(qw);
    }

}
