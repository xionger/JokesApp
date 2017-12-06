package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import static junit.framework.Assert.assertFalse;

import com.udacity.gradle.builditbigger.async.RetrieveJokesAsyncTask;
import com.udacity.gradle.builditbigger.async.AsyncResponse;


public class RetrieveJokesAsyncTaskTest {

    private CountDownLatch countDownLatch;

    @Before
    public void setUp(){
        countDownLatch = new CountDownLatch(1);
    }

    @Test
    public void testAsyncTask() throws InterruptedException{
        countDownLatch = new CountDownLatch(1);
        new RetrieveJokesAsyncTask(new AsyncResponse() {
            @Override
            public void processJokes(String out) {
                assertFalse(TextUtils.isEmpty(out));
                countDownLatch.countDown();
            }
        }).execute();

        countDownLatch.await();
    }

}
