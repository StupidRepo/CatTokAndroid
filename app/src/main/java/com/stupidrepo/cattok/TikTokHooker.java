package com.stupidrepo.cattok;

import static com.stupidrepo.cattok.CatTok.TAG;

import android.util.Log;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.BeforeInvocation;
import io.github.libxposed.api.annotations.XposedHooker;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

@XposedHooker
public class TikTokHooker implements XposedInterface.Hooker {
    @BeforeInvocation
    public static TikTokHooker before(XposedInterface.BeforeHookCallback callback) {
        List<Object> videoList = (List<Object>) callback.getArgs()[0];

        try {
            Class<?> awemeClass = Helpers.getClass("com.ss.android.ugc.aweme.feed.model.Aweme", callback.getMember().getDeclaringClass().getClassLoader());
            Field descField = awemeClass.getDeclaredField("desc");
            descField.setAccessible(true);

            videoList.removeIf(video -> {
                try {
                    String videoDescription = (String) descField.get(video);
                    return !Objects.requireNonNull(videoDescription).toLowerCase().contains("cat");
                } catch (Exception e) {
                    Log.e(TAG, "before: ", e);
                    return true;
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "before: ", e);
        }

        callback.getArgs()[0] = videoList;
        return new TikTokHooker();
    }
}