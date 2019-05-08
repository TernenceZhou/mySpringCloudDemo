package enjoy.controller;

import enjoy.config.InfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${spring.datasource.username}")
    private String userName;

    @Autowired
    private InfoConfig infoConfig;

    @RequestMapping("/config")
    public String getConfig() {
        return "ApplicationName = " + this.applicationName + "、EurekaServers = "
                + this.eurekaServers+"、 datasourceName="+userName+"、infoConfig  "+infoConfig.getCompanyName();
    }
}
