/*
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.javafx.experiments.ensemble2.samples.controls.tree;

import java.util.Arrays;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import com.javafx.experiments.ensemble2.Sample;

/**
 * The TreeView control provides a view on to a tree root, which subsequently
 * allows for drilling down into the children of the root node, and subsequently
 * their children recursively until you reach leaf nodes.
 *
 *  @see javafx.scene.control.TreeView
 */
public class TreeViewSample extends Sample {
    public TreeViewSample() {
        final TreeItem<String> root = new TreeItem<String>("Root node");
        root.getChildren().addAll(Arrays.asList(new TreeItem<String>("Child Node 1"), new TreeItem<String>("Child Node 2"), new TreeItem<String>("Child Node 3")));

        root.getChildren()
                .get(2)
                .getChildren()
                .addAll(Arrays.asList(new TreeItem<String>("Child Node 4"), new TreeItem<String>("Child Node 5"), new TreeItem<String>("Child Node 6"), new TreeItem<String>("Child Node 7"),
                        new TreeItem<String>("Child Node 8"), new TreeItem<String>("Child Node 9"), new TreeItem<String>("Child Node 10"), new TreeItem<String>("Child Node 11"), new TreeItem<String>(
                                "Child Node 12")));

        final TreeView treeView = new TreeView();
        treeView.setShowRoot(true);
        treeView.setRoot(root);
        root.setExpanded(true);

        getChildren().add(treeView);
    }

}
