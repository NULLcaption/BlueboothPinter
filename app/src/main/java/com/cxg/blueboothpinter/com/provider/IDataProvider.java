package com.cxg.blueboothpinter.com.provider;

import android.app.Activity;

import com.cxg.blueboothpinter.com.pojo.Ztwm004;

import java.util.List;
import java.util.Map;

/**
 * service interface
 * Created by Administrator on 2017/5/5.
 */

public interface IDataProvider {
    /**
     * init data
     * @param activity ui
     */
    void startDateUpdateTasks(Activity activity);
    /**
     * 更具托盘编码搜索Ztwm004
     * @param string 代入的参数值
     * @return list
     */
    List<Ztwm004> searchZtwm004(String string);

    /**
     * 进入时加载单位
     * @return map
     */
    Map<String,String> getMeins();
}
