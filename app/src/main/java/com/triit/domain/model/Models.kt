package com.triit.domain.model

import java.util.Date

// User Model
data class User(
    val id: String = "",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val profileImageUrl: String? = null,
    val gender: String = "", // MALE, FEMALE, OTHER
    val vehicleDetails: VehicleDetails? = null,
    val officeLocation: Location? = null,
    val homeLocation: Location? = null,
    val trustScore: Float = 0f,
    val ratings: List<Float> = emptyList(),
    val averageRating: Float = 0f,
    val totalRides: Int = 0,
    val createdAt: Date = Date(),
    val isVerified: Boolean = false,
    val emergencyContacts: List<EmergencyContact> = emptyList()
)

data class VehicleDetails(
    val make: String = "",
    val model: String = "",
    val color: String = "",
    val licensePlate: String = "",
    val seatingCapacity: Int = 4,
    val registrationYear: Int = 2024,
    val insuranceExpiry: Date? = null
)

data class Location(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val address: String = "",
    val city: String = "",
    val landmark: String = ""
)

data class EmergencyContact(
    val name: String = "",
    val phone: String = "",
    val relation: String = ""
)

// Ride Model
data class Ride(
    val id: String = "",
    val driverId: String = "",
    val driver: User? = null,
    val pickupLocation: Location = Location(),
    val dropLocation: Location = Location(),
    val departureTime: Date = Date(),
    val estimatedArrivalTime: Date? = null,
    val availableSeats: Int = 4,
    val bookedSeats: Int = 0,
    val passengers: List<String> = emptyList(),
    val costPerSeat: Float = 0f,
    val rideStatus: String = "SCHEDULED", // SCHEDULED, IN_PROGRESS, COMPLETED, CANCELLED
    val route: List<Location> = emptyList(),
    val safetyRating: Float = 0f,
    val vehicleDetails: VehicleDetails? = null,
    val createdAt: Date = Date(),
    val notes: String = ""
)

// Ride Match Model
data class RideMatch(
    val id: String = "",
    val rideId: String = "",
    val userId: String = "",
    val user: User? = null,
    val distance: Double = 0.0, // in meters
    val matchScore: Float = 0f, // 0-100
    val estimatedCost: Float = 0f,
    val estimatedPickupTime: Long = 0, // in minutes
    val routeSimilarity: Float = 0f, // 0-100
    val createdAt: Date = Date(),
    val status: String = "PENDING" // PENDING, ACCEPTED, REJECTED
)

// Safety Tip Model
data class SafetyTip(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val riskLevel: String = "", // LOW, MEDIUM, HIGH
    val timeSlot: String = "", // MORNING, AFTERNOON, EVENING, NIGHT
    val createdAt: Date = Date()
)

// Review Model
data class Review(
    val id: String = "",
    val fromUserId: String = "",
    val toUserId: String = "",
    val rideId: String = "",
    val rating: Float = 0f, // 1-5
    val comment: String = "",
    val safetyRating: Float = 0f,
    val behaviorRating: Float = 0f,
    val createdAt: Date = Date()
)

// Community Badge Model
data class CommunityBadge(
    val id: String = "",
    val userId: String = "",
    val badgeName: String = "",
    val badgeIcon: String = "",
    val description: String = "",
    val earnedAt: Date = Date()
)

// Community Member Model
data class CommunityMember(
    val id: String = "",
    val user: User = User(),
    val distanceAway: Double = 0.0, // in meters
    val isTrusted: Boolean = false,
    val lastSeenAt: Date = Date(),
    val badges: List<CommunityBadge> = emptyList()
)

// Emergency SOS Model
data class EmergencySOS(
    val id: String = "",
    val userId: String = "",
    val location: Location = Location(),
    val rideId: String? = null,
    val timestamp: Date = Date(),
    val status: String = "ACTIVE", // ACTIVE, RESOLVED, DISMISSED
    val description: String = ""
)
