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
package test.scenegraph.fx3d.camera.parallel;

import org.junit.BeforeClass;
import org.jemmy.fx.Root;
import org.jemmy.image.ImageComparator;
import org.jemmy.image.glass.GlassPixelImageComparator;
import org.jemmy.image.pixel.PixelEqualityRasterComparator;
import test.scenegraph.fx3d.camera.CameraAsChildTests;
import test.scenegraph.fx3d.interfaces.camera.CameraAsChildTestingFace;
import test.scenegraph.fx3d.utils.FX3DAbstractApp;

/**
 *
 * @author Andrew Glushchenko
 */
public class ParallelCameraAsChildTest extends CameraAsChildTests {

    private static ParallelCameraAsChildTestApp app;

    @BeforeClass
    public static void setUp(){
        Root.ROOT.getEnvironment().setProperty(ImageComparator.class,
            new GlassPixelImageComparator(new
                PixelEqualityRasterComparator(FX3DAbstractApp.COLOR_TOLERANCE)));
        ParallelCameraAsChildTestApp.main(null);
        app = (ParallelCameraAsChildTestApp) ParallelCameraAsChildTestApp.getInstance();
    }

    @Override
    protected CameraAsChildTestingFace getCameraAsChildTestingFace() {
        return app;
    }

    @Override
    protected FX3DAbstractApp getApplication() {
        return app;
    }


}
