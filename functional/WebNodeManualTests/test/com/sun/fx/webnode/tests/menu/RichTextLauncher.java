/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.fx.webnode.tests.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Irina Grineva
 */
public class RichTextLauncher extends Application {

    private WebView view = null;
    private HTMLEditor htmlEditor;


    private Scene createScene(String url) {
        view = new WebView();
        htmlEditor =  new HTMLEditor();

        view.getEngine().load(url);

        final VBox box = new VBox();
        view.setMaxHeight(300);
        view.setMinHeight(300);
        htmlEditor.setMaxHeight(300);
        htmlEditor.setMinHeight(300);
        box.getChildren().addAll(view, htmlEditor);

        final Scene scene = new Scene(box);

        scene.setFill(Color.GRAY);
        return scene;
    }

    @Override
    public void start(Stage stage) {
        final Scene scene = createScene(getParameters().getRaw().get(0));
        stage.setTitle("Launcher");
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.sizeToScene();
        stage.show();
    }

    public static void run(final String url) {
        final String[] args = new String[] {url};
        new Thread(new Runnable() {

            public void run() {
                Application.launch(RichTextLauncher.class, args);
            }
        }, "FXSQE app launch thread").start();
    }

}
