package com.equalexperts.mybatisimport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
}
