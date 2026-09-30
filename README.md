# AutoPilot Android — Buildable V1

This is an Android Studio project for the first AutoPilot version.

## Included
- Telegram Bot API test/send module
- AI reply service (OpenAI-compatible Chat Completions endpoint)
- Accessibility Service for authorized live UI monitoring
- Instagram workflow abstraction for a supported publishing integration

## Build on Windows
1. Install Android Studio (a current stable release).
2. Open this folder: `AutoPilotAndroid`.
3. Allow Android Studio to install/sync the Android Gradle Plugin and required SDK components if prompted.
4. Use **Build > Make Project**.
5. Then use **Build > Build APK(s)**.
6. The debug APK will normally be under:
   `app/build/outputs/apk/debug/app-debug.apk`

## Phone
Enable installation from the file manager/browser when Android asks.
Then install the generated `app-debug.apk`.

## Accessibility
After installing:
Settings → Accessibility → AutoPilot → Allow.

## Telegram
Create a bot with Telegram's BotFather, enter its token in the app, and use the target chat ID.

## AI
Enter an OpenAI-compatible endpoint and API key.
For a production app, do NOT embed a permanent API key in the APK. Use a secure backend.

## Important
This project is a buildable V1 foundation, not a finished autonomous Instagram/Telegram agent.
Instagram publishing should use supported Meta/Instagram APIs for eligible accounts.
