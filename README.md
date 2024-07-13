# CatTokAndroid
CatTokAndroid was made from an idea I had after I watched a video on YouTube. That video was "[Modding TikTok to only show Cat Videos][video]", by [Bryce Bostwick][bryce].

In the video mentioned, Bryce successfully modifies TikTok to only display videos that contain the word 'cat' in the description. This is awesome and cool but... he does this on **iOS**.

So I thought, why not make an Android version of this? And so, I made CatTokAndroid.

## How does it work?
CatTokAndroid uses the XPosed framework to hook into the `setData` method (in the `FullFeedPagerAdapter` class) that adapts videos from TikTok's servers to the FYP *(For You Page)* and simply cutting out the videos that don't contain the word 'cat' in their descriptions.

## How do I use it?
To use it, you need to have a rooted Android device with the Xposed Framework installed. If you have Magisk installed, you should use [LSPosed][lsposed].

> [!WARNING]
> ***LSPosed has been discontinued/archived.***
> 
> It is recommended to use an updated fork of LSPosed, such as [LSPosed_mod][lsposed_mod].
> 
> [LSPosed_mod][lsposed_mod] is secure and is trusted to be one of the better LSPosed forks than many others. It also works on the latest Android version(s), incl. the Android 15 betas.

### LSPosed
1. Install [LSPosed][lsposed][(_mod)][lsposed_mod].
2. After you've installed LSPosed, download the CatTokAndroid APK from the [Releases][releases] page and install it (or build it from source).
3. Now, enable the module in the LSPosed app.
4. Simply close TikTok completely (force quit it) and open it again.
5. You should now only see videos cat videos, providing the algorithm recommends at least 1 cat video to you.

[video]: https://www.youtube.com/watch?v=YW3jL2gI9IE
[bryce]: https://www.youtube.com/@brycedotco

[lsposed]: https://github.com/LSPosed/LSPosed
[lsposed_mod]: https://github.com/mywalkb/LSPosed_mod

[releases]: https://github.com/StupidRepo/CatTokAndroid/releases

## FAQ
### I can't see any videos at all, the FYP is just black!
This is because the algorithm doesn't recommend any cat videos to you. The algorithm is based on your interests and what you like.
If it doesn't think you're interested in cat videos, it won't recommend any to you and therefore there will be no videos returned from TikTok servers with the word `cat` in the description.

Simply try dragging down the screen to try and refresh. This should hopefully get you at least 1 cat video after a few attempts :)
### It doesn't load cat videos when I reach the bottom, and I have to swipe multiple times to load one!
This is because the amount of cat videos to other videos is not balanced and therefore, there could be a situation where the ratio of cat videos to other videos is **low**. This is not a bug, but a feature of the algorithm.

