package com.skrrtnick.tasks;

import com.epicbot.api.shared.APIContext;
import com.skrrtnick.SkrrtFishnCook;
import com.skrrtnick.data.Locations;
import com.skrrtnick.data.State;

public class Walk {
    APIContext ctx;
    public Walk(APIContext ctx) {
        this.ctx = ctx;
    }

    public boolean walkToFish() {
        if (!Locations.FISHING_SPOT.getArea().contains(ctx.localPlayer().get())) {
            ctx.webWalking().walkTo(Locations.FISHING_SPOT.getArea().getRandomTile());
        }
        return Locations.FISHING_SPOT.getArea().contains(ctx.localPlayer().get());
    }

    public void walkToBank() {
        if (!Locations.LUMBRIDGE_BANK.getArea().contains(ctx.localPlayer().get())) {
            SkrrtFishnCook.state = State.WALKING;
            ctx.webWalking().walkToBank();

        }

    }
    public boolean walkToStove(APIContext ctx) {
        System.out.println("Walking to stove starting");
        if (!Locations.STOVE.getArea().contains(ctx.localPlayer().get())) {
            SkrrtFishnCook.state = State.WALKING;
            ctx.walking().walkTo(Locations.STOVE.getArea().getRandomTile());        }
        System.out.println("Walking to stove ending");
        return Locations.STOVE.getArea().contains(ctx.localPlayer().get());
    }

}