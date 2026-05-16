# Triit - Hyper-Local Carpooling Platform

A privacy-first, peer-to-peer hyper-local carpooling platform designed specifically for Indian commuters.

## 🚀 Core Concept

Triit connects people living within a **400-meter radius** to share daily commutes safely and affordably. The platform focuses on:

- ✅ Reducing traffic congestion
- ✅ Lowering fuel and travel costs
- ✅ Encouraging community-based ride sharing
- ✅ Maintaining user privacy
- ✅ Providing AI-powered safety guidance

**Zero-commission community-driven model** where drivers and passengers directly coordinate rides.

---

## 📱 Features

### 1. Authentication
- Mobile OTP verification
- Google Sign-In
- Profile setup with vehicle details
- Trust score & ratings system

### 2. Home Screen
- Current location display
- Nearby ride matches (400m radius)
- AI Safety Tips card
- Smart FAB & Bottom Navigation

### 3. Ride Matching System
- Intelligent matching based on location, destination, time
- Show nearby neighbors first
- Integrated map visualization
- Trust score & estimated cost display

### 4. AI Safety Assistant
- Gemini AI-powered real-time safety tips
- Safe pickup suggestions
- Late-night travel risk detection
- AI commute recommendations

### 5. Live Map & Tracking
- Google Maps integration
- Real-time route display
- Live ride tracking
- Pickup/drop visualization

### 6. Community Features
- Ride history & reviews
- Community badges
- Trusted neighbor labels
- Emergency SOS button
- Share live ride status

### 7. Notifications
- Ride request alerts
- Match notifications
- Driver arrival alerts
- Safety reminders

---

## 🛠 Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM + Repository Pattern
- **Authentication**: Firebase Auth
- **Database**: Firebase Firestore
- **Maps**: Google Maps API
- **AI**: Gemini API
- **Async**: Coroutines + Flow
- **DI**: Hilt
- **Design**: Material 3

---

## 📁 Project Structure

```
triit-android/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/com/triit/
│   │   │   │   ├── di/                    # Dependency Injection
│   │   │   │   ├── data/                  # Data layer (Repositories, API)
│   │   │   │   ├── domain/                # Domain layer (Models, Use cases)
│   │   │   │   ├── presentation/          # UI layer (ViewModels, Screens)
│   │   │   │   │   ├── screens/
│   │   │   │   │   ├── components/
│   │   │   │   │   ├── theme/
│   │   │   │   │   └── navigation/
│   │   │   │   ├── TriitApp.kt            # Main App
│   │   │   │   └── MainActivity.kt
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/
│   └── libs.versions.toml
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 🎨 Design System

### Colors
- **Primary**: Deep Blue (`#0A1E3F`)
- **Accent**: Electric Purple (`#7C3AED`)
- **Background**: Dark (`#0F172A`)
- **Surface**: (`#1E293B`)

### Fonts
- Roboto (Material 3 default)

### Components
- Rounded cards (16dp)
- Glassmorphism effects
- Smooth animations
- Dark mode support

---

## 🔧 Setup Instructions

### Prerequisites
- Android Studio Arctic Fox or newer
- Kotlin 1.8+
- Gradle 8.0+
- Firebase project
- Google Maps API key
- Gemini API key

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Nand8282/triit-android.git
   cd triit-android
   ```

2. **Configure Firebase**
   - Download `google-services.json` from Firebase Console
   - Place in `app/` directory

3. **Add API Keys** (in `local.properties`)
   ```properties
   GOOGLE_MAPS_API_KEY=your_key_here
   GEMINI_API_KEY=your_key_here
   ```

4. **Build & Run**
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

---

## 📦 Dependencies

See `gradle/libs.versions.toml` for complete dependency list.

Key dependencies:
- `androidx.compose.*` - Jetpack Compose
- `com.google.firebase.*` - Firebase services
- `com.google.android.gms:play-services-maps` - Google Maps
- `com.google.ai.client.generativeai` - Gemini AI
- `com.google.dagger:hilt-android` - Dependency Injection
- `org.jetbrains.kotlinx:kotlinx-coroutines-*` - Coroutines

---

## 🚀 Getting Started

1. Check out the [ARCHITECTURE.md](ARCHITECTURE.md) for detailed architecture overview
2. Review [SETUP.md](SETUP.md) for step-by-step setup guide
3. Explore example screens in `presentation/screens/`

---

## 📝 Development Workflow

- **Create feature branch**: `git checkout -b feature/your-feature`
- **Follow MVVM pattern**: ViewModel → Repository → API/Firebase
- **Use Compose**: Build UI with composables, not XML
- **Write tests**: Unit tests for ViewModels and repositories
- **Code style**: Follow Kotlin style guide

---

## 🔐 Privacy & Security

- ✅ Privacy-first approach
- ✅ End-to-end encryption for messages
- ✅ User data stored locally with Firestore encryption
- ✅ No personal data sharing without consent
- ✅ GDPR compliant

---

## 📄 License

MIT License - see LICENSE file

---

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md)

---

## 📞 Support

For issues, feature requests, or questions, please open a GitHub issue.

---

**Built with ❤️ for Indian commuters**
