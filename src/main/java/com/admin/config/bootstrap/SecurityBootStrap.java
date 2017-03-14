package com.admin.config.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2)
public class SecurityBootStrap extends AbstractSecurityWebApplicationInitializer {

	private static final Logger log = LogManager.getLogger();

    @Override
    protected boolean enableHttpSessionEventPublisher()
    {
        log.info("Executing security bootstrap.");

        return true;
    }
}
