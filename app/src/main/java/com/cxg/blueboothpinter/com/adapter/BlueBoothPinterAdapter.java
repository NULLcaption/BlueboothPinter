package com.cxg.blueboothpinter.com.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxg.blueboothpinter.R;
import com.cxg.blueboothpinter.com.pojo.Ztwm004;

import java.util.ArrayList;
import java.util.List;

/**
 * blue booth pinter adapter
 * Created by Administrator on 2017/6/14.
 */

public class BlueBoothPinterAdapter extends BaseAdapter {

    public List<Ztwm004> parameterList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Activity activity;

    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    public BlueBoothPinterAdapter(List<Ztwm004> parameterList, Activity activity) {
        params.leftMargin = 2;
        this.parameterList = parameterList;
        this.layoutInflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return parameterList.size();
    }

    @Override
    public Object getItem(int position) {
        return parameterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.fragment_blue_booth_pinter, null);
            holder.Zcupno = (TextView) convertView.findViewById(R.id.Zcupno);
            holder.Werks = (TextView) convertView.findViewById(R.id.werks);
            holder.Zkurno = (TextView) convertView.findViewById(R.id.Zkurno);
            holder.Zbc = (TextView) convertView.findViewById(R.id.Zbc);
            holder.Zlinecode = (TextView) convertView.findViewById(R.id.Zlinecode);
            holder.Matnr = (TextView) convertView.findViewById(R.id.matnr);
            holder.Zproddate = (TextView) convertView.findViewById(R.id.Zproddate);
            holder.Menge = (TextView) convertView.findViewById(R.id.Menge);
            holder.Meins = (TextView) convertView.findViewById(R.id.Meins);
            holder.Zgrdate = (TextView) convertView.findViewById(R.id.Zgrdate);
            holder.Zlichn = (TextView) convertView.findViewById(R.id.Zlichn);
            holder.Lifnr = (TextView) convertView.findViewById(R.id.Lifnr);
            holder.Znum = (TextView) convertView.findViewById(R.id.Znum);
            holder.Zqcnum = (TextView) convertView.findViewById(R.id.Zqcnum);
            holder.EMaktx = (TextView) convertView.findViewById(R.id.EMaktx);
            holder.EName1 = (TextView) convertView.findViewById(R.id.EName1);
            holder.EName2 = (TextView) convertView.findViewById(R.id.EName2);
        } else {
            holder = (ViewHolder) convertView.getTag();
            resetViewHolder(holder);
        }
        Ztwm004 ztwm004 = parameterList.get(position);
        holder.Zcupno.setText(ztwm004.getZcupno());
        holder.Werks.setText(ztwm004.getWerks());
        holder.Zkurno.setText(ztwm004.getZkurno());
        holder.Zbc.setText(ztwm004.getZbc());
        holder.Zlinecode.setText(ztwm004.getZlinecode());
        holder.Matnr.setText(ztwm004.getMatnr());
        holder.Zproddate.setText(ztwm004.getZproddate());
        holder.Menge.setText(ztwm004.getMeins());
        holder.Meins.setText(ztwm004.getMenge());
        holder.Zgrdate.setText(ztwm004.getZgrdate());
        holder.Zlichn.setText(ztwm004.getZlichn());
        holder.Lifnr.setText(ztwm004.getLifnr());
        holder.Znum.setText(ztwm004.getZnum());
        holder.Zqcnum.setText(ztwm004.getZqcnum());
        holder.EMaktx.setText(ztwm004.getEMaktx());
        holder.EName1.setText(ztwm004.getEName1());
        holder.EName2.setText(ztwm004.getEName2());

        return convertView;
    }

    /**
     * reset view holder
     *
     * @param pViewHolder
     */
    private void resetViewHolder(ViewHolder pViewHolder) {
        pViewHolder.Zcupno.setText(null);
        pViewHolder.Werks.setText(null);
        pViewHolder.Zkurno.setText(null);
        pViewHolder.Zbc.setText(null);
        pViewHolder.Zlinecode.setText(null);
        pViewHolder.Matnr.setText(null);
        pViewHolder.Zproddate.setText(null);
        pViewHolder.Menge.setText(null);
        pViewHolder.Meins.setText(null);
        pViewHolder.Zgrdate.setText(null);
        pViewHolder.Zlichn.setText(null);
        pViewHolder.Lifnr.setText(null);
        pViewHolder.Znum.setText(null);
        pViewHolder.Zqcnum.setText(null);
        pViewHolder.EMaktx.setText(null);
        pViewHolder.EName1.setText(null);
        pViewHolder.EName2.setText(null);
    }

    /**
     * view holder
     */
    private static class ViewHolder {
        public TextView Zcupno = null;
        public TextView Werks = null;
        public TextView Zkurno = null;
        public TextView Zbc = null;
        public TextView Zlinecode = null;
        public TextView Matnr = null;
        public TextView Zproddate = null;
        public TextView Menge = null;
        public TextView Meins = null;
        public TextView Zgrdate = null;
        public TextView Zlichn = null;
        public TextView Lifnr = null;
        public TextView Znum = null;
        public TextView Zqcnum = null;
        public TextView EMaktx = null;
        public TextView EName1 = null;
        public TextView EName2 = null;
    }
}
