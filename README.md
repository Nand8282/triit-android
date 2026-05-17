# Triit - Hyper-Local Peer-to-Peer Carpooling Platform

![Triit Logo](https://img.shields.io/badge/Triit-v1.0.0-blue?style=for-the-badge)

**Triit** is a privacy-first, community-driven carpooling application designed specifically for Indian commuters. Connect with people living within a 400-meter radius to share daily commutes safely and affordably.

## 🎯 Core Features

- **Hyper-Local Matching**: Find commuters within 400m radius
- **Privacy-First Design**: Minimal data collection, decentralized approach
- **Zero Commission**: Direct peer-to-peer coordination
- **AI Safety Assistant**: Gemini-powered real-time safety recommendations
- **Trust-Based Community**: Ratings, reviews, and community badges
- **Live Tracking**: Google Maps integration for real-time ride updates
- **Emergency SOS**: One-tap emergency alert system
- **Multi-language Support**: Hindi, English, and regional languages (planned)

## 📱 Screenshots

Login Screen → Home Screen → Ride Matching → Safety Tips

## 🏗️ Architecture

### Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose with Material 3
- **Architecture**: MVVM + Clean Architecture
- **Dependency Injection**: Hilt
- **Asynchronous Programming**: Coroutines + Flow
- **Backend**: Firebase (Auth, Firestore, Messaging)
- **AI Integration**: Google Gemini API
- **Maps**: Google Maps API
- **Networking**: Retrofit + Moshi
- **Image Loading**: Coil
- **Logging**: Timber

### Project Structure

```
app/src/main/java/com/triit/
├── domain/
│   ├── model/          # Core data models
│   └── repository/     # Repository interfaces
├── data/
│   ├── repository/     # Repository implementations
│   ├── remote/         # Firebase/API integration
│   └── di/             # Dependency injection modules
├── presentation/
│   ├── ui/
│   │   ├── screen/     # Compose screens
│   │   ├── component/  # Reusable components
│   │   └── theme/      # Material 3 theming
│   └── viewmodel/      # MVVM ViewModels
└── MainActivity.kt
```

## 🎨 Design System

### Colors
- **Primary**: Deep Blue `#0B1E3F`
- **Accent**: Electric Purple `#8B5CF6`
- **Secondary**: Teal `#14B8A6`
- **Accent Green**: `#10B981`

### Typography
- **Font Family**: Poppins (Bold, SemiBold, Medium, Regular)
- **Material 3 Compliant**: Full text hierarchy
- **Dark Mode Support**: Optimized for both light and dark themes

### Components
- Rounded Cards (12dp-16dp border radius)
- Glassmorphism Effects
- Smooth Animations
- Bottom Navigation (4 tabs)
- Floating Action Button

## 🚀 Getting Started

### Prerequisites
- Android Studio Giraffe or later
- Kotlin 1.9.10+
- JDK 17
- Android SDK 34 (compileSdk)
- Min SDK 24

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Nand8282/triit-android.git
   cd triit-android
   ```

2. **Add Firebase Configuration**
   - Download `google-services.json` from Firebase Console
   - Place in `app/` directory

3. **Configure Gemini API**
   - Get API key from Google AI Studio
   - Add to `build.gradle.kts`:
     ```kotlin
     buildConfigField("String", "GEMINI_API_KEY", "\"YOUR_API_KEY\"")
     ```

4. **Build and Run**
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

## 📋 Features Implementation Status

### ✅ Completed
- [x] Project structure and architecture
- [x] Material 3 theme with brand colors
- [x] Domain models and repository interfaces
- [x] Dependency injection setup
- [x] ViewModels for core features
- [x] Login/Signup screens
- [x] Home screen with ride listings
- [x] Safety ViewModel with AI integration

### 🔄 In Progress
- [ ] Google Maps integration
- [ ] Real-time ride tracking
- [ ] Firebase authentication
- [ ] Firestore ride database
- [ ] Push notifications
- [ ] Bottom navigation screens (Rides, Community, Profile)

### 📅 Planned
- [ ] Community features (badges, trusted neighbors)
- [ ] Review and rating system
- [ ] Emergency SOS functionality
- [ ] Payment integration (Razorpay)
- [ ] Ride history and analytics
- [ ] Multi-language support
- [ ] Offline mode
- [ ] Performance optimization

## 🔐 Privacy & Security

- **Location Privacy**: Only shares location when actively finding rides
- **Data Minimization**: Collects only essential information
- **Encryption**: All communication over HTTPS
- **No Tracking**: No user tracking outside of active rides
- **User Control**: Full data export and deletion options

## 📞 Support & Community

- **Issues**: Report bugs on [GitHub Issues](https://github.com/Nand8282/triit-android/issues)
- **Discussions**: Join community on [GitHub Discussions](https://github.com/Nand8282/triit-android/discussions)
- **Email**: support@triit.dev (planned)

## 📜 License

MIT License - See LICENSE file for details

## 👨‍💻 Development

### Code Style
- Kotlin Official Style Guide
- 4-space indentation
- Meaningful variable names
- Comprehensive code comments

### Testing
- Unit tests with JUnit
- UI tests with Compose Test Framework
- Firebase emulator for local testing

### Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 🎓 Learning Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Material 3 Design System](https://m3.material.io/)
- [Firebase for Android](https://firebase.google.com/docs/android/setup)
- [Google Generative AI](https://ai.google.dev/tutorials/android_quickstart)
- [Android Architecture Components](https://developer.android.com/topic/architecture)

## 🙏 Acknowledgments

- Google for Jetpack Compose & Material Design
- Firebase for backend services
- Google Generative AI for safety assistance
- The Android community for inspiration

## 📱 Device Support

- **Minimum API**: 24 (Android 7.0)
- **Target API**: 34 (Android 14)
- **Architectures**: armeabi-v7a, arm64-v8a, x86, x86_64
- **Screen Sizes**: Phone, Tablet (Portrait & Landscape)

---

**Made with ❤️ for Indian Commuters**
