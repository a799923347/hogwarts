package com.bowen.hogwarts.reactor;


import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * https://www.baeldung.com/reactor-core
 *
 * @author zhaobaowen
 */
public class FirstDemoTest {

  @Test
  public void test() {
    List<Integer> elements = new ArrayList<>();

    Flux.just(1, 2, 3, 4)
        .log()
        .subscribe(elements::add);

    assertThat(elements).containsExactly(1, 2, 3, 4);

  }

  @Test
  public void test_hot_stream() {

    ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
      while (true) {
        fluxSink.next(System.currentTimeMillis());
      }
    }).publish();

    publish.subscribe(System.out::println);
    publish.subscribe(System.out::println);
  }

  @Test
  public void test_throttle() {

    ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
      while (true) {
        fluxSink.next(System.currentTimeMillis());
      }
    })
        .sample(ofSeconds(2))
        .publish();
  }

  @Test
  public void test_concurrency() {

    List<Integer> elements = new ArrayList<>();

    Flux.just(1, 2, 3, 4)
        .log()
        .map(i -> i * 2)
        .subscribeOn(Schedulers.parallel())
        .subscribe(elements::add);
  }
}
