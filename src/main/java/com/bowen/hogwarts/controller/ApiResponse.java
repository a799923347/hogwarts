package com.bowen.hogwarts.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaobaowen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

  private static final Integer SUCCESS_CODE = 0;
  private static final Integer ERROR_CODE = 1;

  private Integer code;

  private T data;

  private String msg;

  public static <T> ApiResponse<T> ok() {
    return new ApiResponse<>(SUCCESS_CODE, null, "成功");
  }

  public static <T> ApiResponse<T> ok(T data) {
    return new ApiResponse<>(SUCCESS_CODE, data, "成功");
  }

  public static <T> ApiResponse<T> fail(String msg) {
    return new ApiResponse<>(ERROR_CODE, null, msg);
  }

  public static <D, T> ApiResponse<T> act(D data, Function<D, ApiResponse<T>> function) {
    return function.apply(data);
  }

  public static <T> ApiResponse<T> act(Supplier<ApiResponse<T>> supplier) {
    return supplier.get();
  }
}
