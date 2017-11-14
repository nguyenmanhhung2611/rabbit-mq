package vn.easycredit.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import vn.easycredit.config.setting.SwaggerSetting;

/**
 * 
 * @author HienNT
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private SwaggerSetting swaggerSetting;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("vn.easycredit.controller"))
                .build()
                .apiInfo(swaggerSetting.getInfo().asSwaggerApiInfo())
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .globalResponseMessage(RequestMethod.POST, swaggerSetting.getGlobalResponseMessages());
    }
}
