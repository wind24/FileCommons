package com.commons;

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

  public void writeByte(byte b) {
    try {
      dos.writeByte(b);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeInt(int i) {
    try {
      dos.writeInt(i);
    } catch (IOException e) {
      e.printStackTrace();
        System.out.println(e.getMessage());
    }
  }

  public void writeFloat(float f) {
    try {
      dos.writeFloat(f);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeBoolean(boolean b) {
    try {
      dos.writeBoolean(b);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeChar(char c) {
    try {
      dos.writeChar(c);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeString(String s) {
    if (s != null && s.length() > 0) {
      try {
        dos.writeUTF(s);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public int size(){
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

  public void writeToFile(File file){
    byte[] data = toByteArray();
    if(data!=null && data.length > 0){
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
