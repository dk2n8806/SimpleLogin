package com;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.admin.config.RestServletContextConfiguration;
import com.admin.config.RootContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
							classes={RootContextConfig.class, RestServletContextConfiguration.class})
@WebAppConfiguration
public class BaseTest{

}
