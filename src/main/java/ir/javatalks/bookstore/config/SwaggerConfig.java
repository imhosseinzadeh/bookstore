package ir.javatalks.bookstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title(ApplicationInfoUtil.TITLE)
                .description(ApplicationInfoUtil.DESCRIPTION)
                .version(ApplicationInfoUtil.VERSION)
                .license(ApplicationInfoUtil.LICENSE)
                .contact(ApplicationInfoUtil.CONTACT));
    }

    @UtilityClass
    private static class ApplicationInfoUtil {

        public static final String TITLE = "BookStoreApplication";
        public static final String DESCRIPTION = "This application helps book sellers to sell their books easily";
        public static final String VERSION = "1.0";

        private static final String CONTACT_NAME = "Iman Hosseinzadeh";
        private static final String CONTACT_EMAIL = "Imhosseinzadeh@gmail.com";
        private static final String CONTACT_URL = "ImanHosseinzadeh.com";

        public static final Contact CONTACT = new Contact().name(CONTACT_NAME).email(CONTACT_EMAIL).url(CONTACT_URL);

        private static final String LICENSE_NAME = "License 2023";
        private static final String LICENSE_URL = "License Url";

        public static final License LICENSE = new License().name(LICENSE_NAME).url(LICENSE_URL);
    }

}

