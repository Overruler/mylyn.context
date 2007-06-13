/*******************************************************************************
 * Copyright (c) 2004 - 2006 Mylar committers and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.mylyn.team.ui;

import java.util.List;

import org.eclipse.mylyn.context.core.ContextCorePlugin;
import org.eclipse.mylyn.context.core.IInteractionContextListener;
import org.eclipse.mylyn.context.core.IInteractionElement;
import org.eclipse.mylyn.tasks.core.AbstractTaskContainer;
import org.eclipse.mylyn.tasks.core.DateRangeContainer;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.ITaskActivityListener;
import org.eclipse.mylyn.tasks.core.ITaskListChangeListener;
import org.eclipse.mylyn.tasks.ui.TasksUiPlugin;

/**
 * @author Mik Kersten
 */
public abstract class AbstractContextChangeSetManager implements IInteractionContextListener {

	protected boolean isEnabled = false;
		
	public void enable() {
		if (!isEnabled) {
			ContextCorePlugin.getContextManager().addListener(this);
			TasksUiPlugin.getTaskListManager().getTaskList().addChangeListener(TASK_CHANGE_LISTENER);
			TasksUiPlugin.getTaskListManager().addActivityListener(TASK_ACTIVITY_LISTENER);
			if (TasksUiPlugin.getTaskListManager().isTaskListInitialized()) {
				initContextChangeSets(); // otherwise listener will do it
			}
			isEnabled = true;
		}
	}

	public void disable() {
		ContextCorePlugin.getContextManager().removeListener(this);
		TasksUiPlugin.getTaskListManager().removeActivityListener(TASK_ACTIVITY_LISTENER);
		TasksUiPlugin.getTaskListManager().getTaskList().removeChangeListener(TASK_CHANGE_LISTENER);
		isEnabled = false;
	}
	
	protected abstract void initContextChangeSets();
	
	protected abstract void updateChangeSetLabel(ITask task);
	
	private ITaskActivityListener TASK_ACTIVITY_LISTENER = new ITaskActivityListener() {

		public void taskListRead() {
			initContextChangeSets();
		}

		public void taskActivated(ITask task) {
			// ignore
		}

		public void tasksActivated(List<ITask> tasks) {
			// ignore
		}

		public void taskDeactivated(ITask task) {
			// ignore
		}

		public void activityChanged(DateRangeContainer week) {
			// ignore
		}

		public void calendarChanged() {
			// ignore
		}
	};

	private ITaskListChangeListener TASK_CHANGE_LISTENER = new ITaskListChangeListener() {

		public void localInfoChanged(ITask task) {
			updateChangeSetLabel(task);
		}

		public void repositoryInfoChanged(ITask task) {
			// ignore
		}

		public void taskMoved(ITask task, AbstractTaskContainer fromContainer, AbstractTaskContainer toContainer) {
			// ignore
		}

		public void taskDeleted(ITask task) {
			// ignore
		}

		public void containerAdded(AbstractTaskContainer container) {
			// ignore
		}

		public void containerDeleted(AbstractTaskContainer container) {
			// ignore
		}

		public void taskAdded(ITask task) {
			// ignore
		}

		public void containerInfoChanged(AbstractTaskContainer container) {
			// ignore
		}
	};

	public void elementDeleted(IInteractionElement node) {
		// TODO: handle?
	}

	public void landmarkAdded(IInteractionElement node) {
		// ignore
	}

	public void landmarkRemoved(IInteractionElement node) {
		// ignore
	}

	public void relationsChanged(IInteractionElement node) {
		// ignore
	}
}