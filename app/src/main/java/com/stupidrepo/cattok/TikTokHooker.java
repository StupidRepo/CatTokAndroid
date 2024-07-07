package com.stupidrepo.cattok;

import static com.stupidrepo.cattok.CatTok.TAG;

import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.BeforeInvocation;
import io.github.libxposed.api.annotations.XposedHooker;

@XposedHooker
public class TikTokHooker implements XposedInterface.Hooker {
    @BeforeInvocation
    public static TikTokHooker before(XposedInterface.BeforeHookCallback callback) {
        List<Object> videoList = (List<Object>) callback.getArgs()[0];
        int size = videoList.size();

//        AtomicInteger found = new AtomicInteger();

        Log.d(TAG, Objects.requireNonNull(callback.getThisObject()).getClass().getName());

        try {
            Class<?> awemeClass = Helpers.getClass("com.ss.android.ugc.aweme.feed.model.Aweme", callback.getMember().getDeclaringClass().getClassLoader());
            Field descField = awemeClass.getDeclaredField("desc");
            descField.setAccessible(true);

            videoList.removeIf(video -> {
                try {
                    String videoDescription = ((String) Objects.requireNonNull(descField.get(video))).replaceAll("#", "");
                    List<String> keywords = Arrays.asList(videoDescription.split(" "));

                    boolean flag = (keywords.contains("cat") || keywords.contains("catsoftiktok"));
//                    if(flag) found.getAndIncrement();

                    return !flag;
                } catch (Exception e) {
                    Log.e(TAG, "before: ", e);
                    return true;
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "before: ", e);
        }
//
//        if(found.get() == 0) {
//            Log.v(TAG, "before: No cat videos were found. TikTok algorithm is too strong! >:P");
//        }

        Log.v(TAG, "before: Video list had " + size + " videos, then got filtered down to " + videoList.size() + " videos!");

        callback.getArgs()[0] = videoList;
        return new TikTokHooker();
    }
}