/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.spongepowered.api.event.entity;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import org.spongepowered.api.util.event.Cancellable;
import org.spongepowered.api.world.Location;

/**
 * Called when an {@link org.spongepowered.api.entity.Entity} moves.
 *
 * <p>This is a continuous movement.</p>
 */
public interface EntityMoveEvent extends EntityDisplacementEvent {

    /**
     * Gets the original velocity of the entity.
     *
     * @return The original velocity
     */
    Vector3d getOriginalVelocity();

    /**
     * Gets the new velocity the entity will have after the event has fired.
     *
     * @return The new velocity
     */
    Vector3d getNewVelocity();

    /**
     * Sets the new velocity the entity will have after the event has fired.
     *
     * @param velocity The new velocity
     */
    void setNewVelocity(Vector3d velocity);
}
