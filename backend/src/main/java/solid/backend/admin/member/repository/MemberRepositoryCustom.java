package solid.backend.admin.member.repository;

import org.springframework.stereotype.Repository;
import solid.backend.admin.member.dto.MemberListDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberListDto> findBySearchCondition(String memberId, String memberName);
}
