package com.bowen.hogwarts.builder;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class BuilderTest {

  @Test
  public void test() {
    BuilderObject xiaoming = Builder.of(BuilderObject::new)
        // BuilderObject::setName 等价于 (object, name) -> object.setName(name)
        .with(BuilderObject::setName, "xiaoming")
        .with(BuilderObject::setIdNo, "123")
        .build();
    System.out.println(JSON.toJSONString(xiaoming));
  }
}

@Data
class BuilderObject {

  private String name;
  private String idNo;
}
