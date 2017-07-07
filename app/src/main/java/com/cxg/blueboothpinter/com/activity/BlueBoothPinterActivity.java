package com.cxg.blueboothpinter.com.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxg.blueboothpinter.R;
import com.cxg.blueboothpinter.com.adapter.BlueBoothPinterAdapter;
import com.cxg.blueboothpinter.com.pojo.Ztwm004;
import com.cxg.blueboothpinter.com.provider.DataProviderFactory;
import com.cxg.blueboothpinter.com.utils.ExitApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 蓝牙打印托盘数据之首页
 */
public class BlueBoothPinterActivity extends AppCompatActivity {

    private EditText IZipcode;
    private Button btnpost, printer, exit;
    private TextView Zcupno, Werks, Zkurno, Zbc, Matnr, Zproddate, Menge, Meins, Zgrdate, Zlichn, Lifnr, Znum, Zqcnum, EMaktx, EName1, EName2, Zlinecode, Charg;
    private List<Ztwm004> ztwm004list;
    private Dialog waitingDialog;
    private BlueBoothPinterAdapter blueBoothPinterAdapter;
    private Map<String, String> map = new HashMap<>();
    private Ztwm004 ztwm004;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_booth_pinter);
        //视图
        initView();
        //数据
        initData();

        ExitApplication.getInstance().addActivity(this);
    }

    /**
     * init view
     */
    public void initView() {
        Zcupno = (TextView) findViewById(R.id.Zcupno);
        Werks = (TextView) findViewById(R.id.werks);
        Zkurno = (TextView) findViewById(R.id.Zkurno);
        Zbc = (TextView) findViewById(R.id.Zbc);
        Zlinecode = (TextView) findViewById(R.id.Zlinecode);
        IZipcode = (EditText) findViewById(R.id.IZipcode);
        Matnr = (TextView) findViewById(R.id.matnr);
        Zproddate = (TextView) findViewById(R.id.Zproddate);
        Charg = (TextView) findViewById(R.id.Charg);
        Menge = (TextView) findViewById(R.id.Menge);
        Meins = (TextView) findViewById(R.id.Meins);
        Zgrdate = (TextView) findViewById(R.id.Zgrdate);
        Zlichn = (TextView) findViewById(R.id.Zlichn);
        Lifnr = (TextView) findViewById(R.id.Lifnr);
        Znum = (TextView) findViewById(R.id.Znum);
        Zqcnum = (TextView) findViewById(R.id.Zqcnum);
        EMaktx = (TextView) findViewById(R.id.EMaktx);
        EName1 = (TextView) findViewById(R.id.EName1);
        EName2 = (TextView) findViewById(R.id.EName2);

        findViewById(R.id.btnpost).setOnClickListener(BtnClicked);
        findViewById(R.id.printer).setOnClickListener(BtnClicked);
        findViewById(R.id.exit).setOnClickListener(BtnClicked);
    }

    /**
     * init data
     */
    public void initData() {
        Bundle bun = getIntent().getExtras();
        //页面UI更新
        ztwm004list = new ArrayList<>();
        if (bun != null) {
            ztwm004 = (Ztwm004) bun.get("ztwm004");
        } else if (ztwm004list.size() != 0) {
            for (Ztwm004 ztwm004 : ztwm004list) {
                Zcupno.setText(ztwm004.getZcupno());
                Werks.setText(ztwm004.getWerks());
                Zkurno.setText(ztwm004.getZkurno());
                Zbc.setText(ztwm004.getZbc());
                Zlinecode.setText(ztwm004.getZlinecode());
                IZipcode.setText(ztwm004.getZlinecode());
                Matnr.setText(ztwm004.getMatnr());
                Zproddate.setText(ztwm004.getZproddate());
                Charg.setText(ztwm004.getCharg());
                Menge.setText(ztwm004.getMenge());
                Meins.setText(ztwm004.getMeins());
                Zgrdate.setText(ztwm004.getZgrdate());
                Zlichn.setText(ztwm004.getZlichn());
                Lifnr.setText(ztwm004.getLifnr());
                Znum.setText(ztwm004.getZnum());
                Zqcnum.setText(ztwm004.getZqcnum());
                EMaktx.setText(ztwm004.getEMaktx());
                EName1.setText(ztwm004.getEName1());
                EName2.setText(ztwm004.getEName2());
            }
        } else {
            Zcupno.setText(null);
            Werks.setText(null);
            Zkurno.setText(null);
            Zbc.setText(null);
            Zlinecode.setText(null);
            IZipcode.setText(null);
            Matnr.setText(null);
            Zproddate.setText(null);
            Charg.setText(null);
            Menge.setText(null);
            Meins.setText(null);
            Zgrdate.setText(null);
            Zlichn.setText(null);
            Lifnr.setText(null);
            Znum.setText(null);
            Zqcnum.setText(null);
            EMaktx.setText(null);
            EName1.setText(null);
            EName2.setText(null);
        }
        //加载数据获取单位
        new getMeinsTask().execute();
    }

    /**
     * 按钮点击事件监听类
     */
    private OnClickListener BtnClicked = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnpost:
                    if (!"".equals(IZipcode.getText().toString().trim())) {
                        // 正则判断下是否输入值为数字
                        Pattern p2 = Pattern.compile("\\d");
                        String IZipcode1 = IZipcode.getText().toString().trim();
                        Matcher matcher = p2.matcher(IZipcode1);
                        if (matcher.matches()) {
                            Toast.makeText(getApplicationContext(), "请填写准确的托盘编码...", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        new searchZtwm004Task().execute(IZipcode.getText().toString().trim());
                    } else {
                        Toast.makeText(getApplicationContext(), "请输入托盘编码,然后查询即可!", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.printer:
                    if ("".equals(IZipcode.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "无打印数据，请重新操作！", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //新建一个显式意图，第一个参数为当前Activity类对象，第二个参数为你要打开的Activity类
                    Intent intent = new Intent(BlueBoothPinterActivity.this, BoothActivity.class);

                    //用Bundle携带数据
                    Bundle ztwm004 = new Bundle();

                    //托盘编码
                    ztwm004.putString("IZipcode", IZipcode.getText().toString().trim());
                    //ERP编号
                    ztwm004.putString("Charg", Charg.getText().toString().trim());
                    //批量编号
                    ztwm004.putString("Zcupno", Zcupno.getText().toString().trim());
                    ztwm004.putString("Zproddate", Zproddate.getText().toString().trim());
                    ztwm004.putString("Werks", Werks.getText().toString().trim());
                    //客户编码
                    ztwm004.putString("Zkurno", Zkurno.getText().toString().trim());
                    System.out.println("========>Zkurno"+Zkurno.getText().toString().trim());
                    ztwm004.putString("Zbc", Zbc.getText().toString().trim());
                    ztwm004.putString("Zlinecode", Zlinecode.getText().toString().trim());
                    ztwm004.putString("Matnr", Matnr.getText().toString().trim());
                    //数量
                    ztwm004.putString("Menge", Menge.getText().toString().trim());
                    //单位转换成汉字
                    String mseh3 = map.get(Meins.getText().toString().trim());
                    ztwm004.putString("Meins", mseh3);
                    //入库日期
                    ztwm004.putString("Zgrdate", Zgrdate.getText().toString().trim());
                    ztwm004.putString("Zlichn", Zlichn.getText().toString().trim());
                    //经销商编码
                    ztwm004.putString("Lifnr", Lifnr.getText().toString().trim());
                    ztwm004.putString("Znum", Znum.getText().toString().trim());
                    ztwm004.putString("Zqcnum", Zqcnum.getText().toString().trim());
                    //物料名称
                    ztwm004.putString("EMaktx", EMaktx.getText().toString().trim());
                    //经销商名称
                    ztwm004.putString("EName1", EName1.getText().toString().trim());
                    //客户名称
                    ztwm004.putString("EName2", EName2.getText().toString().trim());
                    intent.putExtras(ztwm004);
                    //进入到下一个Activity
                    startActivity(intent);
                    //Activity过场动画
                    overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    break;
                case R.id.exit:
                    ExitApplication.getInstance().exit();
                    Toast.makeText(getApplicationContext(), "退出应用", Toast.LENGTH_SHORT).show();
                    break;
                default :
                    break;
            }

        }
    };


    /**
     * 进入时加载单位
     */
    private class getMeinsTask extends AsyncTask<String, Integer, Map<String, String>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showWaitingDialog();
        }

        @Override
        protected Map<String, String> doInBackground(String... params) {
            return DataProviderFactory.getProvider().getMeins();
        }

        @Override
        protected void onPostExecute(Map<String, String> result) {
            dismissWaitingDialog();
            if (result.size() != 0) {
                map = result;
            } else {
                Toast.makeText(getApplicationContext(), "连接超时...退出稍后重试...", Toast.LENGTH_SHORT).show();
            }
        }
    }


    /**
     * 异步加载数据,根据托盘编码获取数据
     */
    private class searchZtwm004Task extends AsyncTask<String, Integer, List<Ztwm004>> {

        //onPreExecute()在execute(Params... params)被调用后立即执行，一般用来在执行后台任务前对UI做一些标记。
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showWaitingDialog();
        }

        //doInBackground(Object... arg0)在onPreExecute()完成后立即执行，用于执行较为费时的操作，此方法将接
        //收输入参数和返回计算结果。这里不能出现任何相关的组件。
        @Override
        protected List<Ztwm004> doInBackground(String... params) {
            String string = params[0];
            return DataProviderFactory.getProvider().searchZtwm004(string);
        }

        //当后台操作结束时，此方法将会被调用，计算结果将做为参数传递到此方法中，直接将结果显示到UI组件上。
        //注意：这个方法中的参数必须和AsyncTask中的最后一个参数相同，不然该方法不执行。
        @Override
        protected void onPostExecute(List<Ztwm004> result) {
            dismissWaitingDialog();
            if (result.size() != 0) {
                Zcupno.setText(result.get(0).getZcupno());
                Werks.setText(result.get(0).getWerks());
                Zkurno.setText(result.get(0).getZkurno());
                Zbc.setText(result.get(0).getZbc());
                Zlinecode.setText(result.get(0).getZlinecode());
                Charg.setText(result.get(0).getCharg());
                IZipcode.setText(result.get(0).getZipcode());
                Matnr.setText(result.get(0).getMatnr());
                Zproddate.setText(result.get(0).getZproddate());
                Menge.setText(result.get(0).getMenge());
                Meins.setText(result.get(0).getMeins());
                Zgrdate.setText(result.get(0).getZgrdate());
                Zlichn.setText(result.get(0).getZlichn());
                Lifnr.setText(result.get(0).getLifnr());
                Znum.setText(result.get(0).getZnum());
                Zqcnum.setText(result.get(0).getZqcnum());
                EMaktx.setText(result.get(0).getEMaktx());
                EName1.setText(result.get(0).getEName1());
                EName2.setText(result.get(0).getEName2());
            } else {
                Toast.makeText(getApplicationContext(), "连接超时...退出稍后重试...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected class ViewHodlerDivision {
        TextView diviName = null;
    }

    protected void resetViewHolderDivision(ViewHodlerDivision pViewHolder) {
        pViewHolder.diviName.setText(null);
    }

    /**
     * 加载图片开始
     */
    private void showWaitingDialog() {
        if (waitingDialog == null) {

            waitingDialog = new Dialog(this, R.style.TransparentDialog);
            waitingDialog.setContentView(R.layout.login_waiting_dialog);
            DialogInterface.OnShowListener showListener = new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialog) {
                    ImageView img = (ImageView) waitingDialog.findViewById(R.id.loading);
                    ((AnimationDrawable) img.getDrawable()).start();
                }
            };
            DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    // updateButtonLook(false);
                }
            };
            waitingDialog.setOnShowListener(showListener);
            waitingDialog.setCanceledOnTouchOutside(false);
            waitingDialog.setOnCancelListener(cancelListener);
            waitingDialog.show();
        }
    }

    /**
     * 加载结束
     */
    private void dismissWaitingDialog() {
        if (waitingDialog != null) {
            ImageView img = (ImageView) waitingDialog.findViewById(R.id.loading);
            ((AnimationDrawable) img.getDrawable()).stop();

            waitingDialog.dismiss();
            waitingDialog = null;
        }
    }

}
