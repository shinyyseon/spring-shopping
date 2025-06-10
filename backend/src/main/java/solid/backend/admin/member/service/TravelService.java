package solid.backend.admin.member.service;

import solid.backend.admin.member.dto.*;

import java.util.List;

public interface TravelService {

    List<TravelDto> getTravelListAll();
    List<TravelSummaryDto> getTravelList();
    void addTravel(AddTravelDto addTravelDto);
    void updateTravel(UpdateTravelDto updateTravelDto);
    void deleteTravel(DeleteTravelDto deleteTravelDto);
}
