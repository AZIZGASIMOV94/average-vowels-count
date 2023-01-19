package com.luxoft.service.inter;

import com.luxoft.dto.OutputDto;

import java.io.IOException;
import java.util.List;

public interface WriteFileServiceInter {
    void writeFile(String path, List<OutputDto> outputDtoList) throws IOException;
}
