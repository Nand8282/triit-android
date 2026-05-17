package com.triit.domain.repository

import com.triit.domain.model.*
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun sendOTP(phone: String): Result<Unit>
    suspend fun verifyOTP(phone: String, otp: String): Result<String> // Returns user ID
    suspend fun signUpUser(user: User): Result<String>
    suspend fun getUserProfile(userId: String): Result<User>
    suspend fun updateUserProfile(user: User): Result<Unit>
    suspend fun loginWithGoogle(idToken: String): Result<String>
    suspend fun logout(): Result<Unit>
    fun getCurrentUserId(): String?
}

interface RideRepository {
    suspend fun createRide(ride: Ride): Result<String>
    suspend fun getRideById(rideId: String): Result<Ride>
    suspend fun getUserRides(userId: String): Result<List<Ride>>
    suspend fun getNearbyRides(latitude: Double, longitude: Double, radiusMeters: Int = 400): Result<List<Ride>>
    suspend fun getRideMatches(ride: Ride): Result<List<RideMatch>>
    suspend fun bookRide(rideId: String, userId: String): Result<Unit>
    suspend fun cancelRideBooking(rideId: String, userId: String): Result<Unit>
    suspend fun completeRide(rideId: String): Result<Unit>
    fun observeRideUpdates(rideId: String): Flow<Ride>
}

interface LocationRepository {
    suspend fun getCurrentLocation(): Result<Location>
    suspend fun getAddressFromCoordinates(latitude: Double, longitude: Double): Result<String>
    suspend fun getCoordinatesFromAddress(address: String): Result<Location>
    suspend fun calculateDistance(from: Location, to: Location): Double
    suspend fun calculateRoute(from: Location, to: Location): Result<List<Location>>
}

interface SafetyRepository {
    suspend fun generateSafetyTips(latitude: Double, longitude: Double, hour: Int): Result<String>
    suspend fun getSafetyTips(): Result<List<SafetyTip>>
    suspend fun reportUnsafeIncident(latitude: Double, longitude: Double, description: String): Result<Unit>
}

interface ReviewRepository {
    suspend fun addReview(review: Review): Result<String>
    suspend fun getReviewsForUser(userId: String): Result<List<Review>>
    suspend fun getRideReviews(rideId: String): Result<List<Review>>
}

interface CommunityRepository {
    suspend fun getNearbyMembers(latitude: Double, longitude: Double, radiusMeters: Int = 400): Result<List<CommunityMember>>
    suspend fun markAsTrusted(userId: String): Result<Unit>
    suspend fun getCommunityBadges(userId: String): Result<List<CommunityBadge>>
    suspend fun getRideHistory(userId: String): Result<List<Ride>>
}

interface NotificationRepository {
    suspend fun subscribeToRideNotifications(rideId: String): Result<Unit>
    suspend fun sendRideRequest(fromUserId: String, toUserId: String, rideId: String): Result<Unit>
    fun observeNotifications(): Flow<String>
}

interface SOSRepository {
    suspend fun triggerEmergencySOS(location: Location, rideId: String?, description: String): Result<String>
    suspend fun resolveEmergencySOS(sosId: String): Result<Unit>
    suspend fun getEmergencyContacts(userId: String): Result<List<EmergencyContact>>
}
