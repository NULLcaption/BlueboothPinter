package com.cxg.blueboothpinter.com.utils;

import android.os.Handler;
import android.os.Message;

import com.cxg.blueboothpinter.com.pojo.Zswm003;

import org.apache.http.client.HttpResponseException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * webservice服务工具类
 * Created by Administrator on 2017/6/16.
 */

public class WebServiceUtils {

    //命名空间
    public static String NAMESPACE = "urn:sap-com:document:sap:soap:functions:mc-style";
    //请求方法名
    public static String METHOD_NAME = "ZwmRfcIts003";
    public static String METHOD_NAME_004 = "ZwmRfcIts004";
    //请求路径
    public static String SOAP_ACTION = "urn:sap-com:document:sap:soap:functions:mc-style/ZwmRfcIts003";
    //请求的webservice路径
    public static final String URL = "http://192.168.0.12:8000/sap/bc/srt/rfc/sap/zwmits3/800/zwmits3/binding?sap-client=800&sap-user=ABAPRFC&sap-password=xpp2@12";
    public static final String URL_004 = "http://192.168.0.12:8000/sap/bc/srt/rfc/sap/zwmits4/800/zwmits4/binding?sap-client=800&sap-user=ABAPRFC&sap-password=xpp2@12";
    // 含有3个线程的线程池
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    /**
     * 请求ZwmRfcIts004接口获取单位列表
     *
     * @param url        请求URL
     * @param methodName 请求的参数名
     * @return map
     */
    public static Map<String, String> callWebServiceFor004(String url, final String methodName) {
        //返回的结果集
        Map<String, String> map = new HashMap<>();
        // set up
        SoapObject request = new SoapObject(NAMESPACE, methodName);
        // SoapObject添加参数
        Zswm003 zswm003 = new Zswm003();
        request.addProperty("EtZswm003", zswm003);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10); // put all required data into a soap
        envelope.dotNet = false;
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(url);
        httpTransport.debug = true;
        try {
            httpTransport.call(SOAP_ACTION, envelope);
            if (envelope.bodyIn instanceof SoapObject) { // SoapObject = SUCCESS
                SoapObject soapObject = (SoapObject) envelope.bodyIn;
                //解析后的返回list
                map = parseSoapObject004(soapObject);
                return map;
            } else if (envelope.bodyIn instanceof SoapFault) {
                SoapFault soapFault = (SoapFault) envelope.bodyIn;
                try {
                    throw new Exception(soapFault.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Soap Object解析返回值
     *
     * @param result 获取到的值
     * @return map
     */
    public static Map<String, String> parseSoapObject004(SoapObject result) {
        Map<String, String> map = new HashMap<>();
        SoapObject provinceSoapObject1 = (SoapObject) result.getProperty("EtZswm003");
        if (provinceSoapObject1 == null) {
            return null;
        }
        for (int i = 0; i < provinceSoapObject1.getPropertyCount(); i++) {
            SoapObject soapObject = (SoapObject) provinceSoapObject1.getProperty(i);
            String Msehi = soapObject.getProperty("Msehi").toString();
            String Mseh3 = soapObject.getProperty("Mseh3").toString();
            map.put(Msehi, Mseh3);

        }
        return map;
    }


    /**
     * 请求ZwmRfcIts003接口获取单位列表
     *
     * @param url        WebService服务器地址
     * @param methodName WebService的调用方法名
     * @param properties WebService的参数
     */
    public static List<Object> callWebService1(String url, final String methodName, HashMap<String, String> properties) {
        //返回的结果集
        List<Object> resultList = new ArrayList<>();
        // set up
        SoapObject request = new SoapObject(NAMESPACE, methodName);
        // SoapObject添加参数
        if (properties != null) {
            for (Iterator<Map.Entry<String, String>> it = properties.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, String> entry = it.next();
                request.addProperty(entry.getKey(), entry.getValue());
            }
        }

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10); // put all required data into a soap
        envelope.dotNet = false;
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(url);
        httpTransport.debug = true;
        try {
            httpTransport.call(SOAP_ACTION, envelope);
            if (envelope.bodyIn instanceof SoapObject) { // SoapObject = SUCCESS
                SoapObject soapObject = (SoapObject) envelope.bodyIn;
                //解析后的返回list
                resultList = parseSoapObject(soapObject);
                return resultList;
            } else if (envelope.bodyIn instanceof SoapFault) {
                SoapFault soapFault = (SoapFault) envelope.bodyIn;
                try {
                    throw new Exception(soapFault.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Soap Object解析返回值
     *
     * @param result 获取到值
     * @return list
     */
    public static List<Object> parseSoapObject(SoapObject result) {
        List<Object> list = new ArrayList<>();

        String EMaktx = result.getProperty("EMaktx").toString();
        String EMessage = result.getProperty("EMessage").toString();
        String EName1 = result.getProperty("EName1").toString();
        String EName2 = result.getProperty("EName2").toString();
        String EType = result.getProperty("EType").toString();

        list.add(EMaktx);
        list.add(EName1);
        list.add(EName2);

        SoapObject provinceSoapObject = (SoapObject) result.getProperty("EsZtwm004");
        if (provinceSoapObject == null) {
            return null;
        }
        for (int i = 0; i < provinceSoapObject.getPropertyCount(); i++) {
            list.add(provinceSoapObject.getProperty(i).toString());
        }
        return list;
    }

    /**
     * 请求ZwmRfcIts003接口获取单位列表
     * 使用多线程访问机制
     *
     * @param url                WebService服务器地址
     * @param methodName         WebService的调用方法名
     * @param properties         WebService的参数
     * @param webServiceCallBack 回调接口
     */
    public static void callWebService(String url, final String methodName, HashMap<String, String> properties, final WebServiceCallBack webServiceCallBack) {
        // 创建HttpTransportSE对象，传递WebService服务器地址
        final HttpTransportSE httpTransportSE = new HttpTransportSE(url);
        // 创建SoapObject对象
        SoapObject soapObject = new SoapObject(NAMESPACE, methodName);

        // SoapObject添加参数
        if (properties != null) {
            for (Iterator<Map.Entry<String, String>> it = properties.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, String> entry = it.next();
                soapObject.addProperty(entry.getKey(), entry.getValue());
            }
        }

        // 实例化SoapSerializationEnvelope，传入WebService的SOAP协议的版本号
        final SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        // 设置是否调用的是.Net开发的WebService
        soapEnvelope.setOutputSoapObject(soapObject);
        soapEnvelope.dotNet = true;
        httpTransportSE.debug = true;

        // 用于子线程与主线程通信的Handler
        final Handler mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // 将返回值回调到callBack的参数中
                webServiceCallBack.callBack((SoapObject) msg.obj);
            }

        };

        // 开启线程去访问WebService
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                SoapObject resultSoapObject = null;
                try {
                    httpTransportSE.call(SOAP_ACTION, soapEnvelope);
                    if (soapEnvelope.getResponse() != null) {
                        // 获取服务器响应返回的SoapObject
                        resultSoapObject = (SoapObject) soapEnvelope.bodyIn;
                    }
                } catch (HttpResponseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } finally {
                    // 将获取的消息利用Handler发送到主线程
                    mHandler.sendMessage(mHandler.obtainMessage(0, resultSoapObject));
                }
            }
        });
    }

    /**
     * 回调接口
     */
    public interface WebServiceCallBack {
        void callBack(SoapObject result);
    }

}
