package test.scenegraph.binding.shapes;

/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */


import org.junit.BeforeClass;
import org.junit.Test;
import test.scenegraph.binding.*;
import com.oracle.jdk.sqe.cc.markup.Covers;
import com.oracle.jdk.sqe.cc.markup.Covers.Level;

public class QuadCurveToTest extends BindingTestBase {
    @BeforeClass
    public static void runUI() {
        BindingApp.factory = Factories.QuadCurveTo;
        BindingApp.main(null);
    }

    public static void main(String[] args) {
        runUI();
    }

    /**
    * This test verifies strokeType property for shapes.QuadCurveTo
    */
    @Test
    public void strokeType() {
        commonTest(ObjectConstraints.strokeType);
    }

    /**
    * This test verifies strokeWidth property for shapes.QuadCurveTo
    */
    @Test
    public void strokeWidth() {
        commonTest(NumberConstraints.strokeWidth);
    }

    /**
    * This test verifies strokeLineJoin property for shapes.QuadCurveTo
    */
    @Test
    public void strokeLineJoin() {
        commonTest(ObjectConstraints.strokeLineJoin);
    }

    /**
    * This test verifies strokeDashOffset property for shapes.QuadCurveTo
    */
    @Test
    public void strokeDashOffset() {
        commonTest(NumberConstraints.strokeDashOffset);
    }

    /**
    * This test verifies fill property for shapes.QuadCurveTo
    */
    @Test
    public void fill() {
        commonTest(ObjectConstraints.fill);
    }

    /**
    * This test verifies stroke property for shapes.QuadCurveTo
    */
    @Test
    public void stroke() {
        commonTest(ObjectConstraints.stroke);
    }

    /**
    * This test verifies opacity property for shapes.QuadCurveTo
    */
    @Test
    public void opacity() {
        commonTest(NumberConstraints.opacity);
    }

    /**
    * This test verifies blendMode property for shapes.QuadCurveTo
    */
    @Test
    public void blendMode() {
        commonTest(ObjectConstraints.blendMode);
    }

    /**
    * This test verifies clip property for shapes.QuadCurveTo
    */
    @Test
    public void clip() {
        commonTest(ObjectConstraints.clip);
    }

    /**
    * This test verifies effect property for shapes.QuadCurveTo
    */
    @Test
    public void effect() {
        commonTest(ObjectConstraints.effect);
    }

    /**
    * This test verifies layoutX property for shapes.QuadCurveTo
    */
    @Test
    public void layoutX() {
        commonTest(NumberConstraints.layoutX);
    }

    /**
    * This test verifies layoutY property for shapes.QuadCurveTo
    */
    @Test
    public void layoutY() {
        commonTest(NumberConstraints.layoutY);
    }

    /**
    * This test verifies translateX property for shapes.QuadCurveTo
    */
    @Test
    public void translateX() {
        commonTest(NumberConstraints.translateX);
    }

    /**
    * This test verifies translateY property for shapes.QuadCurveTo
    */
    @Test
    public void translateY() {
        commonTest(NumberConstraints.translateY);
    }

    /**
    * This test verifies scaleX property for shapes.QuadCurveTo
    */
    @Test
    public void scaleX() {
        commonTest(NumberConstraints.scaleX);
    }

    /**
    * This test verifies scaleY property for shapes.QuadCurveTo
    */
    @Test
    public void scaleY() {
        commonTest(NumberConstraints.scaleY);
    }

    /**
    * This test verifies rotate property for shapes.QuadCurveTo
    */
    @Test
    public void rotate() {
        commonTest(NumberConstraints.rotate);
    }

}
