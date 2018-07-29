package com.github.git_leon.jetpack_survivor_maven.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.github.git_leon.jetpack_survivor_maven.system.JFootPropertyType.*;

public class JFootPropertyTest {
    private JFootProperty mock;
    private String projectName;
    private String mainClassName;
    private String scenarioLock;
    private String hideControls;

    @Before
    public void testConstruction() {
        this.projectName = "The JFoot Experiment";
        this.mainClassName = "Doesn't Matter";
        this.scenarioLock = "true";
        this.hideControls = "false";
        this.mock = new JFootProperty(
                projectName,
                mainClassName,
                scenarioLock,
                hideControls);
    }

    @Test
    public void testProjectName() {
        Assert.assertEquals(projectName, mock.get(PROJECT_NAME));
    }


    @Test
    public void testMainClassName() {
        Assert.assertEquals(mainClassName, mock.get(MAIN_CLASS));
    }

    @Test
    public void testScenarioLock() {
        Assert.assertTrue(Boolean.valueOf(mock.get(SCENARIO_LOCK)));
    }

    @Test
    public void testHideControls() {
        Assert.assertFalse(Boolean.valueOf(mock.get(SCENARIO_HIDECONTROLS)));
    }
}
