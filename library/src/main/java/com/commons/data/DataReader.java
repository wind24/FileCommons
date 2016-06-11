package com.commons.data;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huangzefeng on 16/6/10.
 */
public class DataReader {

  private DataInputStream dis;

  public static DataReader createFromFile(File file){
    try {
      return new DataReader(new FileInputStream(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  public DataReader(InputStream is) {
    dis = new DataInputStream(is);
  }

  public DataReader(byte[] input){
    dis = new DataInputStream(new ByteArrayInputStream(input));
  }

  public byte readByte() {
    try {
      if (dis != null) return dis.readByte();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public int readInt() {
    try {
      if (dis != null) return dis.readInt();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public char readChar(){
    if(dis!=null) try {
      return dis.readChar();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public boolean readBoolean(){
    if(dis!=null) try {
      return dis.readBoolean();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }

  public float readFloat(){
    if(dis!=null) try {
      return dis.readFloat();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public String readString(){
    if(dis!=null) try {
      return dis.readUTF();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  public long readLong(){
    if(dis!=null) try {
      return dis.readLong();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public double readDouble(){
    if(dis!=null) try {
      return dis.readDouble();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public short readShort(){
    if(dis!=null) try {
      return dis.readShort();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return 0;
  }

}
