package uk.ac.herc.iminds.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;
import uk.ac.herc.iminds.domain.UniqueCode;
import uk.ac.herc.iminds.domain.enumeration.AppType;
import uk.ac.herc.iminds.repository.UniqueCodeRepository;
import uk.ac.herc.iminds.service.UniqueCodeService;
import uk.ac.herc.iminds.service.dto.GenerateUniqueCodeDTO;
import uk.ac.herc.iminds.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link uk.ac.herc.iminds.domain.UniqueCode}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class UniqueCodeResource {

    private final Logger log = LoggerFactory.getLogger(UniqueCodeResource.class);

    private final UniqueCodeService uniqueCodeService;

    public UniqueCodeResource(UniqueCodeService uniqueCodeService) {
        this.uniqueCodeService = uniqueCodeService;
    }

    @PostMapping("/unique-codes")
    public ResponseEntity<String> generateUniqueCode(@Valid @RequestBody GenerateUniqueCodeDTO generateUniqueCodeDTO) throws URISyntaxException {
        return ResponseEntity.status(HttpStatus.CREATED).body(uniqueCodeService.generateUniqueCode(generateUniqueCodeDTO));
    }

}
