package com.bowen.hogwarts.generics;

/**
 * @author zhaobaowen
 */
public class GenericTestHelperBean<T> {

  private T value;

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

}
