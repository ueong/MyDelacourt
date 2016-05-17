package xyz.ueong.mydelacourt.util;

import org.junit.rules.ExternalResource;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import xyz.ueong.mydelacourt.AppSchedulers;

/**
 * Created by ueong on 16. 5. 18.
 */
public class SynchronousSchedulers extends ExternalResource {

    @Override
    protected void before() throws Throwable {
        AppSchedulers.instance = new AppSchedulers.SchedulerProvider() {

            @Override
            public Scheduler mainThread() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler io() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler newThread() {
                return Schedulers.immediate();
            }
        };
    }

    @Override
    protected void after() {
        AppSchedulers.instance = new AppSchedulers.DefaultSchedulerProvider();
    }
}
