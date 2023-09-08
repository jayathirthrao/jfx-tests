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
package test.scenegraph.fx3d.lod;

import org.junit.BeforeClass;

/**
 *
 * @author Andrew Glushchenko
 */
public class PerspectiveLodCameraTest extends LodTests {

    @BeforeClass
    public static void setUp() {
        PerspectiveLodCameraTestApp.main(null);
        application = (LodTestAbstractApp) PerspectiveLodCameraTestApp.getInstance();
    }

    @Override
    protected double getInitialLod(LodTestAbstractApp.ShapeType type) {
        switch (type) {
            case Sphere:
            case Cylinder:
            case Box:
                return 50180.137157440186;
            case Plane:
                return 0;
            case SemiSphere:
                return 224544.16751861572;
            case Cone:
                return 25090.068578720093;
        }
        return -1;
    }

    @Override
    protected double getChangedLod(LodTestAbstractApp.ShapeType type) {
        switch (type) {
            case Sphere:
            case Cylinder:
            case Box:
                return 40000.00283122063;
            case Plane:
                return 73418.63214969635;
            case SemiSphere:
                return 178710.10303497314;
            case Cone:
                return 20000.001415610313;
        }
        return -1;
    }
}
