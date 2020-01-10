package xyz.zhuht.multithreading.AnXuDaYin;

public class FooTest {
  public static void main(String[] args) {
    Foo2 foo = new Foo2();

    Thread t1 = new Thread(() -> {
      try {
        foo.first(() -> System.out.println("one"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t2 = new Thread(() -> {
      try {
        foo.second(() -> System.out.println("two"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread t3 = new Thread(() -> {
      try {
        foo.third(() -> System.out.println("three"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t2.start();
    t1.start();
    t3.start();
  }

}
