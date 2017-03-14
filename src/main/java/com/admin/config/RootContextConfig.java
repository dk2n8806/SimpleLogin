package com.admin.config;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.admin.config.secure.SpringSecurityConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration																			
@EnableScheduling
@EnableAsync(
				mode=AdviceMode.PROXY,  proxyTargetClass=false,
				order=Ordered.HIGHEST_PRECEDENCE
)			
@ComponentScan(
			basePackages={"com.core", "com.common"},
			excludeFilters=@ComponentScan.Filter({Controller.class, ControllerAdvice.class})
		)
@Import({PersistenceConfig.class, SpringSecurityConfig.class})
public class RootContextConfig 
		implements AsyncConfigurer, SchedulingConfigurer {

	private static final Logger LOG = LogManager.getLogger(RootContextConfig.class);

	
	@Bean
	public MessageSource messageSource() 
	{
		ReloadableResourceBundleMessageSource messageSource =
											new ReloadableResourceBundleMessageSource();
		messageSource.setCacheSeconds(-1);
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		messageSource.setBasenames(
							                "/WEB-INF/i18n/titles", "/WEB-INF/i18n/messages",
							                "/WEB-INF/i18n/errors", "/WEB-INF/i18n/validation"
							                );
		return messageSource;
	}
	

	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        return mapper;
	}
	
	
	
	@Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(new String[] { "com" });
        return marshaller;
    }
	
	
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		return validator;
	}
	
	@Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        MethodValidationPostProcessor processor =
                new MethodValidationPostProcessor();
        processor.setValidator(this.localValidatorFactoryBean());
        return processor;
    }

	
    
	 @Bean
	    public ThreadPoolTaskScheduler taskScheduler()
	    {
	        LOG.info("Setting up thread pool task scheduler with 20 threads.");
	        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
	        scheduler.setPoolSize(20);
	        scheduler.setThreadNamePrefix("task-");
	        scheduler.setAwaitTerminationSeconds(60);
	        scheduler.setWaitForTasksToCompleteOnShutdown(true);
	      /*  scheduler.setErrorHandler(t -> SCHEDULING_LOG.error(
	                "Unknown error occurred while executing task.", t ));
	        scheduler.setRejectedExecutionHandler(
	                (r, e) -> SCHEDULING_LOG.error(
	                        "Execution of task {} was rejected for unknown reasons.", r ));
	        */
	        return scheduler;
	    }
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		TaskScheduler scheduler = this.taskScheduler();
		LOG.info("Configuring shceduled method executor {}." + scheduler);
		taskRegistrar.setTaskScheduler(scheduler);
	}

	@Override
	public Executor getAsyncExecutor() {
		Executor executor = this.taskScheduler();
		LOG.info("Configuring asynchronous method executor {}." + executor);
		return executor;
	}

	
	
	
	
	
	
}
