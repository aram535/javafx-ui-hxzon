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
package com.javafx.experiments.ensemble2.samples.graphics3d;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import com.javafx.experiments.ensemble2.Sample3D;

/**
 * Sample showing a three 3D cubes animated rotating. When running in a standalone application you will need 
 * to construct a Scene with the depthBuffer argument set to true and depthTest to true on your root node.
 *
 * @see javafx.scene.transform.Rotate
 * @see javafx.scene.paint.Color
 * @see javafx.scene.shape.RectangleBuilder
 */
public class CubeSample extends Sample3D {

    private Timeline animation;

    public CubeSample() {
        super(400, 150);
    }

    @Override
    public Node create3dContent() {
        Cube c = new Cube(50, Color.RED, 1);
        c.rx.setAngle(45);
        c.ry.setAngle(45);
        Cube c2 = new Cube(50, Color.GREEN, 1);
        c2.setTranslateX(100);
        c2.rx.setAngle(45);
        c2.ry.setAngle(45);
        Cube c3 = new Cube(50, Color.ORANGE, 1);
        c3.setTranslateX(-100);
        c3.rx.setAngle(45);
        c3.ry.setAngle(45);

        animation = new Timeline();
        animation.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(c.ry.angleProperty(), 0d), new KeyValue(c2.rx.angleProperty(), 0d), new KeyValue(c3.rz.angleProperty(), 0d)),
                new KeyFrame(Duration.millis(1000), new KeyValue(c.ry.angleProperty(), 360d), new KeyValue(c2.rx.angleProperty(), 360d), new KeyValue(c3.rz.angleProperty(), 360d)));
        animation.setCycleCount(Animation.INDEFINITE);

        return new Group(c, c2, c3);
    }

    @Override
    public void play() {
        super.play();
        animation.play();
    }

    @Override
    public void stop() {
        super.stop();
        animation.pause();
    }

    public class Cube extends Group {
        final Rotate rx = new Rotate(0, Rotate.X_AXIS);
        final Rotate ry = new Rotate(0, Rotate.Y_AXIS);
        final Rotate rz = new Rotate(0, Rotate.Z_AXIS);

        public Cube(double size, Color color, double shade) {
            getTransforms().addAll(rz, ry, rx);
            getChildren().addAll(
                    RectangleBuilder.create() // back face
                            .width(size).height(size).fill(color.deriveColor(0.0, 1.0, (1 - 0.5 * shade), 1.0)).translateX(-0.5 * size).translateY(-0.5 * size).translateZ(0.5 * size).build(),
                    RectangleBuilder.create() // bottom face
                            .width(size).height(size).fill(color.deriveColor(0.0, 1.0, (1 - 0.4 * shade), 1.0)).translateX(-0.5 * size).translateY(0).rotationAxis(Rotate.X_AXIS).rotate(90).build(),
                    RectangleBuilder.create()
                            // right face
                            .width(size).height(size).fill(color.deriveColor(0.0, 1.0, (1 - 0.3 * shade), 1.0)).translateX(-1 * size).translateY(-0.5 * size).rotationAxis(Rotate.Y_AXIS).rotate(90)
                            .build(),
                    RectangleBuilder.create() // left face
                            .width(size).height(size).fill(color.deriveColor(0.0, 1.0, (1 - 0.2 * shade), 1.0)).translateX(0).translateY(-0.5 * size).rotationAxis(Rotate.Y_AXIS).rotate(90).build(),
                    RectangleBuilder.create()
                            // top face
                            .width(size).height(size).fill(color.deriveColor(0.0, 1.0, (1 - 0.1 * shade), 1.0)).translateX(-0.5 * size).translateY(-1 * size).rotationAxis(Rotate.X_AXIS).rotate(90)
                            .build(), RectangleBuilder.create() // top face
                            .width(size).height(size).fill(color).translateX(-0.5 * size).translateY(-0.5 * size).translateZ(-0.5 * size).build());
        }
    }

}
