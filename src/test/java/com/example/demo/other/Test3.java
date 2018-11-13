package com.example.demo.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author byron
 * @date 2018/10/31 16:15
 */
public class Test3 {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("abc");
    list.add("bcdd");
    list.add("adct");
    list.add("ocsi");
    list.add("sdfsd");
    list.stream().filter(item -> item.startsWith("a")&&item.length()>3).collect(Collectors.toList());

    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");



  }

}
