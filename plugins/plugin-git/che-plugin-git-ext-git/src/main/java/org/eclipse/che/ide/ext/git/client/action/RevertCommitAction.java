/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ext.git.client.action;

import static com.google.common.base.Preconditions.checkState;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Project;
import org.eclipse.che.ide.ext.git.client.GitLocalizationConstant;
import org.eclipse.che.ide.ext.git.client.GitResources;
import org.eclipse.che.ide.ext.git.client.revert.RevertCommitPresenter;

/** @author Dmitrii Bocharov (bdshadow) */
@Singleton
public class RevertCommitAction extends GitAction {
  private final RevertCommitPresenter presenter;

  @Inject
  public RevertCommitAction(
      RevertCommitPresenter presenter,
      AppContext appContext,
      GitLocalizationConstant constant,
      GitResources resources) {
    super(
        constant.revertCommitControlTitle(),
        constant.revertCommitControlPrompt(),
        resources.revert(),
        appContext);
    this.presenter = presenter;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    final Project project = appContext.getRootProject();

    checkState(project != null, "Null project occurred");

    presenter.show(project);
  }
}
