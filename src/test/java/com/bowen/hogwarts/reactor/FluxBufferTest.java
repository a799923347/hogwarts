package com.bowen.hogwarts.reactor;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * 使用buffer操作将元素拆分（或者说缓冲）成小块
 */
public class FluxBufferTest {

  @Test
  public void test_buffer() {

    Flux<String> fruitFlux = Flux.just("apple", "orange", "banana", "kiwi", "strawberry");

    Flux<List<String>> bufferedFlux = fruitFlux.buffer(3);

    StepVerifier
        .create(bufferedFlux)
        .expectNext(Arrays.asList("apple", "orange", "banana"))
        .expectNext(Arrays.asList("kiwi", "strawberry"))
        .verifyComplete();

  }

  @Test
  public void test_buffer_parallel() {

    Flux
        .just("apple", "orange", "banana", "kiwi", "strawberry")
        .buffer(3)
        .flatMap(x -> Flux.fromIterable(x)
            .map(String::toUpperCase)
            .subscribeOn(Schedulers.parallel())
            .log())
        .subscribe();
  }
}
