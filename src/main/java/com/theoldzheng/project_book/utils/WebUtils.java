package com.theoldzheng.project_book.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.3.20 12:13
 */
public class WebUtils {
    //实现对参数注入部分的抽取优化练习
    public static <T> T copyParamToBean(Map value, T bean) {

        try {
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
