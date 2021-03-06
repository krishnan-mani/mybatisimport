package com.equalexperts.mybatisimport;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class MyDataSumResultHandler implements ResultHandler {

    private int sum = 0;
    private int count = 0;
    private boolean debug = false;

    public MyDataSumResultHandler(int count) {
        this.count = count;
    }

    @Override
    public void handleResult(ResultContext resultContext) {
        MyData data = (MyData) resultContext.getResultObject();
        if (debug) {
            System.out.println(data.toString());
        }
        sum += data.getId();
    }

    public int getSum() {
        return sum;
    }

}
