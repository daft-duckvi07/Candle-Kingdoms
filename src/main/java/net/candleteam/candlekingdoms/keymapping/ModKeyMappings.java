package net.candleteam.candlekingdoms.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {

    public static final KeyMapping.Category CANDLE_KINGDOMS_CATEGORY = new KeyMapping.Category(
            Identifier.fromNamespaceAndPath("candlekingdoms", "candle_kingdoms_category")
    );

    private static  final KeyMapping KEY_MAPPING_MOVE = new KeyMapping(
            "key.candlekingdoms.moveunit",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            CANDLE_KINGDOMS_CATEGORY);
    public static final Lazy<KeyMapping> PRESS_MOVE = Lazy.of(() -> KEY_MAPPING_MOVE);

    public  static  void register(){

    }
}
