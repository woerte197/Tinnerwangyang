package com.example.wangyang.tinnerwangyang.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyang on 2/1/18.
 */

public class JThreadPool extends ThreadPoolExecutor {

        private final static int SIZE_POOL_CORE = 2;
        private final static int SIZE_POLL_MAX = 10;
        private final static int TIME_KEEP_ALIVE = 2;
        private final static TimeUnit TIME_UNIT = TimeUnit.SECONDS;
        private final static List<ThreadPoolExecutor> SPOOLS = new ArrayList<ThreadPoolExecutor>();
        private static ThreadPoolExecutor globalPool = null;
        private static ThreadPoolExecutor singleGlobalPool = null;

        private JThreadPool() {
            super(SIZE_POOL_CORE, SIZE_POLL_MAX, TIME_KEEP_ALIVE, TIME_UNIT,
                    new LinkedBlockingQueue<Runnable>(), new RejectedHandler());
        }

        public JThreadPool(int min, int max) {
            super(min, max, TIME_KEEP_ALIVE, TIME_UNIT,
                    new LinkedBlockingQueue<Runnable>(), new RejectedHandler());
        }

        public JThreadPool(int min, int max, int keeptime) {
            super(min, max, keeptime, TIME_UNIT,
                    new LinkedBlockingQueue<Runnable>(), new RejectedHandler());
        }

        public JThreadPool(int min, int max,
                           RejectedExecutionHandler executionHandler) {
            super(min, max, TIME_KEEP_ALIVE, TIME_UNIT,
                    new LinkedBlockingQueue<Runnable>(), executionHandler);
        }

        private static class RejectedHandler implements RejectedExecutionHandler {

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        }

        public static ThreadPoolExecutor getDefaultThreadPool() {
            ThreadPoolExecutor pool = new JThreadPool();
            SPOOLS.add(pool);
            return pool;
        }

        public static ThreadPoolExecutor getGlobalThreadPool() {
            if (globalPool == null) {
                globalPool = new JThreadPool(10, 10);
            }
            return globalPool;
        }

        /*
         * 用户临时的异步操作
         */
        public static ThreadPoolExecutor getGlobalSingleThreadPool() {
            if (singleGlobalPool == null) {
                singleGlobalPool = new JThreadPool(1, 1);
            }
            return singleGlobalPool;
        }

        public static void reset() {
            shutdown(globalPool);
            shutdown(singleGlobalPool);
            globalPool = null;
            singleGlobalPool = null;
            try {
                for (ThreadPoolExecutor pool : SPOOLS) {
                    shutdown(pool);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            SPOOLS.clear();
        }

        private static void shutdown(ThreadPoolExecutor pool) {
            if (pool != null) {
                pool.shutdownNow();
                pool = null;
            }
        }
    }

