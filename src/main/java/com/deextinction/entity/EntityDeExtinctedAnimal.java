package com.deextinction.entity;

import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.database.AnimalAttributes;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.DNA;
import com.deextinction.util.MinecraftTime;
import com.deextinction.util.Nucleobases;

import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedAnimal extends EntityCreature implements IAnimals, IAnimatedEntity
{
	protected static final DataParameter<String> DNA_STRING = EntityDataManager.<String> createKey(EntityDeExtinctedAnimal.class, DataSerializers.STRING);
	protected static final DataParameter<Byte> TEXTURE_ID = EntityDataManager.<Byte> createKey(EntityDeExtinctedAnimal.class, DataSerializers.BYTE);
	protected static final DataParameter<Float> SCALE = EntityDataManager.<Float> createKey(EntityDeExtinctedAnimal.class, DataSerializers.FLOAT);
	protected static final DataParameter<Byte> STAGE = EntityDataManager.<Byte> createKey(EntityDeExtinctedAnimal.class, DataSerializers.BYTE);
	protected static final DataParameter<Byte> STATES = EntityDataManager.<Byte> createKey(EntityDeExtinctedAnimal.class, DataSerializers.BYTE);

	protected static final byte FLAG_GENDER = (byte) 0;
	protected static final byte FLAG_SITTING = (byte) 1;
	protected static final byte FLAG_SLEEPING = (byte) 2;
	protected static final byte FLAG_FLYING = (byte) 3;

	protected static final byte ENTITY_STATE_EATING = (byte) 10;

	public static final boolean FEMALE = false;
	public static final boolean MALE = true;

	protected EntityLivingBase animalTarget = null;
	public ResourceLocation texture = null;

	protected int growingAge;
	protected int hunger;
	protected int animTick;
	protected int animID;

	public EntityDeExtinctedAnimal(World worldIn)
	{
		super(worldIn);
	}

	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		this.initAnimal(this.getDefaultDNA());
		this.hunger = (int) (0.5F * this.getMaxHunger());
		this.animTick = 0;
		this.animID = 0;
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(EntityDeExtinctedAnimal.STATES, Byte.valueOf((byte) 0));
		this.dataManager.register(EntityDeExtinctedAnimal.DNA_STRING, String.valueOf(this.getDefaultDNA()));
		this.dataManager.register(EntityDeExtinctedAnimal.TEXTURE_ID, Byte.valueOf((byte) 0));
		this.dataManager.register(EntityDeExtinctedAnimal.SCALE, Float.valueOf((float) 0.0F));
		this.dataManager.register(EntityDeExtinctedAnimal.STAGE, Byte.valueOf((byte) -1));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(0.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.LUCK).setBaseValue(0.0D);

		AnimalAttributes attributes = this.getAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(attributes.getHealth().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(attributes.getKnockbackResistance().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(attributes.getMovementSpeed().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(attributes.getArmor().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(attributes.getArmorToughness().getChildAttribute());
		this.getEntityAttribute(EntityLivingBase.SWIM_SPEED).setBaseValue(attributes.getSwimSpeed().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(attributes.getFollowRange().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(attributes.getAttack().getChildAttribute());
		this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(attributes.getFlyingSpeed().getChildAttribute());
	}

	public void initAnimal(String dnaString)
	{
		if (this.rand.nextFloat() < 0.6F)
			this.initAnimalAdult(dnaString);
		else
			this.initAnimalBabe(dnaString);
	}

	public void initAnimalAdult(String dnaString)
	{
		byte adultStage = this.getMaxGrowthStage();
		this.setGrowingAge(this.getAttributes().getGrowth().get(adultStage));
		this.setGrowthStage(adultStage);
		this.setDNAString(dnaString);
		this.setTextureID(this.getTextureFromDNA(dnaString));
		this.setGender(this.getGenderFromDNA(dnaString));
	}

	public void initAnimalBabe(String dnaString)
	{
		this.setGrowingAge(this.getAttributes().getGrowth().get(0));
		this.setGrowthStage((byte) 0);
		this.setDNAString(dnaString);
		this.setTextureID(this.getTextureFromDNA(dnaString));
		this.setGender(this.getGenderFromDNA(dnaString));
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

	public AnimalAttributes getAttributes()
	{
		return this.getAnimal().getAttributes();
	}

	public void setDNA(DNA dna)
	{
		this.dataManager.set(EntityDeExtinctedAnimal.DNA_STRING, String.valueOf(dna.getDNA()));
	}

	public void setDNAString(String dnaString)
	{
		this.dataManager.set(EntityDeExtinctedAnimal.DNA_STRING, String.valueOf(dnaString));
	}

	public String getDNAString()
	{
		return this.dataManager.get(EntityDeExtinctedAnimal.DNA_STRING);
	}

	protected byte getTextureFromDNA(String dnaString)
	{
		return (byte) 0;
	}

	protected boolean getGenderFromDNA(String dnaString)
	{
		char[] dnaCharString = dnaString.toCharArray();
		return dnaCharString[DNA.DNA_INDEX_1] == Nucleobases.ADENINE.getNucleobaseLetter() || dnaCharString[DNA.DNA_INDEX_1] == Nucleobases.THYMINE.getNucleobaseLetter();
	}

	protected String getDefaultDNA()
	{
		return this.getDefaultDNA(this.rand.nextBoolean());
	}

	protected String getDefaultDNA(boolean isMale)
	{
		if (isMale)
		{
			char[] dnaString = new char[3];
			dnaString[0] = Nucleobases.getRandomAT(this.rand).getNucleobaseLetter();
			dnaString[1] = Nucleobases.getRandomACGT(this.rand).getNucleobaseLetter();
			dnaString[2] = Nucleobases.getRandomACGT(this.rand).getNucleobaseLetter();
			return String.copyValueOf(dnaString);
		}
		else
		{
			char[] dnaString = new char[3];
			dnaString[0] = Nucleobases.getRandomCG(this.rand).getNucleobaseLetter();
			dnaString[1] = Nucleobases.getRandomACGT(this.rand).getNucleobaseLetter();
			dnaString[2] = Nucleobases.getRandomACGT(this.rand).getNucleobaseLetter();
			return String.copyValueOf(dnaString);
		}
	}

	public void setTextureID(byte id)
	{
		this.dataManager.set(EntityDeExtinctedAnimal.TEXTURE_ID, Byte.valueOf(id));
	}

	public byte getTextureID()
	{
		return this.dataManager.get(EntityDeExtinctedAnimal.TEXTURE_ID);
	}

	public ResourceLocation getTexture()
	{
		return this.texture;
	}

	public void setTexture(ResourceLocation texture)
	{
		this.texture = texture;
	}

	public void setTexture(int id)
	{
		if (this.isMale())
			this.texture = this.getAnimal().getMaleAnimalTextures().get(id).getResourceLocation();
		else
			this.texture = this.getAnimal().getFemaleAnimalTextures().get(id).getResourceLocation();
	}

	public byte getGrowthStage()
	{
		return this.dataManager.get(EntityDeExtinctedAnimal.STAGE);
	}

	private void setGrowthStage(byte growthStage)
	{
		this.dataManager.set(EntityDeExtinctedAnimal.STAGE, growthStage);
	}

	public float getGrowthScaled()
	{
		return this.getGrowthStage() / this.getMaxGrowthStage();
	}

	public int getGrowingAge()
	{
		return this.growingAge;
	}

	public void setGrowingAge(int growingAge)
	{
		this.growingAge = growingAge;
	}

	public float getModelScale()
	{
		return this.dataManager.get(EntityDeExtinctedAnimal.SCALE);
	}

	private void setModelScale(Float scale)
	{
		this.dataManager.set(EntityDeExtinctedAnimal.SCALE, scale);
	}

	protected final void setScale(float scale)
	{
		super.setSize(this.getMaxWidth() * scale, this.getMaxHeight() * scale);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.animID != DeAnimationList.NO_ANIMATION)
			this.animTick++;
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		this.onGrowthUpdate();

		this.onHungerUpdate();
	}

	protected void onGrowthUpdate()
	{
		if (!this.world.isRemote)
		{
			this.growingAge++;

			if (this.ticksExisted % 20 == 0)
			{
				int nextGrowthStage = (int) this.getGrowthStage() + 1;

				List<Integer> growths = this.getAttributes().getGrowth();
				if (nextGrowthStage < growths.size())
				{
					int nextGrowthAge = growths.get(nextGrowthStage);

					if (this.growingAge > nextGrowthAge)
						this.setGrowthStage((byte) nextGrowthStage);
				}
			}
		}
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key)
	{
		if (EntityDeExtinctedAnimal.STAGE.equals(key))
		{
			if (this.world.isRemote)
			{
				this.updateBoundingBox(this.getGrowthStage());
				this.setTexture(this.getTextureID());
			}
			else
				this.updateAttributes(this.getGrowthStage());
		}

		super.notifyDataManagerChange(key);
	}

	private void updateAttributes(int growthStage)
	{
		AnimalAttributes attributes = this.getAttributes();

		int maxGrowthStage = this.getMaxGrowthStage();
		double prevHealth = this.getMaxHealth();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(attributes.getHealth().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(attributes.getKnockbackResistance().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(attributes.getMovementSpeed().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(attributes.getArmor().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(attributes.getArmorToughness().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(EntityLivingBase.SWIM_SPEED).setBaseValue(attributes.getSwimSpeed().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(attributes.getFollowRange().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(attributes.getAttack().interpolate(growthStage, maxGrowthStage));
		this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(attributes.getFlyingSpeed().interpolate(growthStage, maxGrowthStage));

		if (prevHealth != this.getMaxHealth())
			this.heal((float) (this.getMaxHealth() - prevHealth));

		if (!this.world.isRemote)
			this.updateAIFromGrowthStage(growthStage);
	}

	protected void updateAIFromGrowthStage(int growthStage)
	{

	}

	private void updateBoundingBox(int growthStage)
	{
		float scale = 1.0F;
		if (this.isAdult())
			scale = (float) this.getAttributes().getScaleAdult().interpolate(growthStage, this.getMaxGrowthStage());
		else
			scale = (float) this.getAttributes().getScaleBaby().interpolate(growthStage, this.getMaxGrowthStage());
		this.setSize(this.getMaxWidth() * scale, this.getMaxHeight() * scale);
		this.setModelScale(scale);
		this.stepHeight = this.getStepHeight(growthStage);
	}

	public void debug()
	{
		String debugMsg = "\n";
		debugMsg += "Growth Stage = " + this.getGrowthStage() + "\n";
		debugMsg += "Growing Age = " + this.getGrowingAge() + "\n";
		debugMsg += "DNA = " + this.getDNAString() + "\n";
		for (IAttributeInstance attribute : this.getAttributeMap().getAllAttributes())
			debugMsg += attribute.getAttribute().getName() + " = " + attribute.getBaseValue() + "\n";

		debugMsg += "==============================";
		debugMsg += "getMaxHealth = " + this.getMaxHealth() + "\n";
		debugMsg += "getHealth = " + this.getHealth() + "\n";

		System.out.println(debugMsg);
	}

	public float getStepHeight(int growthStage)
	{
		return Math.max(1.0F, (float) (Math.ceil(this.height / 2.0F) / 2.0F));
	}

	public byte getMaxGrowthStage()
	{
		return (byte) (this.getAttributes().getGrowth().size() - 1);
	}

	public boolean isNewborn()
	{
		return this.getGrowthStage() == (byte) 0;
	}

	public boolean isFullyGrown()
	{
		return this.getGrowthStage() >= this.getMaxGrowthStage();
	}

	protected void onHungerUpdate()
	{
		if (!this.world.isRemote)
			this.increaseHunger();
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack heldItemStack = player.getHeldItem(hand);
		if (!heldItemStack.isEmpty())
			return this.interactWithItemStack(player, heldItemStack, heldItemStack.getItem());
		else
			return this.interactWithBareHand(player);
	}

	protected boolean interactWithBareHand(EntityPlayer player)
	{
		return false;
	}

	protected boolean interactWithItemStack(EntityPlayer player, ItemStack heldItemStack, Item heldItem)
	{
		if (this.feedWithItem(player, heldItemStack, heldItem))
			return true;

		if (this.processInteractSpawnEgg(player, heldItemStack))
			return true;

		return false;
	}

	private boolean feedWithItem(EntityPlayer player, ItemStack heldItemStack, Item heldItem)
	{
		if (!this.world.isRemote)
		{
			if (this.isNotFull())
			{
				if (this.getCreatureFoodList().contains(heldItem))
				{
					if (!player.capabilities.isCreativeMode)
						heldItemStack.shrink(1);

					String unlocalizedName = heldItemStack.getUnlocalizedName();
					int foodAmount;

					if (DeDatabase.FOOD_LIST.containsKey(unlocalizedName))
						foodAmount = DeDatabase.FOOD_LIST.get(unlocalizedName);
					else
						foodAmount = (int) (0.1F * MinecraftTime.MC_DAY_LENGHT);

					this.decreaseHunger(foodAmount);
					this.heal(foodAmount / 10000);

					this.setEntityStateEating(this, heldItem);
					this.eatingSpecialEvent(player, heldItemStack, heldItem);
					return true;
				}
			}
		}
		return false;
	}

	public void setEntityStateEating(EntityDeExtinctedAnimal entity, Item heldItem)
	{
		this.world.setEntityState(this, EntityDeExtinctedAnimal.ENTITY_STATE_EATING);
	}

	protected void eatingSpecialEvent(EntityPlayer player, ItemStack heldItemStack, Item heldItem)
	{

	}

	protected boolean processInteractSpawnEgg(EntityPlayer player, ItemStack heldItemStack)
	{
		if (heldItemStack.getItem() == Items.SPAWN_EGG)
		{
			if (!this.world.isRemote)
			{
				Class<? extends Entity> oclass = EntityList.getClass(ItemMonsterPlacer.getNamedIdFrom(heldItemStack));

				if (oclass != null && this.getClass() == oclass)
				{
					EntityCreature entityCreature = this.getAnimal().getEntity(this.world);
					if (entityCreature instanceof EntityDeExtinctedAnimal)
					{
						EntityDeExtinctedAnimal entityAnimal = (EntityDeExtinctedAnimal) entityCreature;

						entityAnimal.setLocationAndAngles(this.posX + 0.25D - 0.50D * this.world.rand.nextDouble(), this.posY, this.posZ + 0.25D - 0.50D * this.world.rand.nextDouble(), 0.0F, 0.0F);
						entityAnimal.initAnimal(this.getDNAString());
						this.world.spawnEntity(entityAnimal);
					}
					else
					{
						entityCreature.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
						this.world.spawnEntity(entityCreature);
					}

					if (heldItemStack.hasDisplayName())
						entityCreature.setCustomNameTag(heldItemStack.getDisplayName());

					if (!player.capabilities.isCreativeMode)
						heldItemStack.shrink(1);
				}
			}
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean attackEntityAsMob(Entity target)
	{
		boolean hasAttacked = target.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

		if (hasAttacked)
			this.applyEnchantments(this, target);

		return hasAttacked;
	}

	private byte getDeFlags()
	{
		return this.dataManager.get(EntityDeExtinctedAnimal.STATES).byteValue();
	}

	protected boolean getDeFlag(int flag)
	{
		return (((Byte) this.dataManager.get(EntityDeExtinctedAnimal.STATES)).byteValue() & 1 << flag) != 0;
	}

	private void setDeFlags(byte flag)
	{
		this.dataManager.set(EntityDeExtinctedAnimal.STATES, Byte.valueOf((byte) flag));
	}

	protected void setDeFlag(int flag, boolean set)
	{
		byte states = ((Byte) this.dataManager.get(EntityDeExtinctedAnimal.STATES)).byteValue();

		if (set)
			this.dataManager.set(EntityDeExtinctedAnimal.STATES, Byte.valueOf((byte) (states | 1 << flag)));
		else
			this.dataManager.set(EntityDeExtinctedAnimal.STATES, Byte.valueOf((byte) (states & ~(1 << flag))));
	}

	public void setAnimalTarget(EntityLivingBase creature)
	{
		this.animalTarget = creature;
	}

	public EntityLivingBase getAnimalTarget()
	{
		return this.animalTarget;
	}

	public boolean getGender()
	{
		return this.getDeFlag(EntityDeExtinctedAnimal.FLAG_GENDER);
	}

	public boolean isFemale()
	{
		return !this.getGender();
	}

	public boolean isMale()
	{
		return this.getGender();
	}

	protected void setGender(boolean isMale)
	{
		this.setDeFlag(EntityDeExtinctedAnimal.FLAG_GENDER, isMale);
	}

	protected void setMale()
	{
		this.setGender(EntityDeExtinctedAnimal.MALE);
	}

	protected void setFemale()
	{
		this.setGender(EntityDeExtinctedAnimal.FEMALE);
	}

	public boolean isSitting()
	{
		return this.getDeFlag(EntityDeExtinctedAnimal.FLAG_SITTING);
	}

	public void setSitting(boolean isSitting, EntityPlayer player)
	{
		this.handleSittingText(player);
		this.setDeFlag(EntityDeExtinctedAnimal.FLAG_SITTING, isSitting);
	}

	public void setSitting(boolean isSitting)
	{
		this.setDeFlag(EntityDeExtinctedAnimal.FLAG_SITTING, isSitting);
	}

	public boolean isSleeping()
	{
		return this.getDeFlag(EntityDeExtinctedAnimal.FLAG_SLEEPING);
	}

	public void setSleeping(boolean isSleeping)
	{
		if (isSleeping && !this.isSitting())
			this.setSitting(true);
		this.setDeFlag(EntityDeExtinctedAnimal.FLAG_SLEEPING, isSleeping);
	}

	public boolean isFlying()
	{
		return this.getDeFlag(EntityDeExtinctedAnimal.FLAG_FLYING);
	}

	public void setFlying(boolean isFlying)
	{
		this.setDeFlag(EntityDeExtinctedAnimal.FLAG_FLYING, isFlying);
	}

	@Override
	public void setAnimID(int id)
	{
		this.animID = id;
	}

	@Override
	public int getAnimID()
	{
		return this.animID;
	}

	public boolean canAnimate()
	{
		return this.animID == DeAnimationList.NO_ANIMATION;
	}

	@Override
	public void setAnimTick(int tick)
	{
		this.animTick = tick;
	}

	@Override
	public int getAnimTick()
	{
		return this.animTick;
	}

	public void setAnimation(int animationID)
	{
		if (this.animID == 0)
			DeExtinction.sendAnimPacket(this, animationID);
	}

	public boolean hasBeenHurt()
	{
		return this.hurtTime > 0;
	}

	public boolean isAnyHungry()
	{
		return this.hunger < this.getMaxHunger();
	}

	public boolean isNotFull()
	{
		return this.hunger < (int) (0.8F * this.getMaxHunger());
	}

	public boolean isHungry()
	{
		return this.hunger < (int) (0.5F * this.getMaxHunger());
	}

	public int getHunger()
	{
		return this.hunger;
	}

	public void setHunger(int newHunger)
	{
		if (newHunger < 0)
			this.hunger = 0;
		else if (newHunger > this.getMaxHunger())
			this.hunger = this.getMaxHunger();
		else
			this.hunger = newHunger;
	}

	public void decreaseHunger(int amount)
	{
		int newHunger = this.hunger + amount;
		if (newHunger < this.getMaxHunger())
			this.hunger = newHunger;
		else
			this.hunger = this.getMaxHunger();
	}

	public void decreaseHunger()
	{
		if (this.hunger < this.getMaxHunger())
			this.hunger++;
		else
			this.hunger = this.getMaxHunger();
	}

	public void increaseHunger(int amount)
	{
		int newHunger = this.hunger - amount;
		if (newHunger > 0)
			this.hunger = newHunger;
		else
			this.hunger = 0;
	}

	public void increaseHunger()
	{
		if (this.hunger > 0)
			this.hunger--;
		else
			this.hunger = 0;
	}

	public void handleSittingText(EntityPlayer player)
	{
		if (player != null)
			this.showChatMessage(player, this.getDisplayName() + (this.isSitting() ? I18n.translateToLocal("entity.info.sitting") : I18n.translateToLocal("entity.info.notsitting")));
	}

	@Override
	public int getTalkInterval()
	{
		return 20;
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.3F + 0.7F * this.getGrowthScaled();
	}

	@Override
	public boolean isChild()
	{
		return !this.isAdult();
	}

	public void showChatMessage(EntityPlayer player, String text)
	{
		if (this.world.isRemote && player != null && text != null)
			player.sendMessage(new TextComponentString(text));
	}

	public void spawnParticlesInMouthFromItem(Item item, int amount, double distance, double mouthHeight, double speed)
	{
		double dx = distance * MathHelper.cos(0.01745329251F * this.rotationYawHead + 1.57079632679F);
		double dz = distance * MathHelper.sin(0.01745329251F * this.rotationYawHead + 1.57079632679F);
		int itemID = Item.getIdFromItem(item);
		for (int i = 0; i < amount; i++)
			this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX + dx, this.posY + mouthHeight * (double) this.getEyeHeight(), this.posZ + dz, (this.rand.nextDouble() - 0.5D) * speed, (this.rand.nextDouble() - 0.5D) * speed, (this.rand.nextDouble() - 0.5D) * speed, new int[] { itemID });
	}

	public void spawnParticlesInMouth(EnumParticleTypes particle, int amount, double distance, double mouthHeight, double speed)
	{
		double dx = distance * MathHelper.cos(0.01745329251F * this.rotationYawHead + 1.57079632679F);
		double dz = distance * MathHelper.sin(0.01745329251F * this.rotationYawHead + 1.57079632679F);
		for (int i = 0; i < amount; i++)
			this.world.spawnParticle(particle, this.posX + dx, this.posY + mouthHeight * (double) this.getEyeHeight(), this.posZ + dz, (this.rand.nextDouble() - 0.5D) * speed, (this.rand.nextDouble() - 0.5D) * speed, (this.rand.nextDouble() - 0.5D) * speed);
	}

	public void spawnBubbleParticles(int amount, double distance, double mouthHeight, double speed)
	{
		double dx = distance * MathHelper.cos(0.01745329251F * this.rotationYawHead + 1.57079632679F);
		double dz = distance * MathHelper.sin(0.01745329251F * this.rotationYawHead + 1.57079632679F);
		for (int i = 0; i < amount; i++)
			this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + dx, this.posY + mouthHeight * (double) this.getEyeHeight(), this.posZ + dz, (this.rand.nextDouble() - 0.5D) * 0.25D * speed, 0.25D * speed, (this.rand.nextDouble() - 0.5D) * 0.25D * speed);
	}

	public boolean isPathClear(Vec3d pos1, Vec3d pos2)
	{
		RayTraceResult movingobjectposition = this.world.rayTraceBlocks(pos1, new Vec3d(pos2.x, pos2.y, pos2.z), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
	}

	public boolean isPathClearTo(Vec3d pos)
	{
		RayTraceResult movingobjectposition = this.world.rayTraceBlocks(this.getPositionVector(), new Vec3d(pos.x, pos.y, pos.z), false, true, false);
		return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
	}

	public BlockPos getSurface(World world, BlockPos pos)
	{
		if (world.isAirBlock(pos))
		{
			while (world.isAirBlock(pos))
				pos = pos.down();
			return pos;
		}
		else
		{
			while (!world.isAirBlock(pos))
				pos = pos.up();
			return pos;
		}
	}

	public BlockPos getSurface(EntityLivingBase entity)
	{
		if (!entity.isInWater())
			return entity.getPosition();

		return this.getSurface(entity.getEntityWorld(), entity.getPosition().down());
	}

	public BlockPos getSurface()
	{
		if (!this.isInWater())
			return this.getPosition();

		return this.getSurface(this.getEntityWorld(), this.getPosition().down());
	}

	public BlockPos getWaterDepth(World world, BlockPos pos, BlockPos surface)
	{
		if (!(world.getBlockState(pos).getBlock() instanceof BlockLiquid))
			return pos;

		surface = surface.down();

		while (world.getBlockState(surface).getBlock() instanceof BlockLiquid)
			surface = surface.down();

		return surface.up();
	}

	public BlockPos getWaterDepth(World world, BlockPos pos)
	{
		if (!(world.getBlockState(pos).getBlock() instanceof BlockLiquid))
			return pos;

		BlockPos surface = this.getSurface(world, pos);
		surface = surface.down();

		while (world.getBlockState(surface).getBlock() instanceof BlockLiquid)
			surface = surface.down();

		return surface.up();
	}

	public BlockPos getWaterDepth(BlockPos surface)
	{
		if (!(this.world.getBlockState(this.getPosition()).getBlock() instanceof BlockLiquid))
			return this.getPosition();

		surface.down();

		while (this.world.getBlockState(surface).getBlock() instanceof BlockLiquid)
			surface = surface.down();

		return surface.up();
	}

	public BlockPos getWaterDepth()
	{
		if (!(this.world.getBlockState(this.getPosition()).getBlock() instanceof BlockLiquid))
			return this.getPosition();

		BlockPos surface = this.getSurface(this.world, this.getPosition());
		surface.down();

		while (this.world.getBlockState(surface).getBlock() instanceof BlockLiquid)
			surface = surface.down();

		return surface.up();
	}

	public BlockPos getWaterBottom(EntityLivingBase entity, BlockPos surface)
	{
		if (!entity.isInWater())
			return null;

		return this.getWaterDepth(entity.getEntityWorld(), entity.getPosition().down(), surface);
	}

	public BlockPos getWaterBottom(BlockPos surface)
	{
		if (!this.isInWater())
			return null;

		return this.getWaterDepth(this.getEntityWorld(), this.getPosition().down(), surface);
	}

	public BlockPos getWaterBottom(EntityLivingBase entity)
	{
		if (!entity.isInWater())
			return null;

		return this.getWaterDepth(entity.getEntityWorld(), entity.getPosition().down());
	}

	public BlockPos getWaterBottom()
	{
		if (!this.isInWater())
			return null;

		return this.getWaterDepth(this.getEntityWorld(), this.getPosition().down());
	}

	public int getDistanceToWaterBottom(EntityLivingBase entity)
	{
		if (!entity.isInWater())
			return 0;

		BlockPos bottom = this.getWaterDepth(entity.getEntityWorld(), entity.getPosition().down());
		return (int) (entity.posY - bottom.getY());
	}

	public int getDistanceToWaterBottom()
	{
		if (!this.isInWater())
			return 0;

		BlockPos bottom = this.getWaterDepth(this.world, this.getPosition().down());
		return (int) (this.posY - bottom.getY());
	}

	public String displayGrowingAge()
	{
		int days = MinecraftTime.getInGameDays(this.growingAge);
		String dayString = "";

		if (days == 0)
			dayString = I18n.translateToLocal("entity.creature.newborn");
		else if (days == 1)
			dayString = days + " " + I18n.translateToLocal("entity.creature.day");
		else
			dayString = days + " " + I18n.translateToLocal("entity.creature.days");

		return dayString;
	}

	public double displayHealth()
	{
		return (double) ((int) (100 * this.getHealth())) / 100;
	}

	public double displayMaxHealth()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue())) / 100;
	}

	public int displayHealthScaled(int scale)
	{
		return (int) ((double) scale * this.displayHealth() / this.displayMaxHealth());
	}

	public double displayKnockback()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue())) / 100;
	}

	public double getKnockback()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue();
	}

	public double displayMovementSpeed()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue())) / 100;
	}

	public double getMovementSpeed()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
	}

	public double displayArmor()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue())) / 100;
	}

	public double getArmor()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue();
	}

	public double displayArmorToughness()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue())) / 100;
	}

	public double getArmorToughness()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue();
	}

	public double displaySwimSpeed()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SWIM_SPEED).getAttributeValue())) / 100;
	}

	public double getSpeedSwimming()
	{
		return this.getEntityAttribute(SWIM_SPEED).getAttributeValue();
	}

	public double displayFollowRange()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue())) / 100;
	}

	public double getFollowRange()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).getAttributeValue();
	}

	public double displayAttack()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue())) / 100;
	}

	public double getAttack()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
	}

	public double displayAttackSpeed()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getAttributeValue())) / 100;
	}

	public double getAttackSpeed()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getAttributeValue();
	}

	public double displayFlyingSpeed()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).getAttributeValue())) / 100;
	}

	public double getFlyingSpeed()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).getAttributeValue();
	}

	public double displayLuck()
	{
		return (double) ((int) (100 * this.getEntityAttribute(SharedMonsterAttributes.LUCK).getAttributeValue())) / 100;
	}

	public double getLuck()
	{
		return this.getEntityAttribute(SharedMonsterAttributes.LUCK).getAttributeValue();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setString("DNA", this.getDNAString());
		tagCompound.setByte("TextureID", this.getTextureID());
		tagCompound.setInteger("GrowingAge", this.getGrowingAge());
		tagCompound.setByte("GrowthStage", this.getGrowthStage());
		tagCompound.setInteger("Hunger", this.getHunger());
		tagCompound.setByte("States", this.getDeFlags());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);

		if (tagCompound.hasKey("DNA"))
			this.setDNAString(tagCompound.getString("DNA"));

		if (tagCompound.hasKey("TextureID"))
		{
			this.setTextureID(tagCompound.getByte("TextureID"));
			this.setTexture(this.getTextureID());
		}

		if (tagCompound.hasKey("GrowingAge"))
			this.setGrowingAge(tagCompound.getInteger("GrowingAge"));

		if (tagCompound.hasKey("GrowthStage"))
			this.setGrowthStage(tagCompound.getByte("GrowthStage"));

		if (tagCompound.hasKey("Hunger"))
			this.setHunger(tagCompound.getInteger("Hunger"));

		if (tagCompound.hasKey("States"))
			this.setDeFlags(tagCompound.getByte("States"));
	}

	public abstract DeExtinctedAnimal getAnimal();

	public abstract boolean isAdult();

	public abstract int getMaxHunger();

	public abstract float getMaxHeight();

	public abstract float getMaxWidth();

	public abstract List<Item> getCreatureFoodList();

}
