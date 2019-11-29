/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.data;

import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.Location;
import org.spongepowered.math.vector.Vector3d;

@SuppressWarnings("unchecked")
public class BuilderTest {

    private static final Key<Value<Vector3d>> NORMALIZED_VELOCITY = DummyObjectProvider.createFor(Key.class, "NORMALIZED_VELOCITY");
    private static final Key<BoundedValue<Double>> BOUNDED_DOUBLE = DummyObjectProvider.createFor(Key.class, "BOUNDED_DOUBLE");
    private static final Key<Value<Double>> DOUBLE = DummyObjectProvider.createFor(Key.class, "DOUBLE");

    void test() {
        DataProviderBuilder.builder().forHolders(Entity.class, EntitySnapshot.class)
                .key(NORMALIZED_VELOCITY)
                .get(holder -> holder.get(Keys.VELOCITY).map(Vector3d::normalize).orElse(null))
                .build();

        DataProviderBuilder.builder().forImmutableHolders(EntitySnapshot.class, ItemStackSnapshot.class)
                .key(NORMALIZED_VELOCITY)
                .get(holder -> holder.get(Keys.VELOCITY).map(Vector3d::normalize).orElse(null))
                .with((holder, value) -> holder.with(Keys.VELOCITY, value).orElse(holder))
                .build();

        DataProviderBuilder.builder().forMutableDirectionRelativeHolder(Location.class)
                .key(NORMALIZED_VELOCITY)
                .get((holder, direction) -> holder.get(Keys.VELOCITY).map(v -> v.mul(direction.asOffset())).orElse(Vector3d.ZERO));

        final Value.Immutable<Double> immutableDoubleValue = Value.immutableOf(DOUBLE, 100.0);
        final Value.Mutable<Double> mutableDoubleValue = Value.mutableOf(DOUBLE, 100.0);
        final BoundedValue.Immutable<Double> immutableBoundedDoubleValue = Value.immutableOf(BOUNDED_DOUBLE, 100.0);
        final BoundedValue.Mutable<Double> mutableBoundedDoubleValue = Value.mutableOf(BOUNDED_DOUBLE, 100.0);
    }
}
