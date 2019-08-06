package kazanami.kazanami_shop.main;


import kazanami.kazanami_shop.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@Mod.EventBusSubscriber

public class shop_kazanami {

    public static Item tf_chip, rei_metal;

    public static Logger logger = LogManager.getLogger("Kazanami Shop");


    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        if (Loader.isModLoaded("tf2")) {
            try {
                tf_chip = Item.getByNameOrId("tf2:developchip_2");
                rei_metal = Item.getByNameOrId("tf2:reimetalingot");
                event.getRegistry().registerAll(
                        new ShapelessOreRecipe(new ResourceLocation(Reference.MOD_ID, "reimetal_to_tf_chip"),
                                tf_chip, rei_metal
                        ).setRegistryName(Reference.MOD_ID, "reimetal_to_tf_chip")
                );
            } finally {
                logger.debug("loaded Custom Recipe.");
            }
        }
    }

}
