package com.example.controller.companyAnalyze;

import com.example.DTO.companyAnalyze.PostCompanyAnalyzeDTO;
import com.example.DTO.companyAnalyze.ResponseCompanyAnalyzeDTO;
import com.example.DTO.companyAnalyze.UpdateCompanyAnalyzeDTO;
import com.example.common.Response;
import com.example.service.companyAnalyze.CompanyAnalyzeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CompanyAnalyzeController {
    private final CompanyAnalyzeService companyAnalyzeService;

    @GetMapping("/v2/companys")
    public Response<List<ResponseCompanyAnalyzeDTO>> getCompanyAnalyzes(){
        return Response.of(companyAnalyzeService.getCompanyAnalyzes());
    }
    @GetMapping("/v2/companys/{id}")
    public Response<ResponseCompanyAnalyzeDTO> getCompanyAnalyze(@PathVariable(value = "id") long id){
        return Response.of(companyAnalyzeService.getCompanyAnalyze(id));
    }

    @PostMapping("/v2/companys")
    public void createCompanyAnalyze(@RequestBody PostCompanyAnalyzeDTO postCompanyAnalyzeDTO){
        companyAnalyzeService.createCompanyAnalyze(postCompanyAnalyzeDTO);
    }
    @PutMapping("/v2/companys")
    public void updateCompanyAnalyze(@RequestBody UpdateCompanyAnalyzeDTO updateCompanyAnalyzeDTO, @PathVariable(value = "id") long id){
        companyAnalyzeService.updateCompanyAnalyze(updateCompanyAnalyzeDTO, id);
    }
    @DeleteMapping("/v2/companys/{id}")
    public void deleteCompanyAnalyze(@PathVariable(value = "id") long id){
        companyAnalyzeService.deleteCompanyAnalyze(id);
    }
}
