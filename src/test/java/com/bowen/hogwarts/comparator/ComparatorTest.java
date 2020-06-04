package com.bowen.hogwarts.comparator;

import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

/**
 * @author zhaobaowen
 */
public class ComparatorTest {

  @Test
  public void test() {
    SortObject sortObject1 = SortObject.builder().sequenceId("1").date(new Date(2020, 6, 1)).build();
    SortObject sortObject2 = SortObject.builder().sequenceId("2").date(new Date(2020, 6, 4)).build();
    SortObject sortObject3 = SortObject.builder().sequenceId("3").date(new Date(2020, 6, 3)).build();

    List<SortObject> sortObjects = Lists.newArrayList(sortObject1, sortObject2, sortObject3);
    sortObjects.sort(Comparator.comparing(SortObject::getDate));

    sortObjects.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));

  }

  @Data
  @Builder
  static class SortObject{

    private String sequenceId;

    private Date date;
  }
}
