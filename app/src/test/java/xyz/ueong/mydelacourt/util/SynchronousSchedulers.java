package xyz.ueong.mydelacourt.util;

import org.junit.rules.ExternalResource;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
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
                return Schedulers.trampoline();
            }

            @Override
            public Scheduler io() {
                return Schedulers.trampoline();
            }

            @Override
            public Scheduler newThread() {
                return Schedulers.trampoline();
            }
        };
    }

    @Override
    protected void after() {
        AppSchedulers.instance = new AppSchedulers.DefaultSchedulerProvider();
    }
}
