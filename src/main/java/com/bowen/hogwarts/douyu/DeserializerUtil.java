package com.bowen.hogwarts.douyu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter.MapSplitter;
import java.util.Map;

/**
 * @author zhaobaowen
 */
public class DeserializerUtil {

  private static final MapSplitter splitter = Splitter.on("/").trimResults(CharMatcher.is('/'))
      .omitEmptyStrings().withKeyValueSeparator("@=");
  private static final ObjectMapper mapper = new ObjectMapper();

  static {
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public static BarrageDo deserialize(String plainText) {
    Map<String, String> fields = splitter.split(plainText);
    return mapper.convertValue(fields, BarrageDo.class);
  }

}
