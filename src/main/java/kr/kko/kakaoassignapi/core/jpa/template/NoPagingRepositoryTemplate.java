package kr.kko.kakaoassignapi.core.jpa.template;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface NoPagingRepositoryTemplate<DTO, QUERY> {

    List<DTO> findAllByQuery(final QUERY query);
}