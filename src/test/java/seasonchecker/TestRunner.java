package seasonchecker;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("seasonchecker")
public class TestRunner {

}