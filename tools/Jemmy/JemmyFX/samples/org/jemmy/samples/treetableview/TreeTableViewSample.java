/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.jemmy.samples.treetableview;

import java.util.Date;
import java.util.List;
import org.jemmy.fx.SceneDock;
import org.jemmy.Point;
import org.jemmy.fx.control.TextFieldCellEditor;
import org.jemmy.fx.control.TreeTableCellItemDock;
import org.jemmy.fx.control.TreeTableItemDock;
import org.jemmy.fx.control.TreeTableViewDock;
import org.jemmy.lookup.LookupCriteria;
import org.jemmy.resources.StringComparePolicy;
import org.jemmy.samples.SampleBase;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alexander Kirov
 */
public class TreeTableViewSample extends SampleBase {

    private static SceneDock scene;
    private static TreeTableViewDock treeTableView;

    @BeforeClass
    public static void launch() throws InterruptedException {
        startApp(TreeTableViewApp.class);
        scene = new SceneDock();

        /**
         * Looking up for TableView control. The best option is to do that by
         * id.
         */
        treeTableView = new TreeTableViewDock(scene.asParent(), TreeTableViewApp.TREE_TABLE_VIEW_ID);

        //Set an editor right away.
        treeTableView.asTable().setEditor(new TextFieldCellEditor<Object>());
    }

    /**
     * Will expand and collapse a treeItem. An operation, related to tree
     * structure of data.
     */
    @Test
    public void expandingCollapsing() throws InterruptedException {
        //Collapse some inside item.
        TreeTableItemDock treeTableItemDock = new TreeTableItemDock(treeTableView.asTreeItemParent(), treeTableView.wrap(), "0-0");
        treeTableItemDock.collapse();

        //Collapse root.
        TreeTableItemDock rootItemDock = new TreeTableItemDock(treeTableView.wrap().getRootWrap());
        rootItemDock.collapse();
    }

    /**
     * TableView lookup is no different than other components - check the lookup
     * samples, table item lookup is another matter.
     */
    @Test
    public void lookup() {
        //You could find a cell by it's content.
        new TreeTableCellItemDock(treeTableView.asTable(), "0-1-lastname").asEditableCell().select();
        //By coordinates.
        new TreeTableCellItemDock(treeTableView.asTable(), 1, 1).asEditableCell().select();
        //By toString() of the object.
        new TreeTableCellItemDock(treeTableView.asTable(), "0-2-first", StringComparePolicy.SUBSTRING).asEditableCell().select();
        //Or any other way by creating a custom lookup criteria.
        new TreeTableCellItemDock(treeTableView.asTable(), new LookupCriteria<Object>() {
            public boolean check(Object cntrl) {
                return cntrl instanceof Date;
            }
        }).asEditableCell().select();
    }

    /**
     * Selecting a cell by column and row indexes.
     */
    @Test
    public void selectCellByColumnAndRow() {
        new TreeTableCellItemDock(treeTableView.asTable(), 2, 2).asEditableCell().select();
        //or
        treeTableView.asTable().select(new Point(3, 3));
    }

    /**
     * Scrolling happens automatically when you are trying to select a cell.
     * Should you need the scrolling anyway ...
     */
    @Test
    public void scrollToCell() {
        new TreeTableCellItemDock(treeTableView.asTable(), "0-3-3-3-lastname").shower().show();
    }

    /**
     * Getting information on the table size
     */
    @Test
    public void getTableSize() {
        System.out.println("tableView has " + treeTableView.getColumns().size() + " columns and " + treeTableView.getItems().size() + " rows.");
    }

    /**
     * Selecting multiple cells.
     */
    @Test
    public void selectMultipleCells() {
        treeTableView.asTable().select(new Point(1, 1), new Point(2, 2), new Point(3, 3));
    }

    /**
     * Editing cell value.
     */
    @Test
    public void editCell() {
        new TreeTableCellItemDock(treeTableView.asTable(), 2, 2).asEditableCell().edit("Kirov");
    }

    /**
     * Sorting by field.
     */
    @Test
    public void sort() {
        // No direct API for that http://javafx-jira.kenai.com/browse/JMY-170
    }

    /**
     * Getting selected cells
     */
    @Test
    public void getSelectedCells() {
        new TreeTableCellItemDock(treeTableView.asTable(), "0-2-first", StringComparePolicy.SUBSTRING).asEditableCell().select();
        List<Point> selection = treeTableView.getSelectedCells();
        System.out.println("Selected indices are = " + selection);
        System.out.println("While actual are = " + treeTableView.control().getSelectionModel().getSelectedIndices());
    }
}
