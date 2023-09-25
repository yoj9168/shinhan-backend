package com.example.service.companyAnalyze;

import com.example.DTO.companyAnalyze.PostCompanyAnalyzeDTO;
import com.example.DTO.companyAnalyze.ResponseCompanyAnalyzeDTO;
import com.example.DTO.companyAnalyze.UpdateCompanyAnalyzeDTO;
import com.example.domain.entity.Opinion;
import com.example.domain.entity.CompanyAnalyze;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyAnalyzeService {
    private static List<CompanyAnalyze> companyAnalyzes = new ArrayList<>();
    @PostConstruct
    public void init(){
        companyAnalyzes.addAll(List.of(
                new CompanyAnalyze(1,"두산테스나", Opinion.BUY, "3분기 비용 증가로 영업이익 132억원. 컨센서스 하회 2023년 영업이익률은 17.2%로 전년 대비 7%p 감소 하이엔드 및 차량용", "남궁현", LocalDateTime.now(), 120),
                new CompanyAnalyze(2,"현대위아", Opinion.BUY, "본업인 자동차 업황은 여전히 양호 예상보다 양호한 엔진 사업 모멘텀도 보유 중 본업인 자동차 업황은 여전히 양호 3Q23 전방 산업", "정용진", LocalDateTime.now(), 146),
                new CompanyAnalyze(3,"티에스아이", Opinion.BUY, "3Q23 Ultium Cells 등 북미 JV 추정 물량 연이은 수주 전방 수요 및 정책 환경 변동성 속에서도 고객 다변화로 방어 시장과 섹터", "심원용", LocalDateTime.now(), 191),
                new CompanyAnalyze(4,"동아에스티", Opinion.BUY, "3Q23 Pre; 매출은 줄고, 비용은 늘고 실적은 아쉽지만 새로운 무기들이 생기는 중 투자의견 유지, 목표주가 7만원으로 하향", "정재원", LocalDateTime.now(), 120)
                ));
    }
    public List<ResponseCompanyAnalyzeDTO> getCompanyAnalyzes() {
        return companyAnalyzes.stream().map(ResponseCompanyAnalyzeDTO::of).toList();
    }

    public ResponseCompanyAnalyzeDTO getCompanyAnalyze(long id) {
        return companyAnalyzes.stream().
                filter(company -> company.getId() == id).findFirst().map(ResponseCompanyAnalyzeDTO::of).orElseThrow();
    }

    public void createCompanyAnalyze(PostCompanyAnalyzeDTO postCompanyAnalyzeDTO) {
        companyAnalyzes.add(
                new CompanyAnalyze(companyAnalyzes.size() + 1
                        , postCompanyAnalyzeDTO.getName(),
                        postCompanyAnalyzeDTO.getOpinion(),
                        postCompanyAnalyzeDTO.getExplanation(),
                        postCompanyAnalyzeDTO.getAuthor(),
                        postCompanyAnalyzeDTO.getCreatedAt(),
                        postCompanyAnalyzeDTO.getViews()
                ));
    }


    public void updateCompanyAnalyze(UpdateCompanyAnalyzeDTO updateCompanyAnalyzeDTO, long id) {
        CompanyAnalyze companyAnalyze = companyAnalyzes.stream().filter(company -> company.getId() == id).findFirst().orElseThrow();
        companyAnalyze.setName(updateCompanyAnalyzeDTO.getName());
        companyAnalyze.setAuthor(updateCompanyAnalyzeDTO.getAuthor());
        companyAnalyze.setOpinion(updateCompanyAnalyzeDTO.getOpinion());
        companyAnalyze.setViews(updateCompanyAnalyzeDTO.getViews());
        companyAnalyze.setCreatedAt(LocalDateTime.now());
    }

    public void deleteCompanyAnalyze(long id) {
        companyAnalyzes.remove(
        companyAnalyzes.stream().
                filter(company -> company.getId() == id).findFirst().orElseThrow());
    }
}
