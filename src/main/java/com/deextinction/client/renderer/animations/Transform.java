package com.deextinction.client.renderer.animations;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
@SideOnly(Side.CLIENT)
public class Transform
{
	public float rotX;
	public float rotY;
	public float rotZ;
	public float offsetX;
	public float offsetY;
	public float offsetZ;

	public Transform()
	{
		this.rotX = this.rotY = this.rotZ = 0.0F;
		this.offsetX = this.offsetY = this.offsetZ = 0.0F;
	}

	public Transform(float rx, float ry, float rz)
	{
		this.rotX = rx;
		this.rotY = ry;
		this.rotZ = rz;
		this.offsetX = this.offsetY = this.offsetZ = 0.0F;
	}

	public Transform(float x, float y, float z, float rx, float ry, float rz)
	{
		this(rx, ry, rz);
		this.offsetX = x;
		this.offsetY = y;
		this.offsetZ = z;
	}

	public void addRot(float x, float y, float z)
	{
		this.rotX += x;
		this.rotY += y;
		this.rotZ += z;
	}

	public void addOffset(float x, float y, float z)
	{
		this.offsetX += x;
		this.offsetY += y;
		this.offsetZ += z;
	}
}
