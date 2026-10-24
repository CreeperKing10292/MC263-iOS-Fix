# Minecraft 26.3 iOS Fabric compatibility experiment

This mod cancels `com.mojang.blaze3d.platform.MacosUtil.disableCloseWindowMenuItem()V` before its JNA/Objective-C bridge runs. It does NOT fix JNA code signing, OSHI warnings, or other graphics problems.

## Build using GitHub Actions
1. Create a new GitHub repository and upload these files, preserving `.github/workflows/build.yml`.
2. In Actions, select **Build Fabric 26.3 iOS Fix** and **Run workflow** (or push to main).
3. Download the artifact. Inside, use `mc263-ios-fabric-fix-1.0.0.jar` (NOT a sources JAR).
4. Put it in the `mods` directory for the Amethyst `instances/new` game directory.
5. Launch Fabric Loader 0.20.1 for Minecraft 26.3.
6. Search the log for `[MC263-iOS-Fix] MacosUtil menu call intercepted and skipped`.

If the game crashes with a `MixinApplyError` or `InvalidInjectionException`, save that section of the log. The method name/signature is based on the user's 26.3 stack trace and has not been validated against the actual 26.3 JAR in this environment.

If the message appears but the game crashes later, the mixin has done its job; inspect the next error separately.
