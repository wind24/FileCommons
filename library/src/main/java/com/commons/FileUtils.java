package com.commons;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author wind
 *
 * 常规的文件操作工具类
 */
public class FileUtils {

  /**
   * 写文件
   *
   * @param data
   * @param file
   */
  public static void writeFile(byte[] data, File file) {

    if (data == null || data.length == 0) throw new RuntimeException("data is empty");

    if (file == null) throw new RuntimeException("file is null");

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
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void writeFile(String content,File file){
    FileUtils.writeFile(content.getBytes(),file);
  }

  /**
   * 读文件
   * @param file
   * @return
   */
  public static byte[] readFile(File file){
    if(file == null || !file.exists())
      throw new RuntimeException("target file is empty");

    FileInputStream fis = null;
    byte[] data = null;
    try {
      fis = new FileInputStream(file);
      data = FileUtils.inputStreamToData(fis);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(fis!=null){
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return data;
  }

  /**
   * 读文件的字符串内容
   * @param file
   * @param charsetName
   * @return
   */
  public static String readFileString(File file,String charsetName){
    byte[] data = FileUtils.readFile(file);
    if(data == null || data.length == 0)
      return null;

    try {
      return new String(data,charsetName);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 读文件的字符串内容
   *
   * utf-8编码
   * @param file
   * @return
   */
  public static String readFileString(File file){
    return FileUtils.readFileString(file,"utf-8");
  }

  /**
   * 输入流转byte[]
   * @param stream
   * @return
   * @throws IOException
   */
  public static byte[] inputStreamToData(InputStream stream) throws IOException {
    if(stream == null){
      return null;
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int len  = -1;
    while((len = stream.read(buffer))!=-1){
      baos.write(buffer,0,len);
    }

    byte[] data = baos.toByteArray();

    return data;
  }
}
