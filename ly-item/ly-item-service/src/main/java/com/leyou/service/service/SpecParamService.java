package com.leyou.service.service;

import com.leyou.item.pojo.SpecParam;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/18
 */
public interface SpecParamService {

    List<SpecParam> querySpecParams(Long gid, Long cid, Boolean searching, Boolean generic);

    void saveSpecParam(SpecParam specParam);

    void updateSpecParam(SpecParam specParam);

    void deleteSpecParam(Long id);
}
