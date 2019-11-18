package com.example.demo.other;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 操作文件Demo
 */
public class OperatorFile {
  
  public static void main(String[] args) throws IOException {
    //操作文件路径
    Path path = Paths.get("C:\\","Users\\zhangle\\Desktop","新建文本文档2.txt");
    Path parent = path.getParent();
    Path root = path.getRoot();
    System.out.println(root);
    System.out.println(parent);
    File file = path.toFile();
    System.out.println(file.length());
    System.out.println(Files.size(path));
    //读写文件
    //一次性读取所有文件内容 返回byte[]数组
//    byte[] bytes = Files.readAllBytes(path);
//    System.out.println(new String(bytes, StandardCharsets.UTF_8));
    //将文件内容按行读出
    List<String> list = Files.readAllLines(path);
    list.forEach(System.out::println);
    //追加内容到path路径下的文件。
//    Files.write(path,"\r\n试大概收到".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    //创建文件夹
    Path path1 = Paths.get("C:\\Users\\zhangle\\Desktop\\文件夹\\子文件夹");
    //createDirectory()方法 表示创建一个指定路径的文件或文件夹。路径中除了最后一个部件外，其他部分必须存在。
    //Files.createDirectory(path1);
    //createDirectories()方法 表示创建多个指定路径下的文件或文件夹
    Files.createDirectories(path1);
    //创建临时文件。
    Files.createTempFile(path1,"临时文件",".txt");
    
    //遍历文件目录。list()方法不会遍历子目录
    Path path2 = Paths.get("C:\\Users\\zhangle\\Desktop\\订货啦-定制化开发（快莱订餐）");
    try(Stream<Path> stream = Files.list(path2)){
      stream.forEach(System.out::println);
    }
  
    System.out.println("--------------------------------------------------");
    //遍历文件目录。walk()方法会遍历子目录
//    try(Stream<Path> stream = Files.walk(path2)){
//      stream.forEach(System.out::println);
//    }
  
    //使用文件映射读取文件
    FileChannel fc = FileChannel.open(path,StandardOpenOption.READ);
    MappedByteBuffer buffer = fc.map(MapMode.READ_ONLY,0,fc.size());
    byte[] bytes = new byte[(int)fc.size()];
    while (buffer.hasRemaining()){
      buffer.get(bytes);
      System.out.println(new String(bytes));
    }
  }
  
}
