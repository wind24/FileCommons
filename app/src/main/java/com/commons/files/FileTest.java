package com.commons.files;

import com.commons.DataBuffer;
import com.commons.DataReader;
import java.io.File;

/**
 * Created by huangzefeng on 16/6/10.
 */
public class FileTest {

  public static void main(String[] args) {
    String path = "/Users/huangzefeng/Documents/test_data_stream";
    File txtFile = new File(path);

    DataBuffer buffer = new DataBuffer();
    buffer.writeInt(200);
    buffer.writeChar('b');
    buffer.writeBoolean(true);
    System.out.println("size=" + buffer.size());
    buffer.writeString("测试输入流");
    buffer.writeToFile(txtFile);

    DataReader reader = DataReader.createFromFile(txtFile);
    int r1 = reader.readInt();
    System.out.println("r1=" + r1);
    char r2 = reader.readChar();
    System.out.println("r2=" + r2);
    boolean r3 = reader.readBoolean();
    System.out.println("r3=" + r3);
    String r5 = reader.readString();
    System.out.print("r5=" + r5);
  }
}
