package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String testId) {
        myLogger.log("service id = " + testId);
    }
}