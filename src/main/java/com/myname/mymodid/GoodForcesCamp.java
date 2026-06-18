package com.myname.mymodid;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import lotr.common.LOTRMod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.Constants;

public class GoodForcesCamp extends WorldGenerator {


    private static final boolean VERBOSE_PER_BLOCK = false;

    private static final String TAG = "[GoodForcesCamp]";


    private static final boolean DUMP_ID_HISTOGRAM_ONCE = false;
    private static boolean histogramDumped = false;


    private static final boolean SCAN_REGISTRY_FOR_NAME_FRAGMENT_ONCE = true;
    private static final String REGISTRY_SCAN_FRAGMENT = "pillar2";
    private static boolean registryScanDone = false;

    private static final boolean DUMP_REGISTRY_SEARCH_ONCE = true;
    private static final String[] REGISTRY_SEARCH_KEYWORDS = { "pillar", "wall", "column" };
    private static boolean registrySearchDumped = false;


    private static final Map<String, Block> NUMERIC_REMAP = new HashMap<String, Block>();
    static {

        NUMERIC_REMAP.put("626:13", LOTRMod.pillar3);
        NUMERIC_REMAP.put("626:14", LOTRMod.pillar3);
    }

    private boolean loaded = false;

    private short width;
    private short height;
    private short length;
    private byte[] blocksArray;
    private byte[] metadataArray;
    private byte[] addBlocksArray;


    private NBTTagList tileEntitiesList;

    private Map<Integer, String> blockIdMap = new HashMap<Integer, String>();

    public GoodForcesCamp() {
        log("KONSTRUKTOR: start ladowania schematu...");

        InputStream stream = null;
        try {

            stream = getClass().getResourceAsStream("/assets/mymodid/structures/burak.schematic");
            if (stream == null) {
                logError("KROK 0 [Otwarcie pliku]: NIE UDANE - getResourceAsStream zwrocil null. "
                    + "Sprawdz czy plik 'burak.schematic' istnieje w "
                    + "src/main/resources/assets/mymodid/structures/ i czy jest wlaczony do builda.");
                return;
            }
            log("KROK 0 [Otwarcie pliku]: OK - strumien otwarty.");


            NBTTagCompound nbt;
            try {
                nbt = CompressedStreamTools.readCompressed(stream);
                log("KROK 1 [Odczyt NBT]: OK - NBT wczytany poprawnie.");
            } catch (Exception e) {
                logError("KROK 1 [Odczyt NBT]: NIE UDANE - plik jest uszkodzony, nie jest gzipem "
                    + "lub nie jest prawidlowym formatem .schematic.");
                e.printStackTrace();
                return;
            }


            try {
                this.width = nbt.getShort("Width");
                this.height = nbt.getShort("Height");
                this.length = nbt.getShort("Length");

                if (width <= 0 || height <= 0 || length <= 0) {
                    logError("KROK 2 [Wymiary]: PODEJRZANE - odczytano width=" + width
                        + " height=" + height + " length=" + length
                        + " (jedna z wartosci <= 0). Plik moze byc zly lub uszkodzony.");
                } else {
                    log("KROK 2 [Wymiary]: OK - width=" + width + " height=" + height + " length=" + length);
                }
            } catch (Exception e) {
                logError("KROK 2 [Wymiary]: NIE UDANE - brak tagow Width/Height/Length w NBT.");
                e.printStackTrace();
                return;
            }


            try {
                this.blocksArray = nbt.getByteArray("Blocks");
                this.metadataArray = nbt.getByteArray("Data");

                if (blocksArray == null || blocksArray.length == 0) {
                    logError("KROK 3 [Tablica Blocks]: NIE UDANE - tablica 'Blocks' jest pusta lub null.");
                } else {
                    log("KROK 3 [Tablica Blocks]: OK - dlugosc=" + blocksArray.length);
                }

                if (metadataArray == null || metadataArray.length == 0) {
                    logError("KROK 3 [Tablica Data]: NIE UDANE - tablica 'Data' (metadane) jest pusta lub null.");
                } else {
                    log("KROK 3 [Tablica Data]: OK - dlugosc=" + metadataArray.length);
                }

                int expectedLength = width * height * length;
                if (blocksArray != null && blocksArray.length != expectedLength) {
                    logError("KROK 3 [Walidacja rozmiaru]: PODEJRZANE - oczekiwano " + expectedLength
                        + " bajtow (width*height*length), a tablica Blocks ma " + blocksArray.length
                        + ". Mozliwe niezgodne wymiary.");
                } else if (blocksArray != null) {
                    log("KROK 3 [Walidacja rozmiaru]: OK - rozmiar tablicy zgodny z wymiarami.");
                }
            } catch (Exception e) {
                logError("KROK 3 [Tablice Blocks/Data]: WYJATEK podczas odczytu.");
                e.printStackTrace();
                return;
            }


            if (nbt.hasKey("AddBlocks")) {
                this.addBlocksArray = nbt.getByteArray("AddBlocks");
                log("KROK 4 [AddBlocks]: OK - znaleziono i wczytano, dlugosc=" + addBlocksArray.length);
            } else {
                log("KROK 4 [AddBlocks]: BRAK - tag nie istnieje w schemacie (to jest normalne, nie kazdy schemat go ma).");
            }

            // ---- KROK 5: TileEntities (skrzynie, piece, banery, tabliczki) ----
            if (nbt.hasKey("TileEntities", Constants.NBT.TAG_LIST)) {
                this.tileEntitiesList = nbt.getTagList("TileEntities", Constants.NBT.TAG_COMPOUND);
                log("KROK 5 [TileEntities]: OK - znaleziono " + tileEntitiesList.tagCount() + " obiektow.");
            } else {
                log("KROK 5 [TileEntities]: BRAK - schemat nie zawiera tile entities.");
            }


            if (nbt.hasKey("BlockIDs")) {
                try {
                    NBTTagCompound idCompound = nbt.getCompoundTag("BlockIDs");
                    for (Object key : idCompound.func_150296_c()) {
                        String blockName = (String) key;
                        int idInSchematic = idCompound.getShort(blockName);
                        blockIdMap.put(idInSchematic, blockName);
                    }
                    log("KROK 6 [Mapa ID - BlockIDs]: OK - wczytano " + blockIdMap.size() + " wpisow.");
                } catch (Exception e) {
                    logError("KROK 6 [Mapa ID - BlockIDs]: WYJATEK podczas parsowania tagu BlockIDs.");
                    e.printStackTrace();
                }
            }
            else if (nbt.hasKey("Schematica") && nbt.getCompoundTag("Schematica").hasKey("Blocks")) {
                try {
                    NBTTagCompound schematicaTag = nbt.getCompoundTag("Schematica");
                    NBTTagCompound blocksTag = schematicaTag.getCompoundTag("Blocks");
                    for (Object key : blocksTag.func_150296_c()) {
                        String blockName = (String) key;
                        int idInSchematic = blocksTag.getShort(blockName);
                        blockIdMap.put(idInSchematic, blockName);
                    }
                    log("KROK 6 [Mapa ID - Schematica]: OK - wczytano " + blockIdMap.size() + " wpisow.");
                } catch (Exception e) {
                    logError("KROK 6 [Mapa ID - Schematica]: WYJATEK podczas parsowania tagu Schematica.Blocks.");
                    e.printStackTrace();
                }
            }
            else {
                log("KROK 6 [Mapa ID]: BRAK - nie znaleziono ani 'BlockIDs' ani 'Schematica.Blocks'. "
                    + "Remapowanie po nazwach (np. lotr:stairsDwarvenBrickCracked) NIE BEDZIE DZIALAC, "
                    + "generowanie bedzie polegac wylacznie na numerycznych ID blokow.");
            }

            if (blockIdMap.isEmpty()) {
                logError("KROK 6 [Walidacja mapy ID]: OSTRZEZENIE - blockIdMap jest pusta. "
                    + "Remap po nazwie (krok REMAP w generate()) nigdy sie nie wykona.");
            } else {
                for (Map.Entry<Integer, String> entry : blockIdMap.entrySet()) {
                    log("    mapa ID: id=" + entry.getKey() + " -> '" + entry.getValue() + "'");
                }
            }

            this.loaded = true;
            log("KONSTRUKTOR: ZAKONCZONY SUKCESEM - schemat w pelni wczytany (loaded=true).");

        } catch (Exception e) {
            logError("KONSTRUKTOR: NIEOBSLUZONY WYJATEK - schemat NIE zostal wczytany (loaded=false).");
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception e) {
                    logError("KROK 0 [Zamkniecie strumienia]: WYJATEK podczas zamykania pliku.");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        log("GENERATE: wywolano w pozycji x=" + x + " y=" + y + " z=" + z);

        if (!loaded) {
            logError("GENERATE: PRZERWANO - schemat nie zostal wczytany (loaded=false). Zobacz logi konstruktora powyzej.");
            return false;
        }
        if (blocksArray == null) {
            logError("GENERATE: PRZERWANO - blocksArray jest null.");
            return false;
        }
        if (metadataArray == null) {
            logError("GENERATE: PRZERWANO - metadataArray jest null.");
            return false;
        }
        log("GENERATE: walidacja wstepna OK - zaczynam stawianie bloków (" + width + "x" + height + "x" + length + ").");


        if (SCAN_REGISTRY_FOR_NAME_FRAGMENT_ONCE && !registryScanDone) {
            registryScanDone = true;
            log("REJESTR-SKAN: szukam blokow z fragmentem '" + REGISTRY_SCAN_FRAGMENT + "' w unlocalizedName (ID 0-4095)...");
            int foundCount = 0;
            for (int id = 1; id < 4096; id++) {
                Block b = Block.getBlockById(id);
                if (b == null) continue;
                String uName = b.getUnlocalizedName();
                if (uName != null && uName.toLowerCase().contains(REGISTRY_SCAN_FRAGMENT.toLowerCase())) {
                    foundCount++;
                    log("REJESTR-SKAN: id=" + id + " -> unlocalizedName='" + uName + "'");
                }
            }
            log("REJESTR-SKAN: KONIEC - znaleziono " + foundCount + " blokow zawierajacych '"
                + REGISTRY_SCAN_FRAGMENT + "'.");
        }


        if (DUMP_ID_HISTOGRAM_ONCE && !histogramDumped) {
            histogramDumped = true;
            Map<String, Integer> histogram = new HashMap<String, Integer>();

            for (int dy2 = 0; dy2 < height; dy2++) {
                for (int dz2 = 0; dz2 < length; dz2++) {
                    for (int dx2 = 0; dx2 < width; dx2++) {
                        int idx2 = (dy2 * length + dz2) * width + dx2;
                        if (idx2 < 0 || idx2 >= blocksArray.length) continue;

                        int id2 = blocksArray[idx2] & 0xFF;
                        int m2 = metadataArray[idx2] & 0xFF;

                        if (addBlocksArray != null) {
                            int addIdx2 = idx2 >> 1;
                            if (addIdx2 < addBlocksArray.length) {
                                int addByte2 = addBlocksArray[addIdx2] & 0xFF;
                                if ((idx2 & 1) == 0) {
                                    id2 |= (addByte2 & 0x0F) << 8;
                                } else {
                                    id2 |= (addByte2 & 0xF0) << 4;
                                }
                            }
                        }

                        String key = id2 + ":" + m2;
                        Integer count = histogram.get(key);
                        histogram.put(key, count == null ? 1 : count + 1);
                    }
                }
            }

            log("HISTOGRAM [schematicId:meta -> liczba wystapien] - " + histogram.size() + " unikalnych kombinacji:");
            for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
                String[] parts = entry.getKey().split(":");
                int idPart = Integer.parseInt(parts[0]);
                Block resolvedBlock = Block.getBlockById(idPart);
                String resolvedName = (resolvedBlock != null) ? resolvedBlock.getUnlocalizedName() : "??? (brak w rejestrze)";
                log("    id=" + parts[0] + " meta=" + parts[1] + " -> wystapien=" + entry.getValue()
                    + " (Block.getBlockById(" + parts[0] + ") = " + resolvedName + ")");
            }
            log("HISTOGRAM: KONIEC. Znajdz w powyzszej liscie wpis odpowiadajacy zepsutym schodom "
                + "(np. po unlocalizedName zawierajacym 'stair' lub 'Cracked'), nastepnie dodaj wpis "
                + "do mapy NUMERIC_REMAP w kodzie, np. NUMERIC_REMAP.put(\"id:meta\", \"lotr:pillar2\");");
        }

        int offSetX = width / 2;
        int offSetZ = length / 2;


        int totalBlocks = 0;
        int airSkipped = 0;
        int placedByName = 0;
        int placedByNumericFallback = 0;
        int remapHits = 0;
        int nameMapMisses = 0;
        int placeBlockExceptions = 0;


        for (int dy = 0; dy < height; dy++) {
            for (int dz = 0; dz < length; dz++) {
                for (int dx = 0; dx < width; dx++) {

                    totalBlocks++;
                    int index = (dy * length + dz) * width + dx;

                    if (index < 0 || index >= blocksArray.length) {
                        logError("KROK A [Indeksowanie]: NIE UDANE przy dx=" + dx + " dy=" + dy + " dz=" + dz
                            + " - wyliczony index=" + index + " poza zakresem tablicy (dlugosc="
                            + blocksArray.length + "). Pomijam ten blok.");
                        continue;
                    }

                    int schematicId = blocksArray[index] & 0xFF;
                    int meta = metadataArray[index] & 0xFF;


                    if (addBlocksArray != null) {
                        int addIndex = index >> 1;
                        if (addIndex < addBlocksArray.length) {
                            int addByte = addBlocksArray[addIndex] & 0xFF;
                            if ((index & 1) == 0) {
                                schematicId |= (addByte & 0x0F) << 8;
                            } else {
                                schematicId |= (addByte & 0xF0) << 4;
                            }
                        }
                    }

                    Block mcBlock = null;
                    String realBlockName = "";


                    if (!blockIdMap.isEmpty() && blockIdMap.containsKey(schematicId)) {
                        realBlockName = blockIdMap.get(schematicId);
                        if (VERBOSE_PER_BLOCK) {
                            log("KROK A2 [Mapa ID->nazwa] OK przy (" + dx + "," + dy + "," + dz + "): id="
                                + schematicId + " -> '" + realBlockName + "'");
                        }
                    } else if (VERBOSE_PER_BLOCK) {
                        log("KROK A2 [Mapa ID->nazwa] BRAK WPISU przy (" + dx + "," + dy + "," + dz
                            + "): id=" + schematicId + " (uzyte zostanie tylko numeryczne ID)");
                    }


                    String numericKey = schematicId + ":" + meta;
                    Block numericRemapBlock = NUMERIC_REMAP.get(numericKey);
                    if (numericRemapBlock != null) {
                        remapHits++;
                        log("KROK A3a [Remap numeryczny] SUKCES przy (" + dx + "," + dy + "," + dz
                            + "): id:meta=" + numericKey + " -> Block referencja '"
                            + numericRemapBlock.getUnlocalizedName() + "' (bezposrednio, bez GameRegistry lookup)");
                        mcBlock = numericRemapBlock;
                        realBlockName = numericRemapBlock.getUnlocalizedName();
                        meta = 0;
                    }


                    if (numericRemapBlock == null) {
                        String compareName = realBlockName;
                        int colonCount = countChar(compareName, ':');
                        if (colonCount >= 2) {

                            int lastColon = compareName.lastIndexOf(':');
                            compareName = compareName.substring(0, lastColon);
                        }

                        if (compareName.equalsIgnoreCase("lotr:stairsDwarvenBrickCracked")) {
                            remapHits++;
                            log("KROK A3b [Remap po nazwie] SUKCES przy (" + dx + "," + dy + "," + dz + "): '"
                                + realBlockName + "' (schematicId=" + schematicId + ") -> 'lotr:pillar2', meta ustawione na 0");
                            realBlockName = "lotr:pillar2";
                            meta = 0;
                        }
                    }

                    if (numericRemapBlock == null && !realBlockName.isEmpty()) {
                        if (realBlockName.contains(":")) {
                            String[] parts = realBlockName.split(":");
                            mcBlock = GameRegistry.findBlock(parts[0], parts[1]);

                            if (mcBlock == null) {
                                nameMapMisses++;
                                logError("KROK A4 [GameRegistry.findBlock] NIE UDANE przy (" + dx + "," + dy + "," + dz
                                    + "): findBlock('" + parts[0] + "', '" + parts[1] + "') zwrocil null. "
                                    + "Schematic id=" + schematicId + ". Nazwa bloku jest prawdopodobnie zla "
                                    + "(sprawdz prawdziwa zarejestrowana nazwe w NEI/JEI). "
                                    + "Nastapi fallback na numeryczne ID.");
                            } else if (VERBOSE_PER_BLOCK) {
                                log("KROK A4 [GameRegistry.findBlock] OK przy (" + dx + "," + dy + "," + dz
                                    + "): znaleziono blok dla '" + realBlockName + "'");
                            }
                        } else {
                            mcBlock = Block.getBlockFromName(realBlockName);

                            if (mcBlock == null) {
                                nameMapMisses++;
                                logError("KROK A4 [Block.getBlockFromName] NIE UDANE przy (" + dx + "," + dy + "," + dz
                                    + "): getBlockFromName('" + realBlockName + "') zwrocil null. "
                                    + "Schematic id=" + schematicId + ". Nastapi fallback na numeryczne ID.");
                            } else if (VERBOSE_PER_BLOCK) {
                                log("KROK A4 [Block.getBlockFromName] OK przy (" + dx + "," + dy + "," + dz
                                    + "): znaleziono blok dla '" + realBlockName + "'");
                            }
                        }
                    }


                    if (mcBlock == null) {
                        mcBlock = Block.getBlockById(schematicId);
                        if (mcBlock != null) {
                            placedByNumericFallback++;
                            if (VERBOSE_PER_BLOCK) {
                                log("KROK A5 [Fallback numeryczny] OK przy (" + dx + "," + dy + "," + dz
                                    + "): Block.getBlockById(" + schematicId + ") znalazl blok.");
                            }
                        } else {
                            logError("KROK A5 [Fallback numeryczny] NIE UDANE przy (" + dx + "," + dy + "," + dz
                                + "): Block.getBlockById(" + schematicId + ") TAKZE zwrocil null. "
                                + "Ten blok zostanie calkowicie POMINIETY (dziura w strukturze).");
                        }
                    } else if (!realBlockName.isEmpty()) {
                        placedByName++;
                    }

                    if (mcBlock == null) {

                        continue;
                    }

                    if (mcBlock == Blocks.air) {
                        airSkipped++;
                        continue;
                    }


                    if (realBlockName.startsWith("lotr:") && !realBlockName.contains("wall")) {
                        meta = meta & 0x0F;

                        if (realBlockName.toLowerCase().contains("stairs")) {
                            if ((meta & 4) == 0) {
                                meta = meta & 3;
                            }
                        }
                    }


                    int targetX = x + dx - offSetX;
                    int targetY = y + dy;
                    int targetZ = z + dz - offSetZ;

                    try {
                        world.setBlock(targetX, targetY, targetZ, mcBlock, meta, 2);
                        if (VERBOSE_PER_BLOCK) {
                            log("KROK A7 [setBlock] OK przy swiat(" + targetX + "," + targetY + "," + targetZ + ")");
                        }
                    } catch (Exception e) {
                        placeBlockExceptions++;
                        logError("KROK A7 [setBlock] WYJATEK przy swiat(" + targetX + "," + targetY + "," + targetZ
                            + ") dla bloku '" + realBlockName + "' (schematicId=" + schematicId + "): " + e);
                    }
                }
            }
        }

        log("KROK A [Podsumowanie generowania blokow]: "
            + "total=" + totalBlocks
            + ", postawione_po_nazwie=" + placedByName
            + ", postawione_fallback_numeryczny=" + placedByNumericFallback
            + ", pominiete_jako_air=" + airSkipped
            + ", remap_lotr_pillar2=" + remapHits
            + ", nieudane_lookupy_po_nazwie=" + nameMapMisses
            + ", wyjatki_setBlock=" + placeBlockExceptions);

        if (nameMapMisses > 0) {
            logError("KROK A [Ostrzezenie]: " + nameMapMisses + " blokow nie zostalo znalezionych po nazwie "
                + "i uzyly fallbacku numerycznego. Jesli to dotyczylo 'lotr:pillar2', to wlasnie tu jest Twoj problem "
                + "- nazwa rejestracji bloku jest najpewniej nieprawidlowa.");
        }


        if (tileEntitiesList != null) {
            int teSuccess = 0;
            int teFailed = 0;

            log("KROK B [TileEntities]: start, do przetworzenia=" + tileEntitiesList.tagCount());

            for (int i = 0; i < tileEntitiesList.tagCount(); i++) {
                NBTTagCompound tileTag = tileEntitiesList.getCompoundTagAt(i);

                int teX = tileTag.getInteger("x");
                int teY = tileTag.getInteger("y");
                int teZ = tileTag.getInteger("z");

                int targetX = x + teX - offSetX;
                int targetY = y + teY;
                int targetZ = z + teZ - offSetZ;

                try {
                    NBTTagCompound newTileTag = (NBTTagCompound) tileTag.copy();
                    newTileTag.setInteger("x", targetX);
                    newTileTag.setInteger("y", targetY);
                    newTileTag.setInteger("z", targetZ);

                    TileEntity tileEntity = TileEntity.createAndLoadEntity(newTileTag);
                    if (tileEntity != null) {
                        world.removeTileEntity(targetX, targetY, targetZ);
                        world.setTileEntity(targetX, targetY, targetZ, tileEntity);
                        teSuccess++;
                        if (VERBOSE_PER_BLOCK) {
                            log("KROK B [TileEntity #" + i + "] OK przy (" + targetX + "," + targetY + "," + targetZ + ")");
                        }
                    } else {
                        teFailed++;
                        logError("KROK B [TileEntity #" + i + "] NIE UDANE: createAndLoadEntity zwrocil null "
                            + "dla tagu " + tileTag + " przy docelowej pozycji (" + targetX + "," + targetY + "," + targetZ + ")");
                    }
                } catch (Exception e) {
                    teFailed++;
                    logError("KROK B [TileEntity #" + i + "] WYJATEK przy (" + targetX + "," + targetY + "," + targetZ + "): " + e);
                    e.printStackTrace();
                }
            }

            log("KROK B [Podsumowanie TileEntities]: ok=" + teSuccess + ", nieudane=" + teFailed);
        } else {
            log("KROK B [TileEntities]: pominiete - brak tile entities w schemacie.");
        }


        try {
            world.setBlock(x, y, z, Blocks.ender_chest);
            log("KROK C [Skrzynia kresu]: OK - postawiona w (" + x + "," + y + "," + z + ")");
        } catch (Exception e) {
            logError("KROK C [Skrzynia kresu]: WYJATEK przy stawianiu w (" + x + "," + y + "," + z + "): " + e);
            e.printStackTrace();
        }

        log("GENERATE: ZAKONCZONO dla pozycji x=" + x + " y=" + y + " z=" + z);
        return true;
    }


    private static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    private static void log(String message) {
        System.out.println(TAG + " " + message);
    }

    private static void logError(String message) {
        System.out.println(TAG + " !!! " + message);
    }
}
