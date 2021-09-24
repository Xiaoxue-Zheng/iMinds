package uk.ac.herc.iminds.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uk.ac.herc.iminds.web.rest.TestUtil;

class UniqueCodeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UniqueCode.class);
        UniqueCode uniqueCode1 = new UniqueCode();
        uniqueCode1.setId(1L);
        UniqueCode uniqueCode2 = new UniqueCode();
        uniqueCode2.setId(uniqueCode1.getId());
        assertThat(uniqueCode1).isEqualTo(uniqueCode2);
        uniqueCode2.setId(2L);
        assertThat(uniqueCode1).isNotEqualTo(uniqueCode2);
        uniqueCode1.setId(null);
        assertThat(uniqueCode1).isNotEqualTo(uniqueCode2);
    }
}
