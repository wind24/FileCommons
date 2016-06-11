package com.commons.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by huangzefeng on 16/6/11.
 */
public class DataStreamBuffer {

  private byte[] data;

  public void setData(byte[] data) {
    this.data = data;
  }

  public byte[] getData() {
    return data;
  }

  public int dataSize() {
    return data == null ? 0 : data.length;
  }

  public static Creator newCreator(){
    return new Creator();
  }

  public static class Creator {

    private DataBuffer actualStream;
    private DataBuffer dictionaryStream;

    private final static String STRING_TYPE = "class java.lang.String";

    public Creator() {
      actualStream = new DataBuffer();
      dictionaryStream = new DataBuffer();
    }

    public Creator writeObject(Object obj) throws IllegalAccessException, IOException {
      Field[] fields = obj.getClass().getFields();
      for (Field f : fields) {
        String name = f.getName();
        //保存字典
        dictionaryStream.writeString(name);
        dictionaryStream.writeShort((short) name.length());
        Object val = f.get(obj);
        actualStream.writeData(val);
      }

      return this;
    }

    public Creator writeMap(Map<String, Object> data) throws IOException {
      if (data == null || data.size() == 0) {
        throw new NullPointerException("data must not be null or empty.");
      }

      for (String key : data.keySet()) {
        //保存字典
        dictionaryStream.writeString(key);
        dictionaryStream.writeShort((short) key.length());

        //保存本体数据
        Object value = data.get(key);
        actualStream.writeData(value);
      }

      return this;
    }

    public DataStreamBuffer create() {
      DataStreamBuffer streamBuffer = new DataStreamBuffer();
      try {
        int dictSize = dictionaryStream.size();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(dictSize);
        baos.write(dictionaryStream.toByteArray());
        baos.write(actualStream.toByteArray());
        streamBuffer.setData(baos.toByteArray());
      } catch (IOException e) {
        e.printStackTrace();
      }
      return streamBuffer;
    }
  }
}
