package com.vip.file.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.vip.file.constant.DBConstant;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自动填充字段设置
 *
 * @author wgb
 * @date 2020/3/28 10:26
 */
@Component
public class MyBatisPlusMetaHandler implements MetaObjectHandler {

    /**
     * 新增数据执行
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasGetter(DBConstant.CREATED_TIME)){
            this.setFieldValByName("createdTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("modifiedTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("deleteStatus", false, metaObject);
        }
    }

    /**
     * 更新数据执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if(metaObject.hasGetter(DBConstant.MODIFIED_TIME)) {
            this.setFieldValByName("modifiedTime", LocalDateTime.now(), metaObject);
        }
    }

}
