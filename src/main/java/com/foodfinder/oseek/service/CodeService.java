package com.foodfinder.oseek.service;

import com.foodfinder.oseek.dto.code.CodeResDto;
import com.foodfinder.oseek.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;

    @Transactional
    public List<CodeResDto> findCodes(String codeGroup){
        Sort sort = Sort.by(Sort.Direction.ASC, "codeOrderNo");
        return codeRepository.findAllByCodeGroup(codeGroup, sort).stream()
                .map(CodeResDto::new)
                .collect(Collectors.toList());
    }

}
