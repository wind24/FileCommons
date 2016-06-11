package com.commons.data;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangzefeng on 16/6/10.
 */
public class DataBuffer {

  private ByteArrayOutputStream baos;
  private DataOutputStream dos;

  public DataBuffer() {
    baos = new ByteArrayOutputStream();
    dos = new DataOutputStream(baos);
  }

  public void writeByte(byte b) throws IOException {
    dos.writeByte(b);
  }

  public void writeInt(int i) throws IOException {
    dos.writeInt(i);
  }

  public void writeFloat(float f) throws IOException {
    dos.writeFloat(f);
  }

  public void writeBoolean(boolean b) throws IOException {
    dos.writeBoolean(b);
  }

  public void writeChar(char c) throws IOException {
    dos.writeChar(c);
  }

  public void writeString(String s) throws IOException {
    if (s != null && s.length() > 0) {
      dos.writeUTF(s);
    }
  }

  public void writeShort(short var) throws IOException {
    dos.writeShort(var);
  }

  public void writeLong(long var) throws IOException {
    dos.writeLong(var);
  }

  public void writeDouble(double var) throws IOException {
    dos.writeDouble(var);
  }

  public void writeBytes(String var) throws IOException {
    dos.writeBytes(var);
  }

  public void writeData(Object value) throws IOException {
    if(value instanceof Integer){
      writeInt((Integer) value);
    }else if(value instanceof Long){
      writeLong((Long) value);
    }else if(value instanceof Double){
      writeDouble((Double) value);
    }else if (value instanceof Short){
      writeShort((Short) value);
    }else if(value instanceof Boolean){
      writeBoolean((Boolean) value);
    }else if(value instanceof Character){
      writeChar((Character) value);
    }else if(value instanceof Byte){
      writeByte((Byte) value);
    }else if(value instanceof String){
      writeString((String) value);
    }
  }

  public int size() {
    return dos.size();
  }

  public byte[] toByteArray() {
    if (dos != null) {
      try {
        dos.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return baos.toByteArray();
  }

  public void writeToFile(File file) {
    byte[] data = toByteArray();
    if (data != null && data.length > 0) {
      FileOutputStream fos = null;
      try {
        fos = new FileOutputStream(file);
        fos.write(data);
        fos.flush();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void clear() {
    if (dos != null) {
      try {
        dos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (baos != null) {
      try {
        baos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


}
