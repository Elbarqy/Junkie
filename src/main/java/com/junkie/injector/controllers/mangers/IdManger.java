package com.junkie.injector.controllers.mangers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("application")
public class IdManger {
    private Long junkieCount;
    private Long medsCount;
    private Long junkieInjectionCount;
    public Long getMedsCount() {
        return medsCount;
    }

    public IdManger() {
        this.junkieCount = 0L;
        this.medsCount = 0L;
        this.junkieInjectionCount = 0L;
    }

    public Long getJunkieCount() {
        return junkieCount;
    }

    public void setJunkieCount(Long junkieCount) {
        this.junkieCount = junkieCount;
    }

    public void setMedsCount(Long medsCount) {
        this.medsCount = medsCount;
    }

    public Long getJunkieInjectionCount() {
        return junkieInjectionCount;
    }

    public void setJunkieInjectionCount(Long junkieInjectionCount) {
        this.junkieInjectionCount = junkieInjectionCount;
    }
}