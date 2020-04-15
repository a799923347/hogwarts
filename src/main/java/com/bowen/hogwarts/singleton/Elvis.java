package com.bowen.hogwarts.singleton;

/**
 * @author zhaobaowen
 */
public class Elvis {

  public static final Elvis INSTANCE = new Elvis();

  private Elvis() {
    System.out.println("初始化");
  }

  public void leaveTheBuilding() {
  }

}
