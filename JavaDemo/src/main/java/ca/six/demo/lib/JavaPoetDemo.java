package ca.six.demo.lib;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * songzhw - 2016/3/25
 * Copyright 2016 Six.
 */
public class JavaPoetDemo {
    private TypeSpec.Builder builder;

    public JavaPoetDemo() {
        builder = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL);
    }

    /* 01. introduce
    package com.example.helloworld;

    public final class HelloWorld {
      public static void main(String[] args) {
        System.out.println("Hello, JavaPoet!");
      }
    }
        */
    public void introduce() throws IOException {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)",System.class, "Hello JavaPoet!")
                .build();

        addMe(main);
    }

    public void addMe(MethodSpec method) {
        builder.addMethod(method);
    }

    public void printMe() throws IOException {
        TypeSpec clazz = builder.build();
        JavaFile file = JavaFile.builder("com.example.helloworld", clazz)
                .build();

        file.writeTo(System.out);
    }

    /*  02. Control Flow
  int loop() {
    int result = 0;
    for (int i = 10; i < 15 ; i++ {
      result = result * i;
    }
    return result;
  }
    */
    public void controlFlow(String name, int from, int to, String op) {
        MethodSpec method = MethodSpec.methodBuilder(name)
                .returns(int.class)
                .addStatement("int result = 0")
                .beginControlFlow("for (int i = $L; i < $L ; i++", from, to)
                .addStatement("result = result $L i", op)
                .endControlFlow()
                .addStatement("return result")
                .build();
        addMe(method);
    }

    /*
    03. constructor
public final class HelloWorld {
  private final String greeting;

  public HelloWorld(String greeting) {
    this.greeting = greeting;
  }
    */
    public void cf(){
        MethodSpec flux = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(String.class, "greeting")
                .addStatement("this.$N = $N", "greeting", "greeting")
                .build();

        addMe(flux);
        builder.addField(String.class, "greeting", Modifier.PRIVATE, Modifier.FINAL);
    }



    /*  05. annotation
  @Override
  public String toString() {
    return "Hoverboard";
  }
    */
    public void myString(){
        MethodSpec toString = MethodSpec.methodBuilder("toString")
                .addAnnotation(Override.class)
                .returns(String.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement("return $S", "Hoverboard")
                .build();
        addMe(toString);
    }


    /* 06. Anonymous Inner Classes
package com.example.helloworld;

import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HelloWorld {
  void sortByLength(List<String> strings) {
    Collections.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return a.length() - b.length();
      }
    });
  }
}
    */
    public void annoyInnerClass() throws IOException {
        TypeSpec comparator = TypeSpec.anonymousClassBuilder("")
                .addSuperinterface(ParameterizedTypeName.get(Comparator.class, String.class))
                .addMethod(MethodSpec.methodBuilder("compare")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .addParameter(String.class, "a")
                        .addParameter(String.class, "b")
                        .returns(int.class)
                        .addStatement("return $N.length() - $N.length()", "a", "b")
                        .build())
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addMethod(MethodSpec.methodBuilder("sortByLength")
                        .addParameter(ParameterizedTypeName.get(List.class, String.class), "strings")
                        .addStatement("$T.sort($N, $L)", Collections.class, "strings", comparator)
                        .build())
                .build();

        JavaFile file = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        file.writeTo(System.out);
    }

    /*  04. interface
package com.example.helloworld;

import java.lang.String;

public interface ITest {
  String FLAG = "change";

  void beep();
}
   */
    public void interfaceDemo() throws IOException {
        FieldSpec field = FieldSpec.builder(String.class, "FLAG")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S","change")
                .build();
        MethodSpec method = MethodSpec.methodBuilder("beep")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .build();
        TypeSpec aInterface = TypeSpec.interfaceBuilder("ITest")
                .addModifiers(Modifier.PUBLIC)
                .addField(field)
                .addMethod(method)
                .build();

        JavaFile file = JavaFile.builder("com.example.helloworld", aInterface)
                .build();

        file.writeTo(System.out);

    }

    public static void main(String[] args) throws IOException {
        JavaPoetDemo obj = new JavaPoetDemo();
        obj.introduce();
        obj.controlFlow("loop", 10, 15, "*");
        obj.cf();
        obj.myString();

        obj.printMe();

        System.out.println("=========================");
        obj.annoyInnerClass();


        System.out.println("=========================");
        obj.interfaceDemo();
    }
}
