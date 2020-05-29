package com.intuit.platform.integration.rpasClient.util;

import java.util.concurrent.Callable;

public class CallableResult  implements Callable {


    public CallableResult() {
    }

    @Override
    public String call() throws Exception {
        try {
          return "SUCCESS";

        } catch (Exception e) {
            throw new Exception("There was an error",e);
        }
    }
}