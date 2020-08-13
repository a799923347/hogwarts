package com.bowen.hogwarts.reactor;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * flatMap操作与subscribeOn方法结合使用时，可以释放reactor反应式的异步能力
 */
public class ReactorMapTest {

  @Test
  public void test_flatMap() {
    Flux<Player> playerFlux = Flux
        .just("michael jordan", "scottie pippen", "steve kerr")
        .flatMap(n -> Mono.just(n)
            .map(p -> {
              String[] split = p.split(" ");
              return new Player(split[0], split[1]);
            }).subscribeOn(Schedulers.parallel())
        );

    List<Player> playerList = Arrays.asList(
        new Player("michael", "jordan"),
        new Player("scottie", "pippen"),
        new Player("steve", "kerr")
    );

    StepVerifier.create(playerFlux)
        .expectNextMatches(playerList::contains)
        .expectNextMatches(playerList::contains)
        .expectNextMatches(playerList::contains)
        .verifyComplete();
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Player {

    private String firstName;

    private String secondName;
  }
}
