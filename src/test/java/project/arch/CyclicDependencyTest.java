package project.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

/**
 * The type Cyclic dependency test.
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "project")
public class CyclicDependencyTest {
    /**
     * The constant no_cyclic_dependencies.
     */
    @ArchTest
    public static final ArchRule no_cyclic_dependencies = slices()
            .matching("project.(*)..").should().beFreeOfCycles();
}
