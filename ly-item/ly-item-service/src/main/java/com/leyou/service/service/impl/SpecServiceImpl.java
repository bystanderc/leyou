package com.leyou.service.service.impl;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.service.mapper.SpecGroupMapper;
import com.leyou.service.mapper.SpecParamMapper;
import com.leyou.service.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bystander
 * @date 2018/9/18
 */
@Service
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;


    @Override
    public List<SpecGroup> querySpecGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> specGroupList = specGroupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(specGroupList)) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_NOT_FOUND);
        }
        return specGroupList;
    }

    @Override
    public void saveSpecGroup(SpecGroup specGroup) {
        int count = specGroupMapper.insert(specGroup);
        if (count != 1) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_CREATE_FAILED);
        }
    }

    @Override
    public void deleteSpecGroup(Long id) {
        if (id == null) {
            throw new LyException(ExceptionEnum.INVALID_PARAM);
        }
        SpecGroup specGroup = new SpecGroup();
        specGroup.setId(id);
        int count = specGroupMapper.deleteByPrimaryKey(specGroup);
        if (count != 1) {
            throw new LyException(ExceptionEnum.DELETE_SPEC_GROUP_FAILED);
        }
    }

    @Override
    public void updateSpecGroup(SpecGroup specGroup) {
        int count = specGroupMapper.updateByPrimaryKey(specGroup);
        if (count != 1) {
            throw new LyException(ExceptionEnum.UPDATE_SPEC_GROUP_FAILED);
        }
    }


    @Override
    public List<SpecParam> querySpecParams(Long gid, Long cid, Boolean searching, Boolean generic) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setSearching(searching);
        specParam.setGeneric(generic);
        List<SpecParam> specParamList = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(specParamList)) {
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOUND);
        }
        return specParamList;
    }

    @Override
    public void saveSpecParam(SpecParam specParam) {
        int count = specParamMapper.insert(specParam);
        if (count != 1) {
            throw new LyException(ExceptionEnum.SPEC_PARAM_CREATE_FAILED);
        }
    }

    @Override
    public void updateSpecParam(SpecParam specParam) {
        int count = specParamMapper.updateByPrimaryKeySelective(specParam);
        if (count != 1) {
            throw new LyException(ExceptionEnum.UPDATE_SPEC_PARAM_FAILED);
        }
    }

    @Override
    public void deleteSpecParam(Long id) {
        if (id == null) {
            throw new LyException(ExceptionEnum.INVALID_PARAM);
        }
        int count = specParamMapper.deleteByPrimaryKey(id);
        if (count != 1) {
            throw new LyException(ExceptionEnum.DELETE_SPEC_PARAM_FAILED);
        }
    }

    @Override
    public List<SpecGroup> querySpecsByCid(Long cid) {
        List<SpecGroup> specGroups = querySpecGroupByCid(cid);

        List<SpecParam> specParams = querySpecParams(null, cid, null, null);

        Map<Long, List<SpecParam>> map = new HashMap<>();
        //遍历specParams
        for (SpecParam param : specParams) {
            Long groupId = param.getGroupId();
            if (!map.keySet().contains(param.getGroupId())) {
                //map中key不包含这个组ID
                map.put(param.getGroupId(), new ArrayList<>());
            }
            //添加进map中
            map.get(param.getGroupId()).add(param);
        }

        for (SpecGroup specGroup : specGroups) {
            specGroup.setParams(map.get(specGroup.getId()));
        }

        return specGroups;
    }
}


