class Foo {
    private CountDownLatch firstDone;
    private CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}