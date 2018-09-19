package com.leyou.service.service;

import com.leyou.item.pojo.SpecGroup;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/18
 */
public interface SpecGroupService {

    List<SpecGroup> querySpecGroupByCid(Long cid);

    void saveSpecGroup(SpecGroup specGroup);

    void deleteSpecGroup(Long id);

    void updateSpecGroup(SpecGroup specGroup);
}
