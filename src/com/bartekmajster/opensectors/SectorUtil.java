package com.bartekmajster.opensectors;

import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.potion.*;
import org.bukkit.*;

public class SectorUtil
{
    public static String InventoryToString(final Inventory invInventory) {
        String serialization = String.valueOf(invInventory.getSize()) + ";";
        for (int i = 0; i < invInventory.getSize(); ++i) {
            final ItemStack is = invInventory.getItem(i);
            if (is != null) {
                String serializedItemStack = new String();
                final String isType = String.valueOf(is.getType().getId());
                serializedItemStack = String.valueOf(serializedItemStack) + "t@" + isType;
                if (is.getDurability() != 0) {
                    final String isDurability = String.valueOf(is.getDurability());
                    serializedItemStack = String.valueOf(serializedItemStack) + ":d@" + isDurability;
                }
                if (is.getAmount() != 1) {
                    final String isAmount = String.valueOf(is.getAmount());
                    serializedItemStack = String.valueOf(serializedItemStack) + ":a@" + isAmount;
                }
                final Map<Enchantment, Integer> isEnch = (Map<Enchantment, Integer>)is.getEnchantments();
                if (isEnch.size() > 0) {
                    for (final Map.Entry<Enchantment, Integer> ench : isEnch.entrySet()) {
                        serializedItemStack = String.valueOf(serializedItemStack) + ":e@" + ((Enchantment)ench.getKey()).getId() + "@" + ench.getValue();
                    }
                }
                serialization = String.valueOf(serialization) + i + "#" + serializedItemStack + ";";
            }
        }
        return serialization;
    }
    
    public static String armorToString(final ItemStack[] armor) {
        String serialization = "";
        for (int i = 0; i < armor.length; ++i) {
            final ItemStack is = armor[i];
            if (is != null) {
                String serializationItemStack = "";
                final String type = is.getType().name();
                serializationItemStack = String.valueOf(String.valueOf(serializationItemStack)) + "t@" + type;
                if (is.getDurability() != 0) {
                    final short durability = is.getDurability();
                    serializationItemStack = String.valueOf(String.valueOf(serializationItemStack)) + ":d@" + durability;
                }
                if (is.getAmount() != 1) {
                    final int amount = is.getAmount();
                    serializationItemStack = String.valueOf(String.valueOf(serializationItemStack)) + ":a@" + amount;
                }
                final Map<Enchantment, Integer> enchantments = (Map<Enchantment, Integer>)is.getEnchantments();
                if (enchantments.size() > 0) {
                    for (final Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()) {
                        serializationItemStack = String.valueOf(String.valueOf(serializationItemStack)) + ":e@" + ((Enchantment)enchantment.getKey()).getName() + "@" + enchantment.getValue();
                    }
                }
                if (is.hasItemMeta()) {
                    final ItemMeta im = is.getItemMeta();
                    if (im.hasDisplayName()) {
                        serializationItemStack = String.valueOf(String.valueOf(serializationItemStack)) + ":n@" + im.getDisplayName();
                    }
                    if (im.hasLore()) {
                        for (final String lore : im.getLore()) {
                            serializationItemStack = String.valueOf(String.valueOf(serializationItemStack)) + ":l@" + lore;
                        }
                    }
                }
                serialization = String.valueOf(String.valueOf(serialization)) + i + "#" + serializationItemStack + ";";
            }
        }
        return serialization;
    }
    
    public static ItemStack[] stringToArmor(final String string) {
        final String[] serializedItems = string.split(";");
        final ItemStack[] deserializedArmor = new ItemStack[4];
        String[] arrayOfString1;
        for (int j = (arrayOfString1 = serializedItems).length, i = 0; i < j; ++i) {
            final String serializedItem1 = arrayOfString1[i];
            final String[] serializedItem2 = serializedItem1.split("#");
            final int stackPosition = Integer.parseInt(serializedItem2[0]);
            if (stackPosition < deserializedArmor.length) {
                ItemStack is = null;
                boolean createdItemStack = false;
                final String[] serializedItemStack = serializedItem2[1].split(":");
                String[] array;
                for (int length = (array = serializedItemStack).length, j2 = 0; j2 < length; ++j2) {
                    final String itemInfo = array[j2];
                    final String[] itemAttribute = itemInfo.split("@");
                    if (itemAttribute[0].equals("t")) {
                        is = new ItemStack(Material.getMaterial(itemAttribute[1]));
                        createdItemStack = true;
                    }
                    if (itemAttribute[0].equals("d") && createdItemStack) {
                        is.setDurability(Short.parseShort(itemAttribute[1]));
                    }
                    if (itemAttribute[0].equals("a") && createdItemStack) {
                        is.setAmount(Integer.parseInt(itemAttribute[1]));
                    }
                    if (itemAttribute[0].equals("e") && createdItemStack) {
                        is.addUnsafeEnchantment(Enchantment.getByName(itemAttribute[1]), Integer.parseInt(itemAttribute[2]));
                    }
                    final ItemMeta im = (is != null) ? is.getItemMeta() : null;
                    if (itemAttribute[0].equals("n") && createdItemStack) {
                        im.setDisplayName(itemAttribute[1]);
                    }
                    if (itemAttribute[0].equals("l") && createdItemStack) {
                        if (!im.hasLore()) {
                            im.setLore((List)new ArrayList());
                        }
                        im.getLore().add(itemAttribute[1]);
                    }
                    if (is != null) {
                        is.setItemMeta(im);
                    }
                }
                deserializedArmor[stackPosition] = is;
            }
        }
        return deserializedArmor;
    }
    
    public static Inventory StringToInventory(final String invString) {
        final String[] serializedBlocks = invString.split(";");
        final String invInfo = serializedBlocks[0];
        final Inventory deserializedInventory = Bukkit.getServer().createInventory((InventoryHolder)null, (int)Integer.valueOf(invInfo));
        for (int i = 1; i < serializedBlocks.length; ++i) {
            final String[] serializedBlock = serializedBlocks[i].split("#");
            final int stackPosition = (int)Integer.valueOf(serializedBlock[0]);
            if (stackPosition < deserializedInventory.getSize()) {
                ItemStack is = null;
                Boolean createdItemStack = false;
                final String[] serializedItemStack = serializedBlock[1].split(":");
                String[] arrayOfString1;
                for (int j = (arrayOfString1 = serializedItemStack).length, i2 = 0; i2 < j; ++i2) {
                    final String itemInfo = arrayOfString1[i2];
                    final String[] itemAttribute = itemInfo.split("@");
                    if (itemAttribute[0].equals("t")) {
                        is = new ItemStack(Material.getMaterial((int)Integer.valueOf(itemAttribute[1])));
                        createdItemStack = true;
                    }
                    else if (itemAttribute[0].equals("d") && createdItemStack) {
                        is.setDurability((short)Short.valueOf(itemAttribute[1]));
                    }
                    else if (itemAttribute[0].equals("a") && createdItemStack) {
                        is.setAmount((int)Integer.valueOf(itemAttribute[1]));
                    }
                    else if (itemAttribute[0].equals("e") && createdItemStack) {
                        is.addEnchantment(Enchantment.getById((int)Integer.valueOf(itemAttribute[1])), (int)Integer.valueOf(itemAttribute[2]));
                    }
                }
                deserializedInventory.setItem(stackPosition, is);
            }
        }
        return deserializedInventory;
    }
    
    public static String EffectToString(final Collection<PotionEffect> effects) {
        String serialized = "";
        for (final PotionEffect e : effects) {
            serialized = String.valueOf(serialized) + e.getType().getId() + ":" + e.getDuration() + ":" + e.getAmplifier() + ";";
        }
        return serialized;
    }
    
    public static Collection<PotionEffect> StringToEffect(final String serializedEffects) {
        final ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
        if (serializedEffects.isEmpty()) {
            return effects;
        }
        final String[] effs = serializedEffects.split(";");
        for (int i = 0; i < effs.length; ++i) {
            final String[] effect = effs[i].split(":");
            if (effect.length < 3) {
                throw new IllegalArgumentException(String.valueOf(serializedEffects) + " - PotionEffect " + i + " (" + effs[i] + "): split must at least have a length of 3");
            }
            final int id = Integer.parseInt(effect[0]);
            final int duration = Integer.parseInt(effect[1]);
            final int amplifier = Integer.parseInt(effect[2]);
            final PotionEffectType effectType = PotionEffectType.getById(id);
            if (effectType == null) {
                throw new IllegalArgumentException(String.valueOf(serializedEffects) + " - PotionEffect " + i + " (" + effs[i] + "): no PotionEffectType with id of " + id);
            }
            final PotionEffect e = new PotionEffect(effectType, duration, amplifier);
            effects.add(e);
        }
        return effects;
    }
    
    public static Location StringToLocation(final String location) {
        final String[] str2loc = location.split("\\:");
        final Location loc = new Location(Bukkit.getWorld(str2loc[0]), 0.0, 0.0, 0.0, 0.0f, 0.0f);
        loc.setX(Double.parseDouble(str2loc[1]));
        loc.setY(Double.parseDouble(str2loc[2]));
        loc.setZ(Double.parseDouble(str2loc[3]));
        loc.setYaw(Float.parseFloat(str2loc[4]));
        loc.setPitch(Float.parseFloat(str2loc[5]));
        return loc;
    }
    
    public static String LocationToString(final Location location) {
        return String.valueOf(location.getWorld().getName()) + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ() + ":" + location.getYaw() + ":" + location.getPitch();
    }
}
