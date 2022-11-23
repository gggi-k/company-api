package kr.kko.kakaoassignapi.api.corporation.presentation;

import kr.kko.kakaoassignapi.api.corporation.application.CorporationService;
import kr.kko.kakaoassignapi.api.corporation.dto.CorporationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/corporation")
public class CorporationController {

    private final CorporationService corporationService;

    @GetMapping
    public List<CorporationResponse> findAll() {
        return corporationService.findAll();
    }
}