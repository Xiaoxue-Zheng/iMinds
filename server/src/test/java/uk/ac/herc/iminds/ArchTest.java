package uk.ac.herc.iminds;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("uk.ac.herc.iminds");

        noClasses()
            .that()
            .resideInAnyPackage("uk.ac.herc.iminds.service..")
            .or()
            .resideInAnyPackage("uk.ac.herc.iminds.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..uk.ac.herc.iminds.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
