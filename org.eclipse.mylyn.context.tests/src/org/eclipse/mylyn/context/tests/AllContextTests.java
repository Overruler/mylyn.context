/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.context.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.mylyn.context.sdk.util.ContextTestUtil;

/**
 * @author Mik Kersten
 */
public class AllContextTests {

	public static Test suite() {
		ContextTestUtil.triggerContextUiLazyStart();

		TestSuite suite = new TestSuite(AllContextTests.class.getName());
		suite.addTestSuite(InteractionContextListeningTest.class);
		suite.addTestSuite(ScalingFactorsTest.class);
		suite.addTestSuite(InteractionContextTest.class);
		suite.addTestSuite(ContextExternalizerTest.class);
		suite.addTestSuite(DegreeOfInterestTest.class);
		suite.addTestSuite(ContextTest.class);
		suite.addTestSuite(InteractionEventTest.class);
		suite.addTestSuite(ShadowsBridgeTest.class);
		suite.addTestSuite(EditorStateParticipantTest.class);
		suite.addTestSuite(ToggleFocusActiveViewHandlerTest.class);
		return suite;
	}

}
