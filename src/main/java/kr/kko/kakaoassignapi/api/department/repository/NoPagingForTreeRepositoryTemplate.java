package kr.kko.kakaoassignapi.api.department.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface NoPagingForTreeRepositoryTemplate<DTO, QUERY> {

    List<DTO> findAllByQueryForTree(final QUERY query);
}