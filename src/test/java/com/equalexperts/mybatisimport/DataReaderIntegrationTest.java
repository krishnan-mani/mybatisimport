package com.equalexperts.mybatisimport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//please see and use src/test/resources/fill_numbers.stored_procedure.sql to setup data for the following tests
//#TODO: use integrated setup and teardown methods to setup data in the database instead of a stored procedure

@RunWith(JUnit4.class)
public class DataReaderIntegrationTest {

    @Test
    public void readsMyDataGivenId() throws IOException {
        DataReader reader = new DataReader();
        int testInteger = 3;
        MyData readData = reader.readData(testInteger);
        assertThat(readData.getId(), is(testInteger));
        assertThat(readData.getName(), equalTo("name-" + testInteger));
    }

    @Test
    public void passDataToHandlerTest() throws IOException {
        DataReader reader = new DataReader();
        String statementSelector = "selectAll";
        int count = 100000;
        MyDataSumResultHandler handler = new MyDataSumResultHandler(count);
        reader.passDataToHandler("selectAll", handler);
        assertThat(handler.getSum(), is(((count)*(count + 1))/2));
    }
}
