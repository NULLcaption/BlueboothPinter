package com.cxg.blueboothpinter.com.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * 托盘编码实体类
 * Created by Administrator on 2017/6/14.
 */
@DatabaseTable(tableName = "ZwmRfcIts003")
public class ZwmRfcIts003 implements Serializable{

    @DatabaseField
    private String IZipcode;//托盘编码

    public String getIZipcode() {
        return IZipcode;
    }

    public void setIZipcode(String IZipcode) {
        this.IZipcode = IZipcode;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
