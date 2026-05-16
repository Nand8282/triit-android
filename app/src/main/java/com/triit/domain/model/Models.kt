package com.triit.domain.model

import java.util.Date

// User Model with Trust Score & Vehicle Details
data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val photoUrl: String = "",
    val gender: String = "",
    val trustScore: Float = 5.0f,
    val averageRating: Float = 5.0f,
    val totalRides: Int = 0,
    val officeLocation: String = "",
    val vehicleDetails: VehicleDetails = VehicleDetails(),
    val emergencyContact: String = "",
    val createdAt: Date = Date(),
    val verified: Boolean = false
)

data class VehicleDetails(
    val registrationNumber: String = "",
    val vehicleType: String = "", // Car, Bike, Auto
    val color: String = "",
    val capacity: Int = 4,
    val model: String = ""
)

// Ride Model with Location Tracking
data class Ride(
    val id: String = "",
    val driverId: String = "",
    val driverName: String = "",
    val driverPhotoUrl: String = "",
    val driverTrustScore: Float = 5.0f,
    val pickupLocation: Location = Location(),
    val dropLocation: Location = Location(),
    val pickupTime: Date = Date(),
    val estimatedArrivalTime: Date = Date(),
    val availableSeats: Int = 4,
    val bookedSeats: Int = 0,
    val costPerPerson: Float = 0f,
    val vehicleDetails: VehicleDetails = VehicleDetails(),
    val passengers: List<Passenger> = emptyList(),
    val status: String = "ACTIVE", // ACTIVE, IN_PROGRESS, COMPLETED, CANCELLED
    val routePolyline: String = "",
    val createdAt: Date = Date()
)

data class Location(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val address: String = "",
    val city: String = "",
    val state: String = ""
)

data class Passenger(
    val userId: String = "",
    val name: String = "",
    val status: String = "" // PENDING, ACCEPTED, REJECTED, COMPLETED
)

// Ride Match Model with Distance & Cost
data class RideMatch(
    val id: String = "",
    val rideId: String = "",
    val userId: String = "",
    val distance: Float = 0f, // in meters
    val estimatedCost: Float = 0f,
    val matchScore: Float = 0f, // 0-100 based on location, time, route similarity
    val createdAt: Date = Date()
)

// Safety Tip Model
data class SafetyTip(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val riskLevel: String = "", // LOW, MEDIUM, HIGH
    val timeSlot: String = "" // MORNING, AFTERNOON, EVENING, NIGHT
)

// Review Model for Community Trust
data class Review(
    val id: String = "",
    val rideId: String = "",
    val reviewerId: String = "",
    val revieweeId: String = "",
    val rating: Float = 5.0f,
    val comment: String = "",
    val category: String = "", // DRIVING, CLEANLINESS, BEHAVIOR, SAFETY
    val createdAt: Date = Date()
)

// Community Model for Neighbor Network
data class Community(
    val id: String = "",
    val name: String = "",
    val location: Location = Location(),
    val members: List<String> = emptyList(),
    val totalMembers: Int = 0,
    val communityBadges: List<String> = emptyList(),
    val createdAt: Date = Date()
)

// Incident Report for Safety
data class IncidentReport(
    val id: String = "",
    val reporterId: String = "",
    val location: Location = Location(),
    val description: String = "",
    val severity: String = "", // LOW, MEDIUM, HIGH
    val type: String = "", // HARASSMENT, ACCIDENT, UNSAFE_DRIVING, OTHER
    val createdAt: Date = Date()
)
