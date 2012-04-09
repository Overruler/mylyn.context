/*******************************************************************************
 * Copyright (c) 2004, 2010 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.context.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.mylyn.commons.ui.CommonImages;
import org.eclipse.swt.graphics.Image;

/**
 * @author Mik Kersten
 */
public class ContextUiImages {

	private static final String T_ELCL = "elcl16"; //$NON-NLS-1$

	private static final URL baseURL = ContextUiPlugin.getDefault().getBundle().getEntry("/icons/"); //$NON-NLS-1$

	public static final ImageDescriptor FILE_XML = create(T_ELCL, "file-xml.gif"); //$NON-NLS-1$

	public static final ImageDescriptor FILE_GENERIC = create(T_ELCL, "file_obj.gif"); //$NON-NLS-1$

	public static final ImageDescriptor FOLDER_GENERIC = create(T_ELCL, "fldr_obj.gif"); //$NON-NLS-1$

	public static final ImageDescriptor CONTEXT_FOCUS = create(T_ELCL, "focus.gif"); //$NON-NLS-1$

	private static ImageDescriptor create(String prefix, String name) {
		return create(prefix, name, baseURL);
	}

	private static ImageDescriptor create(String prefix, String name, URL baseURL) {
		try {
			return ImageDescriptor.createFromURL(makeIconFileURL(prefix, name, baseURL));
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}

	private static URL makeIconFileURL(String prefix, String name, URL baseURL) throws MalformedURLException {
		if (baseURL == null) {
			throw new MalformedURLException();
		}

		StringBuffer buffer = new StringBuffer(prefix);
		buffer.append('/');
		buffer.append(name);
		return new URL(baseURL, buffer.toString());
	}

	/**
	 * @deprecated use {@link CommonImages#getImage(ImageDescriptor)} instead
	 */
	@Deprecated
	public static Image getImage(ImageDescriptor imageDescriptor) {
		return CommonImages.getImage(imageDescriptor);
	}

}
