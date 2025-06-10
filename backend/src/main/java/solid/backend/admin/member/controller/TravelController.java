package solid.backend.admin.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import solid.backend.admin.member.dto.AddTravelDto;
import solid.backend.admin.member.dto.TravelDto;
import solid.backend.admin.member.dto.TravelSummaryDto;
import solid.backend.admin.member.service.TravelService;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/travel")
public class TravelController {
    private final TravelService travelService;

    /**
     * 설명 : 여행 상품 조회
     * @return List<TravelSummaryDto>
     */
    @ResponseBody
    @GetMapping("/getTravelList")
    public List<TravelSummaryDto> getTravelListCustom() {
        return travelService.getTravelList();
    }

    /**
     * 설명 : 모든 여행 상품 조회
     * @return List<TravelDto>
     */
    @ResponseBody
    @GetMapping("/getTravelListAll")
    public List<TravelDto> getTravelList() {
        return travelService.getTravelListAll();
    }

    /**
     * 설명 : 여행 상품 추가
     * @return AddTravelDto
     */
    @ResponseBody
    @PostMapping("/addTravel")
    public ResponseEntity<String> addTravel(@RequestBody AddTravelDto addTravelDto) {
        try {
            travelService.addTravel(addTravelDto);
            return ResponseEntity.ok("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("FAIL");
        }
    }
}
