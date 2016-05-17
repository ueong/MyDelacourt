package xyz.ueong.mydelacourt;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ueong on 16. 5. 17.
 */
public class AppSchedulers {
    public interface SchedulerProvider {
        Scheduler mainThread();
        Scheduler io();
        Scheduler newThread();
    }

    public static SchedulerProvider instance = new DefaultSchedulerProvider();

    public static Scheduler mainThread() {
        return instance.mainThread();
    }

    public static Scheduler io() {
        return instance.io();
    }

    public static Scheduler newThread() {
        return instance.newThread();
    }

    public static class DefaultSchedulerProvider implements SchedulerProvider {

        @Override
        public Scheduler mainThread() {
            return AndroidSchedulers.mainThread();
        }

        @Override
        public Scheduler io() {
            return Schedulers.io();
        }

        @Override
        public Scheduler newThread() {
            return Schedulers.newThread();
        }
    }
}
