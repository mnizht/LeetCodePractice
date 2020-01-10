package xyz.zhuht.multithreading.AnXuDaYin;

import java.util.concurrent.Semaphore;

/**
 * 信号量阻断
 */
public class Foo {
  public Foo() {
  }

  public Semaphore seam_first_two = new Semaphore(0);
  public Semaphore seam_two_second = new Semaphore(0);

  public void first(Runnable printFirst) throws InterruptedException {

    //printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    seam_first_two.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {

    seam_first_two.acquire();
    //printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    seam_two_second.release();
  }

  public void third(Runnable printThird) throws InterruptedException {

    seam_two_second.acquire();
    //printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
