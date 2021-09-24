package uk.ac.herc.iminds.service.dto;

import org.springframework.web.bind.annotation.RequestParam;
import uk.ac.herc.iminds.domain.enumeration.AppType;

public class GenerateUniqueCodeDTO {
    private String deviceId;
    private AppType appType;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public AppType getAppType() {
        return appType;
    }

    public void setAppType(AppType appType) {
        this.appType = appType;
    }
}
