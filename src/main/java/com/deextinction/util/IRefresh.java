package com.deextinction.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.NonNullList;

public interface IRefresh
{
	NonNullList getFieldsToRefresh(NonNullList fields);

	void setFieldsToRefresh(ByteBuf fields);
}
