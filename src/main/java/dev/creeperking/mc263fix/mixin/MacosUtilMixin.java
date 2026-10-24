package dev.creeperking.mc263fix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.mojang.blaze3d.platform.MacosUtil", remap = false)
public abstract class MacosUtilMixin {
    @Inject(method = "disableCloseWindowMenuItem()V", at = @At("HEAD"), cancellable = true, remap = false, require = 1)
    private static void mc263iosfix$skipMacMenu(CallbackInfo ci) {
        System.out.println("[MC263-iOS-Fix] MacosUtil menu call intercepted and skipped");
        ci.cancel();
    }
}
