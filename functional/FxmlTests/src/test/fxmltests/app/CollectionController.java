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
package test.fxmltests.app;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author Victor Shubov
 */
public class CollectionController
{
    static int callCount = 0;

    public void handleListChangeEvent(ListChangeListener.Change change)
    {
        System.out.println("arg class: " + change.getClass().getName());
        if (change instanceof ListChangeListener.Change){
       // System.out.println("was added (y/n): " + change.wasAdded());

            ObservableList<String> tt  = change.getList();
            for (String str : tt){
                System.out.println(str);
                callCount++;
            }
       }
    }
}

