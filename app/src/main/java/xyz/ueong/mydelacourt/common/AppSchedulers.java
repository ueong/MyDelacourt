package xyz.ueong.mydelacourt.common;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
