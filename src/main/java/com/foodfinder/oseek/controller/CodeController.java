package com.foodfinder.oseek.controller;

import com.foodfinder.oseek.common.CommController;
import com.foodfinder.oseek.dto.code.CodeResDto;
import com.foodfinder.oseek.service.CodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "code", description = "코드 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeController extends CommController {

    @Autowired
    private CodeService codeService;

    @Operation(summary = "코드 조회", description = "codeGroup 기준으로 코드를 조회합니다.",
               responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CodeResDto.class))))})
    @GetMapping("/{codeGroup}")
    public ResponseEntity findCodes(@PathVariable String codeGroup){
        return SuccessReturn(codeService.findCodes(codeGroup));
    }

}
