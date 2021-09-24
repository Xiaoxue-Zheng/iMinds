package uk.ac.herc.iminds.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.security.RandomUtil;
import uk.ac.herc.iminds.domain.UniqueCode;
import uk.ac.herc.iminds.domain.enumeration.AppType;
import uk.ac.herc.iminds.domain.enumeration.UniqueCodeStatus;
import uk.ac.herc.iminds.repository.UniqueCodeRepository;
import uk.ac.herc.iminds.repository.UserRepository;
import uk.ac.herc.iminds.service.dto.GenerateUniqueCodeDTO;

import java.time.Instant;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class UniqueCodeService {
    private final Logger log = LoggerFactory.getLogger(UniqueCodeService.class);

    private final UniqueCodeRepository uniqueCodeRepository;

    public UniqueCodeService(UniqueCodeRepository uniqueCodeRepository) {
        this.uniqueCodeRepository = uniqueCodeRepository;
    }

    public String generateUniqueCode(GenerateUniqueCodeDTO generateUniqueCodeDTO){
        String deviceId = generateUniqueCodeDTO.getDeviceId();
        AppType appType = generateUniqueCodeDTO.getAppType();
        UniqueCode uniqueCode = new UniqueCode();
        uniqueCode.setAppType(appType);
        uniqueCode.setDeviceId(deviceId);
        uniqueCode.setStatus(UniqueCodeStatus.NEW);
        uniqueCode.setCreateTime(Instant.now());
        uniqueCode.setCode(nextUniqueCode());
        saveWithRetry(uniqueCode);
        return uniqueCode.getCode();
    }

    private void saveWithRetry(UniqueCode uniqueCode){
        try {
            uniqueCodeRepository.save(uniqueCode);
        } catch (ConstraintViolationException exception){
            if(exception.getConstraintName().equalsIgnoreCase("ux_unique_code__code")){
                uniqueCode.setCode(nextUniqueCode());
                uniqueCodeRepository.save(uniqueCode);
            }
        }
    }

    private String nextUniqueCode(){
        return RandomStringUtils.randomAlphabetic(7).toUpperCase(Locale.ROOT);
    }

}
