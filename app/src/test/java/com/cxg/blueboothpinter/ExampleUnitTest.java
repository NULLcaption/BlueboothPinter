package com.cxg.blueboothpinter;

import com.cxg.blueboothpinter.com.pojo.Ztwm004;
import com.cxg.blueboothpinter.com.utils.WebServiceUtils;

import org.junit.Test;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static String OPENAPIURL = "http://192.168.0.16:8000";
    private static final String GET_PERFORMANCE_URL = "/sap/bc/srt/wsdl/srvc_58F9EDF150950D90E1008000C0A80010/wsdl11/allinone/ws_policy/document?sap-client=700&sap-user=rfc&sap-password=poiuyt";
    //命名空间
    public static String NAMESPACE= "/urn:sap-com:document:sap:soap:functions:mc-style";
    //请求方法名
    public static String METHOD_NAME = "/ZwmRfcIts003";

    @Test
    public void init2(){
        Map<String,String> map = WebServiceUtils.callWebServiceFor004(WebServiceUtils.URL_004, WebServiceUtils.METHOD_NAME_004);
        System.out.println(map);
    }

    @Test
    public void init1(){
        HashMap<String,String> properties = new HashMap<>();
        properties.put("IZipcode","7100010021");
        List<Object> list = WebServiceUtils.callWebService1(WebServiceUtils.URL, WebServiceUtils.METHOD_NAME, properties);
        Ztwm004 ztwm004 = new Ztwm004();
        ztwm004.setEMaktx(list.get(0).toString());
        ztwm004.setEName1(list.get(1).toString());
        ztwm004.setEName2(list.get(2).toString());
        ztwm004.setMandt(list.get(3).toString());
        ztwm004.setZipcode(list.get(4).toString());
        ztwm004.setCharg(list.get(5).toString());
        ztwm004.setZcupno(list.get(6).toString());
        ztwm004.setWerks(list.get(7).toString());
        ztwm004.setZkurno(list.get(8).toString());
        ztwm004.setZbc(list.get(9).toString());
        ztwm004.setZlinecode(list.get(10).toString());
        ztwm004.setMatnr(list.get(11).toString());
        ztwm004.setZproddate(list.get(12).toString());
        ztwm004.setZinstock(list.get(13).toString());
        ztwm004.setZoutstock(list.get(14).toString());
        ztwm004.setMblnr(list.get(15).toString());
        ztwm004.setMjahr(list.get(16).toString());
        ztwm004.setMenge(list.get(17).toString());
        ztwm004.setMeins(list.get(18).toString());
        ztwm004.setTanum(list.get(19).toString());
        ztwm004.setZptflg(list.get(20).toString());
        ztwm004.setZgrdate(list.get(21).toString());
        ztwm004.setZlichn(list.get(22).toString());
        ztwm004.setLifnr(list.get(23).toString());
        ztwm004.setZnum(list.get(24).toString());
        ztwm004.setZqcnum(list.get(25).toString());

        List<Ztwm004> ztwm004List = new ArrayList<>();
        ztwm004List.add(ztwm004);

        for (Ztwm004 aa: ztwm004List) {
            System.out.println(aa.getZqcnum());
        }

    }

    @Test
    public void init (){
        HashMap<String,String> properties = new HashMap<>();
        properties.put("IZipcode","7100010021");
        WebServiceUtils.callWebService(WebServiceUtils.URL, WebServiceUtils.METHOD_NAME, properties,
                new WebServiceUtils.WebServiceCallBack() {
            @Override
            public void callBack(SoapObject result) {
                //关闭进度条
                if(result != null){
                    List<Object> object1 = parseSoapObject(result);
                    System.out.println(object1.get(0));
                }else{
                    System.out.println("获取WebService数据错误");
                }
            }
        });
    }

    /**
     * 解析SoapObject对象
     * @param result
     * @return
     */
    private List<Object> parseSoapObject(SoapObject result){
        List<Object> list = new ArrayList<>();

        String EMaktx = result.getProperty("EMaktx").toString();
        String EMessage = result.getProperty("EMessage").toString();
        String EName1=result.getProperty("EName1").toString();
        String EName2=result.getProperty("EName2").toString();
        String EType=result.getProperty("EType").toString();

        list.add(EMaktx);
        list.add(EName1);
        list.add(EName2);

        SoapObject provinceSoapObject = (SoapObject) result.getProperty("EsZtwm004");
        if(provinceSoapObject == null) {
            return null;
        }
//        for(int i=0; i<provinceSoapObject.getPropertyCount(); i++){
//            list.add(provinceSoapObject.getPropety(i).toString());
//        }
        return list;
    }

    @Test
    public void test(){
        String string = "anyType{}";

    }
}