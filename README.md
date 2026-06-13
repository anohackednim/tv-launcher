# TV Launcher

A modern Android TV launcher application that displays installed apps in a grid format optimized for TV viewing.

## Features

✅ **App Grid Display** - Shows all installed applications in a 5-column grid layout
✅ **TV Optimized** - Designed for Android TV with Leanback support
✅ **App Icons** - Displays app icons using Glide image loading
✅ **Launch Apps** - Tap any app to launch it directly
✅ **System Integration** - Can be set as default launcher on TV devices
✅ **Dark Theme** - TV-friendly dark interface

## Requirements

- Android SDK 34 (API Level 34)
- Minimum Android Version: 5.0 (API Level 21)
- Java 8 or higher

## Build Instructions

### Prerequisites
1. Install Android Studio
2. Download Android SDK 34
3. Clone this repository

### Build Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/anohackednim/tv-launcher.git
   cd tv-launcher
   ```

2. **Set up Android SDK path:**
   - Open `local.properties` and add your SDK path:
     ```
     sdk.dir=/path/to/android/sdk
     ```
   - Or let Android Studio configure it automatically

3. **Build the APK:**
   ```bash
   ./gradlew assembleDebug
   ```
   - For release build: `./gradlew assembleRelease`

4. **Find the APK:**
   - Debug APK: `app/build/outputs/apk/debug/app-debug.apk`
   - Release APK: `app/build/outputs/apk/release/app-release.apk`

## Installation

### On Android TV Device

#### Method 1: Using Android Studio
1. Connect your TV via ADB
2. In Android Studio, click **Run** > **Run 'app'**

#### Method 2: Using Command Line
```bash
./gradlew installDebug
```

#### Method 3: Manual Installation
1. Copy the APK to your TV
2. Use a file manager to locate and install it
3. Or use adb:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

### Set as Default Launcher

1. Press the Home button on your TV remote
2. Long press or hold to open the system menu
3. Go to **Settings** > **Applications** > **Default applications**
4. Set "TV Launcher" as the default home app

## Project Structure

```
tv-launcher/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/yahya/launcher/
│   │       │   ├── MainActivity.java          # Main activity
│   │       │   ├── AppInfo.java              # App model
│   │       │   └── AppAdapter.java           # RecyclerView adapter
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml     # Main layout
│   │       │   │   └── app_item.xml          # App grid item
│   │       │   ├── values/
│   │       │   │   ├── colors.xml            # Color definitions
│   │       │   │   ├── strings.xml           # String resources
│   │       │   │   └── styles.xml            # Style definitions
│   │       │   └── AndroidManifest.xml
│   │       └── proguard-rules.pro
│   ├── build.gradle
│   └── gradle.properties
├── build.gradle
├── settings.gradle
└── README.md
```

## Dependencies

- **AndroidX AppCompat** - Compatibility library
- **AndroidX RecyclerView** - Efficient list/grid display
- **Google Material Design** - Material components
- **Glide** - Image loading and caching

## Technologies Used

- **Language:** Java
- **Build System:** Gradle
- **Target Platform:** Android TV
- **Minimum API:** 21
- **Compile API:** 34

## Permissions

The app requests the following permissions:
- `INTERNET` - For loading app data
- `ACCESS_WIFI_STATE` - To detect network status
- `BLUETOOTH` - For device connectivity
- `BLUETOOTH_CONNECT` - For Bluetooth operations
- `READ_EXTERNAL_STORAGE` - To access app data
- `RECEIVE_BOOT_COMPLETED` - To start on device boot
- `KILL_BACKGROUND_PROCESSES` - To manage background apps

## Troubleshooting

### APK Won't Install
- Ensure minimum API 21 is set
- Check that all permissions are correctly defined in AndroidManifest.xml
- Verify device has enough storage space

### Apps Not Showing
- Check device has apps installed
- Verify READ_EXTERNAL_STORAGE permission is granted
- Restart the launcher

### Build Fails
- Run `./gradlew clean` before building
- Ensure Java 8 or higher is installed
- Check Android SDK is properly configured

## Contributing

Feel free to fork this project and submit pull requests for improvements.

## License

This project is open source and available under the MIT License.

## Author

**Yahya** - TV Launcher Developer

## Support

For issues, questions, or suggestions, please open an issue on GitHub.

---

**Happy Launching! 📺🚀**
