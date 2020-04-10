package service;

public class TimeService {

    public void lockMainThread(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}
