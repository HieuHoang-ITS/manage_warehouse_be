package com.warehouse.event;

import java.time.Instant;
import java.util.Date;
import org.springframework.context.ApplicationEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnUserLogoutSuccessEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private final String loginId;
    private final String token;
    private final transient String logOutRequest;
    private final Date eventTime;

    public OnUserLogoutSuccessEvent(String loginId, String token, String logOutRequest) {
        super(loginId);
        this.loginId = loginId;
        this.token = token;
        this.logOutRequest = logOutRequest;
        this.eventTime = Date.from(Instant.now());
    }
}
