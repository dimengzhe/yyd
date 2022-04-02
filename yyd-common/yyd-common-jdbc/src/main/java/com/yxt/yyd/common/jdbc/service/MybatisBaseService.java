package com.yxt.yyd.common.jdbc.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxt.yyd.common.core.domain.BaseEntity;
import com.yxt.yyd.common.core.dto.Dto;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public class MybatisBaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    @SuppressWarnings("unchecked")
    private T entity() {
        T instance = null;
        Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
        try {
            instance = entityClass.newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param map
     */
    protected Long checkId(Map<String, Object> map) {
        Object object = map.get("id");
        if (object == null) {
            return 0L;
        }
        String sId = object.toString();
        if (StringUtils.isBlank(sId)) {
            return 0L;
        }
        Long id = Long.valueOf(sId);
        return id;
    }

    protected String checkSid(Map<String, Object> map) {
        Object object = map.get("sid");
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    /**
     * 描述 : 将Map转换为实体对象. <br/>
     * <p>
     *
     * @param map
     * @param t
     * @return
     */
    @SuppressWarnings("unchecked")
    protected T map2entity(Map<String, Object> map, T t) {
        map.remove("id");
        map.remove("sid");
        map.remove("createTime");
        map.remove("modifyTime");
        if (t instanceof BaseEntity) {
            ((BaseEntity) t).setModifyTime(new Date());
            t = (T) (BaseEntity) t;
        }
        BeanUtil.fillBeanWithMapIgnoreCase(map, t, false);
        return t;
    }

    public int insert(T paramT) {
        return baseMapper.insert(paramT);
    }

    public int insert(Map<String, Object> map) {
        T t = entity();
        t = map2entity(map, t);
        return insert(t);
    }

    public int deleteBySid(String sid) {
        Map<String, Object> map = new HashMap<>();
        map.put("sid", sid);
        return baseMapper.deleteByMap(map);
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param ids
     * @return
     */
    public int delByIds(String ids) {
        String[] split = ids.split(",");
        if (split.length < 1) {
            return 0;
        } else if (split.length == 1) {
            return baseMapper.deleteById(Long.valueOf(ids));
        } else {
            List<Long> list = new ArrayList<>();
            for (String id : split) {
                list.add(Long.valueOf(id));
            }
            return baseMapper.deleteBatchIds(list);
        }
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param sids
     * @return
     */
    public int delBySids(String[] sids) {
        if (sids == null || sids.length < 1) {
            return 0;
        } else if (sids.length == 1) {
            String sid = sids[0];
            return deleteBySid(sid);
        } else {
            List<String> list = new ArrayList<>();
            for (String sid : sids) {
                list.add(sid);
            }
            QueryWrapper<T> qw = new QueryWrapper<>();
            qw.in("sid", list);
            return baseMapper.delete(qw);
        }
    }

    public int updateById(Map<String, Object> map) {
        Long id = checkId(map);
        if (id.equals(0L)) {
            return 0;
        }
        return updateById(map, id);
    }

    public int updateById(Map<String, Object> map, Serializable id) {
        T t = fetchById(id);
        if (t == null) {
            return -1;
        }
        t = map2entity(map, t);

        if (t instanceof BaseEntity) {
            if (((BaseEntity) t).getLockVersion() != null) {
                ((BaseEntity) t).setLockVersion(((BaseEntity) t).getLockVersion() + 1);
            }
        }
        return baseMapper.updateById(t);
    }

    public int updateBySid(Map<String, Object> map) {
        String sid = checkSid(map);
        if (StringUtils.isBlank(sid)) {
            return 0;
        }
        return updateBySid(map, sid);
    }

    public int updateBySid(Dto dto, String sid) {
        T t = fetchBySid(sid);
        if (t == null) {
            return -1;
        }
        BeanUtil.copyProperties(dto, t);
        if (t instanceof BaseEntity) {
            if (((BaseEntity) t).getLockVersion() != null) {
                ((BaseEntity) t).setLockVersion(((BaseEntity) t).getLockVersion() + 1);
            }
        }
        return baseMapper.updateById(t);
    }

    public int updateBySid(Map<String, Object> map, String sid) {
        T t = fetchBySid(sid);
        if (t == null) {
            return -1;
        }
        t = map2entity(map, t);

        if (t instanceof BaseEntity) {
            if (((BaseEntity) t).getLockVersion() != null) {
                ((BaseEntity) t).setLockVersion(((BaseEntity) t).getLockVersion() + 1);
            }
        }
        return baseMapper.updateById(t);
    }

    public int insertOrUpdateById(Map<String, Object> map) {
        Long id = checkId(map);
        if (id.equals(0L)) {
            return insert(map);
        }
        return updateById(map, id);
    }

    public int insertOrUpdateBySid(Map<String, Object> map) {
        String sid = checkSid(map);
        if (StringUtils.isBlank(sid)) {
            return insert(map);
        }
        return updateBySid(map, sid);
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param id
     * @return
     */
    public T fetchById(Serializable id) {
        return baseMapper.selectById(id);
    }

    public T fetchBySid(String sid) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.eq("sid", sid);
        return baseMapper.selectOne(qw);
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param page
     * @param params
     * @return
     */
    public IPage<T> pagging(IPage<T> page, Map<String, Object> params) {
        QueryWrapper<T> qw = defaultPageQueryWrapper(params);
        return pagging(page, qw);
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param page
     * @param qw
     * @return
     */
    public IPage<T> pagging(IPage<T> page, QueryWrapper<T> qw) {
        IPage<T> selectPage = baseMapper.selectPage(page, qw);
        if (selectPage.getPages() < selectPage.getCurrent()) {
            page.setCurrent(selectPage.getPages());
            page.setTotal(selectPage.getTotal());
            selectPage = baseMapper.selectPage(page, qw);
        }
        return selectPage;
    }

    public IPage<Map<String, Object>> paggingMap(IPage<Map<String, Object>> page, Map<String, Object> params) {
        QueryWrapper<T> qw = defaultPageQueryWrapper(params);
        return paggingMap(page, qw);
    }


    public IPage<Map<String, Object>> paggingMap(IPage<Map<String, Object>> page, QueryWrapper<T> qw) {
        IPage<Map<String, Object>> selectMapsPage = baseMapper.selectMapsPage(page, qw);

        if (selectMapsPage.getPages() < selectMapsPage.getCurrent()) {
            page.setCurrent(selectMapsPage.getPages());
            page.setTotal(selectMapsPage.getTotal());
            selectMapsPage = baseMapper.selectMapsPage(page, qw);
        }

        return selectMapsPage;
    }

    /**
     * 描述 : <描述函数实现的功能>. <br/>
     * <p>
     *
     * @param params
     */
    private QueryWrapper<T> defaultPageQueryWrapper(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return Wrappers.emptyWrapper();
        }

        QueryWrapper<T> qw = new QueryWrapper<T>();
        for (String key : params.keySet()) {
            qw.like(key, params.get(key));
        }
        return qw;
    }

    public IPage<T> page(IPage<T> page, Map<String, Object> params) {
        QueryWrapper<T> qw = defaultPageQueryWrapper(params);
        return super.page(page, qw);
    }

    /**
     * 查询与某一字段值相等的数据列表
     *
     * @param filedName  字段名
     * @param filedValue 相等的值
     * @return
     */
    public List<T> listEqFiled(String filedName, String filedValue) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.eq(filedName, filedValue);
        return list(qw);
    }

    /**
     * 查询与某一字段值相等，但不等于id的数据列表
     *
     * @param filedName  字段名
     * @param filedValue 相等的值
     * @param id         id的值
     * @return
     */
    public List<T> listEqFiledNeId(String filedName, String filedValue, Serializable id) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.eq(filedName, filedValue);
        qw.ne("id", id);
        return list(qw);
    }

    /**
     * 查询与某一字段值相等，但与另一字段的值不相等的数据列表
     *
     * @param filedName  相等的字段名
     * @param filedValue 相等的值
     * @param neName     不相等的字段名
     * @param neValue    不相等的值
     * @return
     */
    public List<T> listEqFiledWithNe(String filedName, String filedValue, String neName, String neValue) {
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.eq(filedName, filedValue);
        qw.ne(neName, neValue);
        return list(qw);
    }
}
