# CatTokAndroid
CatTokAndroid was made from an idea I had after I watched a video on YouTube. This video was "[Modding TikTok to only show Cat Videos][video]", by [Bryce Bostwick][bryce].
In the video mentioned, Bryce successfully modifies TikTok to only display videos that contain the word 'cat' in the description. This is good and everything, however he does this on **iOS**. So I thought, why not make an Android version of this? And so, I made CatTokAndroid.

## How does it work?
CatTokAndroid uses the Xposed Framework to hook into TikTok's code and modify it to only show videos that contain the word 'cat' in the description. This is done by hooking into the method that adapts videos from TikTok's servers to the FYP *(For You Page)* and simply cutting out the videos that don't contain the word 'cat' in their descriptions.

## How do I use it?
To use it, you need to have a rooted Android device with the Xposed Framework installed. If you have Magisk installed, you should use [LSPosed][lsposed].

> *Warning*
> LSPosed has been discontinued/archived. It is recommended to use an updated fork of LSPosed, such as [LSPosed_mod][lsposed_mod]. LSPosed_mod is secure and is trusted to be one of the better LSPosed forks than many others. It also works on the latest Android version(s), incl. the Android 15 betas.

After you install [LSPosed][lsposed][(_mod)][lsposed_mod], you can download the CatTokAndroid APK from the [Releases][releases] page and install it (or build it from source). After that, you can enable the module in the LSPosed(_mod) app. After enabling the module, close TikTok completely (force quit it) and open it again. You should now only see videos cat videos, providing the algorithm recommends at least 1 cat video to you.

[video]: https://www.youtube.com/watch?v=YW3jL2gI9IE
[bryce]: https://www.youtube.com/@brycedotco

[lsposed]: https://github.com/LSPosed/LSPosed
[lsposed_mod]: https://github.com/mywalkb/LSPosed_mod

[releases]: https://github.com/StupidRepo/CatTokAndroid/releases
