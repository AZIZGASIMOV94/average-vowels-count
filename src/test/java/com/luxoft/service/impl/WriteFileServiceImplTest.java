package com.luxoft.service.impl;

import com.luxoft.dto.OutputDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class WriteFileServiceImplTest {
    WriteFileServiceImpl writeFileServiceImpl = new WriteFileServiceImpl();

    @Test
    public void testWriteFile() throws Exception {
        writeFileServiceImpl.writeFile("src/test/resources/OUTPUT.TXT",
                Arrays.<OutputDto>asList(new OutputDto(new HashSet<String>(Arrays.asList("Platon")),
                        6, 3.0)));
    }
}