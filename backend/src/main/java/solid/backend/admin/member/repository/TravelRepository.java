package solid.backend.admin.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import solid.backend.admin.member.dto.TravelDto;
import solid.backend.admin.member.dto.TravelSummaryDto;

import java.util.List;

public interface TravelRepository extends JpaRepository<TravelDto, Long> {
    @Query("SELECT new solid.backend.admin.member.dto.TravelSummaryDto(t.travelId, t.travelName, t.travelPrice, t.travelAmount) FROM travel t")
    List<TravelSummaryDto> findAllSummary();
}
