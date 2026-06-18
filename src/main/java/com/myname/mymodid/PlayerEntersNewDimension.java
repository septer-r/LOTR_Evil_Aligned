package com.myname.mymodid;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerEntersNewDimension {

    // ID wymiaru Śródziemia w modzie LOTR to domyślnie 100
    private static final int LOTR_DIMENSION_ID = 100;

    // Tutaj wpisz swoje docelowe koordynaty
    private static final double SPAWN_X = 13661;
    private static final double SPAWN_Y = 85;
    private static final double SPAWN_Z = 576;

    @SubscribeEvent
    public void onPlayerChangeDimension(PlayerChangedDimensionEvent event) {
        // Sprawdzamy, czy gracz właśnie wszedł do wymiaru LOTR
        if (event.toDim == LOTR_DIMENSION_ID) {
            if (event.player instanceof EntityPlayerMP) {
                EntityPlayerMP playerMP = (EntityPlayerMP) event.player;

                // Teleportacja gracza na dokładne koordynaty
                playerMP.setPositionAndUpdate(SPAWN_X, SPAWN_Y, SPAWN_Z);

                // Opcjonalnie: Możesz też ustawić jego łóżko/punkt odrodzenia na te koordynaty,
                // aby po śmierci wracał w to samo miejsce:
                playerMP.setSpawnChunk(
                    new net.minecraft.util.ChunkCoordinates((int)SPAWN_X, (int)SPAWN_Y, (int)SPAWN_Z),
                    true,
                    LOTR_DIMENSION_ID
                );
            }
        }
    }
}
