package uk.ac.herc.iminds.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.herc.iminds.IntegrationTest;
import uk.ac.herc.iminds.domain.UniqueCode;
import uk.ac.herc.iminds.domain.enumeration.AppType;
import uk.ac.herc.iminds.domain.enumeration.UniqueCodeStatus;
import uk.ac.herc.iminds.repository.UniqueCodeRepository;
import uk.ac.herc.iminds.service.UniqueCodeService;
import uk.ac.herc.iminds.service.dto.GenerateUniqueCodeDTO;
import uk.ac.herc.iminds.web.rest.errors.ExceptionTranslator;

/**
 * Integration tests for the {@link UniqueCodeResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UniqueCodeResourceIT {
    static final String ENTITY_API_URL = "/api/unique-codes";

    @Autowired
    private UniqueCodeRepository uniqueCodeRepository;

    @Mock
    private UniqueCodeRepository mockUniqueCodeRepository;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMvc;

    @Autowired
    private MockMvc restUniqueCodeMockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        UniqueCodeService mockUniqueCodeService = new UniqueCodeService(mockUniqueCodeRepository);
        UniqueCodeResource uniqueCodeResource = new UniqueCodeResource(mockUniqueCodeService);
        this.restUniqueCodeMockMvc = MockMvcBuilders.standaloneSetup(uniqueCodeResource)
            .setControllerAdvice(exceptionTranslator)
            .build();
    }


    @Test
    @Transactional
    void createUniqueCode() throws Exception {
        int databaseSizeBeforeCreate = uniqueCodeRepository.findAll().size();
        // Create the UniqueCode
        GenerateUniqueCodeDTO generateUniqueCodeDTO = new GenerateUniqueCodeDTO();
        generateUniqueCodeDTO.setDeviceId(RandomStringUtils.randomAlphabetic(3));
        generateUniqueCodeDTO.setAppType(AppType.ANDROID);
        restMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(generateUniqueCodeDTO)))
            .andExpect(status().isCreated());

        // Validate the UniqueCode in the database
        List<UniqueCode> uniqueCodeList = uniqueCodeRepository.findAll();
        assertThat(uniqueCodeList).hasSize(databaseSizeBeforeCreate + 1);
        UniqueCode testUniqueCode = uniqueCodeList.get(uniqueCodeList.size() - 1);
        assertThat(testUniqueCode.getDeviceId()).isEqualTo(generateUniqueCodeDTO.getDeviceId());
        assertThat(testUniqueCode.getAppType()).isEqualTo(generateUniqueCodeDTO.getAppType());
        assertThat(testUniqueCode.getStatus()).isEqualTo(UniqueCodeStatus.NEW);
    }

    @Test
    @Transactional
    void createUniqueCodeWithRetry() throws Exception {
        // Create the UniqueCode
        GenerateUniqueCodeDTO generateUniqueCodeDTO = new GenerateUniqueCodeDTO();
        generateUniqueCodeDTO.setDeviceId(RandomStringUtils.randomAlphabetic(3));
        generateUniqueCodeDTO.setAppType(AppType.ANDROID);

        when(mockUniqueCodeRepository.save(any()))
            .thenThrow(new ConstraintViolationException("violation happened", null, "ux_unique_code__code"))
            .thenReturn(any(UniqueCode.class));

        restUniqueCodeMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(generateUniqueCodeDTO)))
            .andExpect(status().isCreated());
    }




}
