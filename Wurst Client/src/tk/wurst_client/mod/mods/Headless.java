/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.mod.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C03PacketPlayer;
import tk.wurst_client.event.EventManager;
import tk.wurst_client.event.listeners.UpdateListener;
import tk.wurst_client.mod.Mod;
import tk.wurst_client.mod.Mod.Category;
import tk.wurst_client.mod.Mod.Info;

@Info(category = Category.FUN,
	description = "While this is active, other people will think you are\n"
		+ "headless. Looks hilarious!",
	name = "Headless")
public class Headless extends Mod implements UpdateListener
{
	@Override
	public void onEnable()
	{
		EventManager.addUpdateListener(this);
	}
	
	@Override
	public void onUpdate()
	{
		Minecraft.getMinecraft().thePlayer.sendQueue
			.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook
			(
				Minecraft.getMinecraft().thePlayer.rotationYaw,
				180F,
				Minecraft.getMinecraft().thePlayer.onGround
			));
	}
	
	@Override
	public void onDisable()
	{
		EventManager.removeUpdateListener(this);
	}
}
