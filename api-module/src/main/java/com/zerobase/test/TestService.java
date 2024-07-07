package com.zerobase.test;

import com.zerobase.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {

    private final UserInfoRepository userInfoRepository;

    public TestDto testGetService(String userKey) {
        return TestDto.toDto(
                userInfoRepository.findByUserKey(userKey).orElseThrow(
                        () -> new IllegalArgumentException("해당 사용자가 없습니다.")
                )
        );
    }
}
