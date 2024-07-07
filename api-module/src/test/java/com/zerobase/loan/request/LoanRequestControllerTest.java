package com.zerobase.loan.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerobase.domain.UserInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoanRequestController.class)
public class LoanRequestControllerTest {

    @MockBean
    private LoanRequestService loanRequestService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private final String baseUrl = "/fintech/api/v1";



    @Test
    @DisplayName("유저 요청이 들어오면 정상 응답을 주어야 한다.")
    void testNormalCase() throws Exception {
        // given
        LoanRequestInputDto loanRequestInfoDto = new LoanRequestInputDto(
                "TEST", 10000L, "000101-1234567");

        when(loanRequestService.saveUserInfo(any())).thenReturn(new UserInfo(2L, "", "","", 1L));

        // when // then
        mockMvc.perform(post(baseUrl + "/request")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(loanRequestInfoDto)))
                .andExpect(status().isOk());
    }
}
