package com.triit.data.repository

import com.google.ai.client.generativeai.GenerativeModel
import com.triit.domain.model.SafetyTip
import com.triit.domain.repository.SafetyRepository
import timber.log.Timber
import javax.inject.Inject

class SafetyRepositoryImpl @Inject constructor(
    private val generativeModel: GenerativeModel
) : SafetyRepository {

    override suspend fun generateSafetyTips(
        latitude: Double,
        longitude: Double,
        hour: Int
    ): Result<String> {
        return try {
            val timeSlot = when {
                hour >= 22 || hour <= 5 -> "Late Night"
                hour >= 6 && hour < 12 -> "Morning"
                hour >= 12 && hour < 17 -> "Afternoon"
                else -> "Evening"
            }

            val prompt = """
                As a safety advisor for a hyper-local carpooling app in India, provide a concise safety tip for commuters.
                Time: $timeSlot (Hour: $hour)
                Location: Latitude $latitude, Longitude $longitude
                
                Provide one practical, actionable safety tip in 1-2 sentences. Focus on:
                - Safe pickup points (prefer metro stations, well-lit areas)
                - Time-based precautions
                - Emergency contacts
                - Trust indicators to look for
            """.trimIndent()

            val response = generativeModel.generateContent(prompt)
            val safetyTip = response.text ?: "Please wait for available pickup rides from trusted neighbors nearby."

            Result.success(safetyTip)
        } catch (e: Exception) {
            Timber.e(e, "Error generating safety tips")
            Result.failure(e)
        }
    }

    override suspend fun getSafetyTips(): Result<List<SafetyTip>> {
        return try {
            // TODO: Fetch from Firestore
            val tips = listOf(
                SafetyTip(
                    id = "1",
                    title = "Prefer Well-Lit Pickup Points",
                    description = "Always choose pickup locations near Metro stations or busy areas",
                    riskLevel = "MEDIUM",
                    timeSlot = "EVENING"
                ),
                SafetyTip(
                    id = "2",
                    title = "Share Live Location",
                    description = "Enable live location sharing with trusted contacts during the ride",
                    riskLevel = "HIGH",
                    timeSlot = "NIGHT"
                ),
                SafetyTip(
                    id = "3",
                    title = "Check Driver Rating",
                    description = "Only board rides from drivers with 4.5+ star ratings",
                    riskLevel = "LOW",
                    timeSlot = "MORNING"
                )
            )
            Result.success(tips)
        } catch (e: Exception) {
            Timber.e(e, "Error fetching safety tips")
            Result.failure(e)
        }
    }

    override suspend fun reportUnsafeIncident(
        latitude: Double,
        longitude: Double,
        description: String
    ): Result<Unit> {
        return try {
            // TODO: Log to Firestore and alert community
            Timber.i("Unsafe incident reported at $latitude, $longitude: $description")
            Result.success(Unit)
        } catch (e: Exception) {
            Timber.e(e, "Error reporting incident")
            Result.failure(e)
        }
    }
}
