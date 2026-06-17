package com.myname.mymodid;

import java.io.InputStream;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.sandrohc.schematic4j.SchematicLoader;
import net.sandrohc.schematic4j.schematic.Schematic;

import cpw.mods.fml.common.registry.GameRegistry;

public class GoodForcesCamp extends WorldGenerator {

    private Schematic schematic;

    public GoodForcesCamp() {
        try {
            InputStream stream = getClass().getResourceAsStream("/assets/mymodid/structures/burak.schematic");

            if (stream != null) {
                this.schematic = SchematicLoader.load(stream);
            } else {
                System.out.println("[Mod] Nie można znaleźć pliku burak.schematic!");
            }
        } catch (Exception e) {
            System.out.println("[Mod] Błąd wczytywania schematu:");
            e.printStackTrace();
        }
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        if (schematic == null) {
            return false;
        }

        int width = schematic.width();
        int height = schematic.height();
        int length = schematic.length();

        int offSetX = width / 2;
        int offSetZ = length / 2;
        int licznikPostawionych = 0;

        for (int dy = 0; dy < height; dy++) {
            for (int dz = 0; dz < length; dz++) {
                for (int dx = 0; dx < width; dx++) {

                    var schematicBlock = schematic.block(dx, dy, dz);

                    if (schematicBlock != null) {
                        // REFORMA: schematic4j przechowuje pełny identyfikator pod metodą .block()
                        String fullBlockName = schematicBlock.block();
                        Block mcBlock = null;

                        if (fullBlockName != null && !fullBlockName.isEmpty()) {
                            if (fullBlockName.contains(":")) {
                                String[] parts = fullBlockName.split(":");
                                mcBlock = GameRegistry.findBlock(parts[0], parts[1]);
                            } else {
                                mcBlock = Block.getBlockFromName(fullBlockName);
                            }
                        }

                        int targetX = x + dx - offSetX;
                        int targetY = y + dy;
                        int targetZ = z + dz - offSetZ;


                        if (mcBlock != null && mcBlock != Blocks.air) {
                            world.setBlock(targetX, targetY, targetZ, mcBlock, 0, 2);
                            licznikPostawionych++;
                        }
                    }
                }
            }
        }


        world.setBlock(x, y, z, Blocks.ender_chest);

        System.out.println("[Mod] Generowanie zakończone sukcesem! Postawiono bloki w ilości: " + licznikPostawionych);
        return true;
    }
}
