package com.example.leaf;

import com.example.leaf.biz.IDGen;
import com.example.leaf.biz.SnowflakeIDGenImpl;
import com.example.leaf.common.PropertyFactory;
import com.example.leaf.common.Result;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class SnowflakeIDGenImplTest {
    @Test
    public void testGetId() {
        Properties properties = PropertyFactory.getProperties();

        IDGen idGen = new SnowflakeIDGenImpl(properties.getProperty("leaf.zk.list"), 8080);
        for (int i = 1; i < 1000; ++i) {
            Result r = idGen.get("a");
            System.out.println(r);
        }
    }
}
