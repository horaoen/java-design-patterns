package com.iluwatar.abstractfactory.domain.kingdom;

import com.iluwatar.abstractfactory.*;
import com.iluwatar.abstractfactory.domain.kingdom.army.Army;
import com.iluwatar.abstractfactory.domain.kingdom.castle.Castle;
import com.iluwatar.abstractfactory.domain.kingdom.factory.KingdomFactory;
import com.iluwatar.abstractfactory.domain.kingdom.king.King;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@SuppressWarnings("unused")
public class KingdomBuilder implements IBuilder<Kingdom> {
    private King king;
    private Castle castle;
    private Army army;
    
    public KingdomBuilder withKingdomType(Kingdom.FactoryMaker.KingdomType kingdomType) {
        KingdomFactory kingdomFactory = Kingdom.FactoryMaker.makeFactory(kingdomType);
        this.army = kingdomFactory.createArmy();
        this.castle = kingdomFactory.createCastle();
        this.king = kingdomFactory.createKing();
        return this;
    }
    
    public KingdomBuilder withArmy(Army army) {
        this.army = army;
        return this;
    }
    
    public KingdomBuilder withCastle(Castle castle) {
        this.castle = castle;
        return this;
    }
    
    public KingdomBuilder withKing(King king) {
        this.king = king;
        return this;
    }

    @Override
    public Kingdom build() {
        Kingdom kingdom = new Kingdom();
        kingdom.setArmy(this.army);
        kingdom.setKing(this.king);
        kingdom.setCastle(this.castle);
        return kingdom;
    }
}
