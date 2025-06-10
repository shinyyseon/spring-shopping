package solid.backend.admin.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solid.backend.admin.member.dto.AddTravelDto;
import solid.backend.admin.member.dto.TravelDto;
import solid.backend.admin.member.dto.TravelSummaryDto;
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
}
