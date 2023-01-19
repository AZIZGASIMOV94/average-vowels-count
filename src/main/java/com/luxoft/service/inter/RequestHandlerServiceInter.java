package com.luxoft.service.inter;

import com.luxoft.dto.OutputDto;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface RequestHandlerServiceInter {
    void findAvgNumOfVowels() throws IOException;
    String readFileHandle(Path path);
    void writeFileHandle(String stringPath, List<OutputDto> outputDtoList);
}
