package com.steinshuh.tut.items;

import com.google.common.collect.Multimap;
import com.steinshuh.tut.Ref;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import com.google.common.collect.Multimap;
import com.steinshuh.tut.Ref;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class AwesomebookgirlWand extends Item {

	public AwesomebookgirlWand() {
		setRegistryName("awesomebookgirlwand");        // The unique name (within your mod) that identifies this item
		setUnlocalizedName(Ref.MODID + ".awesomebookgirlwand");     // Used for localization (en_US.lang)
		setCreativeTab(CreativeTabs.TOOLS);
	}
	public float getAttackDamage()
	{
		return 99999f;
	}

	public boolean canHarvestBlock(IBlockState blockIn) {
		return true; 
	}
	public boolean isDamageable() {
		return false;
	}
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
	{
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
		if (slot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) getAttackDamage(), 0));
		}
		return multimap;
	}
}

