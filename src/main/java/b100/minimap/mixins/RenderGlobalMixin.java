package b100.minimap.mixins;

import b100.minimap.Minimap;

import net.minecraft.client.render.RenderGlobal;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = RenderGlobal.class, remap = false)
public abstract class RenderGlobalMixin {
    @Inject(method = "loadRenderers", at = @At("TAIL"))
	protected void loadRenderers(CallbackInfo ci) {
	    Minimap.instance.mapRender.onUpdateAllChunks();
	}
}
