/*
 * Copyright 2003-2005 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ant.dotnet;

import org.apache.tools.ant.BuildFileTest;

/**
 * Tests the MSBuildTask task.
 */
public class MSBuildTaskTest extends BuildFileTest {

    /**
     * Description of the Field
     */
    private final static String TASKDEFS_DIR = "src/etc/testcases/";

    /**
     * Constructor 
     *
     * @param name testname
     */
    public MSBuildTaskTest(String name) {
        super(name);
    }

    /**
     * The JUnit setup method
     */
    public void setUp() {
        configureProject(TASKDEFS_DIR + "msbuild.xml");
    }

    public void testEcho() throws Exception {
        if (getProject().getProperty("msbuild.found") != null) {
            expectLogContaining("echo", "foo is bar");
        }
    }

    public void testNestedFile() throws Exception {
        if (getProject().getProperty("msbuild.found") != null) {
            expectLogContaining("nested-file", "foo is bar");
        }
    }

    public void testNestedTask() throws Exception {
        if (getProject().getProperty("msbuild.found") != null) {
            expectLogContaining("nested-task", "foo is bar");
        }
    }
}