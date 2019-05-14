package com.sprint.crm.mapper;

import com.sprint.crm.pojo.Modules;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModulesMapper {


 

   

    int insertSelective(Modules record);

  

    Modules selectByPrimaryKey(Integer moduleId);

 

    int updateByPrimaryKeySelective(Modules record);
    
    List<Modules> getModuleById(Integer userId);

    List<Modules> getModuleByChild(List<Integer> pids);

    List<Modules> getAllModule();

    List<String> selectNameFromParent(Integer parentId);

    List<Modules> getModuleByChildId(Integer moduleId);
     /**
      * 添加模块
      * @param parentId
      * @param name
      * @param path
      * @param weight
      * @return
      */
    int insertModule(Integer parentId,String name,String path,Integer weight);
    /**
     * 更新模块
     * @param moduleId
     * @param name
     * @param path
     * @param weight
     * @return
     */
    int updateModule(Integer moduleId,String name,String path,Integer weight);
    /**
     * 删除模块
     * @param id
     * @return
     */
    int delModule(Integer moduleId);


}