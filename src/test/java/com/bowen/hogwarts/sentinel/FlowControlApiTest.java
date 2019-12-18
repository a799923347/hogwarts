package com.bowen.hogwarts.sentinel;

import java.io.IOException;
import java.util.Objects;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author zhaobaowen
 */
public class FlowControlApiTest {

  public static void main(String[] args) throws Exception {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("http://localhost:8080/flow/control/test")
        .build();
    for (int i = 0; i < 50; i++) {
      Response response = client.newCall(request).execute();
      System.out.println(Objects.requireNonNull(response.body()).string());
      Thread.sleep(20);
    }
  }

}
