package com.stupidrepo.cattok;

import android.util.Log;

import androidx.annotation.NonNull;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.XposedModule;

public class CatTok extends XposedModule {
    public static final String TAG = "CatTok";

    public CatTok(@NonNull XposedInterface base, @NonNull ModuleLoadedParam param) {
        super(base, param);
        Log.d(TAG, "CatTok: I am alive!");
    }

    @Override
    public void onPackageLoaded(@NonNull PackageLoadedParam param) {
        super.onPackageLoaded(param);

        if (!param.isFirstPackage()) return;

        try {
            hook(Helpers.getMethodFromClass("com.ss.android.ugc.aweme.feed.adapter.FullFeedPagerAdapter",
                            "setData",
                            param.getClassLoader()), TikTokHooker.class);
        } catch (Exception e) {
            Log.e(TAG, "onPackageLoaded: ", e);
        }
    }
}
