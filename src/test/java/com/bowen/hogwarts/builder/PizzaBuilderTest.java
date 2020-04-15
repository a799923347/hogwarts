package com.bowen.hogwarts.builder;

import static com.bowen.hogwarts.builder.NyPizza.Size.SMALL;
import static com.bowen.hogwarts.builder.Pizza.Topping.HAM;
import static com.bowen.hogwarts.builder.Pizza.Topping.ONION;
import static com.bowen.hogwarts.builder.Pizza.Topping.SAUSAGE;

import com.bowen.hogwarts.builder.Pizza.Topping;
import java.util.EnumSet;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class PizzaBuilderTest {

  @Test
  public void test() {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
    NyPizza pizza = new NyPizza.Builder(SMALL)
        .addTopping(SAUSAGE).addTopping(ONION).build();
    Calzone calzone = new Calzone.Builder()
        .addTopping(HAM).sauceInside().build();
  }

}
