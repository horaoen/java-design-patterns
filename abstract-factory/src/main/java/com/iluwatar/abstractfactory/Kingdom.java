/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
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
package com.iluwatar.abstractfactory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Helper class to manufacture {@link KingdomFactory} beans.
 */
@Setter(AccessLevel.PRIVATE)
@Getter
public class Kingdom {

    private King king;
    private Castle castle;
    private Army army;
    
    public Kingdom(Builder builder) {
        this.army = builder.army;
        this.castle = builder.castle;
        this.king = builder.king;
    }

    @SuppressWarnings("unused")
    public static class Builder {
        private King king;
        private Castle castle;
        private Army army;

        public Builder() {
        }
        public Builder(FactoryMaker.KingdomType kingdomType) {
            KingdomFactory kingdomFactory = FactoryMaker.makeFactory(kingdomType);
            this.king = kingdomFactory.createKing();
            this.army = kingdomFactory.createArmy();
            this.castle = kingdomFactory.createCastle();
        }
        
        public Builder withKing(King king) {
            this.king = king;
            return this;
        }
        
        public Builder withArmy(Army army) {
            this.army = army;
            return this;
        }
        
        public Builder withCastle(Castle castle) {
            this.castle = castle;
            return this;
        }
        
        public Kingdom build() {
            return new Kingdom(this);
        }
    }

    /**
     * The factory of kingdom factories.
     */
    public static class FactoryMaker {

        /**
         * Enumeration for the different types of Kingdoms.
         */
        public enum KingdomType {
            ELF, ORC
        }

        /**
         * The factory method to create KingdomFactory concrete objects.
         */
        public static KingdomFactory makeFactory(KingdomType type) {
            return switch (type) {
                case ELF -> new ElfKingdomFactory();
                case ORC -> new OrcKingdomFactory();
            };
        }
    }
}
