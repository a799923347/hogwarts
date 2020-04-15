package com.bowen.hogwarts.builder;

/**
 * 半圆形烤乳酪馅饼，允许指定酱汁是否应该在里面或在外面
 * @author zhaobaowen
 */
public class Calzone extends Pizza {

  private final boolean sauceInside;

  public static class Builder extends Pizza.Builder<Builder> {

    private boolean sauceInside = false; // Default

    public Builder sauceInside() {
      sauceInside = true;
      return this;
    }

    @Override
    public Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private Calzone(Builder builder) {
    super(builder);
    sauceInside = builder.sauceInside;
  }
}
