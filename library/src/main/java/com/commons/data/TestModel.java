package com.commons.data;

/**
 * Created by huangzefeng on 16/6/11.
 */
public class TestModel {

  public int v1;
  public short v2;
  public float v3;
  public double v4;
  public long v5;
  public boolean v6;
  public byte v7;
  public char v8;
  public String v9;

  @Override public String toString() {
    String format = "v1=%d,v2=%d,v3=%f,v4=%f,v5=%d,v6=%s,v7=%d,v8=%c,v9=%s";
    return String.format(format,v1,v2,v3,v4,v5,String.valueOf(v6),v7,v8,v9);
  }
}
