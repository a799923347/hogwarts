```java
private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
```
ctl:32位整型，高3位用于维护线程池的状态，低29位用于维护worker的数量(即线程的数量)。