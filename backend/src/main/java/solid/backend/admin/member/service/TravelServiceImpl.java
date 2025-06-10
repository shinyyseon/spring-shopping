package solid.backend.admin.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solid.backend.admin.member.dto.AddTravelDto;
import solid.backend.admin.member.dto.TravelDto;
import solid.backend.admin.member.dto.TravelSummaryDto;
import solid.backend.admin.member.dto.UpdateTravelDto;
import solid.backend.admin.member.repository.TravelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;

    @Override
    public List<TravelDto> getTravelListAll() {
        return travelRepository.findAll();
    }

    @Override
    public List<TravelSummaryDto> getTravelList() {
        return travelRepository.findAllSummary();
    }

    @Override
    public void addTravel(AddTravelDto addTravelDto) {
        TravelDto travelDto = new TravelDto();

        travelDto.setTravelName(addTravelDto.getTravelName());
        travelDto.setTravelPrice(addTravelDto.getTravelPrice());
        travelDto.setTravelAmount(addTravelDto.getTravelAmount());
        travelDto.setTravelSold(addTravelDto.isTravelSold());
        travelDto.setTravelComment(addTravelDto.getTravelComment());
        travelDto.setTravelLabel(addTravelDto.getTravelLabel());
        travelDto.setTravelStartDt(addTravelDto.getTravelStartDt());
        travelDto.setTravelEndDt(addTravelDto.getTravelEndDt());
        travelDto.setTravelUploadDt(addTravelDto.getTravelUploadDt());
        travelDto.setTravelUpdateDt(addTravelDto.getTravelUpdateDt());
        travelDto.setTravelImg(addTravelDto.getTravelImg());

        travelRepository.save(travelDto);
    }

    @Override
    public void updateTravel(UpdateTravelDto updateTravelDto) {
        TravelDto travel = travelRepository.findById(Long.valueOf(updateTravelDto.getTravelId()))
                .orElseThrow(() -> new IllegalArgumentException("해당 여행 상품이 존재하지 않습니다: id = " + updateTravelDto.getTravelId()));

        // 2. 필드 값 업데이트
        travel.setTravelName(updateTravelDto.getTravelName());
        travel.setTravelPrice(updateTravelDto.getTravelPrice());
        travel.setTravelAmount(updateTravelDto.getTravelAmount());
        travel.setTravelSold(updateTravelDto.isTravelSold());
        travel.setTravelComment(updateTravelDto.getTravelComment());
        travel.setTravelLabel(updateTravelDto.getTravelLabel());
        travel.setTravelStartDt(updateTravelDto.getTravelStartDt());
        travel.setTravelEndDt(updateTravelDto.getTravelEndDt());
        travel.setTravelUploadDt(updateTravelDto.getTravelUploadDt());
        travel.setTravelUpdateDt(updateTravelDto.getTravelUpdateDt());
        travel.setTravelImg(updateTravelDto.getTravelImg());

        // 3. 저장
        travelRepository.save(travel);
    }
}
