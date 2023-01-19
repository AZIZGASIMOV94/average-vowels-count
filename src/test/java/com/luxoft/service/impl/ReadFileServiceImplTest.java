package com.luxoft.service.impl;

import org.junit.Assert;
import org.junit.Test;

public class ReadFileServiceImplTest {
    ReadFileServiceImpl readFileServiceImpl = new ReadFileServiceImpl();

    @Test
    public void testReadFile() throws Exception {
        String actualResult = readFileServiceImpl.readFile("src/test/resources/INPUT.TXT");
        Assert.assertEquals("Platon made bamboo boats.", actualResult.trim());
    }
}