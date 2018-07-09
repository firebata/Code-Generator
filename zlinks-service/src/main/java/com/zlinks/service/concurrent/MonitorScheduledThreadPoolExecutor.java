package com.zlinks.service.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 线程池监控
 *
 * @author zhangjh
 * @date 2017/11/2 11:50
 */
public class MonitorScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public MonitorScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    @Override
    protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {
        if (logger.isDebugEnabled()) {
            logger.debug("task  work begain,worker thread is :" + paramThread.getName());
        }


    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {

        super.afterExecute(r, t);
        if (logger.isDebugEnabled()) {
            logger.debug("task finish ，worker thread is :" + r);
        }


    }

    @Override
    protected void terminated() {
        if (logger.isDebugEnabled()) {
            logger.debug("terminated getCorePoolSize:" + this.getCorePoolSize() + "；getPoolSize:" + this.getPoolSize() + "；getTaskCount:" + this.getTaskCount() + "；getCompletedTaskCount:"
                    + this.getCompletedTaskCount() + "；getLargestPoolSize:" + this.getLargestPoolSize() + "；getActiveCount:" + this.getActiveCount());
        }

    }
}
