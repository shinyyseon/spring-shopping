package solid.backend.admin.member.service;

import solid.backend.admin.member.dto.AddTravelDto;
import solid.backend.admin.member.dto.TravelDto;
import solid.backend.admin.member.dto.TravelSummaryDto;

import java.util.List;

public interface TravelService {

    List<TravelDto> getTravelListAll();
    List<TravelSummaryDto> getTravelList();
    void addTravel(AddTravelDto addTravelDto);
}
