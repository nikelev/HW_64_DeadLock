package ait.volatiles.task;

import java.util.concurrent.atomic.AtomicBoolean;

public class InfiniteLoop implements Runnable {
   // private volatile boolean flag = true;

    private AtomicBoolean flag=new AtomicBoolean(true);

    public boolean isFlag() {
        return flag.get();
    }

    public void setFlag(boolean flag) {
        //this.flag = flag;
        this.flag.set(flag);
    }

    @Override
    public void run() {
        while (isFlag()) ;
        System.out.println(Thread.currentThread().getName() + " Finished");
    }

}
