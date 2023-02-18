package bd.gov.plandiv.pdts.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CustomWebMvcAutoConfig implements WebMvcConfigurer {
    @Value("${extern.resources.path}")
    private String path;
    @Value("${extern.resources.Dir}")
    private String resourceDir;


    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/"+resourceDir+"/**").addResourceLocations("file:"+path);
    }


}
