package uk.ac.herc.iminds.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import uk.ac.herc.iminds.ImindsApp;

@CucumberContextConfiguration
@SpringBootTest(classes = ImindsApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
