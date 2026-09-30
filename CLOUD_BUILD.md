# Build APK without a 64-bit PC

This project contains a GitHub Actions workflow. GitHub builds the APK on its cloud runner, so Android Studio is not required on your 32-bit Windows PC.

1. Create/sign in to GitHub.
2. Create a new repository, e.g. AutoPilotAndroid.
3. Upload all project files, including `.github/workflows/build-apk.yml`.
4. Commit to `main`.
5. Open **Actions** → **Build AutoPilot APK**.
6. Click **Run workflow** if it has not started automatically.
7. When finished, open the run and download the **AutoPilot-debug-apk** artifact.
8. Extract it and install `app-debug.apk` on your Android phone.

Do not upload Telegram bot tokens, AI keys, passwords, or other secrets to the repository.
