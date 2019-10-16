package com.example.demo.other;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * java io流相关demo
 * 输入流demo
 */
public class InputStreamTest extends Date {
  
  //使用‘/’等同于使用‘\\’
  public static final String FILENAME = "C:/Users/zhangle/Desktop/新建文本文档.txt";
  public static final String ZIPNAME = "C:/Users/zhangle/Desktop/test.zip";
  public static final String NEWFILENAME = "C:/Users/zhangle/Desktop/新建文本文档2.txt";
  public static File file = new File(FILENAME);
  public static File newfile = new File(NEWFILENAME);
  public static File zipFile = new File(ZIPNAME);
  
  public void fileInputSteamTest() throws IOException {
    //获取系统默认编码格式。。
    System.out.println(Charset.defaultCharset());
    //使用FileInputStream读取文件
    //java默认的编码格式是UTF-8。
    //如果文件的编码格式与java的编码格式不一致，要转化一致才行。
    System.out.println("文件大小：" + file.length());
    FileInputStream fis = new FileInputStream(file);
    //跳过几个字节。
    byte[] b = new byte[1024];
    while (fis.read(b) != -1) {
      System.out.println(new String(b));
    }
//      int i = fis.read(b);
//      System.out.println("file.read:"+i);
//      System.out.println("内容为："+new String(b));
    fis.close();
  }
  
  public void fileReadTest() throws IOException {
    //使用FileReader读取文件
    //FileReader用于读取字符串文件
    FileReader fileReader = new FileReader(file);
    System.out.println(file.length());
    char[] chars = new char[1024];
    int i;
    int length = 0;
    while ((i = fileReader.read()) != -1) {
      System.out.println((char) i);
      chars[length] = (char) i;
      length++;
    }
  
    System.out.println(new String(chars, 0, length));
    fileReader.close();
  }
  
  /**
   * 使用缓冲字符流处理字符。
   */
  public void bufferedInputReadTest() throws IOException {
    //使用缓冲流读取文件 可直接读取一行
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    FileWriter fileWriter = new FileWriter(newfile);
    //写入新文件
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    String str;
    while ((str = bufferedReader.readLine()) != null) {
      System.out.println(str);
      bufferedWriter.write(str + "\r\n");
      //可以用"\r\n"替换
//        bufferedWriter.newLine();
    }
    bufferedWriter.flush();
    bufferedReader.close();
    bufferedWriter.close();
  }
  
  /**
   * 使用DataInputStream/DataOutputStream读写二进制。
   */
  public void DataTest() throws IOException {
    //先写入
    FileOutputStream fos = new FileOutputStream(newfile);
    DataOutputStream dos = new DataOutputStream(fos);
    //再读入
    FileInputStream fis = new FileInputStream(newfile);
    DataInputStream dis = new DataInputStream(fis);
    dos.writeDouble(12.2);
    dos.writeUTF("名字");
    dos.writeChars("哈哈");
//      dos.writeChar('名');
    dos.flush();
    System.out.println(dis.readDouble());
    System.out.println(dis.readUTF());
    dis.close();
    dos.close();
  }
  
  /**
   * 使用随机访问文件读写文件
   */
  public void RandomAccessFileTest() throws IOException {
    RandomAccessFile raf = new RandomAccessFile(FILENAME, "r");
    //设置指针
    raf.seek(3);
    System.out.println(raf.readLine());
    raf.close();
  }
  
  /**
   * 使用zip压缩文件
   */
  public void zipTest() throws IOException {
    //创建zip文件以及zip输出流
    FileOutputStream fos = new FileOutputStream(zipFile);
    ZipOutputStream zos = new ZipOutputStream(fos);
    //创建打包文件名称
    ZipEntry zipEntry = new ZipEntry(file.getName());
    //压缩进zip
    zos.putNextEntry(zipEntry);
    //读取源文件内容并写入压缩文件中
    BufferedReader fis = new BufferedReader(new FileReader(file));
    String str;
    while ((str = fis.readLine()) != null) {
      str += "\r\n";
      zos.write(str.getBytes());
    }
    zos.closeEntry();
    zos.close();
  }
  
  /**
   * 使用对象输入\输出流与序列化
   */
  public void ObjectTest() throws IOException, ClassNotFoundException {
    //对象输出
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
      //定义sunzi
      Man m = new Man();
      m.setAge(10);
      m.setName("孙子");
      System.out.println("序列化m" + m);

      Sun sun = new Sun();
      sun.setName("张三");
      sun.setAge(25);
      sun.setMan(m);
      System.out.println("序列化sun：" + sun);

      Sun sun2 = new Sun();
      sun2.setMan(m);
      sun2.setAge(26);
      sun2.setName("李四");
      System.out.println("序列化sun2：" + sun2);
      oos.writeObject(m);
      oos.writeObject(sun);
      oos.writeObject(sun2);
    }
    //对象输入
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      Man man = (Man) ois.readObject();
      System.out.println(man);
      System.out.println(man.getName());
      System.out.println(man.getAge());
//      System.out.println(man.getAge());
      Sun sun = (Sun) ois.readObject();
      Sun sun2 = (Sun) ois.readObject();
      System.out.println(sun);
      System.out.println(sun.getName());
//      System.out.println(sun.getMan().getAge());
      System.out.println(sun2);
      System.out.println(sun2.getName());
//      System.out.println(sun2.getAge());
    }
  }
  
  /**
   * 对象自定义序列化。
   */
  public void ObjectCustomTest() throws IOException, ClassNotFoundException{
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
      Customer customer = new Customer();
      customer.setName("张三");
      customer.setPassword(123);
      oos.writeObject(customer);
    }
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      Customer customer = (Customer)ois.readObject();
      System.out.println(customer.getName());
      System.out.println(customer.getPassword());
    }
  }
  
    public static void main (String[]args) throws Exception {
      InputStreamTest i = new InputStreamTest();
//    i.DataTest();
//    i.RandomAccessFileTest();
//      i.zipTest();
//      i.ObjectTest();
      i.ObjectCustomTest();
    }
}

class Man implements Serializable{
  //当本地对象和远程对象的序列版本号一致时。如果本地对象没有远程对象的字段域时，那么在反序列化时会被忽略。
  private static final long serialVersionUID = -1;
  private String name;
  private double address;
  //transient 修饰字段 表示该字段不会被序列化。
  private transient int age;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  
  public double getAddress() {
    return address;
  }

  public void setAddress(double address) {
    this.address = address;
  }
}
class Sun extends Man{
  private Man man;
  
  public Man getMan() {
    return man;
  }
  
  public void setMan(Man man) {
    this.man = man;
  }
}

//自定义序列化demo对象
class Customer implements Serializable, Externalizable {
  private String name;
  
  private int password;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getPassword() {
    return password;
  }
  
  public void setPassword(int password) {
    this.password = password;
  }
  
  //自定义反序列化过程
  private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
//    in.defaultReadObject();
    String name = in.readUTF();
    int password = in.readInt();
    this.name = name;
    this.password = password;
  }
  
  //自定义序列化过程
  private void writeObject(ObjectOutputStream out) throws IOException{
    System.out.println(this.name);
    System.out.println(this.password);
    out.writeUTF(this.name+"哈哈哈");
    out.writeInt(this.password*100);
  }
  
  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
  
  }
  
  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
  
  }
}

