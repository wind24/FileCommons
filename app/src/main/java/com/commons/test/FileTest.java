package com.commons.test;

import com.commons.data.DataStreamBuffer;
import com.commons.data.TestModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangzefeng on 16/6/10.
 */
public class FileTest {

  public static void main(String[] args) {
    //String path = "/Users/huangzefeng/Documents/test_data_stream";
    //File txtFile = new File(path);
    //
    //DataBuffer buffer = new DataBuffer();
    //buffer.writeInt(200);
    //buffer.writeChar('b');
    //buffer.writeBoolean(true);
    //System.out.println("size=" + buffer.size());
    //buffer.writeString("测试输入流");
    ////buffer.writeToFile(txtFile);
    //key
    //DataReader reader = new DataReader(buffer.toByteArray());
    //int r1 = reader.readInt();
    //System.out.println("1 r1=" + r1);
    //char r2 = reader.readChar();
    //System.out.println("1 r2=" + r2);
    //boolean r3 = reader.readBoolean();
    //System.out.println("1 r3=" + r3);
    //String r5 = reader.readString();
    //System.out.print("1 r5=" + r5);

    Map<String,Object> data = new HashMap<>();
    data.put("v1",1);
    data.put("v2",(short)3);
    data.put("v3",1.0f);
    data.put("v4",1.0d);
    data.put("v5",1l);
    data.put("v6",true);
    data.put("v7",(byte)2);
    data.put("v8",'a');
    data.put("v9","testv");

    TestModel model = new TestModel();
    model.v1 = 1;
    model.v2 = 2;
    model.v3 = 3f;
    model.v4 = 4d;
    model.v5 =5l;
    model.v6 = true;
    model.v7 = (byte)6;
    model.v8 = 'a';
    model.v9 = "testv";

    System.out.println("model string:"+model.toString());

    DataStreamBuffer streamBuffer = null;
    DataStreamBuffer mapBuffer = null;
    try {
      streamBuffer = DataStreamBuffer.newCreator().writeObject(model).create();
      mapBuffer = DataStreamBuffer.newCreator().writeMap(data).create();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("streambuffer:"+streamBuffer.dataSize());
    System.out.println("mapBuffer:"+mapBuffer.dataSize());

  }
}
