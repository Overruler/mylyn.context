/*******************************************************************************
 * Copyright (c) 2004, 2008 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.team.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.mylyn.context.sdk.util.ContextTestUtil;

/**
 * @author Mik Kersten
 */
public class AllTeamTests {

	public static Test suite() {
		ContextTestUtil.triggerContextUiLazyStart();

		TestSuite suite = new TestSuite("Test for org.eclipse.mylyn.team.tests");
		suite.addTestSuite(TestSyncViewRefresh.class);
		suite.addTestSuite(ChangeSetManagerTest.class);
		suite.addTestSuite(CommitTemplateTest.class);
		suite.addTestSuite(TeamPropertiesLinkProviderTest.class);
		suite.addTestSuite(TaskFinderTest.class);
		suite.addTestSuite(CommitTemplateVariablesTest.class);
		return suite;
	}

}
