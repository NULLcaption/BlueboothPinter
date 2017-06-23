package com.cxg.blueboothpinter.com.provider;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.cxg.blueboothpinter.com.pojo.Ztwm004;
import com.cxg.blueboothpinter.com.utils.Helpers;
import com.cxg.blueboothpinter.com.utils.WebServiceUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * webService公用类
 * Created by Administrator on 2017/5/5.
 */

public class WebService implements IDataProvider {

    private static WebService instance;

    private static final int TIME_OUT = 30000;

    private static final String TAG = "WebService";

    private WebService() {
        super();
    }

    public static IDataProvider getInstance() {
        if (instance == null) instance = new WebService();
        return instance;
    }


    @Override
    public void startDateUpdateTasks(Activity activity) {
        Context ctx = DataProviderFactory.getContext();
        if (ctx != null) {
            SharedPreferences sp = ctx.getSharedPreferences("XPPWebService", Context.MODE_PRIVATE);

            if (sp.contains("lastUpdate")) {
                Date now = new Date();
                String str1 = sp.getString("lastUpdate", "");
                String str2 = Helpers.getDateStrWithoutTime(now);
                if (str1.startsWith(str2)) {
                    Log.d(TAG, "No updates needed at this time.");
                    return;
                }
            }
            if (UpdateTask.getInstance().getStatus() != AsyncTask.Status.RUNNING) {
                sp.edit().putInt("lastUpdatedShopSequence", -1).commit();
                new UpdateTask(activity, false).execute();
            }
        }
    }

    @Override
    public List<Ztwm004> searchZtwm004(String string) {
        //处理后的类型具体的返回值
        List<Ztwm004> ztwm004List = new ArrayList<>();
        //请求参数
        HashMap<String,String> properties = new HashMap<>();
        properties.put("IZipcode",string);
        //请求后返回值，由于类型未知，均设置为Object
        List<Object> list = WebServiceUtils.callWebService1(WebServiceUtils.URL, WebServiceUtils.METHOD_NAME, properties);
        try {
            if (list.size() != 0){
                String anyType = "anyType{}";
                Ztwm004 ztwm004 = new Ztwm004();
                //物料名称
                if (!anyType.equals(list.get(0).toString())){
                    ztwm004.setEMaktx(list.get(0).toString());
                } else {
                    ztwm004.setEMaktx("");
                }
                if (!anyType.equals(list.get(1).toString())){
                    ztwm004.setEName1(list.get(1).toString());
                } else {
                    ztwm004.setEName1("");
                }
                if (!anyType.equals(list.get(2).toString())){
                    ztwm004.setEName2(list.get(2).toString());
                } else {
                    ztwm004.setEName2("");
                }
                if (!anyType.equals(list.get(3).toString())){
                    ztwm004.setMandt(list.get(3).toString());
                } else {
                    ztwm004.setMandt("");
                }
                if (!anyType.equals(list.get(4).toString())){
                    ztwm004.setZipcode(list.get(4).toString());
                } else {
                    ztwm004.setZipcode("");
                }
                if (!anyType.equals(list.get(5).toString())) {
                    ztwm004.setCharg(list.get(5).toString());
                } else {
                    ztwm004.setCharg("");
                }
                if (!anyType.equals(list.get(6).toString())) {
                    ztwm004.setZcupno(list.get(6).toString());
                } else {
                    ztwm004.setZcupno("");
                }
                if (!anyType.equals(list.get(7).toString())) {
                    if ("1000".equals(list.get(7).toString())){
                        ztwm004.setWerks("湖州工厂");
                    } else if ("2000".equals(list.get(7).toString())){
                        ztwm004.setWerks("天津工厂");
                    } else if ("3000".equals(list.get(7).toString())) {
                        ztwm004.setWerks("成都工厂");
                    }
                } else {
                    ztwm004.setWerks("");
                }
                if (!anyType.equals(list.get(8).toString())) {
                    ztwm004.setZkurno(list.get(8).toString());
                } else {
                    ztwm004.setZkurno("");
                }
                if (!anyType.equals(list.get(9).toString())) {
                    ztwm004.setZbc(list.get(9).toString());
                } else {
                    ztwm004.setZbc("");
                }
                if (!anyType.equals(list.get(10).toString())) {
                    ztwm004.setZlinecode(list.get(10).toString());
                } else {
                    ztwm004.setZlinecode("");
                }
                if (!anyType.equals(list.get(11).toString())) {
                    ztwm004.setMatnr(list.get(11).toString());
                } else {
                    ztwm004.setMatnr("");
                }
                if (!anyType.equals(list.get(12).toString())) {
                    ztwm004.setZproddate(list.get(12).toString());
                } else {
                    ztwm004.setZproddate("");
                }
                if (!anyType.equals(list.get(13).toString())) {
                    ztwm004.setZinstock(list.get(13).toString());
                } else {
                    ztwm004.setZinstock("");
                }
                if (!anyType.equals(list.get(14).toString())) {
                    ztwm004.setZoutstock(list.get(14).toString());
                } else {
                    ztwm004.setZoutstock("");
                }
                if (!anyType.equals(list.get(15).toString())) {
                    ztwm004.setMblnr(list.get(15).toString());
                } else {
                    ztwm004.setMblnr("");
                }
                if (!anyType.equals(list.get(16).toString())) {
                    ztwm004.setMjahr(list.get(16).toString());
                } else {
                    ztwm004.setMjahr("");
                }
                if (!anyType.equals(list.get(17).toString())) {
                    ztwm004.setMenge(list.get(17).toString());
                } else {
                    ztwm004.setMenge("");
                }
                if (!anyType.equals(list.get(18).toString())) {
                    ztwm004.setMeins(list.get(18).toString());
                } else {
                    ztwm004.setMeins("");
                }
                if (!anyType.equals(list.get(19).toString())) {
                    ztwm004.setTanum(list.get(19).toString());
                } else {
                    ztwm004.setTanum("");
                }
                if (!anyType.equals(list.get(20).toString())) {
                    ztwm004.setZptflg(list.get(20).toString());
                } else {
                    ztwm004.setZptflg("");
                }
                if (!anyType.equals(list.get(21).toString())) {
                    ztwm004.setZgrdate(list.get(21).toString());
                } else {
                    ztwm004.setZgrdate("");
                }
                if (!anyType.equals(list.get(22).toString())) {
                    ztwm004.setZlichn(list.get(22).toString());
                } else {
                    ztwm004.setZlichn("");
                }
                if (!anyType.equals(list.get(23).toString())) {
                    ztwm004.setLifnr(list.get(23).toString());
                } else {
                    ztwm004.setLifnr("");
                }
                if (!anyType.equals(list.get(24).toString())) {
                    ztwm004.setZnum(list.get(24).toString());
                } else {
                    ztwm004.setZnum("");
                }
                if (!anyType.equals(list.get(25).toString())) {
                    ztwm004.setZqcnum(list.get(25).toString());
                } else {
                    ztwm004.setZqcnum("");
                }
                ztwm004List.add(ztwm004);
            }
            return ztwm004List;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ztwm004List;
    }

    @Override
    public Map<String, String> getMeins() {
        Map<String,String> map = new HashMap<>();
        try {
            map = WebServiceUtils.callWebServiceFor004(WebServiceUtils.URL_004, WebServiceUtils.METHOD_NAME_004);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
