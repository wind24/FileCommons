package com.commons.files;

import com.commons.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by huangzefeng on 16/6/10.
 */
public class FileTest {

  public static void main(String[] args){

    String path = "/Users/huangzefeng/Documents/test_txt.txt";
    File txtFile = new File(path);
    String content = FileUtils.readFileString(txtFile);
    System.out.println("content="+content);
  }

}
