package com.bowen.hogwarts.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * effective java 第三版，02-当构造方法参数过多时使用builder模式
 * Builder 模式非常适合类层次结构。 使用平行层次的 builder，每个
 * builder 嵌套在相应的类中。 抽象类有抽象的 builder；具体的类有具
 * 体的 builder。 例如，考虑代表各种比萨饼的根层次结构的抽象类
 *
 * https://sjsdfg.github.io/effective-java-3rd-chinese/#/notes/02.%20%E5%BD%93%E6%9E%84%E9%80%A0%E6%96%B9%E6%B3%95%E5%8F%82%E6%95%B0%E8%BF%87%E5%A4%9A%E6%97%B6%E4%BD%BF%E7%94%A8builder%E6%A8%A1%E5%BC%8F
 *
 * @author zhaobaowen
 */
public class Pizza {

  public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {

    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    // Subclasses must override this method to return "this"
    protected abstract T self();
  }

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone(); // See Item 50
  }
}
