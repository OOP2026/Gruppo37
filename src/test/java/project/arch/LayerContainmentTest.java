package project.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * The type Layer containment test.
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "project")
public class LayerContainmentTest {
    /**
     * The constant controllers_reside_in_the_controller_layer.
     */
    @ArchTest
    public static final ArchRule controllers_reside_in_the_controller_layer = classes()
            .that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("project.controller");

    /**
     * The constant controllers_only_reside_in_the_controller_layer.
     */
    @ArchTest
    public static final ArchRule controllers_only_reside_in_the_controller_layer = noClasses()
            .that().haveSimpleNameNotEndingWith("Controller")
            .should().resideInAPackage("project.controller");

    /**
     * The constant DAOs_reside_in_the_DAO_layer.
     */
    @ArchTest
    public static final ArchRule DAOs_reside_in_the_DAO_layer = classes()
            .that().haveSimpleNameEndingWith("DAO")
            .and().haveSimpleNameNotEndingWith("Dao")
            .should().resideInAPackage("project.dao");

    /**
     * The constant DAOs_only_reside_in_the_DAO_layer.
     */
    @ArchTest
    public static final ArchRule DAOs_only_reside_in_the_DAO_layer = noClasses()
            .that().haveSimpleNameNotEndingWith("DAO")
            .should().resideInAPackage("project.dao");

    /**
     * The constant DAO_implementations_reside_in_the_DAO_implementation_layer.
     */
    @ArchTest
    public static final ArchRule DAO_implementations_reside_in_the_DAO_implementation_layer = classes()
            .that().haveSimpleNameEndingWith("Dao")
            .should().resideInAPackage("project.implementazioneDao");

    /**
     * The constant DAO_implementations_only_reside_in_the_DAO_implementation_layer.
     */
    @ArchTest
    public static final ArchRule DAO_implementations_only_reside_in_the_DAO_implementation_layer = noClasses()
            .that().haveSimpleNameNotEndingWith("Dao")
            .should().resideInAPackage("project.implementazioneDao");

    /**
     * The constant GUIs_reside_in_the_GUI_layer.
     */
    @ArchTest
    public static final ArchRule GUIs_reside_in_the_GUI_layer = classes()
            .that().haveSimpleNameEndingWith("src/java/gui")
            .should().resideInAPackage("project.gui");

    /**
     * The constant GUIs_only_reside_in_the_GUI_layer.
     */
    @ArchTest
    public static final ArchRule GUIs_only_reside_in_the_GUI_layer = noClasses()
            .that().haveSimpleNameNotEndingWith("src/java/gui")
            .should().resideInAPackage("project.gui");
}
